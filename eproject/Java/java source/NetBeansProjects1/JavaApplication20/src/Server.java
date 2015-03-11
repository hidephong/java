
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class Server{
   public static void main(String argv[]) {
        try {
            FileInterface fi;
               fi = new ServerImpl("Server");
               Registry rg = LocateRegistry.createRegistry(123);
                   System.out.print("Server running ...");
             Naming.rebind("rmi://localhost:123/FileServer", fi);
         
        } 
         catch (RemoteException ex) {
              }
      
            catch (MalformedURLException ex) {
          }
    }

}
