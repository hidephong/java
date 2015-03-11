/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;
import DataAccess.*;
import Entity.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Lovely
 */
public class TransferManagement {

    Connection Conn = null;
    TransferModel tm;

 public TransferManagement(){
    Conn = TheConnection.getConnection();
    }
public  TransferModel getAllTransfer(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getAllTransfer}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();
            tm= new TransferModel(list);
               return tm;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

      public  boolean delTransfer(int del_id){
            String sql = "{call delTransfer(?)}";
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
public  TransferModel getAllTransferByEmpID(int empid){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getAllTransferByEmpID(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, empid);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();
            tm= new TransferModel(list);
               return tm;
        }catch (SQLException ex){
            return null;
        }

    }
public  TransferModel getLastTransferByEmpID(int empid){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getLastTransferByEmpID(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, empid);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();
            tm= new TransferModel(list);
               return tm;
        }catch (SQLException ex){
            return null;
        }

    }
public  TransferModel getAllTransferBy(String strsearch, int icase) throws SQLException{
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
         String sql;
         switch(icase){

            case 0:
              sql = "{call getAllTransferByEmpID(?)}";
                  cs = Conn.prepareCall(sql);
                  cs.setInt(1,Integer.parseInt(strsearch));
                break;
            
            case 2:
               sql = "{call getAllTransferByRelievingDate(?)}";
                cs = Conn.prepareCall(sql);
                cs.setDate(1,java.sql.Date.valueOf(strsearch));
                break;
            case 3:
                sql = "{call getAllTransferByReportingManager(?)}";
                  cs = Conn.prepareCall(sql);
                  cs.setInt(1,Integer.parseInt(strsearch));
                break;
            case 4:
            sql = "{call getAllTransferByToProject(?)}";  
                  cs = Conn.prepareCall(sql);
                  cs.setString(1,"%"+strsearch+"%");

                break;
            case 5:
               sql = "{call getAllTransferByToDepartment(?)}";
                cs = Conn.prepareCall(sql);
                cs.setString(1,"%"+strsearch+"%");
                break;
                 case 6:
               sql = "{call getAllTransferByStatus(?)}";
                cs = Conn.prepareCall(sql);
                cs.setString(1,"%"+strsearch+"%");
                break;
  }
        try{
          
          
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                 trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();
            tm= new TransferModel(list);
               return tm;
        }catch (SQLException ex){
            return null;
        }

    }
 public boolean UpdateTransferByID(int id, String stt,String manstr,float fAllow)
    {
    
        CallableStatement cs = null;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 7);
        java.util.Date dt =  c.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String formattedDate = formatter.format(dt);
      try
        {
            String sql = "{CALL UpdateTransferByID(?,?,?,?,?)}";
            cs = Conn.prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2,formattedDate);
            cs.setString(3, manstr);
            cs.setString(4, stt);
            cs.setFloat(5,fAllow);
           int ResultCode = cs.executeUpdate();
            cs.close();
            if(ResultCode == 1){
                return  true;
            }else{
                return false;
            }
        }
        catch(SQLException ex)
        {
        }
        return false;
    }

 public boolean E_RequestATransfer(TransferRecord tr){
        try {
            CallableStatement cs = null;
            String E_RequestATransfer = "{Call E_RequestATransfer(?,?,?)}";
            cs = Conn.prepareCall(E_RequestATransfer);
            cs.setInt(1, tr.getEmployeeID());
            cs.setInt(2, tr.getWorkItemID());
            cs.setString(3, tr.getTransferReason());
            int ResultCode = cs.executeUpdate();
            cs.close();
            if(ResultCode == 1){
                return  true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
           return false;
        }
 }

 public  TransferModel getEmployeeTransferByEmpID(int empid){
     System.out.println(">>>>>>>>>>>>>>>>>>" + empid);
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getEmployeeTransferByEmpID(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, empid);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();
            tm= new TransferModel(list);
               return tm;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

 public  TransferModel getAllPendingTransfer(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getAllPendingTransfer}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();
            tm = new TransferModel(list);
               return tm;
        }catch (SQLException ex){
            return null;
        }

    }
public boolean DelTransferBytransferID(int id)
    {

        CallableStatement cs = null;

        try
        {
            String sql = "{CALL DelTransferByID(?)}";
            cs = Conn.prepareCall(sql);
            cs.setInt(1, id);
            boolean bool = cs.execute();
            return bool;
        }
        catch(SQLException ex)
        {
        }
        return false;
    }
 public void UpdateAfterDelete_Transfer(int trID)
        {
            try
            {
                if(Conn == null)
                        return;

                String sql = "{CALL UpdateAfterDelete_Transfer(?)}";
                CallableStatement cs = Conn.prepareCall(sql);
                cs = Conn.prepareCall(sql);
                cs.setInt(1, trID);
                boolean bool = cs.execute();
            }
            catch(SQLException e)
            {
            }
        }


public Vector<TransferRecord> TransferfindFrom(int empid){
         ResultSet rs = null;
        CallableStatement cs = null;
        Vector<TransferRecord> list = new Vector<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getTransferNext(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, empid);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();

               return list;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
        }
public  TransferRecord getTransferByTransferID(int trid){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getTransferByTransferID(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setInt(1, trid);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
            }
            rs.close();
            cs.close();

               return trans;
        }catch (SQLException ex){
            return null;
        }

    }

public  DefaultComboBoxModel getAllTransferID(){
        ResultSet rs = null;
        CallableStatement cs = null;
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        List<TransferRecord> list = new ArrayList<TransferRecord>();
        TransferRecord trans = null;
        String sql = "{call getAllTransferNotComplete}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                trans = new TransferRecord();
                trans.setRecordID(rs.getInt("RecordID"));
                trans.setEmployeeID(rs.getInt("EmployeeID"));
                trans.setWorkItemID(rs.getInt("WorkItemID"));
                trans.setRelievingDate(rs.getDate("RelievingDate"));
                trans.setReportingManager(rs.getString("ReportingManager"));
                trans.setAllowance(rs.getFloat("Allowance"));
                trans.setLocationAddress(rs.getString("LocationAddress"));
                trans.setCreationDate(rs.getDate("CreationDate"));
                trans.setTransferReason(rs.getString("TransferReason"));
                trans.setProjectName(rs.getString("ProjectName"));
                trans.setDepartmentName(rs.getString("DepartmentName"));
                trans.setEmployeeName(rs.getString("EmployeeName"));
                trans.setStatus(rs.getString("Status"));
                list.add(trans);
                dcbm.addElement(trans.getRecordID());
            }
            rs.close();
            cs.close();

               return dcbm;
        }catch (SQLException ex){
            return null;
        }

    }

}
