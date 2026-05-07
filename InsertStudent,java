import java.sql.*;

public class InsertStudent {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "1234"
            );

            String query = "INSERT INTO Student VALUES(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 4);
            ps.setString(2, "Anu");
            ps.setString(3, "ECE");

            ps.executeUpdate();

            System.out.println("Data inserted successfully");

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
