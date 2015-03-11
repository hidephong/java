/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap;



import java.net.URL;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 
 */    

public class StudentManage {
    
Student s = new Student();
Scanner sc = new Scanner(System.in);

 URL link;
public StudentManage() {
     link = this.getClass().getProtectionDomain().getCodeSource().getLocation();
    }
public StudentManage(Student s) {
        this.s = s;
         link = this.getClass().getProtectionDomain().getCodeSource().getLocation();
    }

public Student addStudent(int id,Student s) throws ParseException{
       Student stu= new Student();
       stu=s;

       float f= (stu.getDk1()+stu.getDk2()+stu.getDk3()+stu.getDk4()+stu.getDk5()+stu.getDk6()+stu.getDk7()+stu.getDk8())/8;
       stu.setTb(f);
       if(f<5.0){stu.setLoai("Chua dat");
                }else{
                    if(f<7.0){stu.setLoai("TB Kha");
                               }else{
                                     if(f<8.0){stu.setLoai("Kha");
                                       }else{
                                           stu.setLoai("Gioi");
                                       }
                               }
                   }
       
display(stu);
       return stu;
    }
public void display(Student s){
     
       System.out.println("----------------------------------------------------");
       System.out.println("STT   : " + s.getStt());
       System.out.println("ID   : " + s.getId());
       System.out.println("Ho va Ten : " + s.getHoten());
       System.out.println("Ngay Sinh   : " + s.getDateBirth());
       System.out.println("Khoa : " + s.getKhoa());
       System.out.println("Lop : " + s.getLop());
       System.out.println("Trung binh ky 1 : " + s.getDk1());
       System.out.println("Trung binh ky 2 : " + s.getDk2());
       System.out.println("Trung binh ky 3 : " + s.getDk3());
       System.out.println("Trung binh ky 4 : " + s.getDk4());
       System.out.println("Trung binh ky 5 : " + s.getDk5());
       System.out.println("Trung binh ky 6 : " + s.getDk6());
       System.out.println("Trung binh ky 7 : " + s.getDk7());
       System.out.println("Trung binh ky 8 : " + s.getDk8());
       System.out.println("Trung binh      : " + s.getTb());
       System.out.println("Xep loai        : " + s.getLoai());
       System.out.println("----------------------------------------------------");
     
      
   }



public List<Student> Search(int kieu,String key,List<Student> nstudent) {
     List<Student> reList = new ArrayList<Student>();
     int i = 0;
   
 switch (kieu){
   case 1:
    
    for (;i<nstudent.size();i++) 
    {
     if(nstudent.get(i).getHoten().contains(key))
       {
        reList.add(nstudent.get(i));
       }
     }           
                break;
    
              
                case 2:
      
    for (;i<nstudent.size();i++) 
    {
     if(nstudent.get(i).getLop().contains(key))
       {
        reList.add(nstudent.get(i));
       }
     }        
                break;
            case 3:
          
    for (;i<nstudent.size();i++) 
    {
     if(nstudent.get(i).getKhoa().contains(key))
       {
        reList.add(nstudent.get(i));
       }
     }        
                break;
            case 4:
                
    for (;i<nstudent.size();i++) 
    {
     if(nstudent.get(i).getLoai().equalsIgnoreCase(key))
       {
        reList.add(nstudent.get(i));
       }
     }        
                break;
                case 5:

    for (;i<nstudent.size();i++)
    {
     if(nstudent.get(i).getLoai().equalsIgnoreCase("cĂ³"))
       {
        reList.add(nstudent.get(i));
       }
     }
                break;
 }
return reList;

}

  public int getIndex(List<Student> arrStudent,String id){
       int i = 0;
      int lid=Integer.parseInt(id);
       for (;i<arrStudent.size();i++) {
           
           if(arrStudent.get(i).getId() == lid){
             return i;
           }      
       }
       return -1;
   }
 
  
    
    
   public List<Student> db(List<Student> Listin, int tp) throws ClassNotFoundException{

   List<Student> Listout = new ArrayList<Student>();
        if(tp==0){

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
// set this to a MS Access DB you have on your machine
String filename = link.getPath();
filename=filename.substring(1, filename.length())+"TEST.mdb";
System.out.print(filename);
String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
database+= filename.trim() + ";DriverID=22;READONLY=true}"; // add on to the end
// now we can get the connection from the DriverManager
Connection con = DriverManager.getConnection( database ,"","");
System.out.println("Connected");
Statement st = con.createStatement();
String sql = "Select * From Student";
ResultSet rs = null;
rs = st.executeQuery(sql);
int id=1;
while (rs.next()) {
    s= new Student();
//String check = rs.getString(3).trim()+"  "+rs.getString(4).trim();
s.setId(id);
s.setDateBirth(rs.getString("NgaySinh"));
s.setHoten(rs.getString("Ten"));
s.setKhoa(rs.getString("Khoa"));
s.setLop(rs.getString("Lop"));
s.setStt(rs.getInt("STT"));
s.setDk1(rs.getFloat("TB1"));
s.setDk2(rs.getFloat("TB2"));
s.setDk3(rs.getFloat("TB3"));
s.setDk4(rs.getFloat("TB4"));
s.setDk5(rs.getFloat("TB5"));
s.setDk6(rs.getFloat("TB6"));
s.setDk7(rs.getFloat("TB7"));
s.setDk8(rs.getFloat("TB8"));

s.setR1(rs.getFloat("RenLuyen1"));

       s.setR2(rs.getFloat("RenLuyen2"));

       s.setR3(rs.getFloat("RenLuyen3"));

       s.setR4(rs.getFloat("RenLuyen4"));

       s.setR5(rs.getFloat("RenLuyen5"));

       s.setR6(rs.getFloat("RenLuyen6"));

       s.setR7(rs.getFloat("RenLuyen7"));

       s.setR8(rs.getFloat("RenLuyen8"));


       s.setNo1(rs.getInt("NoM1"));
       s.setNo2(rs.getInt("NoM2"));
       s.setNo3(rs.getInt("NoM3"));
       s.setNo4(rs.getInt("NoM4"));
       s.setNo5(rs.getInt("NoM5"));
       s.setNo6(rs.getInt("NoM6"));
       s.setNo7(rs.getInt("NoM7"));
       s.setNo8(rs.getInt("NoM8"));

       s.setTra1(rs.getInt("TraM1"));
       s.setTra2(rs.getInt("TraM2"));
       s.setTra3(rs.getInt("TraM3"));
       s.setTra4(rs.getInt("TraM4"));
       s.setTra5(rs.getInt("TraM5"));
       s.setTra6(rs.getInt("TraM6"));
       s.setTra7(rs.getInt("TraM7"));
       s.setTra8(rs.getInt("TraM8"));
s.setLV(rs.getString("Luanvan"));
s.setVipham(rs.getString("vipham"));
 float f= (s.getDk1()+s.getDk2()+s.getDk3()+s.getDk4()+s.getDk5()+s.getDk6()+s.getDk7()+s.getDk8())/8;
       s.setTb(f);
       if(f<5.0){s.setLoai("Chua dat");
                }else{
                    if(f<7.0){s.setLoai("TB Kha");
                               }else{
                                     if(f<8.0){s.setLoai("Kha");
                                       }else{
                                           s.setLoai("Gioi");
                                       }
                               }
                   }
System.out.println(s.getVipham().toString());
Listout.add(s);
id=id+1;
}
System.out.println("Select OK");
} catch (SQLException e) {
System.out.println("Error: " + e);
}

return Listout;
    }
    else
    {
Connection con=null;
        try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
// set this to a MS Access DB you have on your machine

String filename = link.getPath();
filename=filename.substring(1, filename.length())+"TEST.mdb";
String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
database+= filename.trim() + ";DriverID=22;READONLY=true}"; // add on to the end
// now we can get the connection from the DriverManager
 con = DriverManager.getConnection( database ,"","");
System.out.println("Connected");
Statement st = con.createStatement();
//    String sql="Insert into users values(‘det’,’123′)";

//int smt=st.executeUpdate(sql);

String sql="Delete From Student";
int i=0;

 st.addBatch(sql);
for (;i<Listin.size();i++) {
           
     s=     Listin.get(i);
  sql ="Insert into Student(ID,ten,NgaySinh,Lop,Khoa,TB1,TB2,TB3,TB4,TB5,TB6,TB7,TB8,vipham,NoM1, NoM2, NoM3, NoM4, NoM5, NoM6, NoM7, NoM8, TraM1, TraM2, TraM3, TraM4, TraM5, TraM6, TraM7, TraM8, RenLuyen1, RenLuyen2, RenLuyen3, RenLuyen4, RenLuyen5, RenLuyen6, RenLuyen7, RenLuyen8,Luanvan)";
  sql=sql+" values("+s.getId()+",'"+s.getHoten()+"','"+s.getDateBirth()+"','"+s.getLop()+"','"+s.getKhoa()+"',"+s.getDk1()+","+s.getDk2()+","+s.getDk3()+","+s.getDk4()+","+s.getDk5()+","+s.getDk6()+","+s.getDk7()+","+s.getDk8()+",'"+s.getVipham()+"',";
  sql=sql+s.getNo1()+","+s.getNo2()+","+s.getNo3()+","+s.getNo4()+","+s.getNo5()+","+s.getNo6()+","+s.getNo7()+","+s.getNo8()+",";
  sql=sql+s.getTra1()+","+s.getTra2()+","+s.getTra3()+","+s.getTra4()+","+s.getTra5()+","+s.getTra6()+","+s.getTra7()+","+s.getTra8()+",";
  sql=sql+s.getR1()+","+s.getR2()+","+s.getR3()+","+s.getR4()+","+s.getR5()+","+s.getR6()+","+s.getR7()+","+s.getR8()+",'"+s.getLV()+"')";
  System.out.println(sql);
  st.addBatch(sql);
       }
int []ds=st.executeBatch();
for(int j:ds) {
System.out.println("kết quả:" +j);
}

//if(smt<1)
//System.out.println("Không chèn được");
} catch (Exception e) {
}
finally {
try {
con.close();
} catch (Exception e) {
}
}
} 

    return null;
    }
}
