import com.sun.kjava.*;

/** A program that gives the user a feel of GUI (Specially CheckBoxes and Radio Buttons.
  */	

public class Check_Radio_Spotlet extends Spotlet 
         {
            private Button ok_button = null; 
            private CheckBox cb1_checkbox = null; 
            private CheckBox cb2_checkbox = null;
            private RadioGroup radiogroup = new RadioGroup(4);
            private RadioButton rb1_radiobutton = null; 
            private RadioButton rb2_radiobutton = null; 
            private RadioButton rb3_radiobutton = null; 
            private RadioButton rb4_radiobutton = null; 
            private String str1 = "";
            private String str2 = "";
			boolean checked_1 = false;
			boolean checked_2 = false;

			// Initialzing the Graphics....
            Graphics gr = Graphics.getGraphics();	
            public Check_Radio_Spotlet()
            {
              register(NO_EVENT_OPTIONS);

			  // Initializing the Buttons, the CheckBoxes and the RadioButtons...
			  ok_button = new Button("Ok",80,70);
			  cb1_checkbox = new CheckBox(80,30,"First"); 
			  cb2_checkbox = new CheckBox(80,50,"Second");

			  rb1_radiobutton = new RadioButton(4,14,"A");
			  rb2_radiobutton = new RadioButton(4,26,"B");
			  rb3_radiobutton = new RadioButton(4,38,"C");
			  rb4_radiobutton = new RadioButton(4,50,"D");
			  
			  // Clear the drawing area...	
              gr.clearScreen();

			  // Adding the RadioButtons in a group so that only one can be clicked at a  // time. 	
              radiogroup.add(rb1_radiobutton);
              radiogroup.add(rb2_radiobutton);
              radiogroup.add(rb3_radiobutton);
              radiogroup.add(rb4_radiobutton);
              
			  // Putting (painting the various GUI components on the Drawing area...
			  cb1_checkbox.paint();
              cb2_checkbox.paint();
              ok_button.paint();
			  			  
			  rb1_radiobutton.paint();
              rb2_radiobutton.paint();
              rb3_radiobutton.paint();
              rb4_radiobutton.paint();
              
			 }
		   
		   // Event Handling Routines...
           public void penDown(int x, int y)
           {

                if(ok_button.pressed(x,y))
                 {
					if (checked_1) 
					  str1 = "Check box 1 is Checked        ";
					else
					  str1 = "Check box 1 is UnChecked";						  					
					gr.drawString(str1,5,85);
					

					if (checked_2)
					  str2 = "Check box 2 is Checked        ";
					else
					  str2 = "Check box 2 is UnChecked";						  					
					gr.drawString(str2,5,95);
															 
				 }
                
				 if(cb1_checkbox.pressed(x,y))
                 {
                   checked_1 = !checked_1;
				   cb1_checkbox.handlePenDown(x,y);
					
	 			 }
                  if(cb2_checkbox.pressed(x,y))
                  {
                    checked_2 = !checked_2;
                    cb2_checkbox.handlePenDown(x,y);
					
                  }
                  if(rb1_radiobutton.pressed(x,y))
                  {
                    gr.drawString("Pressed Radio Button 1", 5,110);
	                rb1_radiobutton.handlePenDown(x,y);
                  }
                  if(rb2_radiobutton.pressed(x,y))
                  {
                    gr.drawString("Pressed Radio Button 2", 5,110);
                    rb2_radiobutton.handlePenDown(x,y);

                  }
                  if(rb3_radiobutton.pressed(x,y))
                  {
                    gr.drawString("Pressed Radio Button 3", 5,110);
                    rb3_radiobutton.handlePenDown(x,y);

                  }
                  if(rb4_radiobutton.pressed(x,y))
                  {
                    gr.drawString("Pressed Radio Button 4", 5,110);
                    rb4_radiobutton.handlePenDown(x,y);

                  }
          }

		public static void main(String args[])
        {
           new Check_Radio_Spotlet();
        }

}