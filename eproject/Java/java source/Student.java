/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package home3;

import java.util.Scanner;

/**
 *
 * @author Lovely
 */
public class Student {
    private String name;
    private int age;
    private float mark;

    public Student()
    {
        
    }

    public void display()
    {
        System.out.println("The Information of student");
        System.out.println("The name: " + this.name);
        System.out.println("The age: "  + this.age);
        System.out.println("The mark: " + this.mark);
    }

    public void input()
    {
        System.out.println("Enter the Information of student");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name: ");
        this.name = input.nextLine();

        System.out.print("Enter the age: ");
        this.age = input.nextInt();

        System.out.print("Enter the mark: ");
        this.mark = input.nextFloat();
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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the mark
     */
    public float getMark() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void setMark(float mark) {
        this.mark = mark;
    }


}
