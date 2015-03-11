package studentman;

/*
 * Notepad.java
 *
 * Simple editor for Vietnamese
 */

import javax.swing.*;
//import net.sourceforge.vietpad.*;

public class Notepad extends JFrame {
    
    /** Creates new form Notepad */
    public Notepad() {
        JScrollPane jScrollPane = new JScrollPane();
        JTextArea jTextArea = new JTextArea();
//        jTextArea.addKeyListener(new VietKeyListener(jTextArea));
//        VietKeyListener.setSmartMark(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tiếng Việt");
        jTextArea.setText("Áo nàng vàng anh về yêu hoa cúc\nÁo nàng xanh anh mến lá sân trường");
        jScrollPane.setViewportView(jTextArea);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        pack();
        setVisible(true);
        JOptionPane.showMessageDialog(null, "Thử nghiệm Tiếng Việt", "Tiếng Việt", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Notepad();
    }    
}