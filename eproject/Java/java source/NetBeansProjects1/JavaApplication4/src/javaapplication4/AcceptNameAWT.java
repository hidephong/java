/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication4;
import java.awt.*;

/**
 *
 * @author Lovely
 */

public class AcceptNameAWT extends Frame {
TextField txtName = new TextField(20);
    Label lblName = new Label("Name: ");
    AcceptNameAWT(String title){
     super(title);
     setLayout(new FlowLayout());
     this.add(lblName);
     this.add(txtName);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        AcceptNameAWT myWin=new AcceptNameAWT("My window");
        myWin.setSize(300,400);
        myWin.setVisible(true);
    }

}
