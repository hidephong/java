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
public interface DeviceSBRemoteHome extends EJBHome {
    
    bean.session.DeviceSBRemote create() throws CreateException, RemoteException;
}
