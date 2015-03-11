/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TuanNA
 */
public class UserEntity {

    private int uID;
    private String usName;
    private String uUser;
    private String usPassword;
    private String usEmai;

    /**
     * @return the uID
     */
    public int getuID() {
        return uID;
    }

    /**
     * @param uID the uID to set
     */
    public void setuID(int uID) {
        this.uID = uID;
    }

    /**
     * @return the usName
     */
    public String getUsName() {
        return usName;
    }

    /**
     * @param usName the usName to set
     */
    public void setUsName(String usName) {
        this.usName = usName;
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

    /**
     * @return the usEmai
     */
    public String getUsEmai() {
        return usEmai;
    }

    /**
     * @param usEmai the usEmai to set
     */
    public void setUsEmai(String usEmai) {
        this.usEmai = usEmai;
    }
}
