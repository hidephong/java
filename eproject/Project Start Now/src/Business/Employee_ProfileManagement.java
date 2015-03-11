/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import DataAccess.Employee_Data;
import DataAccess.MD5Encrypt;
import Entity.Employee;
import Entity.Session;
import GUI.Employee_ChangePassDialogGUI;
import java.sql.*;

/**
 *
 * @author PHUONGPHUONG
 */
public class Employee_ProfileManagement {

    public Employee_Data empDT = null;;
    Employee emp = null;;
    public ResultSet rs = null;
    public ResultSet rsCompare = null;

    public Employee_ProfileManagement()
    {
        empDT = new Employee_Data();
    }

    public Employee getEmployeeProfile(int id)
    {
        try
        {
            rs = empDT.getEmployeeData(id);

            while(rs.next())
            {
                String fullName = rs.getString(1);
                String usrName = rs.getString(2);
                String pwd = rs.getString(3);
                String role = rs.getString(4);
                String project = rs.getString(5);
                String department = rs.getString(6);
                String phone = rs.getString(7);
                Date date = rs.getDate(8);
                int experience = rs.getInt(9);
                String mail = rs.getString(10);
                String gender = rs.getString(11);
                String addr = rs.getString(12);
                String location = rs.getString(13);

                emp = new Employee(fullName, usrName, pwd, role, project, department, phone, date, experience, mail, gender, addr, location);

            }
        }
        catch(SQLException ex)
        {
        }
        return emp;
    }

    public void UpdateEmployeeProfile(int id, String fullname, String phone, String email, String address)
    {
        empDT.UpdateEmployeeProfile(id, fullname, phone, email, address);
    }

    public boolean ChangeEmployeePass()
    {
        boolean chk;

        Employee_ChangePassDialogGUI dialog = new Employee_ChangePassDialogGUI(null, true);

        if(!(dialog.getPwd().equals("")))
        {
            String encryptedPass = new MD5Encrypt().encryptMD5(dialog.getPwd());
            empDT.ChangeEmployeePassword(encryptedPass, Session.getLoginID());
            chk = true;
        }
        else
            chk = false;
        
        return chk;
    }

    public boolean CompareEmployeePassWord(int id, String enteredPass)
    {
        String encryptedPass = new MD5Encrypt().encryptMD5(enteredPass);

        try
        {
            rsCompare = empDT.getEmployeeData(id);

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
