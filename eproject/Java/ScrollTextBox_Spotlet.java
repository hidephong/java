import com.sun.kjava.*;

public class ScrollTextBox_Spotlet extends Spotlet
{
	private Button bt = new Button("Ok",5,145);
	public ScrollTextBox stb		;
	Graphics gr = Graphics.getGraphics();
	
	public ScrollTextBox_Spotlet()
    {
		register(NO_EVENT_OPTIONS);
        gr.clearScreen();
        bt.paint();
        gr.drawRectangle(0,0,160,80,0,1);
		gr.drawString("ScrollTextBox Example...",10,10);
	
		String temp = "1. article1\n2. article2\n3. article3\n4. article4\n5. article5\n6. article6\n7. article7\n8. article8\n9. article9\n10. article10\n11. article11\n12. article12\n13. article13\n14. article14\n15. article15\n16. article16\n17. article17\n";
							
		// initailizing the scrolltextbox with string temp...							
		stb = new ScrollTextBox(temp,1,30,130,100);
        stb.paint();

	}
	
	// Handling the Events.....
	public void penDown(int x, int y)
    {
		if(bt.pressed(x,y))
        {
			System.exit(0);
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
		new ScrollTextBox_Spotlet();
    }

}