/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brab;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author TuanNA
 */
public interface NewSessionBeanRemote extends EJBObject {

    void businessMethod() throws RemoteException;
    
}
