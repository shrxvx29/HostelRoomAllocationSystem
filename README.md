# 🏨 Hostel Room Allocation System

A web-based Hostel Room Allocation System developed using Java, JSP, Servlets, JDBC, MySQL, and Apache Tomcat. The application helps hostel administrators manage students, rooms, and room allocations efficiently.

---

## 📌 Features

### 🔐 Authentication

* Admin Login
* Session Management
* Logout Functionality

### 👨‍🎓 Student Management

* Add Student
* View Students
* Update Student
* Delete Student
* Search Students by Name or Roll Number

### 🏠 Room Management

* Add Room
* View Rooms
* Update Room
* Delete Room
* Track Room Occupancy

### 📋 Allocation Management

* Allocate Rooms to Students
* Prevent Duplicate Allocations
* Check Room Capacity Before Allocation
* Vacate Rooms
* Automatic Room Status Updates

### 📊 Dashboard

* Total Students
* Total Rooms
* Available Rooms
* Active Allocations

---

## 🛠️ Technology Stack

### Frontend

* JSP
* HTML
* CSS

### Backend

* Java
* Servlets
* JDBC

### Database

* MySQL

### Server

* Apache Tomcat 10

### IDE

* Eclipse IDE

---

## 🏗️ Project Architecture

MVC (Model View Controller)

View (JSP)
↓
Controller (Servlets)
↓
DAO Layer
↓
MySQL Database

---

## 📂 Project Structure

src/

├── com.hostel.model

│ ├── Student.java

│ ├── Room.java

│ └── Allocation.java

│

├── com.hostel.dao

│ ├── AdminDAO.java

│ ├── StudentDAO.java

│ ├── RoomDAO.java

│ ├── AllocationDAO.java

│ └── DashboardDAO.java

│

├── com.hostel.servlet

│ ├── AdminServlet.java

│ ├── DashboardServlet.java

│ ├── StudentServlet.java

│ ├── RoomServlet.java

│ ├── AllocationServlet.java

│ ├── AllocateRoomServlet.java

│ └── LogoutServlet.java

│

└── com.hostel.util

└── DBConnection.java

---

## 🗄️ Database Tables

### admin

* admin_id
* username
* password

### students

* student_id
* roll_no
* student_name
* gender
* department
* year_of_study
* phone
* email

### rooms

* room_id
* room_number
* floor_no
* room_type
* capacity
* occupied_beds
* status

### allocations

* allocation_id
* student_id
* room_id
* allocation_date
* status

---

## 🚀 Installation

### Clone Repository

git clone https://github.com/shrxvx29/HostelRoomAllocationSystem.git

### Configure Database

1. Create MySQL Database
2. Execute SQL Scripts
3. Update Database Credentials in DBConnection.java

### Run Application

1. Import Project into Eclipse
2. Configure Apache Tomcat
3. Run on Server
4. Open Browser

http://localhost:8080/HostelRoomAllocation

---

## 🔮 Future Enhancements

* Role Based Access Control
* Email Notifications
* PDF Reports
* Student Portal
* Online Hostel Fee Management
* Spring Boot Migration
* REST API Support

---

## 👨‍💻 Author

K. Saravanan

Java Full Stack Developer

---

## ⭐ Project Status

Completed and Working Successfully
