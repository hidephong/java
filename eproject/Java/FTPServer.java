/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demoftp;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Tuan
 */
public class FTPServer {
static final int PORT = 1234;
	private ServerSocket server=null;
	public FTPServer(){
		try{
			server=new ServerSocket(PORT);
		}catch(Exception e){e.printStackTrace();
		}
	}
	public void action(){
		Socket socket=null;
		int i=0;
		System.out.println("Serverlistening...");
		try{
			while((socket=server.accept())!=null){
				new ServerThread(socket,"Client#"+i);
				System.out.printf("Thread for Client#%d generating...%n",i++);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[]args){
		new FTPServer().action();
	}
}
