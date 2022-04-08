import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main {
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String URL = "jdbc:mysql://localhost:3306/forms";
    private static String user = "root", pass = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection(URL,user,pass);
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()){
                int Id = resultSet.getInt(1);
                String Name = resultSet.getString(2);
                String Gender = resultSet.getString(3);
                int Age = resultSet.getInt(4);
                String Address = resultSet.getString(5);

                System.out.println(Id + " " + Name + " " + Gender + " " + Age + " " + Address + " ");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}