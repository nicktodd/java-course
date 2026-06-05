import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Minimal REST API example using only Java SE libraries + JDBC.
 *
 * Endpoints:
 * GET    /albums
 * GET    /albums/{id}
 * POST   /albums
 * PUT    /albums/{id}
 * DELETE /albums/{id}
 */
public class SimpleMusicApiServer {

    private static final int PORT = 8080;

    // Change defaults or set environment variables: DB_URL, DB_USER, DB_PASSWORD.
    private static final String DB_URL = env("DB_URL",
            "jdbc:mysql://localhost:3306/musicdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
    private static final String DB_USER = env("DB_USER", "root");
    private static final String DB_PASSWORD = env("DB_PASSWORD", "password");

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/albums", new AlbumsHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server running at http://localhost:" + PORT);
        System.out.println("Using DB: " + DB_URL);
    }

    private static String env(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value == null || value.trim().isEmpty()) ? defaultValue : value;
    }

    static class AlbumsHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                String method = exchange.getRequestMethod();
                String path = exchange.getRequestURI().getPath();
                String[] parts = path.split("/");
                Integer id = extractId(parts);

                if ("GET".equals(method) && id == null) {
                    getAll(exchange);
                    return;
                }
                if ("GET".equals(method) && id != null) {
                    getOne(exchange, id);
                    return;
                }
                if ("POST".equals(method) && id == null) {
                    create(exchange);
                    return;
                }
                if ("PUT".equals(method) && id != null) {
                    update(exchange, id);
                    return;
                }
                if ("DELETE".equals(method) && id != null) {
                    delete(exchange, id);
                    return;
                }

                sendJson(exchange, 404, "{\"error\":\"Not found\"}");
            } catch (IllegalArgumentException e) {
                sendJson(exchange, 400, "{\"error\":\"" + escape(e.getMessage()) + "\"}");
            } catch (SQLException e) {
                sendJson(exchange, 500, "{\"error\":\"Database error\",\"details\":\"" + escape(e.getMessage()) + "\"}");
            } catch (Exception e) {
                sendJson(exchange, 500, "{\"error\":\"Server error\",\"details\":\"" + escape(e.getMessage()) + "\"}");
            }
        }

        private Integer extractId(String[] parts) {
            // Path format: /albums or /albums/{id}
            if (parts.length == 3 && !parts[2].trim().isEmpty()) {
                try {
                    return Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("id must be an integer");
                }
            }
            if (parts.length == 2) {
                return null;
            }
            throw new IllegalArgumentException("Invalid path");
        }

        private void getAll(HttpExchange exchange) throws SQLException, IOException {
            List<Album> albums = new ArrayList<Album>();

            String sql = "SELECT id, title, artist, price FROM albums ORDER BY id";
            try (Connection con = dbConnection();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    albums.add(new Album(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("artist"),
                            rs.getBigDecimal("price")
                    ));
                }
            }

            StringBuilder json = new StringBuilder();
            json.append("[");
            for (int i = 0; i < albums.size(); i++) {
                if (i > 0) {
                    json.append(",");
                }
                json.append(albums.get(i).toJson());
            }
            json.append("]");

            sendJson(exchange, 200, json.toString());
        }

        private void getOne(HttpExchange exchange, int id) throws SQLException, IOException {
            String sql = "SELECT id, title, artist, price FROM albums WHERE id = ?";

            try (Connection con = dbConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        sendJson(exchange, 404, "{\"error\":\"Album not found\"}");
                        return;
                    }

                    Album album = new Album(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("artist"),
                            rs.getBigDecimal("price")
                    );
                    sendJson(exchange, 200, album.toJson());
                }
            }
        }

        private void create(HttpExchange exchange) throws SQLException, IOException {
            String body = readBody(exchange);
            AlbumInput input = parseAlbumInput(body);

            String sql = "INSERT INTO albums (title, artist, price) VALUES (?, ?, ?)";
            try (Connection con = dbConnection();
                 PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, input.title);
                ps.setString(2, input.artist);
                ps.setBigDecimal(3, input.price);
                ps.executeUpdate();

                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        Album created = new Album(newId, input.title, input.artist, input.price);
                        sendJson(exchange, 201, created.toJson());
                        return;
                    }
                }
            }

            sendJson(exchange, 500, "{\"error\":\"Could not create album\"}");
        }

        private void update(HttpExchange exchange, int id) throws SQLException, IOException {
            String body = readBody(exchange);
            AlbumInput input = parseAlbumInput(body);

            String sql = "UPDATE albums SET title = ?, artist = ?, price = ? WHERE id = ?";
            try (Connection con = dbConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, input.title);
                ps.setString(2, input.artist);
                ps.setBigDecimal(3, input.price);
                ps.setInt(4, id);

                int changed = ps.executeUpdate();
                if (changed == 0) {
                    sendJson(exchange, 404, "{\"error\":\"Album not found\"}");
                    return;
                }
            }

            Album updated = new Album(id, input.title, input.artist, input.price);
            sendJson(exchange, 200, updated.toJson());
        }

        private void delete(HttpExchange exchange, int id) throws SQLException, IOException {
            String sql = "DELETE FROM albums WHERE id = ?";

            try (Connection con = dbConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                int changed = ps.executeUpdate();
                if (changed == 0) {
                    sendJson(exchange, 404, "{\"error\":\"Album not found\"}");
                    return;
                }
            }

            sendJson(exchange, 200, "{\"message\":\"Album deleted\"}");
        }

        private Connection dbConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        private String readBody(HttpExchange exchange) throws IOException {
            InputStream in = exchange.getRequestBody();
            byte[] bytes = in.readAllBytes();
            return new String(bytes, StandardCharsets.UTF_8);
        }

        private AlbumInput parseAlbumInput(String json) {
            String title = extractString(json, "title");
            String artist = extractString(json, "artist");
            BigDecimal price = extractDecimal(json, "price");

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("title is required");
            }
            if (artist == null || artist.trim().isEmpty()) {
                throw new IllegalArgumentException("artist is required");
            }
            if (price == null) {
                throw new IllegalArgumentException("price is required");
            }

            return new AlbumInput(title.trim(), artist.trim(), price);
        }

        // Minimal parsing for a simple JSON body.
        private String extractString(String json, String key) {
            Pattern p = Pattern.compile("\\\"" + Pattern.quote(key) + "\\\"\\s*:\\s*\\\"(.*?)\\\"");
            Matcher m = p.matcher(json);
            return m.find() ? unescape(m.group(1)) : null;
        }

        private BigDecimal extractDecimal(String json, String key) {
            Pattern p = Pattern.compile("\\\"" + Pattern.quote(key) + "\\\"\\s*:\\s*(-?\\d+(?:\\.\\d+)?)");
            Matcher m = p.matcher(json);
            if (!m.find()) {
                return null;
            }
            return new BigDecimal(m.group(1));
        }

        private void sendJson(HttpExchange exchange, int statusCode, String body) throws IOException {
            byte[] response = body.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
            exchange.sendResponseHeaders(statusCode, response.length);
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(response);
            }
        }

        private String unescape(String s) {
            return s.replace("\\\"", "\"").replace("\\\\", "\\");
        }

        private String escape(String s) {
            if (s == null) {
                return "";
            }
            return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
        }
    }

    static class Album {
        final int id;
        final String title;
        final String artist;
        final BigDecimal price;

        Album(int id, String title, String artist, BigDecimal price) {
            this.id = id;
            this.title = title;
            this.artist = artist;
            this.price = price;
        }

        String toJson() {
            return "{" +
                    "\"id\":" + id + "," +
                    "\"title\":\"" + escapeJson(title) + "\"," +
                    "\"artist\":\"" + escapeJson(artist) + "\"," +
                    "\"price\":" + price +
                    "}";
        }

        private String escapeJson(String s) {
            return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
        }
    }

    static class AlbumInput {
        final String title;
        final String artist;
        final BigDecimal price;

        AlbumInput(String title, String artist, BigDecimal price) {
            this.title = title;
            this.artist = artist;
            this.price = price;
        }
    }
}
