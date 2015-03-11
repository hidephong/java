/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author TuanNA
 */
public class AdminEntity {
    private int aID;
    private String adName;
    private String adPassword;
    private String adEmail;

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
}
