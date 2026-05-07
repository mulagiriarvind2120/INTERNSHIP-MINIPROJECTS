CREATE DATABASE Metro_Management;

USE Metro_Management;

CREATE TABLE Stations (
    station_id INT PRIMARY KEY,
    station_name VARCHAR(100),
    location VARCHAR(100),
    platforms INT
);

CREATE TABLE Metro_Trains (
    train_id INT PRIMARY KEY,
    train_name VARCHAR(100),
    capacity INT,
    station_id INT,
    FOREIGN KEY (station_id) REFERENCES Stations(station_id)
);

ALTER TABLE Stations
ADD opening_year INT;

ALTER TABLE Metro_Trains
RENAME TO Trains;

INSERT INTO Stations (station_id, station_name, location, platforms, opening_year)
VALUES 
(1, 'Majestic', 'Bangalore', 10, 2011),
(2, 'Central', 'Chennai', 8, 2015),
(3, 'MG Road', 'Bangalore', 6, 2011),
(4, 'Airport', 'Delhi', 12, 2010),
(5, 'Park Street', 'Kolkata', 7, 2013);

INSERT INTO Trains (train_id, train_name, capacity, station_id)
VALUES
(101, 'Green Line Express', 800, 1),
(102, 'Blue Line Rapid', 600, 2),
(103, 'Yellow Line Shuttle', 500, 3);

UPDATE Trains
SET capacity = 900
WHERE train_id = 101;

DELETE FROM Stations
WHERE station_id = 5;

SELECT * FROM Trains;
SELECT * FROM Stations;

CREATE USER 'metro_staff'@'localhost' IDENTIFIED BY 'password123';

GRANT SELECT ON Stations TO 'metro_staff'@'localhost';

GRANT INSERT ON Trains TO 'metro_staff'@'localhost';

REVOKE INSERT ON Trains FROM 'metro_staff'@'localhost';
