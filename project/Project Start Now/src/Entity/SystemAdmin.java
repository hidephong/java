/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author PHUONGPHUONG
 */
public class SystemAdmin {
    private int AdminID;
    private String AdminName;
    private String Username;
    private String Password;

    public SystemAdmin(){}

    public SystemAdmin(int id, String name, String usrname, String pwd)
    {
        AdminID = id;
        AdminName = name;
        Username = usrname;
        Password = pwd;
    }

    /**
     * @return the AdminID
     */
    public int getAdminID() {
        return AdminID;
    }

    /**
     * @param AdminID the AdminID to set
     */
    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    /**
     * @return the AdminName
     */
    public String getAdminName() {
        return AdminName;
    }

    /**
     * @param AdminName the AdminName to set
     */
    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
