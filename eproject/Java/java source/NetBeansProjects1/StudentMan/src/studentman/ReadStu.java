/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package studentman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lovely
 */
public class ReadStu extends Thread{
    idxObj mid;
    File files[];
    Student stu;
    ArrayList st = new ArrayList();
    public ReadStu(idxObj m,File[] f,ArrayList sta)
    {
        this.mid = m;
        this.files=f;
      this.st = sta; 
    }


    public void run(){
   while(true){
       if(mid.id>=files.length){break;};
       try{
                synchronized (mid)
                {
                     if(!mid.bfree)
                    {
                        try
                        {
                            mid.wait();
                        }
                        catch(Exception e)
                        {

                        }
                    }

System.out.println(files[mid.id]);
       BufferedReader br = new BufferedReader(new FileReader(files[mid.id]));
     stu=new Student();
       //System.out.print( br.readLine());
       stu.setName(br.readLine());
       stu.setYear(Integer.parseInt(br.readLine()));
       stu.setAddr(br.readLine());
       stu.setPhone(br.readLine());
       //System.out.print(stu.getName());
       //stu.display();

 mid.id+=1;
               st.add(stu);
System.out.print(st.get(mid.id).toString());
                    
                    System.out.println(mid.id);
                    mid.bfree = true;
                    mid.notify();

                  //  Thread.sleep(1000);
                }

        }
            catch(Exception e)
            {

            }

}}
    }
