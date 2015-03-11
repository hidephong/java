/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import GUI.AddProjectGUI;
import DataAccess.ProjectData;

/**
 *
 * @author PHUONGPHUONG
 */
public class ProjectManagement {

    ProjectData projectDA = null;

    ProjectTableModel ptm = null;//for pouring data into table
    ProjectTableModel searchPTM = null;//for searching
    

    public ProjectManagement()
    {
        projectDA = new ProjectData();
    }

    //pour data from DB into ProjectTableModel
    public ProjectTableModel fillData()
    {
        ptm = new ProjectTableModel(projectDA.getAllProject());
        return ptm;
    }

    //updating
    public void UpdateProject(String name, String status, int id)
    {
        projectDA.UpdateAProject(name, status, id);
    }

    //deleting
    public boolean DeleteAProject(int id)
    {
        boolean bool = projectDA.DeleteProject(id);

        if(bool == true)
            return true;
        else
            return false;
    }

    //updating after unsuccessfully deleting
    public void UpdateAfterDelete(int projectID)
    {
        projectDA.UpdateAfterDelete(projectID);
    }

    //searching
    public ProjectTableModel searchProject(int selectedIndex, String keyword)
    {    
        searchPTM = new ProjectTableModel(projectDA.searchProject(selectedIndex, keyword));
       
        return searchPTM;
    }

    public void AddAProject()
    {
        AddProjectGUI dialog = new AddProjectGUI(null, true);

        projectDA.AddProject(dialog.getProject().getProjectName(), dialog.getProject().getStatus());
    }
}
