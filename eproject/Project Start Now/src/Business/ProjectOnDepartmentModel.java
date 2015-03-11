/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lovely
 */
public class ProjectOnDepartmentModel extends DefaultComboBoxModel {
     
  List<String> list = new  ArrayList<String>();
  public ProjectOnDepartmentModel(){};
    public ProjectOnDepartmentModel(List<String> pod){
        this.list= pod;
    }


    @Override
    public int getSize() {
      return list.size();
    }

    @Override
    public Object getElementAt(int index) {
    return list.get(index).toString();
    }

}

