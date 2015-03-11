import java.io.*;
import javax.microedition.io.*;
import com.sun.kjava.*;

/** A program to show how Http Connections work on CLDC. The user is given the feel of http 
*connections by a simple gui program in this program the users have one scrolltextbox where the 
*result of file read will be displayed, the user when presses "fetch" the contents of the 
*file "check1.txt" are sent via network..  (The user is required to create check1.txt on the 
*server directory...).
*/

public class HttpCheck_Spotlet extends Spotlet
{

	private Button bt = new Button("Ok",5,145);
	private Button fetch = new Button("Fetch",45,145);
	public ScrollTextBox stb		;
	DataInputStream dos;
	byte [] b= new byte[32];
	byte[] c = new byte[15000];
	
	Graphics gr = Graphics.getGraphics();
	
	public HttpCheck_Spotlet()
    {
		register(NO_EVENT_OPTIONS);
        gr.clearScreen();
		gr.drawString("Http Check.....",30,10);
        
		bt.paint();
		fetch.paint();

        gr.drawRectangle(0,30,160,80,0,1);
	
		String temp = "Here the result of Http Connection will be Displayed...";
							
		// initailizing the scrolltextbox with string temp...							
		stb = new ScrollTextBox(temp,1,30,130,100);
        stb.paint();
		try
		{
			dos = Connector.openDataInputStream("testhttp://gaurav/books.asp");
			
		}
		catch (IOException e)
		{
			System.out.println("IOException Occured");	   
		}
			  	
	}
	
	// Handling the Events.....
    public void penDown(int x, int y)
    {
		if(bt.pressed(x,y))
        {
			try
			{
				dos.close();	
	        }
			catch (IOException e)
			{
				System.out.println( e );
			}
			System.exit(0);
		}
				
		if (fetch.pressed(x,y))
		{
			int count;
			int total = 0;
			try
			{
				while ((count = dos.read(b,0,32)) > 0) 
				{
					for (int i = 0;i<count;i++)
					{
						c[total]  = b[i];
                        total++;
                     }
				}
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
			String str  = new String(c, 0 ,total);
			stb = new ScrollTextBox(str,1,30,130,100);
			stb.paint();
			System.out.println("Testing ");		
		}

         if (stb.contains(x,y))
			stb.handlePenDown(x,y);
	}

	public void penMove(int x, int y)
    {
		if (stb.contains(x,y))
			stb.handlePenMove(x,y);
    }
			
    public static void main(String args[])
    {
		new HttpCheck_Spotlet();
    }

}