/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lovely
 */
public class Choibai extends Thread {
cars bobai[]=new cars[52];
cars bai;
baichu baichu;
public Choibai(){}
public Choibai(cars[] b,baichu bc){
this.bobai=b;
this.baichu=bc;
}

public void run(){
while(true){
            try {
     synchronized (baichu)
                {
                     if(!baichu.b)
                    {
                        try
                        {
                            baichu.wait();
                        }
                        catch(Exception e)
                        {

                        }
                    }

                //bobai.display();
                //bobai.display();
                Scanner in = new Scanner(System.in);
                System.out.println("Hay chon mot so tu 0 den 12:");
                //int i=in.nextInt();
                //int i=in.nextInt();
                Random r = new Random();
                int i = r.nextInt(13);
                System.out.println("Hay chon mot so tu 0 den 3:");
                //int j=in.nextInt();
                int j = r.nextInt(4);
                for (cars s : bobai) {
                    //System.out.println(s.toString());
                }
                Choibai b = new Choibai();
                bai = bobai[b.chonbai()];
                System.out.println(bai.toString());
                if (i > 13) {
                    break;
                }
                System.out.println(this.bobai[i * 4 + j].sosanh(bobai[i * 4 + j], bai));
                Thread.sleep(1000);
                baichu.ng += 1;
                    baichu.notify();
            } }
     catch (InterruptedException ex) {
                Logger.getLogger(Choibai.class.getName()).log(Level.SEVERE, null, ex);
            }
}

}
public int chonbai(){
Random r = new Random();
int i=r.nextInt(52);

System.out.println(i);
return i;
}
}


