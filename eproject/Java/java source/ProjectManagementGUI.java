/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProjectManagementGUI.java
 *
 * Created on Mar 22, 2011, 8:35:19 PM
 */

package GUI;

import Entity.ProjectTableModel;
import Business.ProjectManagement;
import DataAccess.TheConnection;
import Entity.Project;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author PHUONGPHUONG
 */
public class ProjectManagementGUI extends javax.swing.JPanel implements ListSelectionListener {

    ProjectTableModel ptm = null;
    ProjectManagement pm = null;
    ProjectTableModel searchResult = null;
    Project p = null;

    /** Creates new form ProjectManagementGUI */
    public ProjectManagementGUI() {
        initComponents();
        pm = new ProjectManagement();
        //searchResult = new ProjectTableModel();
        fillProjectTable();
        projectTable.getSelectionModel().addListSelectionListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        projectTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IDTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        statusTextField = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        keywordTxtField = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        goBtn = new javax.swing.JButton();
        projectComboBox = new javax.swing.JComboBox();

        projectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjectID", "ProjectName", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                projectTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(projectTable);

        refreshBtn.setText("REFRESH");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("ProjectID: ");

        IDTextField.setEditable(false);
        IDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Project Name: ");

        jLabel3.setText("Status: ");

        nameTextField.setEditable(false);

        statusTextField.setEditable(false);

        editBtn.setText("EDIT");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("SEARCH");

        jLabel5.setText("Search by: ");

        jLabel6.setText("Key word: ");

        keywordTxtField.setText(" ");
        keywordTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordTxtFieldActionPerformed(evt);
            }
        });

        resetBtn.setText("RESET");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        goBtn.setText("GO");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        projectComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ProjectName", "Status" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(refreshBtn)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(statusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(deleteBtn)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(goBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                                    .addComponent(projectComboBox, 0, 208, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(keywordTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshBtn)
                    .addComponent(addBtn))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel6))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(keywordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetBtn)
                            .addComponent(goBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(deleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(projectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel5)))
                        .addGap(96, 96, 96)))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fillProjectTable()
    {
        ptm = pm.fillData();
        projectTable.setModel(ptm);
    }

    private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextFieldActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void keywordTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordTxtFieldActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        fillProjectTable();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        projectComboBox.setSelectedIndex(0);
        keywordTxtField.setText("");
    }//GEN-LAST:event_resetBtnActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        // TODO add your handling code here:
        searchResult = pm.searchProject(projectComboBox.getSelectedIndex(), keywordTxtField.getText().toString());
        projectTable.setModel(searchResult);
    }//GEN-LAST:event_goBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        //AddProjectGUI addDialog = new AddProjectGUI(null, true);

        
    }//GEN-LAST:event_addBtnActionPerformed

    private void projectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTableMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_projectTableMouseClicked
    public void valueChanged(ListSelectionEvent e)  {
                if (!e.getValueIsAdjusting()) {
                    DefaultListSelectionModel listModel = (DefaultListSelectionModel)e.getSource();
                    int selectedIndex = listModel.getMinSelectionIndex();
                    IDTextField.setText(projectTable.getValueAt(selectedIndex,0).toString());
                    nameTextField.setText(projectTable.getValueAt(selectedIndex,1).toString());
                    statusTextField.setText(projectTable.getValueAt(selectedIndex,2).toString());
                }
            }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        IDTextField.setEditable(true);
        nameTextField.setEditable(true);
        statusTextField.setEditable(true);
}//GEN-LAST:event_editBtnActionPerformed

    private void projectTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_projectTableMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton goBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField keywordTxtField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox projectComboBox;
    private javax.swing.JTable projectTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JTextField statusTextField;
    // End of variables declaration//GEN-END:variables

}