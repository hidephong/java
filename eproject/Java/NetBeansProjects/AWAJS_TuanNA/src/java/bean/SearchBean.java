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
public class SearchBean {

    private List<Book> lstBook;
    private String keyword;

    /** Creates a new instance of SearchBean */
    public SearchBean() {
    }

    /**
     * @return the lstBook
     */
    public List<Book> getLstBook() {
        this.setLstBook(new ArrayList<Book>());
        BookDAL bookDAL = new BookDAL();
        this.setLstBook(bookDAL.search(getKeyword()));
        return lstBook;
    }

    /**
     * @param lstBook the lstBook to set
     */
   

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String search(){
     return "searchview.xhtml";
    }

    /**
     * @param lstBook the lstBook to set
     */
    public void setLstBook(List<Book> lstBook) {
        this.lstBook = lstBook;
    }
}
