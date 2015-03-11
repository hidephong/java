/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

/**
 *
 * @author Lovely
 */

import DataAccess.TheConnection;

import Entity.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lovely
 */
public class DepartmentComboBoxControler {
     Connection Conn = null;
DepartmentComboBoxModel dcbm;
 public DepartmentComboBoxControler(){
    Conn =new TheConnection().getConnection();
    } 

public DepartmentComboBoxModel get_AllDep(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<Department> list = new ArrayList<Department>();
        Department loc= null;
        String sql = "{call get_AllDepartment}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                loc= new Department();
                loc.setDepartmentID(rs.getInt("DepartmentID"));
                loc.setDepartmentName(rs.getString("DepartmentName"));
                loc.setLocationID(rs.getInt("LocationID"));
                loc.setStatus(rs.getNString("Status"));
                list.add(loc);
            }
            rs.close();
            cs.close();
            List<String> rlist = new ArrayList<String>();
            for(Department  ls : list){
            rlist.add(ls.getDepartmentName());
            }
            dcbm= new DepartmentComboBoxModel(rlist);
            return dcbm;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

public int get_DepartmentIDByName(String keyword){
        ResultSet rs = null;
        CallableStatement cs = null;

        Department loc= null;
        String sql = "{call SearchByDepartmentName(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setString(1, keyword.trim());
             rs = cs.executeQuery();
          
              loc= new Department();
if(rs.getRow()>=0){
              while(rs.next()){
                loc.setDepartmentID(rs.getInt("DepartmentID"));
                loc.setDepartmentName(rs.getString("DepartmentName"));
                loc.setLocationID(rs.getInt("LocationID"));
                loc.setStatus(rs.getNString("Status"));
           
    }
}
            rs.close();
            cs.close();

            return loc.getDepartmentID();
           
        }catch (SQLException ex){
            ex.printStackTrace();
            return -1;
        }

    }
public String get_DepartmentNameByID(int depid){
        ResultSet rs = null;
        CallableStatement cs = null;

        Department loc= null;
        String sql = "{call SearchByDepartmentID(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, depid);
             rs = cs.executeQuery();

              loc= new Department();
              if(rs.getRow()>=0){
              while(rs.next()){
                loc.setDepartmentID(rs.getInt("DepartmentID"));
                loc.setDepartmentName(rs.getString("DepartmentName"));
                loc.setLocationID(rs.getInt("LocationID"));
                loc.setStatus(rs.getNString("Status"));
               }
              }
            rs.close();
            cs.close();

            return loc.getDepartmentName();

        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }


}


