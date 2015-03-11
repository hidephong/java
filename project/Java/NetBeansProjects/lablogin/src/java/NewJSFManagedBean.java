/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.User;
import entity.conn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@SessionScoped
public class NewJSFManagedBean implements Serializable{
 private List<User> lst;
    /** Creates a new instance of NewJSFManagedBean */
    public NewJSFManagedBean() {
        lst= new  ArrayList<User>();
        conn c= new conn();
        lst=c.getAll();
    }

    /**
     * @return the lst
     */
    public List<User> getLst() {
        return lst;
    }

    /**
     * @param lst the lst to set
     */
    public void setLst(List<User> lst) {
        this.lst = lst;
    }
    public String login(){
    return "index.xhtml";
    }
   

}
