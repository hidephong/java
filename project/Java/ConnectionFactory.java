/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author THANHTM
 */
public class ConnectionFactory {
    
    private static Connection conn;
    private static String servername;
    private static String port;
    private static String username;
    private static String password;
    private static String database;
    
    public static Connection getConnection() {     
        return conn;
    }
    
    public static boolean connect(String serverName, String port, String username, String password, String database) {
        ConnectionFactory.servername = serverName;
        ConnectionFactory.port = port;
        ConnectionFactory.username = username;
        ConnectionFactory.password = password;
        ConnectionFactory.database = database;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(getConnectionString());
        } catch (Exception ex) {
            return false;
        }
        
        return true;
    }
    
    public static String getConnectionString() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:sqlserver://");
        sb.append(servername);
        sb.append(":");
        sb.append(port);
        sb.append(";databaseName=");
        sb.append(database);
        sb.append(";user=");
        sb.append(username);
        sb.append(";password=");
        sb.append(password);
        return sb.toString();        
    }
    
    public static void exec(String sql) {
        try {
            Statement query = getConnection().createStatement();
            query.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    @SuppressWarnings("static-access")
    public static void main(String arg[])
    {
        ConnectionFactory obj = new ConnectionFactory();
        obj.connect("THANHTM", "1433", "sa", "@thanhtm", "master");
        obj.exec("CREATE DATABASE Test");

    }
}
