/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author PHUONGPHUONG
 */
public class Department {
    private int DepartmentID;
    private int LocationID;
    private String Status;
    private boolean BooleanStatus;
    private String LocationAddress;
    private String DepartmentName;
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
     * @return the LocationID
     */
    public int getLocationID() {
        return LocationID;
    }

    /**
     * @param LocationID the LocationID to set
     */
    public void setLocationID(int LocationID) {
        this.LocationID = LocationID;
    }

   

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
         if(Status.equalsIgnoreCase("Enabled")){
            this.BooleanStatus = true;
        }else{
            this.BooleanStatus = false;
        }
    }
        
    /**
     * @return the Status
     */
    public String getStatus() {
       return Status;
    }
    
    
    public boolean getBooleanStatus() {
            return BooleanStatus;
    }
    
    public void setBooleanStatus(Boolean bstatus){
        this.BooleanStatus = bstatus;
        if(BooleanStatus){
            this.Status =  "Enabled";
        }else{
            this.Status = "Disabled";
        }
    }
    
    
    /**
     * @return the LocationName
     */
    public String getLocationAddress() {
        return LocationAddress;
    }

    /**
     * @param LocationName the LocationName to set
     */
    public void setLocationAddress(String LocationName) {
        this.LocationAddress = LocationName;
    }

  
   
    
 

//     public void setStringAndBooleanStatus(String bStatus) {
//        if(bStatus.equalsIgnoreCase("Enabled")){
//            this.BooleanStatus = true;
//            Status =  "Enabled";
//        }else{
//            this.BooleanStatus = false;
//            Status = "Disabled";
//        }
//    }
//     

    
}
