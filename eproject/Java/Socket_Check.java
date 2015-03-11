import com.sun.kjava.*;
import java.lang.*;
import java.io.*;
import javax.microedition.io.*;

/** A program to show how Sockets work on CLDC. The user is given the feel of socket connections by a simple gui program in this program the users have one textfield, the user enters the text on the textfield and press ok the contents of the textfield are sent via network over to some server socket which is running( use "server.java" in this case present
in "..\serverforsocket\server.java" run it using the command "java server") the server then reads the message and responds back to the same message to the client socket which will show the message on the spotlet..
*/
public class Socket_Check extends Spotlet
{
	InputStream is;
	OutputStream os;
	StreamConnection socket = null;
	
	// Initialzing the various GUI Components							
	private Button bt = new Button("Ok",5,145);
    private Button bt1 = new Button("Exit",35,145);
    public TextField tf = new TextField("Name",10,30,110,110);
            
	Graphics gr = Graphics.getGraphics();
	
	public Socket_Check()
    {
		register(NO_EVENT_OPTIONS);
        gr.clearScreen();
		
		gr.drawString("Socket Check...",30,10);
		bt.paint();
		bt1.paint();

        gr.drawRectangle(0,20,160,80,0,1);
        tf.setUpperCase(true);
        tf.setFocus();
        tf.paint();
		// Initializing the socket connections							
		try
		{
			socket =
  			(StreamConnection)Connector.open("socket://localhost:5555",
			Connector.READ_WRITE,
			true);	
			if (socket != null) 
			{
				System.out.println("Connection is established to localhost on port 5555...");
			}
			
			// Opening the Input and Output Streams...						
			is = socket.openInputStream();
			os = socket.openOutputStream();
		}
		catch(IOException ae)
		{
			System.out.println("Couldn't open socket to 127.0.0.1 :5555... Either server is not started (start it from ../serverforsocket/ using the command java server ) or port is already in use.... "  );
			System.exit(0);
		}
	}

    public void penDown(int x, int y)
    {
		if(bt.pressed(x,y))
        {
			try
			{
				os.write((tf.getText()+"\n").getBytes());
				StringBuffer sb = new StringBuffer();
				
				int b;
				while ((b=is.read()) != 13) 
				{
					sb.append((char)b);
				}
				
				gr.drawString(sb.toString(), 55,50);
				sb.delete(0,sb.capacity());
			}
			catch (IOException aer)
			{
				System.out.println(aer);
			}
		}

		if (bt1.pressed(x,y))
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				System.out.println( e );
			}

			System.exit(0);
		}
		          
	}
    public void keyDown(int x)
    {
		if(tf.hasFocus())
        {
			tf.handleKeyDown(x);
		}

    }
    
	public static void main(String args[])
    {
		new Socket_Check();
    }

}