/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;


/**
 *
 * @author Lovely
 */

import DataAccess.*;
import Entity.*;
import java.util.*;
import java.sql.*;
public class ProjectOnDepManagement {
    Connection Conn = null;
ProjectOnDepartmentModel em;
 public  ProjectOnDepManagement(){
    Conn =new TheConnection().getConnection();
    }
public  ProjectOnDepartmentModel getAllProjectOnDepartment(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<ProjectOnDepartment> list = new ArrayList<ProjectOnDepartment>();
        ProjectOnDepartment emp = null;
        String sql = "{call getAllProjectOnDepartment}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                emp = new ProjectOnDepartment();
                emp.setWorkItemID(rs.getInt("WorkItemID"));
                emp.setDepartmentID(rs.getInt("DepartmentID"));
                emp.setProjectID(rs.getInt("ProjectID"));
                emp.setProjectName(rs.getString("ProjectName"));
                emp.setDepartmentName(rs.getString("DepartmentName"));
                emp.setLocationAddress(rs.getString("LocationAddress"));
                emp.setStartDate(rs.getDate("StartDate"));
                emp.setEndDate(rs.getDate("EndDate"));
                emp.setStatus(rs.getString("Status"));
                list.add(emp);
            }
            rs.close();
            cs.close();

            List<String> rlist = new ArrayList<String>();
            for(ProjectOnDepartment  ls : list){
            rlist.add(ls.getProjectName()+ " on " +ls.getDepartmentName());
            }
            em= new ProjectOnDepartmentModel(rlist);
            return em;
       }
            catch (SQLException ex){
            return null;
        }

    }

public  ProjectOnDepartmentModel getAllProjectOnDepartmentByLoc(String DepName){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<ProjectOnDepartment> list = new ArrayList<ProjectOnDepartment>();
        ProjectOnDepartment emp = null;
        String sql = "{call getAllProjectOnDepartmentByLoc(?)}";
        try{
            cs = Conn.prepareCall(sql);
              cs.setString(1,DepName);
            rs = cs.executeQuery();
            while(rs.next()){
                emp = new ProjectOnDepartment();
                emp.setWorkItemID(rs.getInt("WorkItemID"));
                emp.setDepartmentID(rs.getInt("DepartmentID"));
                emp.setProjectID(rs.getInt("ProjectID"));
                emp.setProjectName(rs.getString("ProjectName"));
                emp.setDepartmentName(rs.getString("DepartmentName"));
                emp.setLocationAddress(rs.getString("LocationAddress"));
                emp.setStartDate(rs.getDate("StartDate"));
                emp.setEndDate(rs.getDate("EndDate"));
                emp.setStatus(rs.getString("Status"));
                list.add(emp);
            }
            rs.close();
            cs.close();

            List<String> rlist = new ArrayList<String>();
            for(ProjectOnDepartment  ls : list){
            rlist.add(ls.getProjectName()+ " on " +ls.getDepartmentName());
            }
            em= new ProjectOnDepartmentModel(rlist);
            return em;
       }
            catch (SQLException ex){
            return null;
        }

    }
public  int getWorkItemID(String ProjectOnDepName){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<ProjectOnDepartment> list = new ArrayList<ProjectOnDepartment>();
        ProjectOnDepartment emp = null;
        String sql = "{call getWorkItemIDByProjDep(?)}";
        try{
            cs = Conn.prepareCall(sql);
              cs.setString(1,"%"+ProjectOnDepName+"%");
            rs = cs.executeQuery();
            while(rs.next()){
                emp = new ProjectOnDepartment();
                emp.setWorkItemID(rs.getInt("WorkItemID"));
                emp.setDepartmentID(rs.getInt("DepartmentID"));
                emp.setProjectID(rs.getInt("ProjectID"));
                emp.setProjectName(rs.getString("ProjectName"));
                emp.setDepartmentName(rs.getString("DepartmentName"));
                emp.setLocationAddress(rs.getString("LocationAddress"));
                emp.setStartDate(rs.getDate("StartDate"));
                emp.setEndDate(rs.getDate("EndDate"));
                emp.setStatus(rs.getString("Status"));
                list.add(emp);
            }
            rs.close();
            cs.close();


            return emp.getWorkItemID();
       }
            catch (SQLException ex){
            return -1;
        }

    }
}
