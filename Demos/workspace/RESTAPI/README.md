# Simple Java REST API (No Spring)

This is a minimal CRUD API for music albums using:
- Java built-in HTTP server (`com.sun.net.httpserver.HttpServer`)
- JDBC (`java.sql.*`)
- MySQL running on localhost

## Endpoints

- `GET /albums`
- `GET /albums/{id}`
- `POST /albums`
- `PUT /albums/{id}`
- `DELETE /albums/{id}`

## 1) Create DB/table/sample data

```bash
mysql -u root -p < schema.sql
```

## 2) Get MySQL JDBC driver

You still need MySQL Connector/J on the classpath (JDBC API is built into Java, the MySQL driver is not).

Example with a jar in current folder:

```bash
javac -cp .:mysql-connector-j-9.0.0.jar SimpleMusicApiServer.java
java -cp .:mysql-connector-j-9.0.0.jar SimpleMusicApiServer
```

## 3) Optional DB config via env vars

Defaults are:
- `DB_URL=jdbc:mysql://localhost:3306/musicdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`
- `DB_USER=root`
- `DB_PASSWORD=password`

Override if needed:

```bash
export DB_USER=root
export DB_PASSWORD=your_password
java -cp .:mysql-connector-j-9.0.0.jar SimpleMusicApiServer
```

## 4) Test with curl

```bash
# Get all
curl http://localhost:8080/albums

# Get one
curl http://localhost:8080/albums/1

# Create
curl -X POST http://localhost:8080/albums \
  -H "Content-Type: application/json" \
  -d '{"title":"Nevermind","artist":"Nirvana","price":13.49}'

# Update
curl -X PUT http://localhost:8080/albums/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Kind of Blue (Remastered)","artist":"Miles Davis","price":14.99}'

# Delete
curl -X DELETE http://localhost:8080/albums/2
```

## Notes

- JSON parsing here is intentionally basic for teaching/demo purposes.
- For real projects, use a JSON library and a mature framework.
