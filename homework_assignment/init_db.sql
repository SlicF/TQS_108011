CREATE DATABASE IF NOT EXISTS homework_assignment;

USE homework_assignment;

CREATE TABLE IF NOT EXISTS trips (
    id INT AUTO_INCREMENT PRIMARY KEY,
    origin VARCHAR(255),
    destination VARCHAR(255),
    date DATE,
    price_euro DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    trip_id INT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (trip_id) REFERENCES trips(id)
);

-- Insert default trips
INSERT INTO trips (origin, destination, date, price_euro) VALUES ('Lisbon', 'Madrid', '2024-04-11', 10.00);
INSERT INTO trips (origin, destination, date, price_euro) VALUES ('Lisbon', 'Madrid', '2024-04-12', 10.00);
INSERT INTO trips (origin, destination, date, price_euro) VALUES ('Lisbon', 'Paris', '2024-04-11', 15.00);
INSERT INTO trips (origin, destination, date, price_euro) VALUES ('Lisbon', 'Paris', '2024-04-12', 15.00);
