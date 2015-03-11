/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author PHUONGPHUONG
 */
public class Post {
    private int RoleID;
    private String Role;
    private float PostAllowance;
    private String Status;
    private boolean bStatus;

    /**
     * @return the RoleID
     */
    public int getRoleID() {
        return RoleID;
    }

    /**
     * @param RoleID the RoleID to set
     */
    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    /**
     * @return the Role
     */
    public String getRole() {
        return Role;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(String Role) {
        this.Role = Role;
    }

    /**
     * @return the PostAllowance
     */
    public float getPostAllowance() {
        return PostAllowance;
    }

    /**
     * @param PostAllowance the PostAllowance to set
     */
    public void setPostAllowance(float PostAllowance) {
        this.PostAllowance = PostAllowance;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
         if(Status.equalsIgnoreCase("Enabled")){
            this.bStatus = true;
        }else{
            this.bStatus = false;
        }
    }


    public boolean getBStatus() {
            return bStatus;
    }

    public void setBStatus(Boolean bstatus){
        this.bStatus = bstatus;
        if(bStatus){
            this.Status =  "Enabled";
        }else{
            this.Status = "Disabled";
        }
    }

}
