/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Entity.Project;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author PHUONGPHUONG
 */
public class ProjectData {

    Connection conn = null;
    private Vector<Project> vector = null;//for pouring data into table
    private Vector<Project> searchVector = null;//for searching
    ResultSet rs = null;//for pouring data into table
    CallableStatement cs = null;//for pouring data into table

    public ProjectData()
    {
        conn = TheConnection.getConnection();
        vector = new Vector<Project>();
        searchVector = new Vector<Project>();
    }

    /**
     * @get all data of Project from the DB
     */
    public Vector<Project> getAllProject()
    {
        try
        {
            getVector().clear();

            String sql = "{call getAllProject}";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            Project p = null;

            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String status = rs.getString(3);
                p = new Project(id, name, status);

                getVector().add(p);
            }
        }
        catch(SQLException e)
        {
        }

        return getVector();
    }

    /**
     * @update data into the DB
     */
    public void UpdateAProject(String name, String status, int id)
    {
         try
        {
            if(conn == null)
                    return;

            String sql = "{CALL UpdateAProject(?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, name);
            cs.setString(3, status);
            boolean bool = cs.execute();
        }
        catch(SQLException e)
        {
        }
    }

    /*
     * @ delete a project from the DB
     */
    public boolean DeleteProject(int id)
    {
        try
        {
            if(conn == null)
                    return false;

            String sql = "{CALL DeleteAProject(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            boolean bool = cs.execute();
        }
        catch(SQLException e)
        {
            //e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * @ update after unsuccessfully deleting
     */
    public void UpdateAfterDelete(int projectID)
    {
        try
        {
            if(conn == null)
                    return;

            String sql = "{CALL UpdateAfterDelete_Project(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, projectID);
            boolean bool = cs.execute();
        }
        catch(SQLException e)
        {
        }
    }

    /*
     * @ search project(s)
     */
    public Vector<Project> searchProject(int selectedIndex, String keyword)
    {
      

        try{
            if(selectedIndex == 0)
            {    getSearchVector().clear();
                String sql = "{CALL SearchByProjectName(?)}";
                cs = conn.prepareCall(sql);
                cs.setString(1, "%"+keyword+"%");
                rs = cs.executeQuery();

                Project p = null;

                while(rs.next())
                {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String status = rs.getString(3);
                    p = new Project(id, name, status);

                    getSearchVector().add(p);
                }
            }
            else if(selectedIndex == 1)
            {
                getSearchVector().clear();
                String sql = "{CALL SearchByProjectStatus(?)}";
                cs = conn.prepareCall(sql);
                cs.setString(1, "%"+keyword+"%");
                rs = cs.executeQuery();

                Project p = null;

                while(rs.next())
                {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String status = rs.getString(3);
                    p = new Project(id, name, status);
                    getSearchVector().add(p);
                }
            }
        }
        catch(Exception e)
        {
        }

        return getSearchVector();
    }

    /*
     * @ Add a project to the DB
     */
    public void AddProject(String projectName, String projectStatus)
    {
        try
        {
            if(conn == null)
                    return;

            if(!projectName.equals(""))
            {
                String sql = "{CALL AddANewProject(?,?)}";
                cs = conn.prepareCall(sql);
                cs.setString(1, projectName);
                cs.setString(2, projectStatus);
                boolean bool = cs.execute();
            }
        }
        catch(SQLException e)
        {
        }
    }

    /**
     * @return the vector
     */
    public Vector<Project> getVector() {
        return vector;
    }

    /**
     * @param vector the vector to set
     */
    public void setVector(Vector<Project> vector) {
        this.vector = vector;
    }

    /**
     * @return the searchVector
     */
    public Vector<Project> getSearchVector() {
        return searchVector;
    }

    /**
     * @param searchVector the searchVector to set
     */
    public void setSearchVector(Vector<Project> searchVector) {
        this.searchVector = searchVector;
    }
}
