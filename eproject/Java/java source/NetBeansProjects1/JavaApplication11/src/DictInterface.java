/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
import java.rmi.*;
public interface DictInterface extends Remote{
public void add(String key,String value) throws RemoteException;
public String get(String key) throws RemoteException;
}
