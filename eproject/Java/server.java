//© 2001 Dreamtech Software India Inc. All rights reserved
import java.io.*;
import java.net.*;

public class server 
{
	public static void main(String args[]) 
	{
		try 
		{
			ServerSocket server_soc = new ServerSocket(5555);
			Socket sc;
			sc = server_soc.accept();
			BufferedReader br = new BufferedReader (new InputStreamReader(sc.getInputStream()));
			PrintWriter pw = new PrintWriter (new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),true);
			while (true) 
			{
				String str = br.readLine();
				pw.println(str);
			}
		}
	
		catch(Exception ae) {
		}
	}
}