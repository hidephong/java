/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.dal.AdminLoginDAL;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class AdminBean {
    private int aID;
    private String adName;
    private String adPassword;
    private String adEmail;
    /** Creates a new instance of AdminBean */
    public AdminBean() {
    }

    /**
     * @return the aID
     */
    public int getaID() {
        return aID;
    }

    /**
     * @param aID the aID to set
     */
    public void setaID(int aID) {
        this.aID = aID;
    }

    /**
     * @return the adName
     */
    public String getAdName() {
        return adName;
    }

    /**
     * @param adName the adName to set
     */
    public void setAdName(String adName) {
        this.adName = adName;
    }

    /**
     * @return the adPassword
     */
    public String getAdPassword() {
        return adPassword;
    }

    /**
     * @param adPassword the adPassword to set
     */
    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    /**
     * @return the adEmail
     */
    public String getAdEmail() {
        return adEmail;
    }

    /**
     * @param adEmail the adEmail to set
     */
    public void setAdEmail(String adEmail) {
        this.adEmail = adEmail;
    }
    public String checkLogin() {
        AdminLoginDAL adminLoginDAL = new AdminLoginDAL();
        if (adminLoginDAL.check(adName,adPassword)) {
            return "admin.xhtml";
        }
        return "adminlogin.xhtml";
    }
}
