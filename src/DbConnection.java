import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String URL="jdbc:mysql://localhost:3306/newsdb";
    private static String User="root";
    private static String Pass="root12345";

    private DbConnection() {}

    private static DbConnection dbConnection=new DbConnection();

    public static DbConnection getInstance() {
        return dbConnection;
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, User, Pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    }


