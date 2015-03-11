/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author PHUONGPHUONG
 */
public class Project {
    private int ProjectID;
    private String ProjectName;
    private String Status;

    public Project(){}

    public Project(int id, String name, String status)
    {
        this.ProjectID = id;
        this.ProjectName = name;
        this.Status = status;
    }

    public Project(String name, String status)
    {
        this.ProjectName = name;
        this.Status = status;
    }

    /**
     * @return the ProjectID
     */
    public int getProjectID() {
        return ProjectID;
    }

    /**
     * @param ProjectID the ProjectID to set
     */
    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    /**
     * @return the ProjectName
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * @param ProjectName the ProjectName to set
     */
    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
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
    }

}
