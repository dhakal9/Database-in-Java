import java.sql.*;
import java.util.*;
public class User {

    public static void dbconnection() {


        try {
            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");

                Scanner sc = new Scanner(System.in);

                // Get the input from the user
                System.out.println("Enter Id");
                int id = sc.nextInt();

                System.out.println("Enter username");
                String username = sc.next();

                System.out.println("Enter password");
                String password = sc.next();
//            String id = "1";
//            String username = "amrit";
//            String password = "amrit123";

            // Create a prepared statement for the insertion
            String query = "INSERT INTO user_info (id, username, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

            // Set the values for the insertion
            stmt.setString(1, String.valueOf(id));
            stmt.setString(2, String.valueOf(username));
            stmt.setString(3, String.valueOf(password));

            // Execute the insertion
            stmt.executeUpdate();

            // Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}