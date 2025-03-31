package bookPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
     //PUT ALL DATABASE PARAMETERS TO ONE PLACE
    private static final String URL = "jdbc:mysql://localhost:3306/book2";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //LOAD JDBC DRIVER
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
