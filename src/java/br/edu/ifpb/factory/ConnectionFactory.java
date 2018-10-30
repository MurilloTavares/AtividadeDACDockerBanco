package br.edu.ifpb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

public class ConnectionFactory {
 
    private static final String USER = "postgres";
    private static final String PASS = "1234";
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String DATABASE = "teste";
    private static final String URL = "jdbc:postgresql://"+HOST+":"+PORT+"/"+DATABASE;

    public static Connection connect() throws SQLException{
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        return connection;
    }
    
}
