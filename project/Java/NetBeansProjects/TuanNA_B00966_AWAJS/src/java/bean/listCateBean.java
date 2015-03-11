/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Book;
import entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import model.dal.BookDAL;
import model.dal.LoadCategoryDAL;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@SessionScoped
public class listCateBean {

    private String selectedValue;
    private String id;
    private List<Category> list = new ArrayList<Category>();
 private List<Book> lstBook;
    /** Creates a new instance of listCateBean */
    public listCateBean() {
     
    }

    public List<SelectItem> getListForCombo() {

        LoadCategoryDAL categoryDAL = new LoadCategoryDAL();

        List<Category> lstCate = new ArrayList<Category>();
        lstCate = categoryDAL.getCategory();
        List<SelectItem> l = new ArrayList<SelectItem>();
        l.add(new SelectItem(-1, "All"));
        for (Category p : lstCate) {
            l.add(new SelectItem(p.getCateID(), p.getCateName()));
        }
        return l;
    }

    public String goBookview() {
        setLstBook(new ArrayList<Book>());
        BookDAL bookDAL = new BookDAL();
        setLstBook(bookDAL.getBooksByID(Integer.parseInt(id)));
        return "cateview.xhtml";
    }

   
    /**
     * @return the selectedValue
     */
    public String getSelectedValue() {
        return selectedValue;
    }

    /**
     * @param selectedValue the selectedValue to set
     */
    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the list
     */
    public List<Category> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Category> list) {
        this.list = list;
    }
     public void changeValue(ValueChangeEvent e) {
     id = e.getNewValue().toString();
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
