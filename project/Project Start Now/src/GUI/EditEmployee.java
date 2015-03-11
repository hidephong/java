package GUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddEmployee.java
 *
 * Created on Mar 25, 2011, 3:13:11 PM
 */



import javax.swing.DefaultComboBoxModel;
import Business.*;
import Entity.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
/**
 *
 * @author Lovely
 */
public class EditEmployee extends javax.swing.JDialog
{
   private EmployeeManager em = new EmployeeManager();
   private LocationComboboxControler  lm = new LocationComboboxControler();
   private ProjectOnDepManagement pm = new ProjectOnDepManagement();
   private RoleComboBoxControler rm = new RoleComboBoxControler();
   DefaultComboBoxModel dcbm,dcbm1,dcbm2;
   DefaultComboBoxModel dcb_gen = new DefaultComboBoxModel();
 static Employee emp;
   boolean frt=true;
    /** Creates new form AddEmployee */
    public EditEmployee(java.awt.Frame parent, boolean modal,Employee imemp) {
        super(parent, modal);
        initComponents();
          init();
          emp=imemp;
          init_cbb(1);
          
    }

 private void init_cbb(int ics) {
       dcbm = new DefaultComboBoxModel();
       dcbm1 = new DefaultComboBoxModel();
       dcbm2 = new DefaultComboBoxModel();
        if(ics==0){
        dcb_gen.addElement("male");
        dcb_gen.addElement("female");
        jCbbGen.setModel(dcb_gen);
        jCbbGen.setSelectedIndex(0);
        jCbbLoc.setModel(lm.get_AllLocation());
        jCbbLoc.setSelectedIndex(0);
        cbProjOnDep.setModel(pm.getAllProjectOnDepartment());
        jCbbRole.setModel(rm.get_AllRole());
        jCbbRole.setSelectedIndex(0);
        }
        else
        {
        dcb_gen.addElement("male");
        dcb_gen.addElement("female");
        jCbbGen.setModel(dcb_gen);
        jCbbGen.setSelectedIndex(0);
        dcbm.addElement(emp.getLocation());
        jCbbLoc.setModel(dcbm);
        jCbbLoc.setSelectedIndex(0);
        dcbm1.addElement(emp.getCurrentProject()+" on " + emp.getCurrentDepartment());
        cbProjOnDep.setModel(dcbm1);
        cbProjOnDep.setSelectedIndex(0);

        dcbm2.addElement(emp.getRole());
        jCbbRole.setModel(dcbm2);
        jCbbRole.setSelectedIndex(0);


            jtf_Username.setText(emp.getUsername());
            jtf_Fullname.setText(emp.getEmployeeName());
            jtf_WorkExperience.setText(String.valueOf(emp.getWorkExperience()));
            jDCDateJoin.setDate(emp.getJoiningDate());
            jtf_Phonenumber.setText(emp.getPhoneNumber());
            jtf_Email.setText(emp.getEmail());
            jtf_Address.setText(emp.getAddress());
            if(emp.getGender().equalsIgnoreCase("male")){jCbbGen.setSelectedIndex(0); } else
            { jCbbGen.setSelectedIndex(1); }
            if(emp.getStatus().contains("enable")){  jChkStatus.setSelected(true);} else {jChkStatus.setSelected(false);}
     }
    }
 private void init(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth())/2);
        int y = (int) ((dimension.getHeight() - getHeight())/2);
        setLocation(x,y);
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
        btnReset = new javax.swing.JButton();
        cbProjOnDep = new javax.swing.JComboBox();
        jDCDateJoin = new com.toedter.calendar.JDateChooser("MM/dd/yyyy", "##/##/####",'_');
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtf_Phonenumber = new javax.swing.JTextField();
        jtf_Email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_Username = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jtf_Fullname = new javax.swing.JTextField();
        jChkStatus = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jCbbRole = new javax.swing.JComboBox();
        jCbbGen = new javax.swing.JComboBox();
        jCbbLoc = new javax.swing.JComboBox();
        jtf_WorkExperience = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtf_Address = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);

        jXHeader1.setBackground(new java.awt.Color(153, 153, 0));
        jXHeader1.setBackgroundPainter(glossPainter1);
        jXHeader1.setTitle("Edit employee");
        jXHeader1.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
        jXHeader1.setTitleForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee info"));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbProjOnDep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProjOnDep.setEnabled(false);

        jDCDateJoin.setDateFormatString("MM/dd/yyyy");

        jLabel12.setText("Project On Department:");

        jLabel11.setText("Location:");

        jLabel14.setText("Status:");

        jLabel7.setText("Phone number:");

        jLabel6.setText("Joining Date:");

        jLabel10.setText("Address:");

        jLabel9.setText("Gender:");

        jLabel2.setText("Username:");

        jtf_Username.setEditable(false);

        btnSave.setText("Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Full name:");

        jLabel5.setText("Work experience");

        jLabel8.setText("Email:");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jCbbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbbRole.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCbbRoleFocusGained(evt);
            }
        });

        jCbbGen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jCbbLoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbbLoc.setEnabled(false);
        jCbbLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbbLocActionPerformed(evt);
            }
        });

        jLabel4.setText("Role:");

        jtf_Address.setColumns(20);
        jtf_Address.setRows(5);
        jScrollPane1.setViewportView(jtf_Address);

        jButton1.setText("Change location");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnSave)
                        .addGap(3, 3, 3)
                        .addComponent(btnReset)
                        .addGap(9, 9, 9)
                        .addComponent(btnClose))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCbbGen, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Phonenumber, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(jtf_WorkExperience, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)
                                .addComponent(jtf_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addGap(47, 47, 47)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbProjOnDep, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDCDateJoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_Fullname)
                                    .addComponent(jCbbRole, 0, 150, Short.MAX_VALUE)
                                    .addComponent(jtf_Email)
                                    .addComponent(jChkStatus)))
                            .addComponent(jLabel14))
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtf_Fullname, jtf_Username});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProjOnDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtf_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jCbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDCDateJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtf_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtf_WorkExperience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jtf_Phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jCbbGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChkStatus)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnReset)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

                 Employee svemp = new Employee();
                 String str;
                 svemp.setEmployeeID(emp.getEmployeeID());
                 svemp.setUsername(jtf_Username.getText());
                 svemp.setEmployeeName(jtf_Fullname.getText());
                 int rid = rm.get_RoleIDByName(jCbbRole.getSelectedItem().toString());
                 svemp.setRoleID(rid);
                 svemp.setWorkExperience(Integer.parseInt(jtf_WorkExperience.getText()));
                 svemp.setJoiningDate(jDCDateJoin.getDate());
                 svemp.setPhoneNumber(jtf_Phonenumber.getText().toString());
                 svemp.setEmail(jtf_Email.getText().toString());
                 svemp.setWorkItemID(pm.getWorkItemID(cbProjOnDep.getSelectedItem().toString()));
                 svemp.setAddress(jtf_Address.getText());
                    if(jCbbGen.getSelectedIndex()==0)
                     { svemp.setGender("Male"); }
                        else { svemp.setGender("Female");}
                     if(jChkStatus.isSelected())
                     {
                          svemp.setStatus("enabled");}
                        else
                     {
                        svemp.setStatus("disabled"); }
                boolean br =   em.update(svemp);
              
         if(br){
              JOptionPane.showMessageDialog(this,"Change employee information success!","Alert",1);
        }else{
              JOptionPane.showMessageDialog(this,"Change employee information not success!","Alert",1);
             }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
             init_cbb(1);
            jtf_Username.setText(emp.getUsername());
            jtf_Fullname.setText(emp.getEmployeeName());
            jtf_WorkExperience.setText(String.valueOf(emp.getWorkExperience()));
            jDCDateJoin.setDate(emp.getJoiningDate());
            jtf_Phonenumber.setText(emp.getPhoneNumber());
            jtf_Email.setText(emp.getEmail());
            jtf_Address.setText(emp.getAddress());
            if(emp.getGender().equalsIgnoreCase("male")){jCbbGen.setSelectedIndex(0); } else
            { jCbbGen.setSelectedIndex(1); }
     if(emp.getStatus().contains("enable")){  jChkStatus.setSelected(true);} else {jChkStatus.setSelected(false);}

            
    }//GEN-LAST:event_btnResetActionPerformed

    private void jCbbRoleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCbbRoleFocusGained
        // TODO add your handling code here:
        jCbbRole.setModel(rm.get_AllRole());
       jCbbRole.setSelectedIndex(0);
    }//GEN-LAST:event_jCbbRoleFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jCbbLoc.setEnabled(true);
        jCbbLoc.setModel(lm.get_AllLocation());
        jCbbLoc.setSelectedIndex(0);
        cbProjOnDep.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCbbLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbbLocActionPerformed
        // TODO add your handling code here:
          cbProjOnDep.setModel(pm.getAllProjectOnDepartmentByLoc(jCbbLoc.getSelectedItem().toString()));

    }//GEN-LAST:event_jCbbLocActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 EditEmployee dialog = new  EditEmployee(new javax.swing.JFrame(), true,emp);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
       
       });
    }


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbProjOnDep;
    private org.jdesktop.swingx.painter.GlossPainter glossPainter1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCbbGen;
    private javax.swing.JComboBox jCbbLoc;
    private javax.swing.JComboBox jCbbRole;
    private javax.swing.JCheckBox jChkStatus;
    private com.toedter.calendar.JDateChooser jDCDateJoin;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JTextArea jtf_Address;
    private javax.swing.JTextField jtf_Email;
    private javax.swing.JTextField jtf_Fullname;
    private javax.swing.JTextField jtf_Phonenumber;
    private javax.swing.JTextField jtf_Username;
    private javax.swing.JTextField jtf_WorkExperience;
    // End of variables declaration//GEN-END:variables

}