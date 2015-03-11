/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient2;

import bean.session.SBDeviceRemote;
import bean.session.SBDeviceRemoteHome;
import java.rmi.RemoteException;
import java.util.List;
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
    public static void main(String[] args) {
        // TODO code application logic here
        try{   
         
            SBDeviceRemote remote=lookupSBDeviceRemote();
//          String s=remote.insertDevice("Tivi");
          String s= remote.test(); 
//          List lst= remote.getAll();
                System.out.println(s);
//                System.out.println(lst.get(1).toString());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        
    }

//    private static NewSessionBeanRemote lookupNewSessionBeanRemote() {
//        try {
//            Context c = new InitialContext();
//            Object remote = c.lookup("java:global/EJBModule9/NewSessionBean!sv.NewSessionBeanRemoteHome");
//            NewSessionBeanRemoteHome rv = (NewSessionBeanRemoteHome) PortableRemoteObject.narrow(remote, NewSessionBeanRemoteHome.class);
//            return rv.create();
//        } catch (Exception ne) {
//         ne.printStackTrace();
//        }
//        return null;
//    }

    private static SBDeviceRemote lookupSBDeviceRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:global/BTEJB/SBDevice!bean.session.SBDeviceRemoteHome");
            SBDeviceRemoteHome rv = (SBDeviceRemoteHome) PortableRemoteObject.narrow(remote, SBDeviceRemoteHome.class);
            return rv.create();
        } catch (Exception ne) {
           ne.printStackTrace();
        } 
        return null;
    }
    
    
}
