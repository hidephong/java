/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PHUONGPHUONG
 */
public class ProjectTableModel extends AbstractTableModel{

    Vector<Project> pVector;

    public ProjectTableModel()
    {
        pVector = new Vector<Project>();
    }

    public ProjectTableModel(Vector<Project> vector)
    {
        this.pVector = vector;
    }

    @Override
    public int getRowCount() {
        return pVector.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Project p = null;

        if(rowIndex < 0) {
            return null;
        }
        else {
            p = pVector.get(rowIndex);
        }

        if(columnIndex == 0)
        {
            return p.getProjectID();
        }
        else if(columnIndex == 1)
        {
            return p.getProjectName();
        }
        else
        {
            return p.getStatus();
        }
    }

    @Override
    public String getColumnName(int column)
    {
        String columnName = "";
        switch(column)
        {
            case 0:
                columnName = "Project ID";
                break;
            case 1:
                columnName = "Project Name";
                break;
            case 2:
                columnName = "Status";
                break;
        }
        return columnName;
    }
}
