/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TuanNA
 */
public class Category {

    private int cateID;
    private String cateName;
    private String cateDescription;

    /**
     * @return the cateID
     */
    public int getCateID() {
        return cateID;
    }

    /**
     * @param cateID the cateID to set
     */
    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    /**
     * @return the cateName
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName the cateName to set
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * @return the cateDescription
     */
    public String getCateDescription() {
        return cateDescription;
    }

    /**
     * @param cateDescription the cateDescription to set
     */
    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }

   
}
