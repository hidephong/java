/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.modul.sb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author TuanNA
 */
public interface SBRemoteHome extends EJBHome {
    
    ejb.modul.sb.SBRemote create() throws CreateException, RemoteException;
}
