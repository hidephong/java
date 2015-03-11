/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import entity.Category;
import entity.UserEntity;
import apk.Conn;
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
public class LoadCategoryDAL {
 public List<Category> getCategory() {
        try {
            List<Category> lst = new ArrayList<Category>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from [Category]");
           Category category = new Category();
            while (rs.next()) {
                category = new Category();
                category.setCateID(rs.getInt("CateID"));
                category.setCateName(rs.getNString("CateName"));
                lst.add(category);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
