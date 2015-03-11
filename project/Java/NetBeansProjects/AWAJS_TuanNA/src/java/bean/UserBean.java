/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.dal.UserLoginDAL;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class UserBean {

    private String uUser;
    private String usPassword;

    /** Creates a new instance of UserBean */
    public UserBean() {
    }

    /**
     * @return the uUser
     */
    public String getuUser() {
        return uUser;
    }

    /**
     * @param uUser the uUser to set
     */
    public void setuUser(String uUser) {
        this.uUser = uUser;
    }

    /**
     * @return the usPassword
     */
    public String getUsPassword() {
        return usPassword;
    }

    /**
     * @param usPassword the usPassword to set
     */
    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }
     public String checkLogin() {
        UserLoginDAL userLoginDAL = new UserLoginDAL();
        if (userLoginDAL.checkLogin(uUser, usPassword)) {
            return "bookview.xhtml";
        }
        return "userlogin.xhtml";
    }
}
