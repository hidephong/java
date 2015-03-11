/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Entity.Admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author PHUONGPHUONG
 */
public class AdminData {
    Connection conn = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    Vector<Admin> va;
    Admin a;

    public AdminData()
    {
        conn = TheConnection.getConnection();
    }

    public Vector<Admin> getAllAdmin(){
        va = new Vector<Admin>();
          try
        {
            String sql = "{CALL getAllAdmin}";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                
                int id = rs.getInt(1);
                String an = rs.getString(2);
                String us = rs.getString(3);
                String pw = rs.getString(4);
                a = new Admin(id, an, us, pw);
                va.add(a);
            }
        }
        catch(SQLException ex)
        {
        }
        return va;
    }
    
    
    public ResultSet getAdminData(int adminID)
    {
        try
        {
            String sql = "{CALL getAdminData(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, adminID);
            rs = cs.executeQuery();
        }
        catch(SQLException ex)
        {
        }
        return rs;
    }

    public void UpdateProfile(String usrname, int id)
    {
        try
        {
            String sql = "{CALL UpdateAdminInfo(?, ?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1, usrname);
            cs.setInt(2, id);
            boolean bool = cs.execute();
        }
        catch(SQLException ex)
        {
        }
    }

    public boolean  ChangePassword(String encryptedPass, int id)
    {
        try
        {
            String sql = "{CALL ChangePassword(?, ?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1, encryptedPass);
            cs.setInt(2, id);
            boolean bool = cs.execute();
            return !bool;
        }
        catch(SQLException ex)
        {
            return false;
        }
    }

     public boolean  UpdateAAdmin(int id, String an, String us)
    {
        try
        {
            String sql = "{CALL UpdateAAdmin(?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, an);
            cs.setString(3, us);
            boolean bool = cs.execute();
            return !bool;
        }
        catch(SQLException ex)
        {
            return false;
        }
    }

     public boolean DelAAdmin(int id){
          try
        {
            String sql = "{CALL DelAAdmin(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            boolean bool = cs.execute();
            return !bool;
        }
        catch(SQLException ex)
        {
            return false;
        }
     }

     public boolean AddAAdmin(String an, String us, String pw){
          try
        {
            String sql = "{CALL AddAAdmin(?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1, an);
            cs.setString(2, us);
            cs.setString(3, pw);
            boolean bool = cs.execute();
            return !bool;
        }
        catch(SQLException ex)
        {
            return false;
        }
     }

     
      public String getAdminPass(int adminID)
    {
         String pass = null;
        try
        {
            String sql = "{CALL getAdminData(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, adminID);
            rs = cs.executeQuery();
            pass =  rs.getString("Password");
        }
        catch(SQLException ex)
        {
        }
        return pass;
    }
}
