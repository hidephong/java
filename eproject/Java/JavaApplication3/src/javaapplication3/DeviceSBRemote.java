/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJBObject;

/**
 *
 * @author TuanNA
 */
public interface DeviceSBRemote extends EJBObject {

    void getAll() throws RemoteException;

    List findByName(String name) throws RemoteException;

    void insertDevice(String Name, String Status) throws RemoteException;
    
}
