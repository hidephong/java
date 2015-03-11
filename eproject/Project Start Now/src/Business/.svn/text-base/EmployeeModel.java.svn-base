/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;
import javax.swing.table.AbstractTableModel;
import Entity.Employee;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lovely
 */

public class EmployeeModel extends AbstractTableModel{
    int count=14;
    private List<Employee> list = new  ArrayList<Employee>();
    public EmployeeModel(){};
    public EmployeeModel(List<Employee> emp){
        this.list= emp;
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
        Employee emp = list.get(rowIndex);

        switch(columnIndex){
            case 0:
                return emp.getEmployeeID();
            case 1:
                return emp.getEmployeeName();
            case 2:
                return emp.getUsername();
            case 3:
                return emp.getGender();
            case 4:
                return emp.getAddress();
            case 5:
                return emp.getRole();
            case 6:
                return emp.getCurrentProject();
            case 7:
                return emp.getCurrentDepartment();
            case 8:
                return emp.getJoiningDate();
            case 9:
                return emp.getEmail();
            case 10:
                return emp.getWorkExperience();
            case 11:
                return emp.getLocation();
            case 12:
                return emp.getPhoneNumber();
            case 13:
                return emp.getStatus();

        }
        return null;

    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Fullname";
            case 2:
                return "Username";
            case 3:
                return "Gender";
            case 4:
                return "Address";
            case 5:
                return "Role";
            case 6:
                return "Project";
            case 7:
                return "Department";
            case 8:
                return "Joining Date";
            case 9:
                return "Email";
            case 10:
                return "Work Experience";
            case 11:
                return "Location";
            case 12:
                return "Phone Number";
            case 13:
                return "Status";

        }
        return null;
    }
    public Employee getEmployeeAt(int rowIndex){
        return list.get(rowIndex);
    }

}

