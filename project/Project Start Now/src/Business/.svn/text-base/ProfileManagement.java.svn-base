/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import DataAccess.AdminData;
import DataAccess.MD5Encrypt;
import Entity.Admin;
import Entity.Session;
import GUI.ChangePassDialogGUI;
import java.sql.*;

/**
 *
 * @author PHUONGPHUONG
 */
public class ProfileManagement {

    public AdminData adminDT = null;;
    Admin admin = null;;
    public ResultSet rs = null;
    public ResultSet rsCompare = null;

    public ProfileManagement()
    {
        adminDT = new AdminData();
    }

    public Admin getAdminProfile(int id)
    {
        try
        {
            rs = adminDT.getAdminData(id);

            while(rs.next())
            {
                String fullName = rs.getString(1);
                String usrName = rs.getString(2);
                String pwd = rs.getString(3);

                admin = new Admin(id, fullName, usrName, pwd);
            }
        }
        catch(SQLException ex)
        {
        }      
        return admin;
    }

    public void UpdateAdminProfile(String usrName, int id)
    {
        adminDT.UpdateProfile(usrName, id);
    }

    public boolean ChangePass()
    {
        boolean chk;

        ChangePassDialogGUI dialog = new ChangePassDialogGUI(null, true);

        if(!(dialog.getPwd().equals("")))
        {
            String encryptedPass = new MD5Encrypt().encryptMD5(dialog.getPwd());
            adminDT.ChangePassword(encryptedPass, Session.getLoginID());
            chk = true;
        }
        else
            chk = false;
        
        return chk;
    }

    public boolean ComparePassWord(int id, String enteredPass)
    {
        String encryptedPass = new MD5Encrypt().encryptMD5(enteredPass);

        try
        {
            rsCompare = adminDT.getAdminData(id);

            while(rsCompare.next())
            {
                String pwd = rsCompare.getString(3);

                if(pwd.equals(encryptedPass))
                {
                    return true;
                }
            }
        }
        catch(SQLException ex)
        {
        }
        return false;
    }
}
