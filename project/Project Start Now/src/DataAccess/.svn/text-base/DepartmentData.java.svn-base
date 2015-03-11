/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;
import Entity.Department;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author TITS
 */
public class DepartmentData {
     Connection conn;
     CallableStatement    CallStmt;
     ResultSet            Resultset;
    public DepartmentData(){
        conn = TheConnection.getConnection();
        CallStmt = null;
        Resultset = null;
    }
  
    public Vector<Department> getAllDepartment(){
       
            String sqlGetAllDept = "{Call GetAllDepartment}";
            Department dept = null;
            CallStmt = null;
            Resultset = null;
            Vector<Department> departmentVector = new Vector<Department>();
       try {   
            CallStmt = conn.prepareCall(sqlGetAllDept);
           
            Resultset = CallStmt.executeQuery();
            while (Resultset.next()) {
                dept = new Department();
                dept.setDepartmentID(Resultset.getInt(1));
                dept.setDepartmentName(Resultset.getString(2));
                dept.setLocationAddress(Resultset.getString(3));
                dept.setStatus(Resultset.getString(4));
                dept.setLocationID(Resultset.getInt(5));

            
                departmentVector.add(dept);
            }
            
            Resultset.close();
            CallStmt.close();
            return departmentVector;
        } catch (SQLException ex) {
            return null;
        }
    }
    public boolean addADepartment(Department dept){
       String SqlAddADept = "{Call addADepartment(?,?,?)}"; 
       CallStmt     = null;
       int ResultCode = 0;
        try {
            CallStmt = conn.prepareCall(SqlAddADept);
            CallStmt.setString(1, dept.getDepartmentName());
            CallStmt.setString(2, dept.getLocationAddress());
            CallStmt.setString(3, dept.getStatus());
            ResultCode = CallStmt.executeUpdate();
            CallStmt.close();
            if (ResultCode == 1) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            //@DelHere 
            System.out.println(ex.toString());
            //
            return false;
        }
   }
    public boolean updateADepartment(Department dept){
        
            String SQLUpdateADept = "{Call UpdateADepartment(?,?,?,?)}";
            CallStmt = null;
            int ResultCode = 0;
        try {    
            CallStmt = conn.prepareCall(SQLUpdateADept);
            CallStmt.setInt(1,dept.getDepartmentID());
            CallStmt.setString(2,dept.getDepartmentName());
            CallStmt.setString(3,dept.getLocationAddress());
            CallStmt.setString(4,dept.getStatus());
            ResultCode = CallStmt.executeUpdate();
            CallStmt.close();
            if(ResultCode == 1){
                return  true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            //DelHere:---
            ex.printStackTrace();
            //
            return false;
        }
    }
    
    public boolean deleteADepartment(int DeptID){
        String SQLDelete = "{Call deleteADepartment(?)}";
        CallStmt    = null;
        int ResultCode = 0;
        try {
            CallStmt = conn.prepareCall(SQLDelete);
            CallStmt.setInt(1, DeptID);
            ResultCode = CallStmt.executeUpdate();
            if(ResultCode == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 547){
               JOptionPane.showMessageDialog(null, "Can not delete because this record is in use. The status of this project will be set to disabled",  "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }

     /*
     * @ update after unsuccessfully deleting
     */
    public void UpdateAfterDelete_Department(int depID)
    {
        try
        {
            if(conn == null)
                    return;

            String sql = "{CALL UpdateAfterDelete_Department(?)}";
            CallStmt = conn.prepareCall(sql);
            CallStmt = conn.prepareCall(sql);
            CallStmt.setInt(1, depID);
            boolean bool = CallStmt.execute();
        }
        catch(SQLException e)
        {
        }
    }
}
