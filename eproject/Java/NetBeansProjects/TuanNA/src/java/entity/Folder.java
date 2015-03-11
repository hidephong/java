/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TuanNA
 */
public class Folder {

    private int fID;
    private int uID;
    private String folderName;

    /**
     * @return the fID
     */
    public int getfID() {
        return fID;
    }

    /**
     * @param fID the fID to set
     */
    public void setfID(int fID) {
        this.fID = fID;
    }

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
     * @return the folderName
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * @param folderName the folderName to set
     */
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
