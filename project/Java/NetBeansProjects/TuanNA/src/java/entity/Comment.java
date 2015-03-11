/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TuanNA
 */
public class Comment {

    private int cID;
    private int uID;
    private String cComment;

    /**
     * @return the cID
     */
    public int getcID() {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void setcID(int cID) {
        this.cID = cID;
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
     * @return the cComment
     */
    public String getcComment() {
        return cComment;
    }

    /**
     * @param cComment the cComment to set
     */
    public void setcComment(String cComment) {
        this.cComment = cComment;
    }
}
