import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBEngine {
    public static final String url = "jdbc:mysql://localhost:3306/marketplace";
    public static final String user = "root";
    public static final String password = "12345";
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

}
