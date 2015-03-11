/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package studentman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Lovely
 */
public class Student {
private String name;
    private int year;
    private String addr;
    private String phone;

public Student(){}
public Student(String strname,int iyear,String straddr,String strphone){
this.setName(strname);
this.setYear(iyear);
this.setAddr(straddr);
this.setPhone(strphone);
}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr the addr to set
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
public void display()
    {
        System.out.println("Name " +this.name);
        System.out.println("Age: " + this.year);
        System.out.println("Add: " + this.addr);
        System.out.println("Phone: "+this.phone);
    }
    @Override
public String toString()
    {
       String str="Name: " +this.name+"\n Age: " + this.year+"\n Add: " + this.addr+"\n Phone: "+this.phone+"\n";
    return str;
    }
    public void savefile() throws FileNotFoundException, IOException{
   
        Student e1 = new Student("Nguyen1", 30, "Hanoi","0990099009");
          File file = new File("D:\\Test\\a.obj");
        FileOutputStream fos = new FileOutputStream(file, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(e1);
        oos.close();
    }
}
