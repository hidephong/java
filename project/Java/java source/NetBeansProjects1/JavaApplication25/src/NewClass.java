/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
class Core
{
        public static void main(String args[])
        {
                //frame khong phu thuoc do phan giai man hinh
                Toolkit kit = Toolkit.getDefaultToolkit();
                Dimension screenSize = kit.getScreenSize();
                int screenWidth = screenSize.width;
                int screenHeight = screenSize.height;
                int frameWidth = 200;
                int frameHeight = 60;
                JFrame frame = new JFrame("My frame");
                frame.setLayout(null);
                frame.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
                frame.setSize(frameWidth,frameHeight);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //tao Button Exit cai dat phuong thuc hanh dong qua class rieng
                Button b1 = new Button("Exit");
                b1.setBounds(0,0,100,25);
                frame.add(b1);
                EventQuit eventQuit=new EventQuit();
                b1.addActionListener(eventQuit);

                //tao Button About cai dat phuong thuc hanh dong truc tiep
                final Button b2 = new Button("About");
                b2.setBounds(100,0,100,25);
                frame.add(b2);
                b2.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                if(e.getSource()==b2) System.out.println("Made in Vietnam");
                        }
                });
                frame.setVisible(true);
        }
}
class EventQuit implements ActionListener
{
        public void actionPerformed(ActionEvent e)
        {
                System.exit(0);
        }
}

