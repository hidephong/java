
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class NewClass {
    static int i=0;
    public static void main(String args[]){
      Thread dlg[] = null;
        while(true){
           dlg[i] = new Thread(new ServerDialog1()) ;
    dlg[i].start();
            try {
                dlg[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
i++;
        }
    }
}
