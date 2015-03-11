/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;


import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            //DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           // Class.forName("com.mysql.jdbc.Driver");//.newInstance();

            String username = "";
            String password = "";
            String dbURL = "jdbc:odbc:demosv";
            Connection connection = DriverManager.getConnection(dbURL, username, password);
//            String URL = "jdbc:mysql://localhost/sv?user=root&password=";
        //    Connection connection = DriverManager.getConnection(URL);
            
            java.sql.Statement sta = connection.createStatement();
            String query = "SELECT * FROM SinhVien";
            ResultSet rs;
            rs= (ResultSet) sta.executeQuery(query);
            Vector rows=new Vector();
            Vector row;
            
            while (rs.next()){
                String ma=rs.getString(1);
                String ten=rs.getString(2);
                row=new Vector();
                row.add(ma);
                row.add(ten);
                rows.add(row);
                System.out.println("MaNV: " + ma);
                System.out.println("Ho ten: " +  ten);
                System.out.println("----");
        	}
           // System.out.println(dbURL + connection);
            //tao ra mot frame chua ban hieu no
            JFrame f=new JFrame();
            JPanel p=(JPanel)f.getContentPane();
            p.setLayout(new BorderLayout());
            JTable t=new JTable();
            Vector header=new Vector();
            header.add("Ma");
            header.add("Ten");
            t.setModel(new DefaultTableModel(rows,header));
            JScrollPane  sc=new JScrollPane(t);
            p.add(sc,BorderLayout.CENTER);
            f.setSize(500,600);
            f.validate();
            f.setVisible(true);
            sta.close();
            connection.close();

       } catch (SQLException ex) {
        System.out.println("Error loading driver: " + ex);
    } catch(ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
    }

    }


}
