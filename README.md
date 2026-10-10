# Student Attendance Management System (SAMS)

## 1. Project Overview

The Student Attendance Management System (SAMS) is a Java-based desktop application developed to manage student information, courses, lecturers, class schedules, attendance records, and attendance reports.

The project uses a layered architecture to separate the user interface, business logic, and database operations.

## 2. Features

* User login for administrators and lecturers
* Student management (CRUD operations)
* Course management (CRUD operations)
* Lecturer management (CRUD operations)
* Class scheduling
* Attendance management
* Attendance reports

## 3. Technologies Used

* Java
* JavaFX
* FXML
* Maven
* MySQL
* JDBC
* NetBeans IDE
* Layered Architecture
* DAO, BO, and DTO patterns

## 4. Database Setup

1. Install and start MySQL Server.
2. Open MySQL Workbench or another MySQL client.
3. Open the `sams.sql` file included in this project.
4. Execute the SQL script to create the database tables and insert the sample data.
5. Check the database connection URL, username, and password in `DBConnection.java`.

**Note:** Back up any existing database data before running a script that drops or recreates tables.

## 5. How to Run the Project

1. Open the project in NetBeans.
2. Ensure MySQL Server is running.
3. Confirm that the `sams` database and its tables exist.
4. Check the database connection settings in `DBConnection.java`.
5. Build the project using **Clean and Build**.
6. Run the project from NetBeans.

## 6. Default Login Credentials

Use the demo credentials inserted into the database by the provided SQL script.

| Role     | Username   | Password      |
| -------- | ---------- | ------------- |
| Admin    | `admin`    | `1234`    |
| Lecturer | `lecturer` | `5678` |

These credentials work only if the corresponding records and password format match your application's login implementation.

## 7. Project Structure

* `controller` — Handles user interface actions
* `bo` — Contains business logic
* `dao` — Handles database operations
* `dto` — Holds data transfer objects
* `view` — Contains JavaFX FXML files
* `DBConnection` — Manages database connections

## 8. Author

Student Attendance Management System project.
