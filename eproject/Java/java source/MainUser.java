/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcallablestatement;

import java.sql.*;

/**
 *
 * @author PHUONGPHUONG
 */
public class MainUser {

    /**
     * @param args the command line arguments
     */
    public static void Main(String[] args) {
        // TODO code application logic here
         //load driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Load driver succ!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        //create connection
        try {
            // Create a variable for the connection string.
            String connectionUrl = "jdbc:sqlserver://localhost:1427;"
                    + "databaseName=EmployeeTransferManagement_DB;user=etmuser;Password=123";
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection type4 succ!");

            String sql = "{CALL getAdminData(?)}";
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, 1);
            ResultSet rs = cs.executeQuery();

            String fullName = rs.getString(1);
            String usrName = rs.getString(2);
            String pwd = rs.getString(3);

            System.out.println("Test na: "+fullName);
            con.close();
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
