/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Mainfrm.java
 *
 * Created on Nov 17, 2011, 9:34:29 PM
 */
package baitap;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lovely
 */
public class Mainfrm extends javax.swing.JFrame {
 List<Student> student = new ArrayList<Student>();
        StudentManage man = new StudentManage();
        int idx,last,type=1;
        List<Student> tmp =  new ArrayList<Student>();
        List<Student>   st= new ArrayList<Student>();
        String txtKey;
         StudentModel svtbm;
         int pb=0;
    /** Creates new form Mainfrm */
    public Mainfrm() {
        initComponents();
       loaddb();
    }
public void loaddb(){
if(pb>0){
    Vector<Student> sm= new Vector<Student>();
       int i=0; 

       
    for (;i<student.size();i++) 
    {
        sm.add(student.get(i));
      
     }   
    
    
 svtbm=new StudentModel(sm);
jTable2.setModel(svtbm);

}
pb=pb+1;
}
public void tclear(){
STT.setText("");
Hoten.setText("");
Lop.setText("");
Khoa.setText("");
NS.setText("");
TB1.setText("");
TB2.setText("");
TB3.setText("");
TB4.setText("");
TB5.setText("");
TB6.setText("");
TB7.setText("");
TB8.setText("");
STT1.setText("");
Hoten1.setText("");
Lop1.setText("");
Khoa1.setText("");
NS1.setText("");
TB9.setText("");
TB10.setText("");
TB11.setText("");
TB12.setText("");
TB13.setText("");
TB14.setText("");
TB15.setText("");
TB16.setText("");
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnlMan = new javax.swing.JTabbedPane();
        jpnladd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        STT = new javax.swing.JTextField();
        Hoten = new javax.swing.JTextField();
        NS = new javax.swing.JTextField();
        Lop = new javax.swing.JTextField();
        Khoa = new javax.swing.JTextField();
        TB1 = new javax.swing.JTextField();
        TB2 = new javax.swing.JTextField();
        TB3 = new javax.swing.JTextField();
        TB4 = new javax.swing.JTextField();
        TB5 = new javax.swing.JTextField();
        TB6 = new javax.swing.JTextField();
        TB7 = new javax.swing.JTextField();
        TB8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpnlEdit = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        STT1 = new javax.swing.JTextField();
        Hoten1 = new javax.swing.JTextField();
        NS1 = new javax.swing.JTextField();
        Lop1 = new javax.swing.JTextField();
        Khoa1 = new javax.swing.JTextField();
        TB9 = new javax.swing.JTextField();
        TB10 = new javax.swing.JTextField();
        TB11 = new javax.swing.JTextField();
        TB12 = new javax.swing.JTextField();
        TB13 = new javax.swing.JTextField();
        TB14 = new javax.swing.JTextField();
        TB15 = new javax.swing.JTextField();
        TB16 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jpnlSearch = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        rbTen = new javax.swing.JRadioButton();
        rbKhoa = new javax.swing.JRadioButton();
        rbLoai = new javax.swing.JRadioButton();
        rbLop = new javax.swing.JRadioButton();
        jpnlView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlMan.setPreferredSize(new java.awt.Dimension(800, 600));

        jpnladd.setPreferredSize(new java.awt.Dimension(800, 600));
        jpnladd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Thêm Sinh Viên");
        jpnladd.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 11, -1, -1));

        jLabel3.setText("STT");
        jpnladd.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel4.setText("Họ Tên");
        jpnladd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jLabel5.setText("Ngày sinh");
        jpnladd.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jLabel6.setText("Lớp");
        jpnladd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel7.setText("Khoa");
        jpnladd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel8.setText("TB Kỳ 1");
        jpnladd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel9.setText("TB Kỳ 2");
        jpnladd.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel10.setText("TB Kỳ 3");
        jpnladd.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel11.setText("TB Kỳ 6");
        jpnladd.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jLabel12.setText("TB Kỳ 5");
        jpnladd.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        jLabel13.setText("TB Kỳ 4");
        jpnladd.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel15.setText("TB Kỳ 8");
        jpnladd.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel16.setText("TB Kỳ 7");
        jpnladd.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));
        jpnladd.add(STT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 83, -1));
        jpnladd.add(Hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 210, -1));
        jpnladd.add(NS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 130, -1));
        jpnladd.add(Lop, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 140, -1));
        jpnladd.add(Khoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 140, -1));
        jpnladd.add(TB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 40, -1));
        jpnladd.add(TB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 40, -1));
        jpnladd.add(TB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 40, -1));
        jpnladd.add(TB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 40, -1));
        jpnladd.add(TB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 40, -1));
        jpnladd.add(TB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 40, -1));
        jpnladd.add(TB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 40, -1));
        jpnladd.add(TB8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 40, -1));

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpnladd.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jpnladd.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jpnlMan.addTab("ADD", jpnladd);

        jpnlEdit.setPreferredSize(new java.awt.Dimension(800, 600));
        jpnlEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel17.setText("Sửa thông tin Sinh Viên");
        jpnlEdit.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 11, -1, -1));

        jLabel18.setText("STT");
        jpnlEdit.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel19.setText("Họ Tên");
        jpnlEdit.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jLabel20.setText("Ngày sinh");
        jpnlEdit.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jLabel21.setText("Lớp");
        jpnlEdit.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel22.setText("Khoa");
        jpnlEdit.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel23.setText("TB Kỳ 1");
        jpnlEdit.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel24.setText("TB Kỳ 2");
        jpnlEdit.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel25.setText("TB Kỳ 3");
        jpnlEdit.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel26.setText("TB Kỳ 6");
        jpnlEdit.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jLabel27.setText("TB Kỳ 5");
        jpnlEdit.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        jLabel28.setText("TB Kỳ 4");
        jpnlEdit.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel29.setText("TB Kỳ 8");
        jpnlEdit.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel30.setText("TB Kỳ 7");
        jpnlEdit.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));
        jpnlEdit.add(STT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 83, -1));
        jpnlEdit.add(Hoten1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 210, -1));
        jpnlEdit.add(NS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 130, -1));
        jpnlEdit.add(Lop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 140, -1));
        jpnlEdit.add(Khoa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 140, -1));
        jpnlEdit.add(TB9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 40, -1));
        jpnlEdit.add(TB10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 40, -1));
        jpnlEdit.add(TB11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 40, -1));
        jpnlEdit.add(TB12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 40, -1));
        jpnlEdit.add(TB13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 40, -1));
        jpnlEdit.add(TB14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 40, -1));
        jpnlEdit.add(TB15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 40, -1));
        jpnlEdit.add(TB16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 40, -1));

        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jpnlEdit.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jpnlMan.addTab("Edit", jpnlEdit);

        jLabel14.setText("Từ khóa");

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel31.setText("Tìm kiếm");

        jLabel32.setText("Theo");

        buttonGroup1.add(rbTen);
        rbTen.setSelected(true);
        rbTen.setText("Họ tên");

        buttonGroup1.add(rbKhoa);
        rbKhoa.setText("Khoa");

        buttonGroup1.add(rbLoai);
        rbLoai.setText("Loại");

        buttonGroup1.add(rbLop);
        rbLop.setText("Lớp");

        javax.swing.GroupLayout jpnlSearchLayout = new javax.swing.GroupLayout(jpnlSearch);
        jpnlSearch.setLayout(jpnlSearchLayout);
        jpnlSearchLayout.setHorizontalGroup(
            jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSearchLayout.createSequentialGroup()
                .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jLabel31))
                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlSearchLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnlSearchLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(36, 36, 36)
                                .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                                        .addComponent(rbTen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbLop)
                                        .addGap(10, 10, 10)
                                        .addComponent(rbKhoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbLoai))))))
                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jpnlSearchLayout.setVerticalGroup(
            jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSearchLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14))
                    .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbLop)
                                .addComponent(rbKhoa)
                                .addComponent(rbTen))
                            .addComponent(rbLoai)))
                    .addGroup(jpnlSearchLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jpnlMan.addTab("Search", jpnlSearch);

        jpnlView.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpnlViewFocusGained(evt);
            }
        });

        jLabel1.setText("Danh sách sinh viên");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jpnlViewLayout = new javax.swing.GroupLayout(jpnlView);
        jpnlView.setLayout(jpnlViewLayout);
        jpnlViewLayout.setHorizontalGroup(
            jpnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlViewLayout.createSequentialGroup()
                .addGroup(jpnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlViewLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel1))
                    .addGroup(jpnlViewLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jpnlViewLayout.setVerticalGroup(
            jpnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jpnlMan.addTab("View", jpnlView);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(800, 21));

        jMenu1.setText("File");

        jMenuItem1.setText("Load Database");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem8.setText("Exit");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Help");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
// TODO add your handling code here:
    System.exit(0);
}//GEN-LAST:event_jMenuItem8ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here: 
    if(rbTen.isSelected()){type=1;}else
        if(rbLop.isSelected()){type=2;}else
            if(rbKhoa.isSelected()){type=3;}else{type=4;}
     txtKey=key.getText();
     st=man.Search(type,txtKey,student);
     Vector<Student> sm= new Vector<Student>();
       int i=0; 
       
    for (;i<st.size();i++) 
    {
        sm.add(st.get(i));
      
     }   
 svtbm=new StudentModel(sm);
jTable1.setModel(svtbm);
 loaddb();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        tclear();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    if(student.isEmpty())
                {last = 0;}
                else{
                last = student.get(student.size()-1).getId();
                }
                last++;
                Student s =new Student();
                StudentManage man1 = new StudentManage();
        try {
            s=man1.addStudent(last, STT.getText().trim(), Hoten.getText(), NS.getText(), Lop.getText(), Khoa.getText(), TB1.getText().trim(),TB2.getText().trim(),TB3.getText().trim(),TB4.getText().trim(),TB5.getText().trim(),TB6.getText().trim(),TB7.getText().trim(),TB8.getText().trim());
             student.add(student.size(),s);      
                    } catch (ParseException ex) {
            Logger.getLogger(Mainfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        tclear();
        loaddb();        
}//GEN-LAST:event_jButton1ActionPerformed

private void jpnlViewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpnlViewFocusGained
// TODO add your handling code here:
   
    
}//GEN-LAST:event_jpnlViewFocusGained

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
                 idx = man.getIndex(student,STT1.getText());
                 Student t= new Student();
                 t= student.get(idx);
                Student s= man.Editstudent(STT1.getText().trim(), Hoten1.getText(), NS1.getText(), Lop1.getText(), Khoa1.getText(), TB9.getText().trim(),TB10.getText().trim(),TB11.getText().trim(),TB12.getText().trim(),TB13.getText().trim(),TB14.getText().trim(),TB15.getText().trim(),TB16.getText().trim(),t);
                       
              
                            tmp.clear();
                            tmp.addAll(student);
                            student.clear();
                            tmp.set(idx,s);
                            student.addAll(tmp);
        } catch (ParseException ex) {
            Logger.getLogger(Mainfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        tclear();
          loaddb();   
}//GEN-LAST:event_jButton4ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // TODO add your handling code here:
                man.db(student,1);
                  loaddb();   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mainfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
    try {
            // TODO add your handling code here:
                student=man.db(student,0);
                loaddb();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mainfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Mainfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Mainfrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Hoten;
    private javax.swing.JTextField Hoten1;
    private javax.swing.JTextField Khoa;
    private javax.swing.JTextField Khoa1;
    private javax.swing.JTextField Lop;
    private javax.swing.JTextField Lop1;
    private javax.swing.JTextField NS;
    private javax.swing.JTextField NS1;
    private javax.swing.JTextField STT;
    private javax.swing.JTextField STT1;
    private javax.swing.JTextField TB1;
    private javax.swing.JTextField TB10;
    private javax.swing.JTextField TB11;
    private javax.swing.JTextField TB12;
    private javax.swing.JTextField TB13;
    private javax.swing.JTextField TB14;
    private javax.swing.JTextField TB15;
    private javax.swing.JTextField TB16;
    private javax.swing.JTextField TB2;
    private javax.swing.JTextField TB3;
    private javax.swing.JTextField TB4;
    private javax.swing.JTextField TB5;
    private javax.swing.JTextField TB6;
    private javax.swing.JTextField TB7;
    private javax.swing.JTextField TB8;
    private javax.swing.JTextField TB9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpnlEdit;
    private javax.swing.JTabbedPane jpnlMan;
    private javax.swing.JPanel jpnlSearch;
    private javax.swing.JPanel jpnlView;
    private javax.swing.JPanel jpnladd;
    private javax.swing.JTextField key;
    private javax.swing.JRadioButton rbKhoa;
    private javax.swing.JRadioButton rbLoai;
    private javax.swing.JRadioButton rbLop;
    private javax.swing.JRadioButton rbTen;
    // End of variables declaration//GEN-END:variables
}