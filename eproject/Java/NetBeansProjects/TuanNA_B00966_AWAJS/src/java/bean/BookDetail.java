/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Book;
import entity.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import model.dal.BookDAL;
import model.dal.CommentDAL;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@SessionScoped
public class BookDetail {

    private int BID;
    private List<Book> bk;
    private List<Comment> lstCm;
    private String newComment;

    /** Creates a new instance of BookDetail */
    public BookDetail() {
        String sid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        BID = Integer.parseInt(sid);
        bk = new ArrayList<Book>();
        BookDAL bookDAL = new BookDAL();
        bk = bookDAL.getBooksByBID(BID);
    }

    /**
     * @return the lstCm
     */
    public List<Comment> getLstCm() {

        lstCm = new ArrayList<Comment>();
        CommentDAL commentDAL = new CommentDAL();
        lstCm = commentDAL.getComment(BID);
        return lstCm;
    }

    /**
     * @param lstCm the lstCm to set
     */
    public void setLstCm(List<Comment> lstCm) {
        this.lstCm = lstCm;
    }

    /**
     * @return the bk
     */
    public List<Book> getBk() {
        String sid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (sid != null) {
            BID = Integer.parseInt(sid);
            bk = new ArrayList<Book>();
            BookDAL bookDAL = new BookDAL();
            bk = bookDAL.getBooksByBID(BID);
        }
        return bk;
    }

    /**
     * @param bk the bk to set
     */
    public void setBk(List<Book> bk) {
        this.bk = bk;
    }

    /**
     * @return the BID
     */
    public int getBID() {
        return BID;
    }

    /**
     * @param BID the BID to set
     */
    public void setBID(int BID) {
        this.BID = BID;
    }

    public String insertCm() {
        CommentDAL commentDAL = new CommentDAL();
        commentDAL.addComment(getNewComment(), 1, BID);
        this.newComment = "";
        String nUrl = "bookdetail.xhtml";
        return nUrl;
    }

    /**
     * @return the newComment
     */
    public String getNewComment() {
        return newComment;
    }

    /**
     * @param newComment the newComment to set
     */
    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }
}
