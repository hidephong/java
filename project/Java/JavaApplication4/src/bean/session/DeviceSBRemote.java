/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author TuanNA
 */
public interface DeviceSBRemote extends EJBObject {

    String insertDevice(String Name, String Status) throws RemoteException;
    
}
