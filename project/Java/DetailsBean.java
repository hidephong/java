/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.BookEntity;
import entity.CommentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author khoai
 */
@ManagedBean
@RequestScoped
public class DetailsBean {

    /**
     * Creates a new instance of DetailsBean
     */
    private List<BookEntity> list = new ArrayList<BookEntity>();
    private List<CommentEntity> li = new ArrayList<CommentEntity>();
    private String id;
    private String comment;

    public DetailsBean() {
        String sid = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("id");
        id = sid;

    }

    /**
     * @return the id
     */
    public String commentBook() {
        DbConnection db = new DbConnection();
        db.addComment(Integer.parseInt(id), comment);
        return "details.xhtml?id="+id;
    }

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
    public List<BookEntity> getList() {
        DbConnection db = new DbConnection();
        String sid = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("id");
        if (sid != null) {
            list = new ArrayList<BookEntity>();
            list = db.getOneBook(Integer.parseInt(sid));
        }
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<BookEntity> list) {
        this.list = list;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the li
     */
    public List<CommentEntity> getLi() {
        DbConnection db = new DbConnection();
         String sid = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("id");
         if (sid != null) {
            li = new ArrayList<CommentEntity>();
            li = db.getComment(Integer.parseInt(sid));
        }
        return li;
       
    }

    /**
     * @param li the li to set
     */
    public void setLi(List<CommentEntity> li) {
        this.li = li;
    }
}
