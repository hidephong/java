
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
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
public class BookServer {
public static void main(String args[]){
        try {
            try {
                LocateRegistry.createRegistry(1235);
            } catch (RemoteException ex) {
                Logger.getLogger(BookServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            BookServerImpl bi = new BookServerImpl();
            Naming.bind("rmi://localhost:1235/book",bi);
            System.out.println("Server is ready");
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(BookServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(BookServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BookServer.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}
