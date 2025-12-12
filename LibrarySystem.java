import java.sql.*;
import java.util.Scanner;

public class LibrarySystem {
    // DATABASE CONFIGURATION
    // Change "root" and "your_password" to your actual MySQL username/password
    static final String URL = "jdbc:mysql://localhost:3306/library_db";
    static final String USER = "root"; 
    static final String PASS = "your_password"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Load the Driver (Optional in newer Java versions, but good practice)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println("\n==========================================");
            System.out.println("      LIBRARY MANAGEMENT SYSTEM (MySQL)");
            System.out.println("==========================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: addBook(sc); break;
                case 2: displayBooks(); break;
                case 3: updateBook(sc); break;
                case 4: deleteBook(sc); break;
                case 5: 
                    System.out.println("Exiting...");
                    return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // 1. ADD BOOK
    private static void addBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        String query = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, qty);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book added successfully!");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    // 2. DISPLAY ALL BOOKS
    private static void displayBooks() {
        String query = "SELECT * FROM books";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n-------------------------------------------------------------");
            System.out.printf("%-5s %-25s %-20s %-10s%n", "ID", "Title", "Author", "Qty");
            System.out.println("-------------------------------------------------------------");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.printf("%-5d %-25s %-20s %-10d%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("quantity"));
            }

            if (!hasData) System.out.println("No books found in the library.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    // 3. UPDATE BOOK
    private static void updateBook(Scanner sc) {
        System.out.print("Enter Book ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        // Check if ID exists first (Optional, but good UX)
        
        System.out.print("Enter New Title: ");
        String title = sc.nextLine();
        System.out.print("Enter New Author: ");
        String author = sc.nextLine();
        System.out.print("Enter New Quantity: ");
        int qty = sc.nextInt();

        String query = "UPDATE books SET title=?, author=?, quantity=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book updated successfully!");
            else System.out.println("Book ID not found.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    // 4. DELETE BOOK
    private static void deleteBook(Scanner sc) {
        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM books WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book deleted successfully!");
            else System.out.println("Book ID not found.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
