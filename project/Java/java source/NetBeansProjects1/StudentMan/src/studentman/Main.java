/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package studentman;

import java.io.File;
import java.lang.reflect.Array;
import java.security.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Lovely
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
     
        final idxObj mid = new idxObj();
         File f=new File("D:\\DS\\");
         final File fs[]=f.listFiles();
         final ArrayList st = new ArrayList();
           Thread t1= new ReadStu(mid,fs,st);
         Thread t2=new ReadStu(mid,fs,st);
          Thread t3= new ReadStu(mid,fs,st);
         Thread t4=new ReadStu(mid,fs,st);
        Thread t5= new ReadStu(mid,fs,st);
        
             t1.start();
             t2.start();
           t3.start();
             t4.start();
           t5.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
int j;
             for(int i=0;i<fs.length;i++){
                 j=i;
             System.out.println((++j)+": "+st.get(i).toString());
             }
    }}
      
    


