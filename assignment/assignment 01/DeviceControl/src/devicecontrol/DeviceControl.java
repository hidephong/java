/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devicecontrol;

import bean.session.DeviceSBRemote;
import bean.session.DeviceSBRemoteHome;
import java.rmi.RemoteException;
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
public class DeviceControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
      if (args.length>0) {
        String sid=args[0];
        String status = args[1];
        DeviceSBRemote remote= lookupDeviceSBRemote();
        int id=Integer.parseInt(sid);
        String updateDevice = remote.updateDevice(id, status);
        System.out.print(updateDevice);
      }else{
       System.out.print("nhap vao 2 tham so");
      }
      }
    
     private static DeviceSBRemote lookupDeviceSBRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:global/ASMEJB/DeviceSB!bean.session.DeviceSBRemoteHome");
            DeviceSBRemoteHome rv = (DeviceSBRemoteHome) PortableRemoteObject.narrow(remote, DeviceSBRemoteHome.class);
            return rv.create();
        } catch (Exception ne) {
           ne.printStackTrace();
        } 
        return null;
    }
}
