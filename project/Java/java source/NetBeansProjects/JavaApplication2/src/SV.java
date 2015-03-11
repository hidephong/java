/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class SV {
    private String IDS;
    private String teacher;
    private float toan;
    private float van;
    private float anh;

    /**
     * @return the IDS
     */
     public SV(String s1,String s2,float f1,float f2,float f3){
    this.IDS=s1;
    this.teacher=s2;
    this.toan=f1;
    this.van=f2;
    this.anh=f3;
    }
    public String getIDS() {
        return IDS;
    }

    /**
     * @param IDS the IDS to set
     */
    public void setIDS(String IDS) {
        this.IDS = IDS;
    }

    /**
     * @return the teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the toan
     */
    public float getToan() {
        return toan;
    }

    /**
     * @param toan the toan to set
     */
    public void setToan(float toan) {
        this.toan = toan;
    }

    /**
     * @return the van
     */
    public float getVan() {
        return van;
    }

    /**
     * @param van the van to set
     */
    public void setVan(float van) {
        this.van = van;
    }

    /**
     * @return the anh
     */
    public float getAnh() {
        return anh;
    }

    /**
     * @param anh the anh to set
     */
    public void setAnh(float anh) {
        this.anh = anh;
    }
}
