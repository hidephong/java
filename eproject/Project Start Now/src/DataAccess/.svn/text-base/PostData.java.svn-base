/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Business.PostModel;
import Entity.Post;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nha.HV
 */
public class PostData {
    Post post;

    Connection Con;
    CallableStatement CsPost;
    ResultSet RsPost;

    Vector<Post> postVector;
    Vector<Post> searchPostVector;
    
    public  PostData(){
        Con = TheConnection.getConnection();
        CsPost = null;
        RsPost = null;
    }
    
    public Vector<Post> getAllPost(){
        try {
            String SQLGetAllPost = "{Call getAllPost}";
            post = null;
            CsPost = null;
            RsPost = null;
            postVector = new Vector<Post>();
            CsPost = Con.prepareCall(SQLGetAllPost);
            RsPost = CsPost.executeQuery();
            while(RsPost.next()){
                post = new Post();
                post.setRoleID(RsPost.getInt(1));
                post.setRole(RsPost.getString(2));
                post.setPostAllowance(RsPost.getFloat(3));
                post.setStatus(RsPost.getString(4));
                postVector.add(post);
            }
            RsPost.close();
            CsPost.close();
            return postVector;
        } catch (SQLException ex) {
            System.out.println("PostData: " + ex.toString());
             return null;
        }
    }
    
    public boolean addAPost(Post apost){
        try {
            String SQLAddAPost = "{Call addAPost(?,?,?)}";
            CsPost = null;
            int RsCode = 0;
            CsPost = Con.prepareCall(SQLAddAPost);
            CsPost.setString(1, apost.getRole());
            CsPost.setFloat(2, apost.getPostAllowance());
            CsPost.setString(3, apost.getStatus());
            RsCode = CsPost.executeUpdate();
            if(RsCode == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("PostData > addAPost: " + ex.toString());
            return false;
        }
    }

    public boolean updateAPost(Post upost){
        try {
            String SQLAddAPost = "{Call UpdateAPost(?,?,?,?)}";
            CsPost = null;
            int RsCode = 0;
            CsPost = Con.prepareCall(SQLAddAPost);
            CsPost.setInt(1, upost.getRoleID());
            CsPost.setString(2, upost.getRole());
            CsPost.setFloat(3, upost.getPostAllowance());
            CsPost.setString(4, upost.getStatus());
            RsCode = CsPost.executeUpdate();
            if(RsCode == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("PostData > uAPost: " + ex.toString());
            return false;
        }
    }

    public boolean deleteAPost(int id){
          try {
            String SQLAddAPost = "{Call deleteAPost(?)}";
            CsPost = null;
            int RsCode = 0;
            CsPost = Con.prepareCall(SQLAddAPost);
            CsPost.setInt(1, id);
            RsCode = CsPost.executeUpdate();
            if(RsCode == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("PostData > uAPost: " + ex.toString());
            JOptionPane.showMessageDialog(null, "Delete post failed!");
            return false;
        }
     }
    public Vector<Post> searchPost(String role, String stt){
    
            searchPostVector = new Vector<Post>();
            String sqlSearchPost = "{Call searchPost(?,?)}";
            CsPost = null;
            RsPost = null;
            post = null;
        try {   
            CsPost = Con.prepareCall(sqlSearchPost);
            CsPost.setString(1, role);
            CsPost.setString(2, stt);
            RsPost = CsPost.executeQuery();
            while(RsPost.next()){
                post = new Post();
                post.setRoleID(RsPost.getInt(1));
                post.setRole(RsPost.getString(2));
                post.setPostAllowance(RsPost.getFloat(3));
                post.setStatus(RsPost.getString(4));
                searchPostVector.add(post);
            }
            return searchPostVector;
        } catch (SQLException ex) {
            return null;
        }
            
            
            
            
    }
}
