import javax.microedition.midlet.MIDlet;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
 
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
import org.kxml.*;
import org.kxml.parser.XmlParser;
import org.kxml.parser.*;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;
 
import javax.microedition.io.HttpConnection;
import javax.microedition.io.Connector;

import java.lang.String;

/**
 * This class Displayes the is a User Interface for this Project it displayes
  * the list of items availabel with the stock of every item. Accepts the Quantity 
  * to be Ordered and Calculate the total Amount of Order based on the Quantity 
  * Ordered.And updates the Database by calling a JSP passing ITEMCODE, QUNATITY ORDERED
  * TOTAL AMOUNT as parameter.
  */
 public class OrderManager extends MIDlet implements CommandListener
  {
 	/* This vector will contain Item Code  */
 	private Vector vitem = null;
 	/* This Vector will contain Item Quantity  */
  	private Vector vquantity = null;
  	/* This Vector will conatin Item Price */
  	private Vector vrate = null;
  	
  	/* This Class GetData is a internal class and returns Item Code with Quantity and Rate  */
  	private GetData gdata = null;
  	
 	/* Declaring variables for Display class.  */
 	private Display displaylist = null;
 	
  	/* Declaration of List which will Display the Items with Quantity  */
  	private List items = null;
  	/* Declaration of Form  */
  	private Form entryform = null;
  	private Form displayform = null;
  	
  	private String itemselect = null;
 	/* This Command is a backcommmand  */
 	private Command backcommand = null;
 	/* This command is to view the total  */
  	private Command totalcommand = null;
  	/* This command is to place an order  */
  	private Command okcommand = null;
  	/* This command again displayes the list of items with the quantity  */
  	private Command goback = null;
  	/* This command quits the application */
  	private Command exit = null;
 	/* This TextFeild is to get the quantity to be ordered  */
 	private TextField enter = null;
 	/* This Hashtable containes entries of itemcode and the quantity ordered. The key
  	is the itemcode.  */
  	private Hashtable htable = null;
  	/* This HttpConnection object connects to the web server and updates the database by
  	placing an order  */
  	private HttpConnection connection = null;
  	
  	/* Constructor Called  */
 	public OrderManager()
 	{
 		/* This will get the Display Object  */
  		displaylist = Display.getDisplay(this);
          
  		/* Declerations   */
  		items = new List("Items",List.IMPLICIT);
  		items.setCommandListener(this);
  		htable = new Hashtable();
  		backcommand = new Command("Back",Command.BACK,1);
 		goback = new Command("Back",Command.BACK,1);
 		totalcommand = new Command("Total",Command.SCREEN,1);
 		okcommand = new Command("OK",Command.SCREEN,1);
  		exit = new Command("Exit",Command.EXIT,1);
  	}
  	
  	/* This method is called when the application starts  */
  	public void startApp()
  	{
  		/* Gdata Instantiated  */
 		gdata = new GetData();
 		/* GetData parseData method called this method parses XML  */
 		gdata.parseData();
  		/* GetData returnItem method returns vector object containing Item list  */
  		vitem = gdata.returnItem();
  		/* This line Trims empty white spaces from the vector vitem  */
  		vitem.trimToSize();
  		/* GetData returnStock method returns Vector object containing Stock list(availabel
  		item quantity  */
 		vquantity = gdata.returnStock();
		/* Trims empty spaces from Vector  */
		vquantity.trimToSize();
		/* GetData returnPrice method returns Vector object containing Price list  */
 		vrate = gdata.returnPrice();
 		/* Trims empty spaces from Vector  */
 		vrate.trimToSize();
 		/* For loop starts
 		This for loop runs until there are values in Vector vitem(vitem.size() give the size 
 		of the vector)  */
 		for(int i=1;i<=vitem.size();i++)
		{
			/* In this line List append method is called and the itemcode and the quantity 
			availabel is added to the list  */
 			items.append((String)vitem.elementAt(i-1) +"   "+ (String)vquantity.elementAt(i-1),null);
 		}
 		/* this line will display the list containing the items  */
 		displaylist.setCurrent(items);
 		/* List is registered for totalcommand and command other than Select command have to be
 		registered with the List class object by calling its addCommand method  */
 		items.addCommand(totalcommand);
		/* List is registred for exit command */
		items.addCommand(exit);
		/* entryform intantiated a TextFeild will be added to this form(Form is behaves as we have
 		containers in the JAVA Standard Edition  */
 		entryform = new Form("Entry Form");
 		/* entryform is registered with backcommand  */
 		entryform.addCommand(backcommand);
 		/* entry form registered for receiving command  */
 		entryform.setCommandListener(this);
  		/* displayform is intantaited this will display the total amount of order with item code  */
 		displayform = new Form("View Total");
 		/* displayform registered for receiving command  */
 		displayform.setCommandListener(this);
  		/* displayform is registered with goback command  */
  		displayform.addCommand(goback);
  		/* displayform is registered with okcommand  */
  		displayform.addCommand(okcommand);
  	}
  	
  	/**
 	* This method is called when ever a user presses a button or a command is given on any
 	* of the Items the two parameters are Command object and the displayable object
 	*/
  	public void commandAction(Command c, Displayable d)
  	{
  		int totalbill = 0;
  		int a = 0;
  		/* The code in this if condition is executed when an Selected command on the list
  		 is generated(i.e when an item is selected in the list)  */
  		if(c == List.SELECT_COMMAND)
 		{
 			/* This line of code gets the String value of the List item selected by calling the 
 			getString(). List getSelectedIndex() returns the index of the item selected which
  			is passed as an argument to the getString().  */
  			String str = items.getString(items.getSelectedIndex());
  			int i = str.indexOf(" ");
  			/* This line will get only the item value from str(str conatins item as well as its 
  			quantity)  */
  			itemselect = str.substring(0,i);
  			/* TextFeild instantaited  */
 			enter = new TextField("Enter Quantity","",5,TextField.NUMERIC);
 			/* The code in if block cleares the entryform(deletes the items in the entryform)  */
 			if((entryform.size() > 0))
  			{
  				entryform.delete(0);
  			}
  			/* This line add items to the entryform in this case TextFeild enter is added to the
  			entryform  */
  			entryform.append(enter);
  			/* The entryform is displayed  */
 			displaylist.setCurrent(entryform);
 		}
 		
  		/* The code in this if condition is executed when an back command on the entryform
  		is generated(i.e when an user press the button indicating Back)  */
  		if(c == backcommand)
  		{
  			/*The code in the if block is executed only when the user enters some value in the 
  			Textfeild  */
  			if(!(enter.getString().equals("")))
 			{
 				/*Two values are put in htable(HashTable)the first one is itemselect which is the 
 				itemCode and the quantity the user enterd to be ordered both the values are 
  				String values  */
  				htable.put(itemselect,enter.getString());
  			}
  			/* the back command again displays the List  */
  			displaylist.setCurrent(items);
  		}
  		
 		/* The code in this if condition is executed when an total command on the List
 		is generated(i.e when an user press the button indicating Total)  */
 		if(c == totalcommand)
  		{
  			String str;
  			/* This is a StringItem decleration  */
  			StringItem sitem;
  			/* This for loop will run until the end of HashTable. htable.keys() returns an 
  			Enumeration of Objects in the HashTable e.hashMoreElements returns True if there
 			are more elements.  */
			for (Enumeration e = htable.keys(); e.hasMoreElements();) 
			{
				/* The e.netElement() returns an Object with which hkey is initalised  */
 				Object hkey = e.nextElement();
 				/* The vitem.indexOf() method returns a integer value which is the index of the 
 				Object in this vector.The argument to this method is a String value which is the 
 				item code and indexitem is initialised with this integer value.  */
 				int indexitem = vitem.indexOf((String)hkey);
 				/*First take htable.get(hkey) this method returns the object associated with this key
 				in the hashtable so it returns the quantity ordered for this item code  */ 
				int quan = Integer.parseInt((String)htable.get(hkey));
				/* vrate.elementAt() returns an Object this object is the rate of the item whose index
				value is indexitem this is type caste to String and parseInt method parse this string
 				into int value and initialised into rate.  */
 				int rate = Integer.parseInt((String)vrate.elementAt(indexitem));
 				/* The total will contain the amount of the each item ordered which is quan*rate
 				(Quantity*Rate)  */
 				String total = new String();
 				total = total.valueOf(quan*rate);
 				/* This String conatins the hkey(Item Code)and the total value of that item code
				to be displayed to the user  */
				str = ((String)hkey) +"     " + total;
				/*The str is passed as an argument to the Constructer of StringItem which will 
 				 display the value in str  */
 				sitem = new StringItem("",str);
 				/* sitem is added in diaplayform   */
 				displayform.append(sitem);
 				/* totalbill is the total amount of order */
 				totalbill+=(quan*rate);
  			}
 			/* This str contains total amount oforder  */
 			str = "Total"+"        "+totalbill;
 			/* str passed to StringItem  */
  			sitem = new StringItem("",str);
  			/* added to displayform  */
  			displayform.append(sitem);
  			/* This will display the displayform containing the items ordered with total to the 
  			 user */
  			displaylist.setCurrent(displayform);
  		}
 		/* The code in this if condition is executed when an goback command on the displayform
 		is generated(i.e when an user press the button indicating Back)  */
 		if(c == goback)
  		{
  			/* displayform.size() returns an int value indicating the Number of objects in the 
  			displayform  */
  			int noofobjects = displayform.size();
  			/* This while loop runs until there are objects in the displayform.The code in this
  			while loop delets the objects from the displayform.This code behaves like a clear
  			screen command*/
 			while(noofobjects > 0)
 			{
 				/*Displays the object a this position.In Form class the position of objects starts
  				from 0 and deleting a item will make other items shift upward.ie If you delete a item
  				at 0th position the item at position 1 will move at 0th position  */
  				displayform.delete(0);	
  				/* This line will give the decremented value of displayform.size()  */
  				noofobjects = displayform.size();
  				
  			}
 			/* This will set the current display to List containing the itemcode and stock  */
 			displaylist.setCurrent(items);
 		}
  		/* The code in this if condition is executed when an ok command on the displayform
  		is generated(i.e when an user press the button indicating ok)  */
  		if(c == okcommand && !(htable.isEmpty()))
  		{
  			/* The urlvalue String contains a url pointing to jsp which will update the database */
  			String urlvalue = "http://localhost:8080/examples/jsp/sql_order_mon.jsp?value=";
  			/* The Code in this for loop is executed until there are Objects in the HashTable  */
 			for (Enumeration e = htable.keys(); e.hasMoreElements();) 
 			{
 				Object hkey = e.nextElement();
  				/* The three int value indexitem,quan and rate are arguments to be passed to an
  				jsp application  */
  				int indexitem = vitem.indexOf((String)hkey);
  				int quan = Integer.parseInt((String)htable.get(hkey));
  				int rate = Integer.parseInt((String)vrate.elementAt(indexitem));
  				/* The values indexitem,quan and rate are added to this string which are arguments to 
  				the jsp and these arguments will be updated in the database 
 				The First argument is the itemID(Item Code)
 				The Second argument is the Quantity of the Item to be ordered
 				The third argument is the total amount of order of one item(quan*rate)  */ 
  				urlvalue = urlvalue.concat((String)hkey + "*" + (String)htable.get(hkey) + "*" +(quan*rate)+"*");
  			}
  			try
  			{
  				/* Connecting to the given url  */
  				connection = (HttpConnection)Connector.open(urlvalue);
  				/* An inputstream is opened to read from that connection  */
 				InputStream ins = connection.openInputStream();
 			}
 			catch(IOException ex)
  			{
  				System.out.println("IOException occured");
  			}
  			System.out.println(" This is the url value " + urlvalue);
			/* Destroy App Called  */
  			this.destroyApp(true);
  			/* This will notify the application manager that the midlet is destroyed  */
 			this.notifyDestroyed();
		}
		/* This if Condition is executed to display the user an error message  */
		if(c == okcommand && htable.isEmpty())
 		{
 			/* This Alert class is used to diaplay message to the user for some seconds */
 			Alert erroralert = new Alert("WHAT IS THIS","Please Don't mess with me",null,AlertType.ERROR);
 			/* This line will set the time for which the message will be displayed to the user  */
 			erroralert.setTimeout(5000);
 			/* The alert screen is displayed  */
 			displaylist.setCurrent(erroralert);
		}
		/* This if conditon is executed when the user press exit button  */
		if(c == exit)
 		{
 			/* Destroy App Called  */
 			this.destroyApp(true);
 			/* This will notify the application manager that the midlet is destroyed  */
 			this.notifyDestroyed();
 		}
 	}
		
	/* This method is called when the application is paused*/
	public void pauseApp()
 	{
 		System.out.println("Pause applet called");
 	}
 	
 	/* This method is called when the application is terminated. This is the ideal method to free
 	resources */
  	public void destroyApp(boolean b)
 	{
 		Vector vitem = null;
 		Vector vquantity = null;
  		Vector vrate = null;
  		GetData gdata = null;
  		Display displaylist = null;
  		List items = null;
  		entryform = null;
  		displayform = null;
  		itemselect = null;
 		backcommand = null;
 		totalcommand = null;
 		okcommand = null;
  		goback = null;
  		enter = null;
  		htable = null;
  		connection = null;
  		System.gc();
  	}
  }
 
 /* This is a inner class and this class opens a url and reads XML data and on the fly parses the data
 according to the conditions given. This class uses a java based XML Parser this parser is a event based
  parser.This class calls a JSP which queries the database and generates XML Data Containing the Item Code
  availabel item quantity and the rate of the item  */
  class GetData
  {
  	/* This String object is url value to be connected to the HTTP Server*/
  	String url = "http://localhost:8080/examples/jsp/sql_xml.jsp";
  	/* HttpConnection Object */
 	HttpConnection con = null;
 	/* This InputStream Object is used to read data from the InputStream opened on a URL */
  	InputStream ins = null;
  	/* ParserEvent are event generated by the parser while parsing data */
  	ParseEvent event;
  	/* This class is an object of Abstract Xml parser  */
  	AbstractXmlParser parser;
  	/* Vector objects declared  */
  	Vector itemcode,itemquantity,itemprice;
  	/* Constructor of GetData Declared  */
 	public GetData()
 	{
  		
  		try
  		{	
  			/* This makes an Http Connection opens a stream to the connection and pass this object 
  			   to the XmlParser class  */ 	
  			con = (HttpConnection)Connector.open(url);
  			ins = con.openInputStream();
  			parser = new XmlParser(new InputStreamReader(ins));
 		}
 		catch(IOException ex)
  		{
  			System.out.println("IOException occured");
  		}	
  		/*Initialize the vector objects */
  		itemcode = new Vector();
  		itemquantity = new Vector();
  		itemprice = new Vector();
  	}
 	/* This method parses the xml data and stores the data in the vectors accordingly*/
 	void parseData()
  	{
  		boolean founditem = false;
  		boolean quantity = false;
  		boolean price = false;
  		do
  		{
  			try
 			{
				/* This will read the data form the stream and generate parsing events  */
				event = parser.read ();
 				/* This will check the start fo the tag and the name of the tag like <item_code>*/
 				if(event.getType()==Xml.START_TAG)
 				{
 					StartTag stag = (StartTag)event;
 					if(stag.getName().equals("item_code"))
 					{
 						founditem = true;
 					}
					if(stag.getName().equals("quantity"))
					{	
 						quantity = true;
 					}
 					if(stag.getName().equals("unit_price"))
 					{	
 						price = true;
 					}
 				}
  		/* This will be true if the there is 
some Text found like <item_code>156 */
 				if(event.getType()== Xml.TEXT)
 				{
  					TextEvent tevent = (TextEvent)event;
  					if(founditem)
  					{
  						itemcode.addElement(tevent.getText());
  						founditem = false;
  					}
  					if(quantity)
  					{
 						
 					   itemquantity.addElement(tevent.getText());
  					   quantity = false;
  					}
  					if(price)
  					{
  						itemprice.addElement(tevent.getText());
  						price = false;
  					}
  				}
 			}
 			catch(IOException ex)
  			{	
  				System.out.println("Exception occured");
  			}
  		}
  		while (!(event instanceof EndDocument));	
  	}			
  		
  	/* This method will release the memory and free the resources */
 	void releaseMeromery()
 	{
  		con = null;
  		ins = null;
  		parser = null;
  		itemcode = null;
  		itemquantity = null;
  		itemprice = null;
  	}
  	
 	/* The next three method will return vector objects containing itemcode,
 	   item quantity and item price respectively  */
  	Vector returnItem()
  	{
  		return itemcode;
  	}
  	
  	Vector returnStock()
  	{
  		return itemquantity;
 	}
 	
  	Vector returnPrice()
  	{
  		return itemprice;
  	}
  
}