
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class SVTableModel extends    AbstractTableModel {
Vector<SV> svarr;
public  SVTableModel(Vector<SV> arr){
this.svarr=arr;
}
    public int getRowCount() {
   return svarr.size();
    }

    public int getColumnCount() {
    return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
   if(columnIndex==0){
   return svarr.elementAt(rowIndex).getIDS();

   }else
       if(columnIndex==1){
       return svarr.elementAt(rowIndex).getTeacher();
       }
       else if(columnIndex==2){
       return svarr.elementAt(rowIndex).getToan();}
       else if(columnIndex==3){
       return svarr.elementAt(rowIndex).getVan();}
       else {
       return svarr.elementAt(rowIndex).getAnh();
        }
    }
public String getColumName(int column){

   if(column==0){
   return "ID Student";

   }else
       if(column==1){
       return "Teacher";
       }
       else if(column==2){
       return "Diem Toan";}
       else if(column==3){
       return "Diem Van";}
       else {
       return "Diem Anh";
        }
}
}
