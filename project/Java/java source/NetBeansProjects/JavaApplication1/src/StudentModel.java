
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class StudentModel extends AbstractTableModel{
  Vector<StudentClass> list;
public StudentModel(Vector<StudentClass> list) {
        this.list = list;
    }
    public int getRowCount() {
    return list.size();
    }

    public int getColumnCount() {
  return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
