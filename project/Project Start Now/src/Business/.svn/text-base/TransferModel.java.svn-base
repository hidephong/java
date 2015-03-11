/*
 * To change this ttranslate, choose Tools | Ttranslates
 * and open the ttranslate in the editor.
 */

package Business;

import javax.swing.table.AbstractTableModel;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lovely
 */

public class TransferModel extends AbstractTableModel{
    int count=13;
    private List<TransferRecord> list = new  ArrayList<TransferRecord>();
    public TransferModel(){};
    public TransferModel(List<TransferRecord> trans){
        this.list= trans;
    }
  @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return count;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TransferRecord trans = list.get(rowIndex);

        switch(columnIndex){
            case 0:
                return trans.getRecordID();
            case 1:
                return trans.getEmployeeID();
            case 2:
                return trans.getEmployeeName();
            case 3:
                return trans.getWorkItemID();
            case 4:
                return trans.getRelievingDate();
            case 5:
                return trans.getReportingManager();
            case 6:
                return trans.getAllowance();
            case 7:
                return trans.getCreationDate();
            case 8:
                return trans.getLocationAddress();
            case 9:
                return trans.getTransferReason();
            case 10:
                return trans.getProjectName();
            case 11:
                return trans.getDepartmentName();
            case 12:
                 return trans.getStatus();
        }
        return null;

    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "RecordID";
            case 1:
                return "EmployeeID";
            case 2:
                return "EmployeeName";
            case 3:
                return "WorkItemID";
            case 4:
                return "RelievingDate";
            case 5:
                return "ReportingManager";
            case 6:
                return "Allowance";
            case 7:
                return "CreationDate";
            case 8:
                return "LocationAddress";
            case 9:
                return "TransferReason";
            case 10:
                return "ProjectName";
            case 11:
                return "DepartmentName";
            case 12:
                return "Status";

        }
        return null;
    }
    public TransferRecord getElementAt(int rowIndex){
        return list.get(rowIndex);
    }

}
