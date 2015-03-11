/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hocvui;

/**
 *
 * @author Tuấn Tâm
 */
public class TracNghiem extends javax.swing.JFrame {

    int cau=1;
    /**
     * Creates new form TracNghiem
     */
    public TracNghiem() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jbtnLui = new javax.swing.JButton();
        jbtnTiep = new javax.swing.JButton();
        jbtnKQ = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Trắc nghiệm vui");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox1.setText("Đúng");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox2.setText("Sai");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Câu hỏi:");

        jbtnLui.setText("Quay lại");
        jbtnLui.setEnabled(false);
        jbtnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLuiActionPerformed(evt);
            }
        });

        jbtnTiep.setText("Tiếp theo");
        jbtnTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTiepActionPerformed(evt);
            }
        });

        jbtnKQ.setText("Kết quả");
        jbtnKQ.setEnabled(false);
        jbtnKQ.setSelected(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hocvui/ARIEL2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jbtnLui)
                        .addGap(32, 32, 32)
                        .addComponent(jbtnTiep)
                        .addGap(39, 39, 39)
                        .addComponent(jbtnKQ))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLui)
                    .addComponent(jbtnTiep)
                    .addComponent(jbtnKQ))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLuiActionPerformed
        // TODO add your handling code here:
        cau=cau-1;
        if(cau>1){
            jbtnKQ.setEnabled(false);
            jbtnTiep.setEnabled(true);
            jLabel3.setText(cau+"");
        }
        else{
        jbtnLui.setEnabled(false);
        }
         
    }//GEN-LAST:event_jbtnLuiActionPerformed

    private void jbtnTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTiepActionPerformed
        // TODO add your handling code here:
        cau=cau+1;
        jLabel3.setText(cau+"");
        if(cau>=5){
            jbtnTiep.setEnabled(false);
            jbtnKQ.setEnabled(true);
        }
         jbtnLui.setEnabled(true);
       
    }//GEN-LAST:event_jbtnTiepActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TracNghiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TracNghiem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnKQ;
    private javax.swing.JButton jbtnLui;
    private javax.swing.JButton jbtnTiep;
    // End of variables declaration//GEN-END:variables
}
