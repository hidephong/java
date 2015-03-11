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
public interface DeviceSBRemote extends EJBObject {

    String insertDevice(int id, String name, String status) throws RemoteException;

    String removeDevice(int id) throws RemoteException;

    String updateDevice(int id, String status) throws RemoteException;

    List findAll() throws RemoteException;
    
}
