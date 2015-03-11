/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.dal.BookDAL;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class listBean {

    private List<Book> lstBook;

    /** Creates a new instance of listBean */
    public listBean() {
        lstBook = new ArrayList<Book>();
        BookDAL bookDAL = new BookDAL();
        lstBook = bookDAL.getBooks();
    }

    /**
     * @return the lstBook
     */
    public List<Book> getLstBook() {
        return lstBook;
    }

    /**
     * @param lstBook the lstBook to set
     */
    public void setLstBook(List<Book> lstBook) {
        this.lstBook = lstBook;
    }

   
}
