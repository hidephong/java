package baitap;


import java.util.List;
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
public class StudentModel extends AbstractTableModel{
Vector<Student> svarr;
public  StudentModel(Vector<Student> arr){
this.svarr=arr;
}
    @Override
    public int getRowCount() {
   return svarr.size();
    }

    @Override
    public int getColumnCount() {
    return 16;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
   switch (columnIndex){
   case 0: 
   return svarr.elementAt(rowIndex).getId();
  
     case  1: {
       return svarr.elementAt(rowIndex).getHoten();
       }
     case 2:{
       return svarr.elementAt(rowIndex).getDateBirth();}
     case 3:{
       return svarr.elementAt(rowIndex).getKhoa();}
     case 4:{
        return svarr.elementAt(rowIndex).getLop();
       }

     case 5:{
       return svarr.elementAt(rowIndex).getDk1();}
     case 6:{
       return svarr.elementAt(rowIndex).getDk2();}
     case 7:{
        return svarr.elementAt(rowIndex).getDk3();
       }
       
     case 8:{
       return svarr.elementAt(rowIndex).getDk4();}
     case 9:{
       return svarr.elementAt(rowIndex).getDk5();}
     case 10:{
        return svarr.elementAt(rowIndex).getDk6();
       }
       
     case 11:{
       return svarr.elementAt(rowIndex).getDk7();}
     case 12:{
       return svarr.elementAt(rowIndex).getDk8();}
   case 13:{
       return svarr.elementAt(rowIndex).getTb();}
   default:
       return svarr.elementAt(rowIndex).getLoai();
        }
      
        
    }
    
    @Override
public String getColumnName(int columnIndex){

  switch (columnIndex){
   case 0: 
   return "ID";
  
     case  1: {
       return "Hoten";
       }
     case 2:{
        return "Ngay Sinh";}
     case 3:{
      return "Khoa";}
     case 4:{
        return "Lop";
       }

     case 5:{
       return "TB1";}
     case 6:{
       return "TB2";}
     case 7:{
        return "TB3";
       }
       
     case 8:{
       return "TB4";}
     case 9:{
       return "TB5";}
     case 10:{
        return "TB6";
       }
       
     case 11:{
       return "TB7";}
     case 12:{
       return "TB8";}
   case 13:{
       return "TBC";}
   default:
       return "Loai";
        }
}
}
