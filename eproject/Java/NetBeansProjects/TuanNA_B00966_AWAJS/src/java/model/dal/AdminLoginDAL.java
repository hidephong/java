/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import entity.AdminEntity;
import model.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuanNA
 */
public class AdminLoginDAL {

    public List<AdminEntity> getAllAdmin() {
        List<AdminEntity> lst;
        try {
            lst = new ArrayList<AdminEntity>();
            AdminEntity adminEntity = new AdminEntity();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Admin");

            while (rs.next()) {
                adminEntity = new AdminEntity();
                adminEntity.setAdName(rs.getNString("AdName"));
                adminEntity.setAdEmail(rs.getNString("AdEmail"));
                adminEntity.setAdPassword(rs.getNString("AdPassword"));
                adminEntity.setaID(rs.getInt("AID"));
                lst.add(adminEntity);
                System.out.println(adminEntity.getaID());
            }
            return lst;
        } catch (Exception ex) {
        }
        return null;
    }
    public boolean check(  String user, String pass){
        List<AdminEntity> lstAE = getAllAdmin();
         AdminEntity adminEntity = new AdminEntity();
       for(int i=0;i<lstAE.size();i++){
         adminEntity = new AdminEntity();
         adminEntity=lstAE.get(i);
           if(adminEntity.getAdName().equalsIgnoreCase(user)&&adminEntity.getAdPassword().equalsIgnoreCase(pass)){
        return true;
           }
        }
        return false;
    }
}
