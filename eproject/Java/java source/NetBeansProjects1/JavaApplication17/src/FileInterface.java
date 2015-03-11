/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote {
    public File[] getname() throws
   RemoteException ;
   public byte[] downloadFile(String fileName) throws
   RemoteException;
}
