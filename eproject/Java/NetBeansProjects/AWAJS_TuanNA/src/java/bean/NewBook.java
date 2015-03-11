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
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import model.dal.BookDAL;
import model.dal.LoadCategoryDAL;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class NewBook {
    private int id;
    private String nameBook;
    private String author;
    private String publisher;
    private int year;
    private String description;
    private int bookCategory;
    private String bookLink;
    private String category;
    private String img;
    private String selectedValue;
    private List<Category> list = new ArrayList<Category>();
    /** Creates a new instance of NewBook */
    public NewBook() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nameBook
     */
    public String getNameBook() {
        return nameBook;
    }

    /**
     * @param nameBook the nameBook to set
     */
    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the bookCategory
     */
    public int getBookCategory() {
        return bookCategory;
    }

    /**
     * @param bookCategory the bookCategory to set
     */
    public void setBookCategory(int bookCategory) {
        this.bookCategory = bookCategory;
    }

    /**
     * @return the bookLink
     */
    public String getBookLink() {
        return bookLink;
    }

    /**
     * @param bookLink the bookLink to set
     */
    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
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
 public List<SelectItem> getListForCombo() {

        LoadCategoryDAL categoryDAL = new LoadCategoryDAL();

        List<Category> lstCate = new ArrayList<Category>();
        lstCate = categoryDAL.getCategory();
        List<SelectItem> l = new ArrayList<SelectItem>();

        for (Category p : lstCate) {
            l.add(new SelectItem(p.getCateID(), p.getCateName()));
        }
        return l;
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
      public void changeValue(ValueChangeEvent e) {
     id = Integer.parseInt(e.getNewValue().toString());
    }
       public String add(){
     Book book = new Book();
     book.setAuthor(author);
     book.setBookCategory(bookCategory);
     book.setBookLink(bookLink);
     book.setCategory(category);
     book.setDescription(description);
     book.setId(id);
     book.setImg(img);
     book.setNameBook(nameBook);
     book.setPublisher(publisher);
     book.setYear(year);
     BookDAL bdal = new BookDAL();
     bdal.addBook(book);
     return "admin.xhtml";
     }
}
