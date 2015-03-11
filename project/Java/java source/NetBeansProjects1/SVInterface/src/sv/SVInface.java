/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
// java.rmi.server.UnicastRemoteObject;
package sv;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface SVInface extends Remote{
public void save(SV sv) throws RemoteException;
public String search(String email) throws RemoteException;
public void remove(String email) throws RemoteException;
}
