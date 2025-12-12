# Library Management System

A console-based application to manage library books using **Java** for logic and **MySQL** for data persistence. This system implements full **CRUD** (Create, Read, Update, Delete) functionality.

## 🚀 Features
- **Add Books**: Insert book details into the MySQL database.
- **View Library**: Fetch and display all books in a formatted table.
- **Update Records**: Modify book details by Book ID.
- **Delete Books**: Remove books from the database.
- **Database Connectivity**: Uses JDBC to communicate with MySQL.

## 🛠️ Technology Stack
- **Language**: Java (JDK 8+)
- **Database**: MySQL
- **Driver**: MySQL Connector/J

## ⚙️ Setup & Installation

### 1. Database Setup
Run the following SQL script in your MySQL Workbench or Command Line:
```sql
CREATE DATABASE library_db;
USE library_db;
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    quantity INT
);
