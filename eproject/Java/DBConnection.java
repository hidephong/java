/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.BooksEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoai
 */
public class DBConnection {

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BookOnline", "sa", "123");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<BooksEntity> getAll() {
        try {
            List<BooksEntity> bo = new ArrayList<BooksEntity>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Book");

            while (rs.next()) {
                int id = rs.getInt("Id");
                String bookName = rs.getString("BookName");
                String bookDes = rs.getString("BookDes");
                float bookPrice = rs.getFloat("BookPrice");
                String bookAut = rs.getString("BookAut");
                String bookCate = rs.getString("BookCate");
                bo.add(new BooksEntity(id, bookName, bookDes, bookPrice, bookAut, bookCate));
            }
            return bo;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<BooksEntity> getSearch(String bokName)
    {
        try {
            List<BooksEntity> bo = new ArrayList<BooksEntity>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Book where BookName like '%"+bokName+"%'");
            while(rs.next())
            {
                int id = rs.getInt("Id");
                String bookName = rs.getString("BookName");
                String bookDes = rs.getString("BookDes");
                float bookPrice = rs.getFloat("BookPrice");
                String bookAut = rs.getString("BookAut");
                String bookCate = rs.getString("BookCate");
                bo.add(new BooksEntity(id, bookName, bookDes, bookPrice, bookAut, bookCate));
            }
             return bo;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    public List<BooksEntity> getBook(int bookId)
    {
        try {
            List<BooksEntity> bo = new ArrayList<BooksEntity>();
                Connection con = getConnection();
                Statement st = con.createStatement();
                String sql ="select * from Book where Id ="+bookId;
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                int id = rs.getInt("Id");
                String bookName = rs.getString("BookName");
                String bookDes = rs.getString("BookDes");
                float bookPrice = rs.getFloat("BookPrice");
                String bookAut = rs.getString("BookAut");
                String bookCate = rs.getString("BookCate");
                bo.add(new BooksEntity(id, bookName, bookDes, bookPrice, bookAut, bookCate));
                }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
}
