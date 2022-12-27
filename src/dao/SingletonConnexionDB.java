package dao;

import java.sql.*;

public class SingletonConnexionDB {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gesioncommandes","root","");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnexion(){
        return connection;
    }
}
