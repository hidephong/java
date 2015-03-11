/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Lovely
 */
public class ProjectOnDepartmentModel extends DefaultComboBoxModel {
      int count=14;
    private List<ProjectOnDepartment> list = new  ArrayList<ProjectOnDepartment>();
    public ProjectOnDepartmentModel(){};
    public ProjectOnDepartmentModel(List<ProjectOnDepartment> pod){
        this.list= pod;
    }


    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return count;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProjectOnDepartment pod = list.get(rowIndex);

        switch(columnIndex){
            case 0:
                return pod.getWorkItemID();
            case 1:
                return pod.getDepartmentID();
            case 2:
                return pod.getProjectID();
            case 3:
                return pod.getDepartmentName();
            case 4:
                return pod.getProjectName();
            case 5:
                return pod.getStartDate();
            case 6:
                return pod.getEndDate();
            case 7:
                return pod.getLocationAddress();
            case 8:
                return pod.getStatus();
            }
        return null;

    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "WorkItemID";
            case 1:
                return "DepartmentID";
            case 2:
                return "ProjectID";
            case 3:
                return "DepartmentName";
            case 4:
                return "ProjectName";
            case 5:
                return "StartDate";
            case 6:
                return "EndDate";
            case 7:
                return "LocationAddress";
            case 8:
                return "Status";
        }
        return null;
    }
    public  ProjectOnDepartment getEmployeeAt(int rowIndex){
        return list.get(rowIndex);
    }

}

