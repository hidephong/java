import javax.swing.*;

public class TextAreaExample {

	public static void main(String[] args){
		JFrame frame= new JFrame("TextArea frame");
		JPanel panel=new JPanel();
		JTextArea jt= new JTextArea("Welcome Roseindia",5,20);
		frame.add(panel);
		panel.add(jt);
		frame.setSize(250,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
