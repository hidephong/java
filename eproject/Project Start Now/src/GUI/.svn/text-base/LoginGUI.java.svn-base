 package GUI;

import DataAccess.LoginValidate;
import DataAccess.TheConnection;
import Language.Language;
import Entity.Session;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.*;

/**
 *
 * @author nhahv
 */
public class LoginGUI extends javax.swing.JFrame {
    ServerConfigureGUI svrConGui;
    int LoginID;
    LoginValidate logValidate;
    /** Creates new form LoginValidate */
    public LoginGUI() {
        initComponents();
        svrConGui = new ServerConfigureGUI(this,true);
        logValidate = new LoginValidate();
        LoginID = -1;
       
           
      

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_EmpName = new javax.swing.JLabel();
        jTextField_User = new javax.swing.JTextField();
        jBt_Login = new javax.swing.JButton();
        jLabel_Password = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel_Loginass = new javax.swing.JLabel();
        jRadioButton_Employee = new javax.swing.JRadioButton();
        jRadioButton_Admin = new javax.swing.JRadioButton();
        jBt_Reset = new javax.swing.JButton();
        jLabel_Message = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login"); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLayeredPane1.setAlignmentX(0.0F);
        jLayeredPane1.setAlignmentY(0.0F);
        jLayeredPane1.setName("jLayeredPane1"); // NOI18N
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(500, 375));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 375));

        jLabel_Logo.setFont(jLabel_Logo.getFont().deriveFont(jLabel_Logo.getFont().getStyle() | java.awt.Font.BOLD, jLabel_Logo.getFont().getSize()+8));
        jLabel_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Language.Language", Language.getLocale()); // NOI18N
        jLabel_Logo.setText(bundle.getString("EMPLOYEE_TRANSFER_MANAGEMENT")); // NOI18N
        jLabel_Logo.setName("jLabel_Logo"); // NOI18N

        jLabel_EmpName.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel_EmpName.setText(bundle.getString("EMPLOYEE_NUMBER")); // NOI18N
        jLabel_EmpName.setName("jLabel_EmpName"); // NOI18N

        jTextField_User.setName("jTextField_User"); // NOI18N

        jBt_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/task-complete.png"))); // NOI18N
        jBt_Login.setText(bundle.getString("LOGIN")); // NOI18N
        jBt_Login.setName("jBt_Login"); // NOI18N
        jBt_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt_Login_Do_Login(evt);
            }
        });

        jLabel_Password.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel_Password.setText(bundle.getString("PASSWORD")); // NOI18N
        jLabel_Password.setName("jLabel_Password"); // NOI18N

        jPasswordField.setName("jPasswordField"); // NOI18N

        jLabel_Loginass.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel_Loginass.setText("Login as: "); // NOI18N
        jLabel_Loginass.setName("jLabel_Loginass"); // NOI18N

        buttonGroup1.add(jRadioButton_Employee);
        jRadioButton_Employee.setFont(new java.awt.Font("Tahoma 12", 1, 12));
        jRadioButton_Employee.setSelected(true);
        jRadioButton_Employee.setText("Employee"); // NOI18N
        jRadioButton_Employee.setName("jRadioButton_Employee"); // NOI18N
        jRadioButton_Employee.setOpaque(false);

        buttonGroup1.add(jRadioButton_Admin);
        jRadioButton_Admin.setFont(new java.awt.Font("Tahoma 12 12", 1, 12));
        jRadioButton_Admin.setText(bundle.getString("ADMIN")); // NOI18N
        jRadioButton_Admin.setName("jRadioButton_Admin"); // NOI18N
        jRadioButton_Admin.setOpaque(false);

        jBt_Reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/view-refresh.png"))); // NOI18N
        jBt_Reset.setText(bundle.getString("RESET")); // NOI18N
        jBt_Reset.setName("jBt_Reset"); // NOI18N
        jBt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt_ResetActionPerformed(evt);
            }
        });

        jLabel_Message.setText(bundle.getString("CHECKING_SERVER")); // NOI18N
        jLabel_Message.setName("jLabel_Message"); // NOI18N

        jSeparator3.setName("jSeparator3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel_Loginass)
                .addContainerGap(278, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBt_Reset)
                        .addGap(18, 18, 18)
                        .addComponent(jBt_Login))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addComponent(jLabel_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Password)
                                    .addComponent(jLabel_EmpName))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordField)
                                    .addComponent(jTextField_User, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jRadioButton_Employee)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton_Admin)))))))
                .addGap(214, 214, 214))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_EmpName)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Password))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_Admin)
                    .addComponent(jRadioButton_Employee)
                    .addComponent(jLabel_Loginass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBt_Login)
                    .addComponent(jBt_Reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Logo)
                .addGap(19, 19, 19))
        );

        jPanel1.setBounds(0, 0, 490, 370);
        jLayeredPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login_US.png"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setRequestFocusEnabled(false);
        jLabel6.setVerifyInputWhenFocusTarget(false);
        jLabel6.setBounds(0, 0, 500, 375);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setAlignmentX(0.0F);
        jMenuBar1.setName("jMenuBar1"); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(500, 32));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/go-home.png"))); // NOI18N
        jMenu1.setText(bundle.getString("SYSTEM")); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/preferences-system.png"))); // NOI18N
        jMenuItem1.setText(bundle.getString("SERVER_CONFIG")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jMenu1.add(jSeparator2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/application-exit.png"))); // NOI18N
        jMenuItem3.setText(bundle.getString("EXIT")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/help-browser.png"))); // NOI18N
        jMenu2.setText(bundle.getString("HELP")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/dialog-information.png"))); // NOI18N
        jMenuItem4.setText(bundle.getString("REPORT_ISSUE")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu2.add(jSeparator1);

        jMenuAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/gtk-about.png"))); // NOI18N
        jMenuAbout.setText(bundle.getString("ABOUT")); // NOI18N
        jMenuAbout.setName("jMenuAbout"); // NOI18N
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-504)/2, (screenSize.height-433)/2, 504, 433);
    }// </editor-fold>//GEN-END:initComponents
    private void jBt_Login_Do_Login(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt_Login_Do_Login
        if(connection != null){
        boolean loged = tryLogin();
        if (loged) {
            this.setVisible(false);
            if(jRadioButton_Admin.isSelected()){
            new MainFrameGUI().setVisible(loged);
        }else{
            new Employee_MainFrameGUI().setVisible(loged);
        }
        }
        }
 else{
       checkConnection();
 }
    }//GEN-LAST:event_jBt_Login_Do_Login

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                    svrConGui.setVisible(true);
                    if(!svrConGui.isShowing()){
                        checkConnection();
                    }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int e = JOptionPane.showConfirmDialog(this, "Do you want exit ?", "Do you want exit", JOptionPane.OK_CANCEL_OPTION);
        if (e == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jBt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt_ResetActionPerformed
       jTextField_User.setText(null);
       jPasswordField.setText(null);
       jRadioButton_Employee.setSelected(true);
    }//GEN-LAST:event_jBt_ResetActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         int e = JOptionPane.showConfirmDialog(this, "Do you want exit ?", "Do you want exit", JOptionPane.OK_CANCEL_OPTION);
            if (e == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         Runtime rt = Runtime.getRuntime();
        try {
            String filePath = "help.chm";
            rt.exec("hh.exe " + filePath);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Cannot load help file!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         checkConnection();
    }//GEN-LAST:event_formWindowOpened

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
        // TODO add your handling code here:
        new AboutUs(this,false).setVisible(true);
    }//GEN-LAST:event_jMenuAboutActionPerformed
int retry = 1;
    private void checkConnection() {
        retry++;
        System.out.println("+ >>>>>"+ retry);
        if(this.isShowing()){
        System.out.println("Checking Connection");
        jLabel_Message.setForeground(Color.BLACK);
        jLabel_Message.setText("Checking Connection...");
            
     
        connection =new TheConnection().getConnection();
        if (connection != null) {
            jLabel_Message.setText("Connected to server! Ready ro login !");
        } else {
            jLabel_Message.setForeground(Color.red);
            jLabel_Message.setText("Connection failed: Please reconfigure your server conection.");
            svrConGui = new ServerConfigureGUI(jframe, true);
            svrConGui.setVisible(true);
            
            if (!svrConGui.isShowing() && retry < 3) {
                checkConnection();
                
            }

        }
    }
    }
    private boolean tryLogin() {
        jLabel_Message.setText(null);
        jLabel_Message.setForeground(Color.red);
        String StringPassword = new String(jPasswordField.getPassword());
        String Username = jTextField_User.getText();

        if (Username.isEmpty() || StringPassword.isEmpty()) {
            jLabel_Message.setText(userBundle.getString("ERROR_LOGIN:USER_PASS_NOT_BLANK"));
            return false;
        }

        boolean isAdmin = jRadioButton_Admin.isSelected();
        LoginID = logValidate.loginValidate(Username, StringPassword, isAdmin);
        if (LoginID > 0) {
            Session.setSession(true);
            Session.setPermission(isAdmin);
            Session.setLoginID(LoginID);
            System.out.println(LoginID);
            jLabel_Message.setForeground(Color.GREEN);
            jLabel_Message.setText("Loged!");
            return true;
        }
        jLabel_Message.setText("Login Failed !");
        return false;
    }
    
    //@Nha.HV: Chức năng cho Menu Help
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBt_Login;
    private javax.swing.JButton jBt_Reset;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_EmpName;
    private javax.swing.JLabel jLabel_Loginass;
    private javax.swing.JLabel jLabel_Logo;
    public static javax.swing.JLabel jLabel_Message;
    private javax.swing.JLabel jLabel_Password;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRadioButton_Admin;
    private javax.swing.JRadioButton jRadioButton_Employee;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField_User;
    // End of variables declaration//GEN-END:variables
   JFrame jframe;
    Connection connection;
    private java.util.ResourceBundle userBundle = java.util.ResourceBundle.getBundle("Language.Language", Language.getLocale());
}
