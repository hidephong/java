/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;


import Language.Language;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author nhahv
 */
public class TheConnection{
    private static Connection  connection;
    public  TheConnection(){
        connection = tryConnection();
    }
     private  Connection tryConnection(){
        try {
            Connection con;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (DriverManager.getConnection(ServerConfigure.getConnection()));
            System.out.println("TheConnection say: " + con.toString());
            setConnection(con);
            if(con.isValid(3)){
            return con;
            }else{
            JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("LANGUAGE.Language", Language.getLocale()).getString("CANNOT CONNECT TO SERVER"), java.util.ResourceBundle.getBundle("LANGUAGE.Language", Language.getLocale()).getString("CANNOT CONNECT TO SERVER"),JOptionPane.OK_OPTION);
                return null;
            }

        } catch (SQLException ex) {
           System.out.println("Error Code" + ex.getErrorCode());
           
            JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("LANGUAGE.Language", Language.getLocale()).getString("CANNOT CONNECT TO SERVER"), java.util.ResourceBundle.getBundle("LANGUAGE.Language", Language.getLocale()).getString("CANNOT CONNECT TO SERVER"),JOptionPane.OK_OPTION);
          return null;  
        } catch (ClassNotFoundException cex) {
            JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("LANGUAGE.Language", Language.getLocale()).getString("SYSTEM ERROR: JDBCSQL DRIVER NOT FOUND"), java.util.ResourceBundle.getBundle("LANGUAGE.Language", Language.getLocale()).getString("SYSTEM ERROR: JDBCSQL DRIVER NOT FOUND"), JOptionPane.OK_OPTION);
          return null;
                  
        }
 

    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        //TheConnection tc = new TheConnection();
            return connection;
      
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        TheConnection.connection = connection;
    }

 
  
} 
