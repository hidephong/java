/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Employee_RequestATransfer.java
 *
 * Created on Apr 7, 2011, 5:13:07 PM
 */

package GUI;

import Business.*;
import DataAccess.WorkItemData;
import Entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.*;

/**
 *
 * @author Nha.HV
 */
public class Admin_RequestATransfer extends javax.swing.JDialog {

    /** Creates new form Employee_RequestATransfer */
    

     final SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
    TransferRecord transrecord;
    TransferManagement traman;
    EmployeeManager em = new EmployeeManager();
    //Table Var
    WorkItem wi;
    WorkItemData wiData;
    WorkItemModel witblModel;
    Vector<WorkItem> wiVector;

    //Filter's Var
    TableRowSorter<TableModel> sorter;
    TableModel tbm;
    RowFilter<TableModel, Object> deptFilter = null;
    RowFilter<TableModel, Object> locFilter = null;
    RowFilter<TableModel, Object> prjFilter = null;
    RowFilter<TableModel, Object> sdateFilter = null;
    RowFilter<TableModel, Object> edateFilter = null;
    RowFilter<TableModel, Object> sttFilter = null;
    RowFilter<TableModel, Object> nullFilter = null;
    List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();
    RowFilter<TableModel, Object> allRowFilter = null;
    //Combobox Var
    private _Total_CBBControler aawic;
    Vector<Department> depVec;
    Vector<Department> depInLocVec;
    Employee emp;
     /** Creates new form WorkItemGUI */
    public Admin_RequestATransfer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initDistplay();
        displayFilter();
        initDistplay();
        EmployeeModel emod = em.getAllEmployee();
        DefaultComboBoxModel dcbm1 = new  DefaultComboBoxModel();
        for(int i=0;i<emod.getRowCount();i++){
        dcbm1.addElement(emod.getEmployeeAt(i).getUsername());
        }
         cbbUsername.setModel(dcbm1);
    }
    
    
    //<<<<<<< DISPLAY >>>>>>>//
    private  void initDistplay(){
        traman = new TransferManagement();
        //Table
         wiData = new WorkItemData();
         wiVector = wiData.getWorkItemsForTransfer();
         witblModel = new WorkItemModel(wiVector);
         jtbWorkItems.setModel(witblModel);
         tbm = jtbWorkItems.getModel();
         
         //ComboBbox
        aawic = new _Total_CBBControler();
        jcbbDept.setModel(aawic.getDcbbm());
        jcbbProj.setModel(aawic.getPcbbm());
        jcbbloc.setModel(aawic.getLcbbm());
            //Filter for Cbb Department in Location;
        depVec = aawic.getdVec();

        Request(false);


    }
    private void refressInitDisplay(){
        initDistplay();
    }

    private void displayInfomations(){
          if (jtbWorkItems.getSelectedRow() > -1) {
            int index = jtbWorkItems.convertRowIndexToModel(jtbWorkItems.getSelectedRow());
            jtfID.setText("" + wiVector.get(index).getWorkItemID());
            jcbbDept.setSelectedItem(wiVector.get(index).getDepartmentName());
            jcbbProj.setSelectedItem(wiVector.get(index).getProjectName());
            jdateStart.setDate(wiVector.get(index).getStartDate());
            jdateEnd.setDate(wiVector.get(index).getEndDate());
            jcbbloc.setSelectedItem(wiVector.get(index).getLocationAdress());
        }
    }

    private void resetDisplayInfomations(){
        jcbbDept.setSelectedIndex(-1);
        jcbbProj.setSelectedIndex(-1);
        jdateStart.cleanup();
        jdateEnd.cleanup();
       
    }

    private void displayFilter(){
        _Total_CBBControler filterCbb = new _Total_CBBControler();
        fDep_cbb.setModel(filterCbb.getFilterdcbb());
        fPrj_cbb.setModel(filterCbb.getFilterpcbb());
        fLoc_cbb.setModel(filterCbb.getFilterlcbb());
       
        fDep_cbb.setSelectedIndex(0);
        fPrj_cbb.setSelectedIndex(0);
        fLoc_cbb.setSelectedIndex(0);
      
        
        
        

    }


   private void resetDisplayFilter(){
        fDep_cbb.setSelectedIndex(0);
        fPrj_cbb.setSelectedIndex(0);
        fLoc_cbb.setSelectedIndex(0);
        resetFilter();
       

   }

   private void DepartOnLocation(){
       depVec = aawic.getdVec();
       depInLocVec = new Vector<Department>();
       for (Department dv : depVec) {
           if(dv.getLocationAddress().equalsIgnoreCase(jcbbloc.getSelectedItem().toString()));
           depInLocVec.add(dv);
       }
       aawic.setDcbbm(depInLocVec);
       jcbbDept.setModel(aawic.getDcbbm());

   }

  //<<<<<<< FUNCTIONS >>>>>>>
   private void filter(){

        try {
            filters = new ArrayList<RowFilter<TableModel, Object>>();
           // System.out.println(jtbWorkItems.getValueAt(jtbWorkItems.getSelectedRow(), 1));
            if (fDep_cbb.getSelectedIndex() > 0) {
                System.out.println("FD: " + fDep_cbb.getSelectedItem().toString());
                deptFilter = RowFilter.regexFilter(fDep_cbb.getSelectedItem().toString(), 1);
                filters.add(deptFilter);
            }
            if (fLoc_cbb.getSelectedIndex() > 0) {
                System.out.println("FL: "+ fLoc_cbb.getSelectedItem().toString());
                locFilter = RowFilter.regexFilter(fLoc_cbb.getSelectedItem().toString(), 2);
                filters.add(locFilter);
            }
            if (fPrj_cbb.getSelectedIndex() > 0) {
                System.out.println("FP: "+ fPrj_cbb.getSelectedItem().toString());
                prjFilter = RowFilter.regexFilter(fPrj_cbb.getSelectedItem().toString(), 3);
                filters.add(prjFilter);
            }
            for (RowFilter<TableModel, Object> f : filters) {
                System.out.println(f);
            }
            allRowFilter = RowFilter.andFilter(filters); // you may also choose the OR filter
        } catch (java.util.regex.PatternSyntaxException e) {
            System.out.println(e);
            return;
        }
        
        sorter = new TableRowSorter<TableModel>(tbm);
        sorter.setRowFilter(allRowFilter);
        jtbWorkItems.setRowSorter(sorter);
        //jtbWorkItems.revalidate();
    }

   private void resetFilter(){
        sorter = new TableRowSorter<TableModel>(tbm);
        nullFilter = RowFilter.regexFilter("");
        sorter.setRowFilter(nullFilter);
        jtbWorkItems.setRowSorter(sorter);
   }

   private void filterDepartmentByLocation(){
       if(fLoc_cbb.getSelectedIndex() > 0){
            String LocationName = fLoc_cbb.getSelectedItem().toString();
            DefaultComboBoxModel depInloc = new DefaultComboBoxModel();
        depInloc.addElement("---All---");
        for (Department d : depVec) {
            if (d.getLocationAddress().equalsIgnoreCase(LocationName)) {
                depInloc.addElement(d.getDepartmentName());
            }
        }
        fDep_cbb.setModel(depInloc);
       }

   }
 void Request(boolean b){
            jtfReason.setVisible(b);
            jtaReason.setVisible(b);
            jtaReason.requestFocus(b);
            jtaReason.setText(null);
            jbtCancel.setVisible(b);
            jbtSend.setVisible(b);
            jtbWorkItems.setEnabled(!b);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbWorkItems = new javax.swing.JTable();
        jbtRefresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbID = new javax.swing.JLabel();
        jlbName = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jlbProject = new javax.swing.JLabel();
        jbtAdd = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jcbbProj = new javax.swing.JComboBox();
        jcbbDept = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        //SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
        jdateStart = new JDateChooser("MM/dd/yyyy", "$dd/##/####", '_');
        jLabel3 = new javax.swing.JLabel();
        jdateEnd = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbbloc = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaReason = new javax.swing.JTextArea();
        jtfReason = new javax.swing.JLabel();
        jbtSend = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        fDep_cbb = new javax.swing.JComboBox();
        fLoc_cbb = new javax.swing.JComboBox();
        fPrj_cbb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jbtreset = new javax.swing.JButton();
        pnlEmployee = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbUsername = new javax.swing.JComboBox();
        tf_EmpID = new javax.swing.JTextField();
        tf_fullname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "In progress and In comming work item(s)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 400));

        jtbWorkItems.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbWorkItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbWorkItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbWorkItems);

        jbtRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/gnome-session-reboot.png"))); // NOI18N
        jbtRefresh.setText("Refresh");
        jbtRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                    .addComponent(jbtRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jbtRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Work Item Infomantions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 400));

        jlbID.setText("ID :");

        jlbName.setText("Department : ");

        jtfID.setEditable(false);

        jlbProject.setText("Project: ");

        jbtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/opinion-agree.png"))); // NOI18N
        jbtAdd.setText("Tranfer to this work items");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        jbtCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_16/dialog-error.png"))); // NOI18N
        jbtCancel.setText("Cancel");
        jbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelActionPerformed(evt);
            }
        });

        jcbbProj.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbbProj.setKeySelectionManager(null);

        jcbbDept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Start Date: ");

        jdateStart.setDateFormatString("MM/dd/yyyy");
        jdateStart.setDateFormatString("MM/dd/yyyy");

        jLabel3.setText("End Date: ");

        jdateEnd.setDateFormatString("MM/dd/yyyy");

        jLabel2.setText("(mm/dd/yyyy)");
        jLabel2.setEnabled(false);

        jLabel4.setText("(mm/dd/yyyy)");
        jLabel4.setEnabled(false);

        jLabel5.setText("Location: ");

        jcbbloc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbbloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbblocActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        jtaReason.setColumns(20);
        jtaReason.setFont(new java.awt.Font("Tahoma", 0, 12));
        jtaReason.setLineWrap(true);
        jtaReason.setRows(5);
        jtaReason.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(jtaReason);

        jtfReason.setText("Reasons : ");

        jbtSend.setText("Send request");
        jbtSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlbID)
                        .addGap(76, 76, 76)
                        .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlbProject)
                                .addGap(53, 53, 53)
                                .addComponent(jcbbProj, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlbName)
                                .addGap(27, 27, 27)
                                .addComponent(jcbbDept, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)
                                .addComponent(jdateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jdateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel2))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jbtAdd))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfReason)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jbtCancel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtSend)))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbID))
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlbProject))
                    .addComponent(jcbbProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlbName))
                    .addComponent(jcbbDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jcbbloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jdateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jdateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfReason))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSend)
                    .addComponent(jbtCancel))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfer to:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 150));

        fDep_cbb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fDep_cbb.setKeySelectionManager(null);

        fLoc_cbb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fLoc_cbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fLoc_cbbActionPerformed(evt);
            }
        });

        fPrj_cbb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Deparment");

        jLabel7.setText("Location");

        jLabel8.setText("Project");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/menu-editor.png"))); // NOI18N
        jButton1.setText("Display");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons_24/document-open-recent.png"))); // NOI18N
        jbtreset.setText("Reset");
        jbtreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(fLoc_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(fDep_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(fPrj_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jbtreset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fPrj_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fDep_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fLoc_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtreset, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlEmployee.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Information"));

        jLabel9.setText("Identity:");

        jLabel10.setText("Username:");

        jLabel11.setText("Fullname:");

        cbbUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbUsernameActionPerformed(evt);
            }
        });

        tf_EmpID.setEditable(false);

        tf_fullname.setEditable(false);

        javax.swing.GroupLayout pnlEmployeeLayout = new javax.swing.GroupLayout(pnlEmployee);
        pnlEmployee.setLayout(pnlEmployeeLayout);
        pnlEmployeeLayout.setHorizontalGroup(
            pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_fullname, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(tf_EmpID, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(cbbUsername, 0, 181, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        pnlEmployeeLayout.setVerticalGroup(
            pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeLayout.createSequentialGroup()
                .addGroup(pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_EmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1158, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1166)/2, (screenSize.height-621)/2, 1166, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbWorkItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbWorkItemsMouseClicked
        displayInfomations();
}//GEN-LAST:event_jtbWorkItemsMouseClicked

    private void jbtRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRefreshActionPerformed
        refressInitDisplay();
        resetFilter();
}//GEN-LAST:event_jbtRefreshActionPerformed

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        if(Session.getLoginID() == 0){
            JOptionPane.showMessageDialog(jButton1, "Your indentity has been corrupted! Please re login.");
            return;
        }
        if(!jtfID.getText().isEmpty()){
            Request(true);
        }else{
            JOptionPane.showMessageDialog(jtbWorkItems, "Please chose a work item to make the transfer request!");
        }
        
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelActionPerformed
        Request(false);
}//GEN-LAST:event_jbtCancelActionPerformed

    private void jcbblocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbblocActionPerformed
        DepartOnLocation();
}//GEN-LAST:event_jcbblocActionPerformed

    private void jbtSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSendActionPerformed
        if(!jtaReason.getText().isEmpty()){
            transrecord = new TransferRecord();
            transrecord.setEmployeeID(Integer.parseInt(tf_EmpID.getText().toString()));
            transrecord.setWorkItemID(Integer.parseInt(jtfID.getText()));
            transrecord.setTransferReason(jtaReason.getText());
            boolean requested = traman.E_RequestATransfer(transrecord);
            if(requested){
                JOptionPane.showMessageDialog(this, "Send request completed!");
                this.setVisible(false);
                return;
            }else{
                JOptionPane.showMessageDialog(this, "Send request failed!");
                return;
            }
            
            
            
        }else{
            JOptionPane.showMessageDialog(jtaReason, "Please give some reason here!");
        }
        
    }//GEN-LAST:event_jbtSendActionPerformed

    private void fLoc_cbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fLoc_cbbActionPerformed
        filterDepartmentByLocation();
}//GEN-LAST:event_fLoc_cbbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        filter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtresetActionPerformed
        resetDisplayFilter();
        //
}//GEN-LAST:event_jbtresetActionPerformed

    private void cbbUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbUsernameActionPerformed
        // TODO add your handling code here:
        emp=em.getEmployeeByUsername(cbbUsername.getSelectedItem().toString());
        String stritem="";
       
        stritem = emp.getEmployeeName();
        tf_fullname.setText(stritem);
        stritem= String.valueOf(emp.getEmployeeID());
        tf_EmpID.setText(stritem);
    }//GEN-LAST:event_cbbUsernameActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Admin_RequestATransfer dialog = new Admin_RequestATransfer(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbbUsername;
    private javax.swing.JComboBox fDep_cbb;
    private javax.swing.JComboBox fLoc_cbb;
    private javax.swing.JComboBox fPrj_cbb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtRefresh;
    private javax.swing.JButton jbtSend;
    private javax.swing.JButton jbtreset;
    private javax.swing.JComboBox jcbbDept;
    private javax.swing.JComboBox jcbbProj;
    private javax.swing.JComboBox jcbbloc;
    private com.toedter.calendar.JDateChooser jdateEnd;
    private com.toedter.calendar.JDateChooser jdateStart;
    private javax.swing.JLabel jlbID;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jlbProject;
    private javax.swing.JTextArea jtaReason;
    private javax.swing.JTable jtbWorkItems;
    private javax.swing.JTextField jtfID;
    private javax.swing.JLabel jtfReason;
    private javax.swing.JPanel pnlEmployee;
    private javax.swing.JTextField tf_EmpID;
    private javax.swing.JTextField tf_fullname;
    // End of variables declaration//GEN-END:variables

}
