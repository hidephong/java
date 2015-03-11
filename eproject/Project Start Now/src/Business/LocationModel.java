/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Entity.Location;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nhahv
 */
public class LocationModel extends AbstractTableModel {
    public Object[][] TableObjectses;
    public String[] columns;
    public LocationModel(Vector<Location> location){
        TableObjectses = new Object[location.size()][];
        int i = 0;
        columns = new String[]{"Location ID", "Location Adress", "Location Allowances", "Status"};
        for (Location l : location) {
            TableObjectses[i] = new Object[columns.length];
            TableObjectses[i][0] = Integer.valueOf(l.getLocationID());
            TableObjectses[i][1] = l.getLocationAddress();
            TableObjectses[i][2] = l.getLocationAllowance();
            TableObjectses[i][3] = l.getLocationStatus();
            i++;
        }
    }
    
    @Override
    public String getColumnName(int col){
        return columns[col];
    }
    
    
    @Override
    public int getRowCount() {
       return TableObjectses.length;
    }

    @Override
    public int getColumnCount() {
         return columns.length;
    }

    @Override
    public Object getValueAt(int iRow, int iCol) {
        return TableObjectses[iRow][iCol];
        
    }
    
    

}
