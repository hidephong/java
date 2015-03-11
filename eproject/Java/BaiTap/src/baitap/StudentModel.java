package baitap;


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
    private static final long serialVersionUID = 1L;



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
    return 31;
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
       return svarr.elementAt(rowIndex).getNo1();}
     case 14:{
       return svarr.elementAt(rowIndex).getNo2();}
     case 15:{
        return svarr.elementAt(rowIndex).getNo3();
       }

     case 16:{
       return svarr.elementAt(rowIndex).getNo4();}
     case 17:{
       return svarr.elementAt(rowIndex).getNo5();}
     case 18:{
        return svarr.elementAt(rowIndex).getNo6();
       }

     case 19:{
       return svarr.elementAt(rowIndex).getNo7();}
     case 20:{
       return svarr.elementAt(rowIndex).getNo8();}

       case 21:{
       return svarr.elementAt(rowIndex).getTra1();}
     case 22:{
       return svarr.elementAt(rowIndex).getTra2();}
     case 23:{
        return svarr.elementAt(rowIndex).getTra3();
       }

     case 24:{
       return svarr.elementAt(rowIndex).getTra4();}
     case 25:{
       return svarr.elementAt(rowIndex).getTra5();}
     case 26:{
        return svarr.elementAt(rowIndex).getTra6();
       }

     case 27:{
       return svarr.elementAt(rowIndex).getTra7();}
     case 28:{
       return svarr.elementAt(rowIndex).getTra8();}

   case 29:{
       return svarr.elementAt(rowIndex).getTb();}
    case 30:{
       return svarr.elementAt(rowIndex).getVipham();}
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
       return "No1";}
     case 14:{
       return "No2";}
     case 15:{
        return "No3";
       }

     case 16:{
       return "No4";}
     case 17:{
       return "No5";}
     case 18:{
        return "No6";
       }

     case 19:{
       return "No7";}
     case 20:{
       return "No8";}

       case 21:{
       return "Tra1";}
     case 22:{
       return "Tra2";}
     case 23:{
        return "Tra3";
       }

     case 24:{
       return "Tra4";}
     case 25:{
       return "Tra5";}
     case 26:{
        return "Tra6";
       }

     case 27:{
       return "Tra7";}
     case 28:{
       return "Tra8";}
   case 29:{
       return "TBC";}
    case 30:{
       return "Vipham";}
   default:
       return "Loai";
        }
}
}
