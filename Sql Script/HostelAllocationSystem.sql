
CREATE DATABASE hostel_db;
USE hostel_db;
-- Admin Table

CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Students Table

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    roll_no VARCHAR(20) UNIQUE NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    gender ENUM('Male','Female') NOT NULL,
    department VARCHAR(100) NOT NULL,
    year_of_study INT NOT NULL,
    phone VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Rooms Table

CREATE TABLE rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_number VARCHAR(20) UNIQUE NOT NULL,
    floor_no INT NOT NULL,
    room_type ENUM('Single','Double','Triple') NOT NULL,
    capacity INT NOT NULL,
    occupied_beds INT DEFAULT 0,
    status ENUM('Available','Full','Maintenance')
           DEFAULT 'Available'
);

-- Allocations Table

CREATE TABLE allocations (
    allocation_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    room_id INT NOT NULL,
    allocation_date DATE NOT NULL,
    status ENUM('Active','Vacated')
           DEFAULT 'Active',

    FOREIGN KEY (student_id)
    REFERENCES students(student_id)
    ON DELETE CASCADE,

    FOREIGN KEY (room_id)
    REFERENCES rooms(room_id)
    ON DELETE CASCADE
);

-- Default Admin

INSERT INTO admin(username,password)
VALUES ('admin','admin123');