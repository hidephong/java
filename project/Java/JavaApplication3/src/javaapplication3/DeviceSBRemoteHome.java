/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author TuanNA
 */
public interface DeviceSBRemoteHome extends EJBHome {
    
    DeviceSBRemote create() throws CreateException, RemoteException;
}
