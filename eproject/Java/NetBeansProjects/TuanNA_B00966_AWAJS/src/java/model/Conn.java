/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TuanNA
 */
public class Conn {

    Connection dbConn;

    public Connection getConnection() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dbConn = DriverManager.getConnection("jdbc:sqlserver://TUANNA-PC\\SQLEXPRESS:1433;DatabaseName=BookStore", "sa", "123");
            System.out.println("Connection Successful!");
            // if successful print Connection Successful!
        } catch (Exception e) {

        }
        return dbConn;

    }
}
