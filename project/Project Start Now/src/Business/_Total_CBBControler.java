 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import DataAccess.DepartmentData;
import DataAccess.LocationData;
import DataAccess.PostData;
import DataAccess.ProjectData;
import DataAccess.WorkItemData;
import Entity.Department;
import Entity.Location;
import Entity.Post;
import Entity.Project;
import Entity.WorkItem;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Nha.HV
 */
public class _Total_CBBControler {
    private LocationData locdata;
    private DepartmentData depdata;
    private ProjectData prjdata;
    private PostData postData;
    private WorkItemData widata;

    private Vector<Location> locVec;
    private Vector<Department> depVec;
    private Vector<Project> prjVec;
    private Vector<Post> postVec;
    private Vector<WorkItem> wiVec;


    private DefaultComboBoxModel loccbbm;
    private DefaultComboBoxModel depcbbm;
    private DefaultComboBoxModel prjcbbm;
    private DefaultComboBoxModel postcbbm;

    private DefaultComboBoxModel filterlcbb;
    private DefaultComboBoxModel filterdcbb;
    private DefaultComboBoxModel filterpcbb;

    public _Total_CBBControler() {
        locdata = new LocationData();
        depdata = new DepartmentData();
        prjdata = new ProjectData();
        postData = new PostData();
      
            locVec = new Vector<Location>();
            locVec = locdata.getAllLocation();
            depVec = new Vector<Department>();
            depVec = depdata.getAllDepartment();
            prjVec = new Vector<Project>();
            prjVec = prjdata.getAllProject();
            postVec = new Vector<Post>();
            postVec = postData.getAllPost();

                setLcbbm(locVec);
                setDcbbm(depVec);
                setPcbbm(prjVec);
                setPostcbbm(postVec);

                    setFilterdcbb(depVec);
                    setFilterlcbb(locVec);
                    setFilterpcbb(prjVec);


    }

   
    /**
     * @return the dVec
     */
    public Vector<Department> getdVec() {
        return depVec;
    }

    /**
     * @param dVec the dVec to set
     */
    public void setdVec(Vector<Department> dVec) {
        this.depVec = dVec;
    }

    /**
     * @return the pVec
     */
    public Vector<Project> getpVec() {
        return prjVec;
    }

    /**
     * @param pVec the pVec to set
     */
    public void setpVec(Vector<Project> pVec) {
        this.prjVec = pVec;
    }

    /**
     * @return the dcbbm
     */
    public DefaultComboBoxModel getDcbbm() {
        return depcbbm;
    }

    /**
     * @param dcbbm the dcbbm to set
     */
    public  void setDcbbm(Vector<Department> dv) {
            depcbbm = new DefaultComboBoxModel();
            for (Department department : dv) {
            depcbbm.addElement(department.getDepartmentName());
            if(department.getDepartmentName().isEmpty()){
                depcbbm.addElement("Null");
            }
        }
    }
 

    /**
     * @return the pcbbm
     */
    public DefaultComboBoxModel getPcbbm() {
        
        return prjcbbm;
    }

    /**
     * @param pcbbm the pcbbm to set
     */
    public void setPcbbm(Vector<Project> pv) {
         prjcbbm = new DefaultComboBoxModel();
        for (Project prj : pv) {
            prjcbbm.addElement(prj.getProjectName());
            System.out.println("setpcbb: affter add element: " + prjcbbm.getSize());
        }

    }
  
       /**
     * @return the lVec
     */
    public Vector<Location> getlVec() {
        return locVec;
    }

    /**
     * @param lVec the lVec to set
     */
    public void setlVec(Vector<Location> lVec) {
        this.locVec = lVec;
    }

    /**
     * @return the lcbbm
     */
    public DefaultComboBoxModel getLcbbm() {
        return loccbbm;
    }

    /**
     * @param lcbbm the lcbbm to set
     */
    public void setLcbbm(Vector<Location> lv) {
        loccbbm = new DefaultComboBoxModel();
        for (Location location : lv) {
            loccbbm.addElement(location.getLocationAddress());
        }
    }


    /**
     * @return the filterlcbb
     */
    public DefaultComboBoxModel getFilterlcbb() {
        return filterlcbb;
    }

    /**
     * @param filterlcbb the filterlcbb to set
     */
    public void setFilterlcbb(Vector<Location> lv) {
        filterlcbb = new DefaultComboBoxModel();
        filterlcbb.addElement("---All---");
        for (Location location : lv) {
            filterlcbb.addElement(location.getLocationAddress());
        }
    }

    /**
     * @return the filterdcbb
     */
    public DefaultComboBoxModel getFilterdcbb() {
        return filterdcbb;
    }

    /**
     * @param filterdcbb the filterdcbb to set
     */
    public void setFilterdcbb(Vector<Department> dv) {
            filterdcbb = new DefaultComboBoxModel();
            filterdcbb.addElement("---All---");
        for (Department department : dv) {
            filterdcbb.addElement(department.getDepartmentName());
            }
    }

    /**
     * @return the filterpcbb
     */
    public DefaultComboBoxModel getFilterpcbb() {
        return filterpcbb;
    }

    /**
     * @param filterpcbb the filterpcbb to set
     */
    public void setFilterpcbb(Vector<Project> pv) {
        filterpcbb = new DefaultComboBoxModel();
         filterpcbb.addElement("---All---");
        for (Project prj : pv) {
            filterpcbb.addElement(prj.getProjectName());
        }
    }

    /**
     * @return the postcbbm
     */
    public DefaultComboBoxModel getPostcbbm() {
        return postcbbm;
    }

    /**
     * @param postcbbm the postcbbm to set
     */
    public void setPostcbbm(Vector<Post> post) {
       postcbbm = new DefaultComboBoxModel();
        for (Post p : post) {
            postcbbm.addElement(p.getRole());
        }
    }

   
    
}
