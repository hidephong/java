import com.sun.kjava.*;

/** A program that gives the user a feel of how HelpDisplays are to be used in a program,  	  *	HelpDisplays are helpful in giving the user instructions as to how the program is to be   *	used.... 
  */	

public class HelpDisplay_Spotlet extends Spotlet
{
	public static void main(String args[])
    {
		String helpText = "Programmers can write all the instructions for using the program here the user can scroll down the instructions and when the user presses the Done button the program is displayed";

		// HelpDisplay is being initialized here the first argument tells the text to be displayed 
		//the second argument mentions the class which is to be run after the user presses the DONE button,
		//the third argument tells about the events in which we are interested.. after the helpdisplay is 
		//shown then when the DONE button is pressed then the class name(2nd argument) is registered and its
		//events are taken into consideration...
		(new HelpDisplay(helpText,"helpdisplay_spotlet",NO_EVENT_OPTIONS)).register(NO_EVENT_OPTIONS);
	}

    public HelpDisplay_Spotlet()
    {
		Graphics gr = Graphics.getGraphics();
        gr.clearScreen();
        gr.drawString("Main Class after the Help display..", 15,35);
    }
}