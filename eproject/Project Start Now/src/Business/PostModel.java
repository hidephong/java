/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import DataAccess.PostData;
import Entity.Post;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nha.HV
 */
public class PostModel extends AbstractTableModel{
    public Object[][] RowsData;
    public String[] ColName;
    int iRow;


    public PostModel(Vector<Post> postVector){
        ColName = new String[]{"Role ID", "Role" , "Role Allowance", "Enable"};
        RowsData = new Object[postVector.size()][];
        iRow = 0;
        for (Post post : postVector) {
            RowsData[iRow] = new Object[ColName.length];
            RowsData[iRow][0] = Integer.valueOf(post.getRoleID());
            RowsData[iRow][1] = post.getRole();
            RowsData[iRow][2] = post.getPostAllowance();
            RowsData[iRow][3] = post.getBStatus();
            iRow ++;
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }



    @Override
    public String getColumnName(int column) {
        return ColName[column];
    }

    @Override
    public int getRowCount() {
        return iRow;
    }

    @Override
    public int getColumnCount() {
        return ColName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return RowsData[rowIndex][columnIndex];
    }


}
