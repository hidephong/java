/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication4;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Lovely
 */
public class AcceptNameSwing extends JFrame {
JTextField txtName = new JTextField(20);
    JLabel lblName = new JLabel("Name: ");
    AcceptNameSwing(String title){
     super(title);
     setLayout(new FlowLayout());
     this.add(lblName);
     this.add(txtName);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        AcceptNameSwing myWin=new AcceptNameSwing("My window");
        myWin.setSize(300,400);
        myWin.setVisible(true);
    }
}
