/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LoginValidate extends Thread{
    String PreSQL;
    PreparedStatement statement;
    Connection kinect;
    public LoginValidate(){
        PreSQL = null;
        statement = null;
        
    }



    public int loginValidate(String UserName, String Password, boolean isAdmin){
        kinect = TheConnection.getConnection();
        String encryptedPass = new MD5Encrypt().encryptMD5(Password) ;     
        if(isAdmin){
                 
                 PreSQL = "SELECT AdminID FROM SystemAdmin WHERE Username = ? AND PassWord = ?";
             }
             else{
                 PreSQL = "SELECT EmployeeID FROM Employee WHERE Username = ? AND PassWord = ?";
             }
             // Connet to database and validate;
             try {
                 statement =  kinect.prepareStatement(PreSQL);
                 statement.setString(1, UserName);
                 statement.setString(2, encryptedPass);
                 ResultSet rs = statement.executeQuery();
                 System.out.println(rs.toString());
                 while (rs.next()){
                     return rs.getInt(1);
                 }
                return -1;
             } catch (Exception e) {
                 return -1;
             }
            
        }
}


           
