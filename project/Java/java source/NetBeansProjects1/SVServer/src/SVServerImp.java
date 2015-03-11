/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.SV;
import sv.SVInface;

public class SVServerImp extends UnicastRemoteObject implements SVInface{
HashMap<String,SV> svarr ;
 SV svtmp ;
    public SVServerImp() throws RemoteException, IOException{
     svarr =new HashMap();
 
       File f=new File("stu.dat");
       if(f.exists()){
      try {
         FileInputStream fis = new FileInputStream(f);

        BufferedInputStream br= new BufferedInputStream(fis);
                ObjectInputStream ob = new ObjectInputStream(br);
                 int n=ob.readInt();
                 System.out.println(n);
                  for(int i=0;i<n;i++)
                   {
                        svtmp = (SV) ob.readObject();
                        svarr.put(svtmp.getEmail(), svtmp);
                    }
                        System.out.println("a"+svarr.size());
         fis.close();


            } catch (Exception ex) {
          ex.printStackTrace();
            }

        }
 

}
    public void save(SV sv) throws RemoteException {
        {
            
                    svarr.put(sv.getEmail(), sv);

 try {
            FileOutputStream fos1= new FileOutputStream(new File("stu.dat"));
            ObjectOutputStream ob1=new ObjectOutputStream(fos1);
            ob1.writeInt(svarr.size());
                Set set=svarr.keySet();
                java.util.Iterator iter = set.iterator();
                while(iter.hasNext()){
                     ob1.writeObject((SV)svarr.get(iter.next()));
                }

                fos1.close();
 } catch (IOException ex) {
           ex.printStackTrace();
        }
            }

 

    }

    public String search(String email) throws RemoteException {

        if(svarr.containsKey(email)){
               svtmp =svarr.get(email);
           
                return  svtmp.toString();
            }

   return "Not Found";
    }

    public void remove(String email) throws RemoteException {
SV svtmp = null;
        try {
            FileInputStream fis= new FileInputStream(new File("stu.dat"));
            ObjectInputStream ob=new ObjectInputStream(fis);
            try {
                while ((svtmp = (SV) ob.readObject()) != null) {
                    svarr.put(svtmp.getEmail(),svtmp);
                }
            } catch (ClassNotFoundException ex) {
             ex.printStackTrace();
            }
            if(svarr.containsKey(email)){
               svtmp =svarr.remove(email);
 try {
            FileOutputStream fos1= new FileOutputStream(new File("stu.dat"),true);
            ObjectOutputStream ob1=new ObjectOutputStream(fos1);

 Set set=svarr.keySet();
        java.util.Iterator iter = set.iterator();
        while(iter.hasNext()){
                 ob1.writeObject((SV)svarr.get(iter.next()));
        }

    
 } catch (IOException ex) {
           ex.printStackTrace();
        }
            }

  } catch (IOException ex) {
           ex.printStackTrace();
        }

    }
public static void main(String args[]) throws RemoteException, MalformedURLException, IOException{
    SVServerImp svs=new SVServerImp() ;
Registry rg = LocateRegistry.createRegistry(123);
Naming.rebind("rmi://localhost:123/sv",svs);
System.out.println("Server running ...");
}
}
