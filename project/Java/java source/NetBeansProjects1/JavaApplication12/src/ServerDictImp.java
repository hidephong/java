/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
import java.lang.String;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
//import JavaApplication11.DictInterface;
public class ServerDictImp extends UnicastRemoteObject implements DictInterface  {
HashMap<String,String> dict;
    public ServerDictImp() throws RemoteException{
            dict = new HashMap<String,String>();
    };

    public void add(String key, String value) {
        dict.put(key, value);
    }

    public String get(String key) {
    return (String) dict.get(key);
    }
  public static void main(String args[]) throws RemoteException, MalformedURLException{
ServerDictImp dt=new ServerDictImp() ;
Registry rg = LocateRegistry.createRegistry(123);
Naming.rebind("rmi://localhost:123/dict",dt);
        
}
}

