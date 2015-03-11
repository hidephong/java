/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Book;
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
public class BookDAL {

    public List<Book> getBooks() {
        try {
            List<Book> lst = new ArrayList<Book>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Book inner join  Category On BookCategory=CateID");
            Book book;
            while (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("ID"));
                book.setNameBook(rs.getNString("Name"));
                book.setBookCategory(rs.getInt("BookCategory"));
                book.setBookLink(rs.getNString("BookLink"));
                book.setAuthor(rs.getNString("Author"));
                book.setCategory(rs.getNString("CateName"));
                book.setPublisher(rs.getNString("Publisher"));
                book.setDescription(rs.getNString("Description"));
                book.setYear(rs.getInt("Year"));
                book.setImg(rs.getNString("img"));
                lst.add(book);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Book> search(String keyword) {
        try {
            List<Book> lst = new ArrayList<Book>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Book inner join  Category On BookCategory=CateID Where [Name] like '%" + keyword + "%'");
            Book book;
            while (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("ID"));
                book.setNameBook(rs.getNString("Name"));
                book.setBookCategory(rs.getInt("BookCategory"));
                book.setBookLink(rs.getNString("BookLink"));
                book.setAuthor(rs.getNString("Author"));
                book.setCategory(rs.getNString("CateName"));
                book.setPublisher(rs.getNString("Publisher"));
                book.setDescription(rs.getNString("Description"));
                book.setYear(rs.getInt("Year"));
                book.setImg(rs.getNString("img"));
                lst.add(book);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addBook(Book book) {
        boolean b = false;
        try {
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            System.out.print("Insert Into Book([Name],Author,Publisher,[Year],[Description],BookCategory,img,BookLink) values('" + book.getNameBook() + "','" + book.getAuthor() + "','" + book.getPublisher() + "'," + book.getYear() + ",'" + book.getDescription() + "'," + book.getBookCategory() + ",'bia.png','')");

            b = st.execute("Insert Into Book([Name],Author,Publisher,[Year],[Description],BookCategory,img,BookLink) values('" + book.getNameBook() + "','" + book.getAuthor() + "','" + book.getPublisher() + "'," + book.getYear() + ",'" + book.getDescription() + "'," + book.getBookCategory() + ",'bia.png','')");
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public boolean updateBook(Book book) {
        boolean b = false;
        try {
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();

            b = st.execute("Update Book set img='" + book.getImg() + "',bookLink= '" + book.getBookLink() + "' where ID=" + book.getId());
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public Book getnewBook() {
        try {
            List<Book> lst = new ArrayList<Book>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select top (1) * from Book inner join  Category On BookCategory=CateID Order By ID Desc");
            Book book;
            rs.next();
            book = new Book();
            book.setId(rs.getInt("ID"));
            book.setNameBook(rs.getNString("Name"));
            book.setBookCategory(rs.getInt("BookCategory"));
            book.setBookLink(rs.getNString("BookLink"));
            book.setAuthor(rs.getNString("Author"));
            book.setCategory(rs.getNString("CateName"));
            book.setPublisher(rs.getNString("Publisher"));
            book.setDescription(rs.getNString("Description"));
            book.setYear(rs.getInt("Year"));
            book.setImg(rs.getNString("img"));


            return book;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Book> getBooksByID(int id) {
        try {
            List<Book> lst = new ArrayList<Book>();
            Connection conn;
            Conn c = new Conn();
            conn = c.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Book inner join  Category On BookCategory=CateID Where CateID=" + id);
            Book book;
            while (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("ID"));
                book.setNameBook(rs.getNString("Name"));
                book.setBookCategory(rs.getInt("BookCategory"));
                book.setBookLink(rs.getNString("BookLink"));
                book.setAuthor(rs.getNString("Author"));
                book.setCategory(rs.getNString("CateName"));
                book.setPublisher(rs.getNString("Publisher"));
                book.setDescription(rs.getNString("Description"));
                book.setYear(rs.getInt("Year"));
                book.setImg(rs.getNString("img"));
                lst.add(book);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
