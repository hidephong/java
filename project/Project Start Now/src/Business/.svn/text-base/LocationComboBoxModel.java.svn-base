/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;


import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Lovely
 */
public class LocationComboBoxModel  extends DefaultComboBoxModel {
private List<String> list = new  ArrayList<String>();
 public LocationComboBoxModel(){};
    public LocationComboBoxModel(List<String> pj){
        this.list= pj;
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

