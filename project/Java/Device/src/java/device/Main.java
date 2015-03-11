/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package device;

import bean.session.DeviceSBRemote;
import bean.session.DeviceSBRemoteHome;
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
             DeviceSBRemote remote=lookupDeviceSBRemote();
            
          remote.insertDevice("ABc", "On");
//          String s= remote.insertDevice(s, s); 
                System.out.println("ok");
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
