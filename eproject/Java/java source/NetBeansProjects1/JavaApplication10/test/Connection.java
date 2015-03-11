
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import sun.misc.Service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
class Connection extends Thread
{
protected Socket netClient;
protected ObjectInputStream fromClient;
protected PrintStream toClient;

Service servicedet;

static Vector vector_online = new Vector(1,1);//Method to check chatrer online
static Vector vector_toclient = new Vector(1,1);//Method to retrieve/send message
private int localMsgCount;// To count local messages
String listonline="";//userOnline
static int messageCount;//To count the total number of messages stored

String nickname;//ten cua user dang su dung Thread nay , quan trong!!!

public Connection(Socket client)
{
netClient = client;
try
{
fromClient = new ObjectInputStream(netClient.getInputStream());
toClient = new PrintStream(netClient.getOutputStream());
}
catch(IOException e)
{
try
{
netClient.close();
}
catch(IOException e1)
{
System.err.println("Unable to set up streams" + e1);
return;
}
}
this.start();
}

}
