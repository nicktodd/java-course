CREATE DATABASE IF NOT EXISTS musicdb;
USE musicdb;

CREATE TABLE IF NOT EXISTS albums (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

INSERT INTO albums (title, artist, price) VALUES
('Kind of Blue', 'Miles Davis', 12.99),
('Abbey Road', 'The Beatles', 15.50),
('Rumours', 'Fleetwood Mac', 11.75);
