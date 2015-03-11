/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import DataAccess.TheConnection;
import Entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lovely
 */
public class RoleComboBoxControler {
     Connection Conn = null;
RoleComboBoxModel rcbm;
 public RoleComboBoxControler(){
    Conn =TheConnection.getConnection();
    }
   public  RoleComboBoxModel get_AllRole(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<Post> list = new ArrayList<Post>();
        Post rol= null;
        String sql = "{call get_AllRole}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                rol= new Post();
                rol.setRoleID(rs.getInt("RoleID"));
                rol.setRole(rs.getString("Role"));
                rol.setPostAllowance(rs.getInt("PostAllowance"));
                rol.setStatus(rs.getNString("Status"));
                list.add(rol);
            }
            rs.close();
            cs.close();
            List<String> rlist = new ArrayList<String>();
            for(Post ls : list){
            rlist.add(ls.getRole());
            }
          rcbm=new  RoleComboBoxModel(rlist);
            return rcbm;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

   public int get_RoleIDByName(String keyword){
        ResultSet rs = null;
        CallableStatement cs = null;

        Post  rol= null;
        if(keyword.isEmpty()){return -1;}
        String sql = "{call SearchByRoleName(?)}";
        try{
            cs = Conn.prepareCall(sql);
            cs.setString(1, keyword.trim());
             rs = cs.executeQuery();
          
              rol= new Post();
if(rs.getRow()>=0){
             while(rs.next()){
                rol= new Post();
                rol.setRoleID(rs.getInt("RoleID"));
                rol.setRole(rs.getString("Role"));
                rol.setPostAllowance(rs.getInt("PostAllowance"));
                rol.setStatus(rs.getNString("Status"));

            }
}
            rs.close();
            cs.close();

            return rol.getRoleID();

        }catch (SQLException ex){
            ex.printStackTrace();
            return -1;
        }

    }

   public  float get_PostAllowanceByName(String locaName){
        ResultSet rs = null;
        CallableStatement cs = null;
        Post  rol= null;
        String sql = "{call get_PostAllowanceByName(?)}";
        try{
             rol= new Post();
            cs = Conn.prepareCall(sql);
            cs.setString(1,"%"+locaName+"%");
            rs = cs.executeQuery();
      if(rs.getRow()>0){

                rol.setRoleID(rs.getInt("RoleID"));
                rol.setRole(rs.getString("Role"));
                rol.setPostAllowance(rs.getInt("PostAllowance"));
                rol.setStatus(rs.getNString("Status"));
            }

            rs.close();
            cs.close();
      return   rol.getPostAllowance();
        }catch (SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

}
