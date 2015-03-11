
import java.util.Vector;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class BookServerImpl extends UnicastRemoteObject implements bookInterface{
Vector arr;
    BookServerImpl() throws RemoteException{
    arr=new Vector();
    }
    public void addbook(String name) throws RemoteException{
  arr.add(name);
    }

    public String getbook(int i) throws RemoteException {
    return arr.get(i).toString();
    }

}
