import java.util.*;

public class MessageBoard
{
	public static void main(String args[])
	{
		System.out.println("MESSAGE BOARD");
		Scanner input = new Scanner(System.in);
		
		System.out.print("Number of messages");
		int n = input.nextInt();
		
		MyThread myThread[] = new MyThread[n];
		for(int i=0;i<n;i++)
		{
			myThread[i] = new MyThread();
			myThread[i].index = (i+1);
			myThread[i].input();
		}
		
		for(int i=0;i<n;i++)
		{
			myThread[i].start();
		}
	}
}

class MyThread extends Thread
{
	String msg = "";
	int nTimeOut = 1000;
	int nPriority = 1;	
	int index = 1;
	
	public void run()
	{
		while(true)
		{
			System.out.println(this.msg);
			try
			{
				Thread.sleep(nTimeOut);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void input()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Message " + this.index + ": ");
		this.msg = input.nextLine();
		
		System.out.print("Time out: ");
		this.nTimeOut = input.nextInt();
		
		System.out.print("Priority: ");
		String priority = input.next();
		
		if(priority.equalsIgnoreCase("high"))
			this.nPriority = Thread.MAX_PRIORITY;
		else if(priority.equalsIgnoreCase("medium"))
			this.nPriority = Thread.NORM_PRIORITY;
		else	
			this.nPriority = Thread.MIN_PRIORITY;
	}
	
}

