/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;



/**
 *
 * @author Lovely
 */
public class chubai extends Thread{

public chubai(cars[] cay,baichu c){
try{
    synchronized (c)
                {
                     if(c.b)
                    {
                        try
                        {
                            c.wait();
                        }
                        catch(Exception e)
                        {

                        }
                    }
}
    if( c.ng>=4){
        c.ng=0;
    c.b=false;


    }
                    c.notify();
            }
     catch (Exception ex) {
              ex.printStackTrace();
     }

}
}
