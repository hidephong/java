/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import entity.UserEntity;
import model.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TuanNA
 */
public class UserLoginDAL {

    public List<UserEntity> getUser() {
        try {
            List<UserEntity> lst = new ArrayList<UserEntity>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from [User]");
            UserEntity userEntity;
            while (rs.next()) {
                userEntity = new UserEntity();
                userEntity.setUsName(rs.getNString("UsName"));
                userEntity.setUsPassword(rs.getNString("UsPassword"));
                userEntity.setUsEmai(rs.getNString("UsEmail"));
                userEntity.setuID(rs.getInt("UID"));
                userEntity.setuUser(rs.getNString("UUser"));
                lst.add(userEntity);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public boolean checkLogin( String us, String pa) {
      List<UserEntity> uelst=  getUser();
        UserEntity ue= new UserEntity();
        for (int i = 0; i < uelst.size(); i++) {
            ue= new UserEntity();
            ue = (UserEntity) uelst.get(i);
            if (ue.getuUser().equalsIgnoreCase(us) && ue.getUsPassword().equalsIgnoreCase(pa)) {
                return true;
            }
        }
        return false;
    }
}
