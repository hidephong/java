/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication9;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lovely
 */
   
public class server{
  static ServerSocket serverSocket;

    static Socket socket = null;
 public static void main(String args[]){

        try {
      serverSocket = new ServerSocket(1112);
              socket = serverSocket.accept();
            System.out.println("Waitting...");
          Thread t =new Thread(new mServerDialog());
          t.run();
        }
    catch (Exception ex) {
     ex.printStackTrace();
    }
   
}
}
