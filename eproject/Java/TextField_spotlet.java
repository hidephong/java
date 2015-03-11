import com.sun.kjava.*;

/** A program that gives the user a feel of GUI (Specially Textboxes and Buttons..).
  */	

public class TextField_spotlet extends Spotlet
{
	// Declaring the Variables...
	private Button ok_button = null;
    public TextField tf_textfield = null; 
     
    Graphics gr = Graphics.getGraphics();

    public TextField_spotlet()
    {						
		register(NO_EVENT_OPTIONS);
        // Clearing the drawing area....
		gr.clearScreen();		  

		// Initializing textfields and Buttons..........
		ok_button = new Button("Ok",5,130);
		tf_textfield = new TextField("Name",10,10,110,110);
              
		ok_button.paint();
		
		// Draw a rectangular area so that textfield can be drawn.
        gr.drawRectangle(0,0,160,80,0,1);
        
		// Accepts only UpperCase.      
		tf_textfield.setUpperCase(true);
        
		// Sets the Focus so that the cursor blinks
		tf_textfield.setFocus();
        tf_textfield.paint();

	}
	
	// Handling Events...	
    public void penDown(int x, int y)
    {
		if(ok_button.pressed(x,y))
        {
			gr.drawString("User Entered..",30,130);
			gr.drawString(tf_textfield.getText()+"                       ", 95,130);
		}
	}
    public void keyDown(int x)
    {
		if(tf_textfield.hasFocus())
        {
			tf_textfield.handleKeyDown(x);
		}

    }
    
	// Call to the main Function...                 
	public static void main(String args[])
    {
		new TextField_spotlet();
    }

}