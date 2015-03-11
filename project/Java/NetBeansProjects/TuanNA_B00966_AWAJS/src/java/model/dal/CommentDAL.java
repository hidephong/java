/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import entity.Category;
import entity.Comment;
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
public class CommentDAL {

    public List<Comment> getComment(int id) {
        try {
            List<Comment> lst = new ArrayList<Comment>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from [CommentTbl] where UID=" + id + " order by cid desc");
            Comment comment = new Comment();
            while (rs.next()) {
                comment = new Comment();
                comment.setuID(rs.getInt("UID"));
                comment.setcComment(rs.getNString("cComment"));
                lst.add(comment);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addComment(String comment, int bID, int uID) {
        boolean b = false;
        try {
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            String strcmd = "insert Into CommentTbl(UID,CComment) values(" + uID + ",'" + comment + "')";
            b = st.execute(strcmd);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}
