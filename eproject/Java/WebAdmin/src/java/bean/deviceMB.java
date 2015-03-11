/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.session.SBDeviceRemote;
import bean.session.SBDeviceRemoteHome;
import entities.DeviceInfo;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
public class deviceMB {
List list = new ArrayList();
    /**
     * Creates a new instance of deviceMB
     */
    public deviceMB() throws RemoteException {
        SBDeviceRemote remote=lookupSBDeviceRemote();
        list=remote.findAll();  
    }

    private SBDeviceRemote lookupSBDeviceRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:global/BTEJB/SBDevice!bean.session.SBDeviceRemoteHome");
            SBDeviceRemoteHome rv = (SBDeviceRemoteHome) PortableRemoteObject.narrow(remote, SBDeviceRemoteHome.class);
            return rv.create();
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } catch (CreateException ce) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ce);
            throw new RuntimeException(ce);
        } catch (RemoteException re) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", re);
            throw new RuntimeException(re);
        }
    }
}
