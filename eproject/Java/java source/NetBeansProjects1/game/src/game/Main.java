/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

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
cars cay[] =new cars[52];
for(int i=0;i<13;i++){
cay[i*4]=new cars(i+1,"co");
cay[i*4+1]=new cars(i+1,"ro");
cay[i*4+2]=new cars(i+1,"nhep");
cay[i*4+3]=new cars(i+1,"bich");
}
final baichu c= new baichu();
      Thread t[]=new Choibai[4];
      for(int i=0;i<4;i++){
      t[i]=new Choibai(cay,c);
      }
//      Thread chu=new chubai(cay,c);
//      chu.start();
       for(int i=0;i<4;i++){
t[i].start();
        }
    for(int i=0;i<4;i++){
t[i].join();
        }
//      chu.join();
    }

}

