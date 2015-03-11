/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 *
 * @author TuanNA
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
             DeviceSBRemote remote=lookupDeviceSBRemote();
            remote.insertDevice("ABC", "on");
        } catch (RemoteException ex) {
            Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     private static DeviceSBRemote lookupDeviceSBRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:global/EJBModule2/DeviceSB!session.bean.DeviceSBRemoteHome");
            DeviceSBRemoteHome rv = (DeviceSBRemoteHome) PortableRemoteObject.narrow(remote, DeviceSBRemoteHome.class);
            return rv.create();
        } catch (Exception ne) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } 
    }
    
}
