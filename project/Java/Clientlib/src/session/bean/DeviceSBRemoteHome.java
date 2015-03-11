/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.bean;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author TuanNA
 */
public interface DeviceSBRemoteHome extends EJBHome {
    
    session.bean.DeviceSBRemote create() throws CreateException, RemoteException;
}
