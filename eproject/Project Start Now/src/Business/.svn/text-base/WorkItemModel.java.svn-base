/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Entity.WorkItem;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nha.HV
 */
public class WorkItemModel extends AbstractTableModel {
     private  Object[][] WiData;
     private String[] wiCol;

     public  WorkItemModel(Vector<WorkItem> wiVector){
        wiCol = new String[]{"ID","Department","Location","Project","Start Date","End Date","Status"};
        WiData = new Object[wiVector.size()][];


        int i = 0;
        for (WorkItem wi : wiVector) {
            WiData[i] = new Object[wiCol.length];
            WiData[i][0] = wi.getWorkItemID();
            WiData[i][1] = wi.getDepartmentName();
            WiData[i][2] = wi.getLocationAdress();
            WiData[i][3] = wi.getProjectName();
            WiData[i][4] = wi.getStartDate();
            WiData[i][5] = wi.getEndDate();
            WiData[i][6] = wi.getStatus();
            i++;
        }
    }

    @Override
    public String getColumnName(int column) {
        return wiCol[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }




    @Override
    public int getRowCount() {
        return WiData.length;
    }

    @Override
    public int getColumnCount() {
        return wiCol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return WiData[rowIndex][columnIndex];
    }

}
