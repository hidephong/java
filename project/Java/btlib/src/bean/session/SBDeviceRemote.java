/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJBObject;

/**
 *
 * @author TuanNA
 */
public interface SBDeviceRemote extends EJBObject {

    String test() throws RemoteException;

    String insertDevice(String Name) throws RemoteException;

    List getAll() throws RemoteException;

    String findByName(String name) throws RemoteException;
    
}
