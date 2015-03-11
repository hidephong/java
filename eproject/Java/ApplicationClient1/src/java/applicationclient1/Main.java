/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import bean.session.DeviceSBRemote;
import bean.session.DeviceSBRemoteHome;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

/**
 *
 * @author TuanNA
 */
public class Main {
  

    /**
     * @param args the command line arguments
     */
  
//  private static NewSessionBeanRemote lookupNewSessionBeanRemote() {
//        try {
//            Context c = new InitialContext();
//            Object remote = c.lookup("java:global/EJBModule6/NewSessionBean!ss.NewSessionBeanRemoteHome");
//            NewSessionBeanRemoteHome rv = (NewSessionBeanRemoteHome) PortableRemoteObject.narrow(remote, NewSessionBeanRemoteHome.class);
//            return rv.create();
//        } catch (NamingException ne) {
//            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        } catch (CreateException ce) {
//            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ce);
//            throw new RuntimeException(ce);
//        } catch (RemoteException re) {
//            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", re);
//            throw new RuntimeException(re);
//        }
//    }

    public static void main(String[] args) {
        try {
            // TODO code application logic here
           
            DeviceSBRemote remote=lookupDeviceSBRemote();
            
          remote.insertDevice("ABc", "On");
//          String s= remote.insertDevice(s, s); 
                System.out.println("ok");
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
    
       private static DeviceSBRemote lookupDeviceSBRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:global/EJBASM/DeviceSB!bean.session.DeviceSBRemoteHome");
            DeviceSBRemoteHome rv = (DeviceSBRemoteHome) PortableRemoteObject.narrow(remote, DeviceSBRemoteHome.class);
            return rv.create();
        } catch (Exception ne) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } 
    }
}
