/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author haohao
 */
@ManagedBean
@RequestScoped
public class ListBean {

    private String selectedValue;
    private List<Product> list = new ArrayList<Product>();

    {
        list.add(new Product("1", "hao hao"));
        list.add(new Product("2", "miliket"));
        list.add(new Product("3", "omachi"));
    }

    public List<SelectItem> getListForCombo() {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Product p : list) {
            l.add(new SelectItem(p.getId(), p.getName()));
        }
        return l;
    }
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String viewDetail() {
        String sid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("thu");
        this.id = sid;
        return "didauchadc.xhtml?id=" + id;
    }

    public void changeValue(ValueChangeEvent e) {
        e.getNewValue().toString();
    }

    /** Creates a new instance of ListBean */
    public ListBean() {
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }
}
