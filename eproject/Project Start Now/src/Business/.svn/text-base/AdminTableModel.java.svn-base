/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Entity.Admin;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nha.HV
 */
public class AdminTableModel  extends AbstractTableModel {
    public Object[][] TableObjectses;
    public String[] columns;
    public AdminTableModel(Vector<Admin> va){
        TableObjectses = new Object[va.size()][];
        int i = 0;
        columns = new String[]{"Admin ID", "Admin Name", "Username"};
        for (Admin a : va) {
            TableObjectses[i] = new Object[columns.length];
            TableObjectses[i][0] = Integer.valueOf(a.getAdminID());
            TableObjectses[i][1] = a.getAdminName();
            TableObjectses[i][2] = a.getAdminUsrname();
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
