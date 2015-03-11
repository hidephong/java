/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brab;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author TuanNA
 */
public interface NewSessionBeanRemoteHome extends EJBHome {
    
    brab.NewSessionBeanRemote create() throws CreateException, RemoteException;
}
