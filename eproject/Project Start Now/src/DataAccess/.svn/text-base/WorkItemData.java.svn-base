/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;
import Entity.WorkItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author TITS
 */
public class WorkItemData {
     final SimpleDateFormat SQLDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
     Connection conn;
     CallableStatement    csWi;
     ResultSet            rsWi;
     WorkItem             wi;
     Vector<WorkItem>     wiVector;


    public WorkItemData(){
        conn = TheConnection.getConnection();
        csWi = null;
        rsWi = null;
    }

    public Vector<WorkItem> getAllWorkItems(){

            String sqlgetAllWorkItems = "{Call getAllWorkItems}";
           
            csWi = null;
            rsWi = null;
           wiVector = new Vector<WorkItem>();
       try {
            csWi = conn.prepareCall(sqlgetAllWorkItems);

            rsWi = csWi.executeQuery();
            while (rsWi.next()) {
                wi = new WorkItem();
                wi.setWorkItemID(rsWi.getInt(1));
                wi.setDepartmentID(rsWi.getInt(2));
                wi.setProjectID(rsWi.getInt(3));
                wi.setStartDate(rsWi.getDate(4));
                wi.setEndDate(rsWi.getDate(5));
                wi.setStatus(rsWi.getString(6));
                //-----
                wi.setDepartmentName(rsWi.getString(7));
                wi.setProjectName(rsWi.getString(8));
                wi.setLocationAdress(rsWi.getString(9));
                wi.setLocationID(rsWi.getInt(10));

            
                wiVector.add(wi);
            }

            rsWi.close();
            csWi.close();
            return wiVector;
        } catch (SQLException ex) {
            return null;
        }
    }
    public int addAWorkItem(WorkItem wi){
       String SqlAddAWi = "{Call addAWorkItem(?,?,?,?,?)}";
       csWi     = null;
       int ResultCode = 0;
        try {
            csWi = conn.prepareCall(SqlAddAWi);
            csWi.setInt(1, wi.getDepartmentID());
            csWi.setInt(2, wi.getProjectID());
            csWi.setDate(3, new java.sql.Date(wi.getStartDate().getTime()));
            csWi.setDate(4, new java.sql.Date(wi.getEndDate().getTime()));
            csWi.setString(5, wi.getStatus());

            ResultCode = csWi.executeUpdate();
            csWi.close();
            return ResultCode;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return ResultCode;
        }
   }
    public boolean UpdateAWorkItem(WorkItem wi){

            String SQLUpdateAWi = "{Call UpdateAWorkItem(?,?,?,?,?,?)}";
            csWi = null;
            int ResultCode = 0;
        try {
            csWi = conn.prepareCall(SQLUpdateAWi);
            csWi.setInt(1, wi.getWorkItemID());
            csWi.setInt(2, wi.getDepartmentID());
            csWi.setInt(3, wi.getProjectID());
            csWi.setString(4, SQLDATEFORMAT.format(wi.getStartDate()));
            csWi.setString(5, SQLDATEFORMAT.format(wi.getEndDate()));
            csWi.setString(6, wi.getStatus());
            ResultCode = csWi.executeUpdate();
            csWi.close();
            System.out.println("RSC " + ResultCode);
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

    public boolean deleteAWorkItem(int wiID){
        String SQLdeleteAWorkItem = "{Call deleteAWorkItem(?)}";
        csWi    = null;
        int ResultCode = 0;
        try {
            csWi = conn.prepareCall(SQLdeleteAWorkItem);
            csWi.setInt(1, wiID);
            ResultCode = csWi.executeUpdate();
            if(ResultCode == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 547){
               JOptionPane.showMessageDialog(null, "Error: Cannot delete the Department has being active. Code: "+ ex.getErrorCode());
            }
            return false;
        }
    }
    public Vector<WorkItem> checkConfictWorkItems(WorkItem wi){
        String checkConfictWorkItems = "{Call checkConfictWorkItems(?,?,?,?,?)}";

            csWi = null;
            rsWi = null;
           wiVector = new Vector<WorkItem>();
       try {
            csWi = conn.prepareCall(checkConfictWorkItems);
            csWi.setInt(1, wi.getWorkItemID());
            csWi.setInt(2, wi.getDepartmentID());
            csWi.setInt(3,wi.getProjectID());
            csWi.setString(4, SQLDATEFORMAT.format(wi.getStartDate()));
            csWi.setString(5, SQLDATEFORMAT.format(wi.getEndDate()));
            rsWi = csWi.executeQuery();
            while (rsWi.next()) {
                wi = new WorkItem();
                wi.setWorkItemID(rsWi.getInt(1));
                wi.setDepartmentID(rsWi.getInt(2));
                wi.setProjectID(rsWi.getInt(3));
                wi.setStartDate(rsWi.getDate(4));
                wi.setEndDate(rsWi.getDate(5));
                wi.setStatus(rsWi.getString(6));
                //-----
 


                wiVector.add(wi);
            }

            rsWi.close();
            csWi.close();
            return wiVector;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
public Vector<WorkItem> getWorkItemsForTransfer(){

            String sqlgetAllWorkItems = "{Call getWorkItemsForTransfer}";

            csWi = null;
            rsWi = null;
           wiVector = new Vector<WorkItem>();
       try {
            csWi = conn.prepareCall(sqlgetAllWorkItems);

            rsWi = csWi.executeQuery();
            while (rsWi.next()) {
                wi = new WorkItem();
                wi.setWorkItemID(rsWi.getInt(1));
                wi.setDepartmentID(rsWi.getInt(2));
                wi.setProjectID(rsWi.getInt(3));
                wi.setStartDate(rsWi.getDate(4));
                wi.setEndDate(rsWi.getDate(5));
                wi.setStatus(rsWi.getString(6));
                //-----
                wi.setDepartmentName(rsWi.getString(7));
                wi.setProjectName(rsWi.getString(8));
                wi.setLocationAdress(rsWi.getString(9));
                wi.setLocationID(rsWi.getInt(10));


                wiVector.add(wi);
            }

            rsWi.close();
            csWi.close();
            return wiVector;
        } catch (SQLException ex) {
            return null;
        }
    }
 
    

}
