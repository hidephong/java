/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddALocation.java
 *
 * Created on Mar 24, 2011, 3:26:18 PM
 */

package GUI;

import DataAccess.LocationData;
import Entity.Location;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Nha.HV
 */
public class AddALocation extends javax.swing.JDialog {
    LocationData locdata;
    /** Creates new form AddALocation */
    public AddALocation(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        locdata = new LocationData();
        setLocation();
    }
    
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        glossPainter1 = new org.jdesktop.swingx.painter.GlossPainter();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jPanel1 = new javax.swing.JPanel();
        jlbloca = new javax.swing.JLabel();
        jTF_LocAD = new javax.swing.JTextField();
        jlballowance = new javax.swing.JLabel();
        jFmtAllowance = new javax.swing.JFormattedTextField();
        jlbstatus = new javax.swing.JLabel();
        jcbb_AddStatus = new javax.swing.JComboBox();
        jLb_Message = new javax.swing.JLabel();
        jbtcancel = new javax.swing.JButton();
        jbtreset = new javax.swing.JButton();
        jBT_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a location");
        setResizable(false);

        jXHeader1.setBackground(new java.awt.Color(51, 51, 0));
        jXHeader1.setBackgroundPainter(glossPainter1);
        jXHeader1.setTitle("Add a location");
        jXHeader1.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
        jXHeader1.setTitleForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jlbloca.setText("Location Address: ");

        jlballowance.setText("Allowance:");

        jFmtAllowance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFmtAllowance.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jlbstatus.setText("Status: ");

        jcbb_AddStatus.setModel(new javax.swing.DefaultComboBoxModel(status));

        jbtcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/gnome-session-halt.png"))); // NOI18N
        jbtcancel.setText("Cancel");
        jbtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelActionPerformed(evt);
            }
        });

        jbtreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/document-open-recent.png"))); // NOI18N
        jbtreset.setText("Reset");
        jbtreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtresetActionPerformed(evt);
            }
        });

        jBT_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/task-accepted.png"))); // NOI18N
        jBT_save.setText("Save");
        jBT_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBT_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_Message, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbloca)
                            .addComponent(jlballowance)
                            .addComponent(jlbstatus))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtAllowance, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(jTF_LocAD, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbb_AddStatus, 0, 120, Short.MAX_VALUE)
                                .addGap(122, 122, 122))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtcancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtreset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBT_save)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBT_save, jbtcancel, jbtreset});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbloca)
                    .addComponent(jTF_LocAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlballowance)
                    .addComponent(jFmtAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbb_AddStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbstatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLb_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtreset, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBT_save, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBT_save, jbtcancel, jbtreset});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-409)/2, (screenSize.height-304)/2, 409, 304);
    }// </editor-fold>//GEN-END:initComponents

     private void setLocation(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth())/2);
        int y = (int) ((dimension.getHeight() - getHeight())/2);
        setLocation(x,y);
    }
    private void jBT_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBT_saveActionPerformed
      
        
        if(jFmtAllowance.getText().length()>12){
               jLb_Message.setText("Error: Allowance damn huge!");
               return;
           }
           if(jTF_LocAD.getText().isEmpty() || jFmtAllowance.getText().isEmpty()){
               jLb_Message.setText("Error: Locationname and Allowance can not be empty !");
               return;
           }
           try {
             float f = Float.parseFloat(jFmtAllowance.getText());
        } catch (Exception e) {
            jLb_Message.setText("Error: Allowance must be real");
            return;
        }
         
           
               
           
           Vector<Location> tosearch = LocationGUI.locationVector;
            for (Location loc : tosearch) {
            if(loc.getLocationAddress().equalsIgnoreCase(jTF_LocAD.getText())){
                 jLb_Message.setText("Error: Location alailable already !");
                    return;
                }
            
        }
            
            
           
        Location loc = new Location();
           loc.setLocationAddress(jTF_LocAD.getText());
           loc.setLocationAllowance(Float.valueOf(jFmtAllowance.getText()));
           loc.setLocationStatus(status[jcbb_AddStatus.getSelectedIndex()]);
          
           if(locdata.addALocation(loc)){
               this.dispose();
               JOptionPane.showMessageDialog(rootPane, "Add successful!");
              
           }else{
               jLb_Message.setText("Error: Failed");
           }
      
    }//GEN-LAST:event_jBT_saveActionPerformed

    private void jbtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Do you want exit?", "Do you want exit?",JOptionPane.YES_NO_OPTION);
        if(i == 0){this.dispose();
        }
    }//GEN-LAST:event_jbtcancelActionPerformed

    private void jbtresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtresetActionPerformed
        jTF_LocAD.setText(null);
        jFmtAllowance.setText(null);
        jcbb_AddStatus.setSelectedIndex(0);
    }//GEN-LAST:event_jbtresetActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddALocation dialog = new AddALocation(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.painter.GlossPainter glossPainter1;
    private javax.swing.JButton jBT_save;
    private javax.swing.JFormattedTextField jFmtAllowance;
    private javax.swing.JLabel jLb_Message;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTF_LocAD;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JButton jbtcancel;
    private javax.swing.JButton jbtreset;
    private javax.swing.JComboBox jcbb_AddStatus;
    private javax.swing.JLabel jlballowance;
    private javax.swing.JLabel jlbloca;
    private javax.swing.JLabel jlbstatus;
    // End of variables declaration//GEN-END:variables
    int count = 0;
    String[] status = new String[]{"Enabled","Disabled"};

}