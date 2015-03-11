/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class lstbean {
List<String> lst= new ArrayList<String>();

    public List<String> getLst() {
        return lst;
    }

    public void setLst(List<String> lst) {
        this.lst = lst;
    }
    /** Creates a new instance of lstbean */
    public lstbean() {
lst.add("demo");
lst.add("demo tiep");
    }

}
