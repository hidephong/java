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

    void insertDevice(int id, String name, String status) throws RemoteException;

    String removeDevice(int id) throws RemoteException;

    void updateDevice(int id) throws RemoteException;

    void changeDevice(int id, String Status) throws RemoteException;

    List findAll() throws RemoteException;
    
}
