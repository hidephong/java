/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServerDialog.java
 *
 * Created on Aug 30, 2010, 6:18:15 PM
 */



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Hoang
 */
public class ServerDialog1 extends javax.swing.JFrame implements Runnable{

    /** Creates new form ServerDialog */

    ServerSocket serverSocket;
    ObjectInputStream is;
    ObjectOutputStream os;
    Socket socket = null;
int i=0;
    public ServerDialog1() {
         initComponents();
       setTitle("Server");
        setSize(400,300);
        setVisible(true);
     
    //  while(true){
          try {  
            serverSocket = new ServerSocket(1112);
        while(true){
            System.out.println("Waitting...");
              socket = serverSocket.accept();
  
    
                os= new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
                

                os.writeObject("Hello, connected");
                os.flush();

                    try {
                        String strRead = is.readObject().toString();
                        jTextArea1.append("Client:" +  strRead + "\n");
                                  
                        
                    } catch (Exception e1) {
//System.exit(0);
                        socket.close();
                        e1.printStackTrace();
                    }



              }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txtMess = new javax.swing.JTextField();
        butSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        butSend.setText("Send");
        butSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txtMess, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(butSend)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSend))
                .addGap(38, 38, 38))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSendActionPerformed
        // TODO add your handling code here:
        try {
             os.writeObject(txtMess.getText());
             os.flush();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_butSendActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtMess;
    // End of variables declaration//GEN-END:variables

  

    public  void run(){
         }

}
