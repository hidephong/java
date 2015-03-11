/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.Date;
/**
 *
 * @author Lovely
 */
public class ProjectOnDepartment {
private int WorkItemID;
    private int DepartmentID;
    private int ProjectID;
    private Date StartDate;
    private Date EndDate;
    private String Status;
    private String ProjectName;
    private String DepartmentName;
    private String LocationAddress;

    /**
     * @return the WorkItemID
     */
    public int getWorkItemID() {
        return WorkItemID;
    }

    /**
     * @param WorkItemID the WorkItemID to set
     */
    public void setWorkItemID(int WorkItemID) {
        this.WorkItemID = WorkItemID;
    }

    /**
     * @return the DepartmentID
     */
    public int getDepartmentID() {
        return DepartmentID;
    }

    /**
     * @param DepartmentID the DepartmentID to set
     */
    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
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
     * @return the StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the EndDate
     */
    public Date getEndDate() {
        return EndDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
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
     * @return the DepartmentName
     */
    public String getDepartmentName() {
        return DepartmentName;
    }

    /**
     * @param DepartmentName the DepartmentName to set
     */
    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    /**
     * @return the LocationAddress
     */
    public String getLocationAddress() {
        return LocationAddress;
    }

    /**
     * @param LocationAddress the LocationAddress to set
     */
    public void setLocationAddress(String LocationAddress) {
        this.LocationAddress = LocationAddress;
    }

}
