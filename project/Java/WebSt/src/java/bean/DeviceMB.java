/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.session.DeviceSBRemote;
import bean.session.DeviceSBRemoteHome;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@SessionScoped
public class DeviceMB {
String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    /**
     * Creates a new instance of DeviceMB
     */
    public DeviceMB() {
        a="a";
        try {
            DeviceSBRemote bRemote= lookupDeviceSBRemote();
    bRemote.insertDevice("ABC","On");
        } catch (RemoteException ex) {
            Logger.getLogger(DeviceMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private static DeviceSBRemote lookupDeviceSBRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("[java:global/ASMEJB/DeviceSB!bean.session.DeviceSBRemoteHome");
            DeviceSBRemoteHome rv = (DeviceSBRemoteHome) PortableRemoteObject.narrow(remote, DeviceSBRemoteHome.class);
            return rv.create();
        } catch (NamingException ne) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } catch (CreateException ce) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ce);
            throw new RuntimeException(ce);
        } catch (RemoteException re) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", re);
            throw new RuntimeException(re);
        }
    }
}
