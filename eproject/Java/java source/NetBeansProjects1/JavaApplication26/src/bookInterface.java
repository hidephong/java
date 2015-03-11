
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public interface bookInterface extends Remote {
public void addbook(String name) throws RemoteException;
public String getbook(int i) throws RemoteException;
}
