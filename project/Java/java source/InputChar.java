/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Lovely
 */
import java.lang.*;
import java.io.*;
class InputChar
{
    public static void main(String args[])
    {
        char ch;
        ch=' ';
         System.out.println("nhap vao mot ky tu");
        try
        {
            ch=(char)System.in.read();
        }
catch(Exception e)
        {
    System.out.println("nhap loi");
}
System.out.println("ki yu vua nhap: " + ch);
}
}