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

/**
 *
 * @author Lovely
 */

  
public class NewClass1 {
    public static ServerSocket serverSocket;
    ObjectInputStream is;
    ObjectOutputStream os;
    public static Socket socket = null;
     public static void main(String args[]) throws IOException {
  while(true){
       serverSocket = new ServerSocket(1112);

              socket = serverSocket.accept();
            System.out.println("Waitting...");
      Thread t =new Thread(new ServerDialog1());
t.run();
  }
    }

}
