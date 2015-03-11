/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.text.SimpleDateFormat;
public class EmployeeManager {
    Connection Conn = null;
    EmployeeModel em;
 List<Employee> list = new ArrayList<Employee>();
  public EmployeeManager(){
    Conn =new TheConnection().getConnection();
    }
public  EmployeeModel getAllEmployee(){
        ResultSet rs = null;
        CallableStatement cs = null;
        list.clear();
        Employee emp = null;
        String sql = "{call getAllEmployee}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
                list.add(emp);
            }
            rs.close();
            cs.close();
            em= new EmployeeModel(list);
            return em;
        }catch (SQLException ex){
            return null;
        }
    }


       public  boolean update(Employee emp){
            String sql = "{call updateEmployee(?,?,?,?,?,?,?,?,?,?,?)}";
            int i;
            try{
                CallableStatement cs = Conn.prepareCall(sql);

                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = formatter.format(emp.getJoiningDate());

                cs.setInt(1,emp.getEmployeeID());
                cs.setString(2,emp.getEmployeeName());
                cs.setInt(3,emp.getRoleID());
                cs.setInt(4,emp.getWorkExperience());
                cs.setInt(5,emp.getWorkItemID());
                cs.setString(6, formattedDate);
                cs.setString(7,emp.getPhoneNumber());
                cs.setString(8,emp.getEmail());
                cs.setString(9,emp.getGender());
                cs.setString(10,emp.getAddress());
                cs.setString(11,emp.getStatus());
                 i = cs.executeUpdate();
                cs.close();
                if(i == 1){
                    return true;
                }
                else{
                    return false;
                }
            }catch(Exception ex){
                return false;
            }
        }
public  boolean add(Employee emp){
            String sql = "{call addEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}";

            try{
                CallableStatement cs = Conn.prepareCall(sql);
                String encryptedPass = new MD5Encrypt().encryptMD5( emp.getPassword());
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
                String formattedDate = formatter.format(emp.getJoiningDate());
                cs.setString(1,emp.getUsername());
                cs.setString(2,emp.getEmployeeName());
                cs.setString(3,encryptedPass);
                cs.setInt(4,emp.getRoleID());
                cs.setInt(5,emp.getWorkExperience());
                cs.setInt(6,emp.getWorkItemID());
                cs.setString(7, formattedDate);
                cs.setString(8,emp.getPhoneNumber());
                cs.setString(9,emp.getEmail());
                cs.setString(10,emp.getGender());
                cs.setString(11,emp.getAddress());
                cs.setString(12,emp.getStatus());
               int ResultCode = cs.executeUpdate();
            cs.close();
            if(ResultCode == 1){
                return  true;
            }else{
                return false;
            }

            }catch(Exception ex){
                                return false;
            }
         }

 public  boolean delEmployee(int del_id){
            String sql = "{call delEmployee(?)}";
              int i = 0;
            try{
                CallableStatement cs = Conn.prepareCall(sql);
                cs.setInt(1,del_id);
                i = cs.executeUpdate();
                cs.close();
                if(i == 1){
                    return true;
                }
                else{
                    return false;
                }
            }catch(Exception ex){
                return false;
            }
         }

 public void UpdateAfterDelete_Employee(int empID)
        {
            try
            {
                if(Conn == null)
                        return;

                String sql = "{CALL UpdateAfterDelete_Employee(?)}";
                CallableStatement cs = Conn.prepareCall(sql);
                cs = Conn.prepareCall(sql);
                cs.setInt(1, empID);
                boolean bool = cs.execute();
            }
            catch(SQLException e)
            {
            }
        }

public  Employee getAllEmployeeByID(int inp){
        ResultSet rs = null;
        CallableStatement cs = null;
        Employee emp = null;
        String sql = "{call getAllEmployeeByID(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, inp);
            rs = cs.executeQuery();
           if(rs.getRow()>=0){   rs.next();
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
            }
            rs.close();
            cs.close();
            return emp;
        }catch (SQLException ex){
            return null;
        }

    }

public  Employee getEmployeeByUsername(String str){
        ResultSet rs = null;
        CallableStatement cs = null;
        Employee emp = null;
        String sql = "{call getAllEmployeeByUsername(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setString(1, str);
            rs = cs.executeQuery();
           if(rs.getRow()>=0){   rs.next();
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
            }
            rs.close();
            cs.close();
            return emp;
        }catch (SQLException ex){
            return null;
        }

    }

public  Employee getEmployeeByFullname(String str){
        ResultSet rs = null;
        CallableStatement cs = null;
        Employee emp = null;
        String sql = "{call getEmployeeByFullname(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setString(1, str);
            rs = cs.executeQuery();
           if(rs.getRow()>=0){   rs.next();
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
            }
            rs.close();
            cs.close();
            return emp;
        }catch (SQLException ex){
            return null;
        }

    }

public  EmployeeModel getEmployeeBy(int icase, String str){
        ResultSet rs = null;
        CallableStatement cs = null;
        Employee emp = null;
        list.clear();
         String sql="";// = "{call getAllEmployeeByUsername(?)}";
         switch(icase){
            case 1:
                 sql = "{call getAllEmployeeByFullname(?)}";
                break;
            case 2:
                sql = "{call getAllEmployeeByGender(?)}" ;
                break;
            case 3:
                 sql = "{call getAllEmployeeByAddress(?)}" ;
                 break;
            case 4:
                  sql = "{call getAllEmployeeByRole(?)}" ;
                  break;
            case 5:
                 sql = "{call getAllEmployeeByProject(?)}" ;
                 break;
            case 6:
                sql = "{call getAllEmployeeByDepartment(?)}" ;
                break;
            case 7:
            sql = "{call getAllEmployeeByEmail(?)}" ;
                  break;
            case 8:
                  sql = "{call getAllEmployeeByLocation(?)}" ;
                 break;
            case 9:
                 sql = "{call getAllEmployeeByPhoneNumber(?)}" ;
                 break;
            case 10:
                 sql = "{call getAllEmployeeByStatus(?)}";
                 break;
             case 11:
                sql = "{call getAllEmployeeByUsername(?)}";
                 break;

              }

        try{
            cs = Conn.prepareCall(sql);
            cs.setString(1,"%"+ str+"%");
            rs = cs.executeQuery();
          while(rs.next()){
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
            list.add(emp);
            }
            rs.close();
            cs.close();
            em= new EmployeeModel(list);
            return em;
        }catch (SQLException ex){
            return null;
        }

    }
public  EmployeeModel getEmployeeByJoiningDate(java.sql.Date dt){
        ResultSet rs = null;
        CallableStatement cs = null;
        Employee emp = null;
        String   sql = "{call getAllEmployeeByJoiningDate(?)}" ;
        try{
            cs = Conn.prepareCall(sql);
            cs.setDate(1,(java.sql.Date) dt);
            rs = cs.executeQuery();
             while(rs.next()){
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
            list.add(emp);
            }
            rs.close();
            cs.close();
            em= new EmployeeModel(list);
            return em;
        }catch (SQLException ex){
            return null;
        }

    }

     public  EmployeeModel getEmployeeByExperience(int iexp){
        ResultSet rs = null;
        CallableStatement cs = null;
        Employee emp = null;
        String sql = "{call getAllEmployeeByExperience(?)}" ;
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1,iexp);
            rs = cs.executeQuery();
            while(rs.next()){
                emp = new Employee();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setEmployeeName(rs.getString("EmployeeName"));
                emp.setUsername(rs.getString("UserName"));
                emp.setGender(rs.getString("Gender"));
                emp.setRole(rs.getString("Role"));
                emp.setCurrentProject(rs.getString("ProjectName"));
                emp.setCurrentDepartment(rs.getString("DepartmentName"));
                emp.setLocation(rs.getString("LocationAddress"));
                emp.setJoiningDate(rs.getDate("JoiningDate"));
                emp.setEmail(rs.getString("Email"));
                emp.setWorkExperience(rs.getInt("WorkExperience"));
                emp.setAddress(rs.getString("Address"));
                emp.setPhoneNumber(rs.getString("PhoneNumber"));
                emp.setStatus(rs.getString("Status"));
            list.add(emp);
            }
            rs.close();
            cs.close();
            em= new EmployeeModel(list);
            return em;
        }catch (SQLException ex){
            return null;
        }

    }
    public  boolean updateEWorkitem(Employee emp,int iwkid){
            String sql = "{call updateEWorkitem(?,?)}";
            int i=0;
            try{
                CallableStatement cs = Conn.prepareCall(sql);
                cs.setInt(1,emp.getEmployeeID());
                cs.setInt(2,iwkid);

                 i = cs.executeUpdate();
                cs.close();
                if(i == 1){
                    return true;
                }
                else{
                    return false;
                }
            }catch(Exception ex){
                return false;
            }
        }
}
