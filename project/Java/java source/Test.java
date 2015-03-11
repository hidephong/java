package bank;
import java.util.*;

public class Test
{
	public static void main(String args[])
	{
		int nChoose = 0;
		StudentManagement stuMan = new StudentManagement();
		do
		{
			System.out.println("1.	Create an Account");	
			System.out.println("2.	Save to file");	
			System.out.println("3.	Display");	
			System.out.println("4.	Read from file");	
			System.out.println("5.	Exit");	
			System.out.print("Chon 1 menu: ");	
			Scanner input = new Scanner(System.in);
			nChoose = input.nextInt();
			
			switch(nChoose)
			{
				case 1:
					stuMan.createAccount();
					break;	
				case 2:
					stuMan.saveToFile();
					break;
				case 3:
					stuMan.display();
					break;
				case 4:
					stuMan.readFromFile();
					break;
				case 5:
					System.exit(0);

			}
		}
		while(nChoose!=5);
	}	
}
