
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class ServerImpl extends UnicastRemoteObject implements FileInterface {
String name;
File fl[];
public ServerImpl(String s) throws RemoteException{
super();
name=s;
File f =new File("c:\\download");
fl= f.listFiles();
}
public File[] getname(){
return fl;
}
 public byte[] downloadFile(String fileName) throws RemoteException {
     File f =new File(fileName);
     byte buffer[] = new byte[(int)f.length()];
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(f));
       input.read(buffer,0,buffer.length);
         input.close();
         return(buffer);
        } catch (IOException ex) {
            Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return null;
    }
}
