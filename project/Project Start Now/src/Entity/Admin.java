/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author PHUONGPHUONG
 */
public class Admin {
    private int adminID;
    private String adminName;
    private String adminUsrname;
    private String adminPwd;

    public Admin(){}

    public Admin(int adminID, String adminName, String adminUsrname, String adminPwd) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminUsrname = adminUsrname;
        this.adminPwd = adminPwd;
    }

  
    /**
     * @return the adminID
     */
    public int getAdminID() {
        return adminID;
    }

    /**
     * @param adminID the adminID to set
     */
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    /**
     * @return the adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName the adminName to set
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * @return the adminUsrname
     */
    public String getAdminUsrname() {
        return adminUsrname;
    }

    /**
     * @param adminUsrname the adminUsrname to set
     */
    public void setAdminUsrname(String adminUsrname) {
        this.adminUsrname = adminUsrname;
    }

    /**
     * @return the adminPwd
     */
    public String getAdminPwd() {
        return adminPwd;
    }

    /**
     * @param adminPwd the adminPwd to set
     */
    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

}
