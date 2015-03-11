/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author haohao
 */
@ManagedBean
@RequestScoped
public class DidauchadcBean {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /** Creates a new instance of DidauchadcBean */
    public DidauchadcBean() {
        String sid = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("id");
        id = sid;
    }

    public String test() {
        return "didauchadc.xhtml?id="+id;
    }
}
