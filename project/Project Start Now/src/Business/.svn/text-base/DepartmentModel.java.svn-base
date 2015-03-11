/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Entity.Department;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nha.HV
 */
public class DepartmentModel extends AbstractTableModel {
    private  Object[][] DepartmentData;
    private String[] ColumnHeader;
   
    public DepartmentModel(Vector<Department> departmentVector){
        ColumnHeader = new String[]{"ID","Department Name","Location","Enabled"};
        DepartmentData = new Object[departmentVector.size()][];
     
                
        int i = 0;
        for (Department department : departmentVector) {
            DepartmentData[i] = new Object[ColumnHeader.length];
            DepartmentData[i][0] = department.getDepartmentID();
            DepartmentData[i][1] = department.getDepartmentName();
            DepartmentData[i][2] = department.getLocationAddress();
            DepartmentData[i][3] = department.getBooleanStatus();
            
        
            i++;
        }
        
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
    
    
    
    @Override
    public String getColumnName(int column) {
        return ColumnHeader[column];
    }

    
    
    @Override
    public int getRowCount() {
        return DepartmentData.length;
    }

    @Override
    public int getColumnCount() {
        return ColumnHeader.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DepartmentData[rowIndex][columnIndex];
    }
    

}
