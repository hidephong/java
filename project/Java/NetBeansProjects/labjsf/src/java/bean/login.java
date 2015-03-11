/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class login {
String username;

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
String password;
    /** Creates a new instance of login */
    public login() {
    }
public String check(){
    if(username.equals("admin")&&password.equals("123")){
    return "success";
    }
return "fail";
}
}
