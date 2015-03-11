/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author TuanNA
 */
public interface SBDeviceRemoteHome extends EJBHome {
    
    bean.session.SBDeviceRemote create() throws CreateException, RemoteException;
}
