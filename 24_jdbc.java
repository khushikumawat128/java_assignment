import java.sql.*;
import java.util.Scanner;

class StudentDatabaseApp {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void insertRecord(Connection conn, String name, double percentage) throws SQLException {
        String sql = "INSERT INTO student (name, percentage) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, percentage);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        }
    }

    private static void updateRecord(Connection conn, int rollno, String name, double percentage) throws SQLException {
        String sql = "UPDATE student SET name = ?, percentage = ? WHERE rollno = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, percentage);
            pstmt.setInt(3, rollno);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the given rollno.");
            }
        }
    }

    private static void deleteRecord(Connection conn, int rollno) throws SQLException {
        String sql = "DELETE FROM student WHERE rollno = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rollno);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the given rollno.");
            }
        }
    }

    private static void displayRecord(Connection conn, int rollno) throws SQLException {
        String sql = "SELECT * FROM student WHERE rollno = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rollno);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Roll No: " + rs.getInt("rollno"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Percentage: " + rs.getDouble("percentage"));
                } else {
                    System.out.println("No record found with the given rollno.");
                }
            }
        }
    }

    private static void displayAllRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rollno"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Percentage: " + rs.getDouble("percentage"));
                System.out.println("-----------");
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = connect(); Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Insert record");
                System.out.println("2. Update record");
                System.out.println("3. Delete record");
                System.out.println("4. Display particular record");
                System.out.println("5. Display all records");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter percentage: ");
                        double percentage = scanner.nextDouble();
                        insertRecord(conn, name, percentage);
                        break;
                    case 2:
                        System.out.print("Enter rollno: ");
                        int rollnoToUpdate = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        System.out.print("Enter new percentage: ");
                        double newPercentage = scanner.nextDouble();
                        updateRecord(conn, rollnoToUpdate, newName, newPercentage);
                        break;
                    case 3:
                        System.out.print("Enter rollno: ");
                        int rollnoToDelete = scanner.nextInt();
                        deleteRecord(conn, rollnoToDelete);
                        break;
                    case 4:
                        System.out.print("Enter rollno: ");
                        int rollnoToDisplay = scanner.nextInt();
                        displayRecord(conn, rollnoToDisplay);
                        break;
                    case 5:
                        displayAllRecords(conn);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
