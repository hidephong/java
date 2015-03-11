import com.sun.kjava.*;

public class Database_Check extends Spotlet
{
	// Declaring the Variables...
	private Button ok_button = null;
	
	// Declaring the Variables...
	private Button get_button = null;

	public TextField tf_textfield = null; 
	public TextField tf1_textfield = null; 

	Database dbg;
	Graphics gr = Graphics.getGraphics();

    public Database_Check()
    {						
		register(NO_EVENT_OPTIONS);
		
		// Clearing the drawing area....
		gr.clearScreen();		  

		gr.drawString("Database Example....",30,10);

		// Initializing textfields and Buttons..........
		ok_button = new Button("Store",5,145);
		get_button = new Button("Retrieve",55,145);

		tf_textfield = new TextField("Name",10,50,110,20);
		tf1_textfield = new TextField("Result",10,70,110,20);
              
		ok_button.paint();
		get_button.paint();
		
		// Draw a rectangular area so that textfield can be drawn.
        gr.drawRectangle(0,30,160,80,0,1);
		
		// Accepts only UpperCase.              
		tf_textfield.setUpperCase(true);
		
		// Sets the Focus so that the cursor blinks
		tf_textfield.setFocus();
        tf_textfield.paint();
        tf1_textfield.paint();

		// Database initialization.....
		String name = "check";
		int cid = 0x4B415754;
		int tid = 0x44425370;
		
		dbg = new Database (tid,cid,Database.READWRITE);
		if (dbg.isOpen())
		{
			Database.create(0,name,cid,tid,false);
		}
	 	else
		{
			Database.create(0,name,cid,tid,false);
		}
      

	}
    
	// Handling Events...	
	public void penDown(int x, int y)
    {
		if(ok_button.pressed(x,y))
        {
			byte[] data = (tf_textfield.getText()+"?").getBytes();
           	dbg.addRecord(data);
		}
		if(get_button.pressed(x,y))
        {
			byte[] data = dbg.getRecord(65535);
			String temp = new String(data);
			temp = temp.substring(0,temp.indexOf("?"));
			tf1_textfield.setText(temp);
		}
	}
    
	public void keyDown(int x)
    {
		if(tf_textfield.hasFocus())
        {
			tf_textfield.handleKeyDown(x);

		}

	}

    public static void main(String args[])
    {
		new Database_Check();
	}
}
