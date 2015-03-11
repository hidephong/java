package GUI;

import DataAccess.LocationData;
import Entity.Location;
import Business.LocationModel;
import java.awt.HeadlessException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class LocationGUI extends javax.swing.JPanel {

    LocationData locdata;
    Location loc;

    /** Creates new form LocationGUI */
    public LocationGUI() {
        initComponents();
        saveBtn.setVisible(false);
        cancelBtn.setVisible(false);
        locdata = new LocationData();
        onLoad();
    }

    private boolean Delete() throws HeadlessException, NumberFormatException {
        if (jTable_Location.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(jTable_Location, "Please choose a location to delete!", "WARNING", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        int SelectedRow = jTable_Location.convertRowIndexToModel(jTable_Location.getSelectedRow());
        int locID = Integer.parseInt(jTextField_LocationID.getText());
        if (SelectedRow >= 0) {
            String confirmDelete = "Do you want to delete selected project: " + jTable_Location.getValueAt(SelectedRow, 1) + "?";
            if (JOptionPane.showConfirmDialog(this, confirmDelete, confirmDelete, JOptionPane.YES_NO_OPTION) == 0) {
                int todelID = Integer.parseInt(jTable_Location.getValueAt(SelectedRow, 0).toString());
                try {
                    boolean deleted = locdata.deleteAllocation(todelID);
                    if (deleted) {
                        RowSorter<? extends TableModel> rowSorter = jTable_Location.getRowSorter();
                        rowSorter.rowsDeleted(SelectedRow, SelectedRow);
                        jTable_Location.setModel(rowSorter.getModel());
                        jTable_Location.revalidate();
                    } else {
                        JOptionPane.showMessageDialog(this, "Can not delete because this record is in use. The status of this location will be set to disabled", "WARNING", JOptionPane.ERROR_MESSAGE);
                        locdata.UpdateAfterDelete(locID);
                        RowSorter<? extends TableModel> rowSorter = jTable_Location.getRowSorter();
                        jTable_Location.setModel(rowSorter.getModel());
                        this.onLoad();
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    private boolean Save() throws HeadlessException {
        if (jTextArea_LocationAddress.getText().isEmpty() || jTextField_LocationAllowance.getText().isEmpty() || jComboBox_LocationStatus.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(jTextArea_LocationAddress, "Fields cannot be empty!", "Warning", JOptionPane.OK_OPTION);
            return true;
        }
        String locAdd = jTextArea_LocationAddress.getText();
        try {
            int id = Integer.parseInt(jTextField_LocationID.getText());
            float locAll = Float.valueOf(jTextField_LocationAllowance.getText());
            String stt = jComboBox_LocationStatus.getSelectedItem().toString();
            loc = new Location(id, locAdd, locAll, stt);
            if (locdata.updateALocation(loc)) {
                JOptionPane.showMessageDialog(this, "Update completed successful!");
                onLoad();
            } else {
                JOptionPane.showMessageDialog(this, "Cannot update this location.", "Warning", JOptionPane.OK_OPTION);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jTextField_LocationAllowance, "Allowance must be a real number!", "Warning", JOptionPane.OK_OPTION);
            return true;
        }
        return false;
    }

    private void Searching() {
        System.out.println(jtf_kywrd.getText());
        if (jtf_kywrd.getText().length() >= 0) {
            tempVector = new Vector<Location>();
            for (Location loc : locationVector) {
                if (loc.getLocationAddress().toLowerCase().contains(jtf_kywrd.getText().toLowerCase())) {
                    i++;
                    tempVector.add(loc);
                }
            }
            TableModel tempModel = new LocationModel(tempVector);
            jTable_Location.setModel(tempModel);
            jTable_Location.revalidate();
        }
    }

    private void onLoad() {

        locationVector = new LocationData().getAllLocation();
        hashCodeonLoad = locationVector.hashCode();
        //locationDataChange = new LocationDA().getAllLocation();
        tableModel = new LocationModel(locationVector);
        jTable_Location.setModel(tableModel);
        tempVector = locationVector;
        jTable_Location.setRowSorter(jTable_Location.getRowSorter());



        jTextField_LocationID.setText("");
        jTextField_LocationID.setEditable(false);
        jTextArea_LocationAddress.setText("");
        jTextField_LocationAllowance.setText(null);
        jComboBox_LocationStatus.setSelectedIndex(-1);
        editting(false);
    }

    private void editting(boolean b) {
        jTextArea_LocationAddress.setEditable(b);
        jTextField_LocationAllowance.setEditable(b);
        jComboBox_LocationStatus.setEnabled(b);
        saveBtn.setVisible(b);
        cancelBtn.setVisible(b);
    }

    private void viewInfomation(){
        int SelectedRow = jTable_Location.convertRowIndexToModel(jTable_Location.getSelectedRow());
        String stringLocationId = Integer.toString(tempVector.get(SelectedRow).getLocationID());
        jTextField_LocationID.setText(stringLocationId);
        jTextArea_LocationAddress.setText(tempVector.get(SelectedRow).getLocationAddress());
        jTextField_LocationAllowance.setText(""+tempVector.get(SelectedRow).getLocationAllowance());
        jComboBox_LocationStatus.setSelectedItem(tempVector.get(SelectedRow).getLocationStatus());
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        glossPainter1 = new org.jdesktop.swingx.painter.GlossPainter();
        jPanel2 = new javax.swing.JPanel();
        jLabel_LocationID = new javax.swing.JLabel();
        jTextField_LocationID = new javax.swing.JTextField();
        jLabel_LocationAddress = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_LocationAddress = new javax.swing.JTextArea();
        jLabel_LocationAllowance = new javax.swing.JLabel();
        jLabel_LocationStatus = new javax.swing.JLabel();
        jComboBox_LocationStatus = new javax.swing.JComboBox();
        jButton_Edit = new javax.swing.JButton();
        jButton_Add = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jTextField_LocationAllowance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton_F5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Location = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jtf_kywrd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Location Infomation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 262));

        jLabel_LocationID.setText("ID: ");
        jLabel_LocationID.setName("jLabel_LocationID"); // NOI18N
        jLabel_LocationID.setRequestFocusEnabled(false);

        jTextField_LocationID.setName("jTextField_LocationID"); // NOI18N
        jTextField_LocationID.setPreferredSize(new java.awt.Dimension(0, 20));

        jLabel_LocationAddress.setText("Address:");
        jLabel_LocationAddress.setName("jLabel_LocationAddress"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextArea_LocationAddress.setColumns(20);
        jTextArea_LocationAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea_LocationAddress.setRows(5);
        jTextArea_LocationAddress.setBorder(null);
        jTextArea_LocationAddress.setName("jTextArea_LocationAddress"); // NOI18N
        jScrollPane2.setViewportView(jTextArea_LocationAddress);

        jLabel_LocationAllowance.setText("Allowance: ");
        jLabel_LocationAllowance.setName("jLabel_LocationAllowance"); // NOI18N

        jLabel_LocationStatus.setText("Status:");
        jLabel_LocationStatus.setName("jLabel_LocationStatus"); // NOI18N

        jComboBox_LocationStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enabled", "Disabled" }));
        jComboBox_LocationStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jComboBox_LocationStatus.setName("jComboBox_LocationStatus"); // NOI18N
        jComboBox_LocationStatus.setPreferredSize(new java.awt.Dimension(0, 24));

        jButton_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/story-editor.png"))); // NOI18N
        jButton_Edit.setText("Edit");
        jButton_Edit.setName("jButton_Edit"); // NOI18N
        jButton_Edit.addActionListener(formListener);

        jButton_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/opinion-agree.png"))); // NOI18N
        jButton_Add.setText("Add");
        jButton_Add.setName("jButton_Add"); // NOI18N
        jButton_Add.addActionListener(formListener);

        jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/opinion-disagree.png"))); // NOI18N
        jButton_Delete.setText("Delete");
        jButton_Delete.setName("jButton_Delete"); // NOI18N
        jButton_Delete.addActionListener(formListener);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_16/document-save.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setName("saveBtn"); // NOI18N
        saveBtn.addActionListener(formListener);

        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_16/dialog-error.png"))); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.setName("cancelBtn"); // NOI18N
        cancelBtn.addActionListener(formListener);

        jTextField_LocationAllowance.setName("jTextField_LocationAllowance"); // NOI18N
        jTextField_LocationAllowance.addActionListener(formListener);

        jLabel1.setText("$");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_LocationAddress)
                            .addComponent(jLabel_LocationID)
                            .addComponent(jLabel_LocationAllowance)
                            .addComponent(jLabel_LocationStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_LocationStatus, 0, 211, Short.MAX_VALUE)
                            .addComponent(jTextField_LocationID, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_LocationAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Delete))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(98, Short.MAX_VALUE)
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelBtn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_LocationID)
                    .addComponent(jTextField_LocationID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_LocationAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_LocationAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel_LocationAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_LocationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_LocationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(saveBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Edit)
                    .addComponent(jButton_Delete))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 400));

        jButton_F5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/gnome-session-reboot.png"))); // NOI18N
        jButton_F5.setText("Refress");
        jButton_F5.setName("jButton_F5"); // NOI18N
        jButton_F5.addActionListener(formListener);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable_Location.setAutoCreateRowSorter(true);
        jTable_Location.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Address", "Allwance", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_Location.setName("jTable_Location"); // NOI18N
        jTable_Location.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Location.getTableHeader().setReorderingAllowed(false);
        jTable_Location.addMouseListener(formListener);
        jScrollPane1.setViewportView(jTable_Location);
        jTable_Location.getColumnModel().getColumn(0).setResizable(false);
        jTable_Location.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable_Location.getColumnModel().getColumn(1).setResizable(false);
        jTable_Location.getColumnModel().getColumn(2).setResizable(false);
        jTable_Location.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable_Location.getColumnModel().getColumn(3).setResizable(false);
        jTable_Location.getColumnModel().getColumn(3).setPreferredWidth(50);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(jButton_F5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_F5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 108));

        jtf_kywrd.setName("jtf_kywrd"); // NOI18N
        jtf_kywrd.addFocusListener(formListener);
        jtf_kywrd.addKeyListener(formListener);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/system-search.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtf_kywrd, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jtf_kywrd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jButton_Edit) {
                LocationGUI.this.jButton_EditActionPerformed(evt);
            }
            else if (evt.getSource() == jButton_Add) {
                LocationGUI.this.jButton_AddActionPerformed(evt);
            }
            else if (evt.getSource() == saveBtn) {
                LocationGUI.this.saveBtnActionPerformed(evt);
            }
            else if (evt.getSource() == cancelBtn) {
                LocationGUI.this.cancelBtnActionPerformed(evt);
            }
            else if (evt.getSource() == jButton_F5) {
                LocationGUI.this.jButton_F5ActionPerformed(evt);
            }
            else if (evt.getSource() == jTextField_LocationAllowance) {
                LocationGUI.this.jTextField_LocationAllowanceActionPerformed(evt);
            }
            else if (evt.getSource() == jButton_Delete) {
                LocationGUI.this.jButton_DeleteActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == jtf_kywrd) {
                LocationGUI.this.jtf_kywrdFocusLost(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jtf_kywrd) {
                LocationGUI.this.jtf_kywrdKeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jtf_kywrd) {
                LocationGUI.this.jtf_kywrdKeyTyped(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jTable_Location) {
                LocationGUI.this.jTable_LocationMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_F5ActionPerformed
        this.onLoad();
    }//GEN-LAST:event_jButton_F5ActionPerformed

    private void jTable_LocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LocationMouseClicked
       viewInfomation();
    }//GEN-LAST:event_jTable_LocationMouseClicked

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        Delete();
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
        if (jTable_Location.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(jTable_Location, "Please choose a location to edit!", "Warning", JOptionPane.OK_OPTION);
            return;
        }

        editting(true);
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        addALocation = new AddALocation(null, true);
        addALocation.setVisible(true);
        onLoad();


    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jtf_kywrdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_kywrdKeyTyped
}//GEN-LAST:event_jtf_kywrdKeyTyped

    private void jtf_kywrdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_kywrdFocusLost
    }//GEN-LAST:event_jtf_kywrdFocusLost

    private void jtf_kywrdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_kywrdKeyPressed
        Searching();

    }//GEN-LAST:event_jtf_kywrdKeyPressed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Save();
}//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        editting(false);
}//GEN-LAST:event_cancelBtnActionPerformed

    private void jTextField_LocationAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LocationAllowanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LocationAllowanceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancelBtn;
    public org.jdesktop.swingx.painter.GlossPainter glossPainter1;
    public javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton_Add;
    public javax.swing.JButton jButton_Delete;
    public javax.swing.JButton jButton_Edit;
    public javax.swing.JButton jButton_F5;
    public javax.swing.JComboBox jComboBox_LocationStatus;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel_LocationAddress;
    public javax.swing.JLabel jLabel_LocationAllowance;
    public javax.swing.JLabel jLabel_LocationID;
    public javax.swing.JLabel jLabel_LocationStatus;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable_Location;
    public javax.swing.JTextArea jTextArea_LocationAddress;
    public javax.swing.JTextField jTextField_LocationAllowance;
    public javax.swing.JTextField jTextField_LocationID;
    public javax.swing.JTextField jtf_kywrd;
    public javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
    public static String[] statusModel = new String[]{"Enabled", "Disabled"};
    AbstractTableModel tableModel;
    public static Vector<Location> locationVector;
    Vector<Location> tempVector;
    int i = 0;
    int hashCodeonLoad;
    DefaultComboBoxModel locationStatus;
    AddALocation addALocation;
}
