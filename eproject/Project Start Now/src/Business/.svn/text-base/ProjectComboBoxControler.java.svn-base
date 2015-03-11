/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import DataAccess.TheConnection;

import Entity.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lovely
 */
public class ProjectComboBoxControler {
    Connection Conn = null;
ProjectComboBoxModel pcbm;
 public  ProjectComboBoxControler(){
    Conn = TheConnection.getConnection();
    }

public  ProjectComboBoxModel get_AllProject(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<Project> list = new ArrayList<Project>();
        Project prj = null;
        String sql = "{call get_AllProject}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                prj = new Project();
                prj.setProjectID(rs.getInt("ProjectID"));
                prj.setProjectName(rs.getNString("ProjectName"));
                prj.setStatus(rs.getNString("Status"));
                list.add(prj);
            }
            rs.close();
            cs.close();
            List<String> rlist = new ArrayList<String>();
            for(Project ls : list)
            {
            rlist.add(ls.getProjectName());
            }
           pcbm=new ProjectComboBoxModel(rlist) ;
            return pcbm;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

}
