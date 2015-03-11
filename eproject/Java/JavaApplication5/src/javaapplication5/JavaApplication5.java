/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import sun.tools.jar.Main;
import sv.NewSessionBeanRemote;
import sv.NewSessionBeanRemoteHome;

/**
 *
 * @author TuanNA
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         try {
            // TODO code application logic here
           
            NewSessionBeanRemote remote=lookupDeviceSBRemote();
            
          String s=remote.businessMethod();
//          String s= remote.insertDevice(s, s); 
                System.out.println();
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
}
