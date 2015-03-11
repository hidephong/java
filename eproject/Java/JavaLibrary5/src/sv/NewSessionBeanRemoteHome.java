/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author TuanNA
 */
public interface NewSessionBeanRemoteHome extends EJBHome {
    
    sv.NewSessionBeanRemote create() throws CreateException, RemoteException;
}
