/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataAccess.TheConnection;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author NhaHV
 * @version
 */
public class GenerateLetter extends javax.swing.JFrame {

    FileInputStream is;
    Connection Con;
    HashMap map;
   // JasperPrint jp;
    JasperViewer jv;
    JFrame jf;

    public GenerateLetter() {
        Con = TheConnection.getConnection();
        map = new HashMap();
       
    }
    public void GenerateLetter(int type, int value) {
        String filename = "";
        switch (type) {
            case 1:
                filename = "reports/ReferenceLetter.jasper";
                break;
            case 2:
                filename = "reports/ApprovalTransferLetter.jasper";
                break;
            case 3:
                filename = "reports/DenialTransferLetter.jasper";
                break;
            default:
                break;
        }
        try {
            is = new FileInputStream(filename);
            System.out.println("Loadded..." + filename);
            map = new HashMap();
            map.put("RecordID", value);
            Con = TheConnection.getConnection();
            JasperPrint jp = JasperFillManager.fillReport(is, map, Con);
            System.out.println("Fill Completed...");
            jv = new JasperViewer(jp);
            jf = new JFrame();
            jf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            int x = 1000, y = 600;
            jf.setSize(x,y);
            jf.add(jv.getContentPane());
            jf.setVisible(true);


        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds((screenSize.width-x)/2, (screenSize.height-y)/2, x, y);
        } catch (Exception ex) {
        }
    }
}
