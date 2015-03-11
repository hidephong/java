/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Entity.Employee;
import java.sql.*;

/**
 *
 * @author PHUONGPHUONG
 */
public class Employee_Data {
    Connection conn = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    public Employee_Data()
    {
        conn = TheConnection.getConnection();
    }

    public ResultSet getEmployeeData(int empID)
        
    {
        try
        {
            String sql = "{CALL GetEmployeeInfo(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, empID);
            rs = cs.executeQuery();
        }
        catch(SQLException ex)
        {
        }
        return rs;
    }

    public void UpdateEmployeeProfile(int id, String fullname, String phone, String email, String address)
    {
        try
        {
            String sql = "{CALL UpdateEmployeeInfo(?, ?, ?, ?, ?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, fullname);
            cs.setString(3, phone);
            cs.setString(4, email);
            cs.setString(5, address);
            boolean bool = cs.execute();
        }
        catch(SQLException ex)
        {
        }
    }

    public void ChangeEmployeePassword(String encryptedPass, int id)
    {
        try
        {
            String sql = "{CALL ChangeEmployeePassword(?, ?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1, encryptedPass);
            cs.setInt(2, id);
            boolean bool = cs.execute();
        }
        catch(SQLException ex)
        {
        }
    }
}
