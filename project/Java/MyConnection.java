/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demoftp;

/**
 *
 * @author Tuan
 */

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Tuan
 */

public class MyConnection {

public Connection getConnection(){
    try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:quanlytaikhoan","Tuan-PC\\SQLEXPRESS","");
        return con;
        
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.toString(),"Loi",JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
}

