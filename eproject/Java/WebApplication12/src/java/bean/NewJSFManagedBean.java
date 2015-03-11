/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author haohao
 */
@ManagedBean
@SessionScoped
public class NewJSFManagedBean {

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String checkLogin() {
        if (username.equals("haohao") && password.equals("123")) {
            return "success.xhtml";
        }
        return "index.xhtml";
    }
    public String didauchadc(){
        return "didauchadc.xhtml";
    }

    /** Creates a new instance of NewJSFManagedBean */
    public NewJSFManagedBean() {
    }
}
