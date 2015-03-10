/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 
 */    

public class StudentManage {
    
Student s = new Student();
Scanner sc = new Scanner(System.in);
String dateformat = "dd/MM/yyyy"; 
Date dt=null;
public StudentManage() {
    }
public StudentManage(Student s) {
        this.s = s;
    }

public Student addStudent(int id,String stt,String name, String dat, String lop, String khoa,String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8) throws ParseException{
       Student stu=new Student();
       stu.setId(id);
       long l=Long.parseLong(stt);
       stu.setStt(l);
       stu.setHoten(name);
           System.out.println(dat);   
        try { 
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat); 
        sdf.setLenient(false); 
        dt =  sdf.parse(dat); 
           
         
        } 
        catch (Exception e) { 
        System.out.println(e.getMessage()); 
        } 

        
       stu.setDateBirth(dt);
       stu.setKhoa(khoa);
       stu.setLop(lop);
       stu.setDk1(Float.parseFloat(t1));
   
       stu.setDk2(Float.parseFloat(t2));
  
       stu.setDk3(Float.parseFloat(t3));
    
       stu.setDk4(Float.parseFloat(t4));
  
       stu.setDk5(Float.parseFloat(t5));
     
       stu.setDk6(Float.parseFloat(t6));
     
       stu.setDk7(Float.parseFloat(t7));
    
       stu.setDk8(Float.parseFloat(t8));  
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
public Student Editstudent(String stt,String name, String dat, String lop, String khoa,String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,Student stu) throws ParseException{
      
      
       long l=Long.parseLong(stt);
       stu.setStt(l);
       stu.setHoten(name);
           
        try { 
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat); 
        sdf.setLenient(false); 
        dt = sdf.parse(dat); 
        } 
        catch (ParseException e) { 
        System.out.println(e.getMessage()); 
        } 

        catch (IllegalArgumentException e) { 

        } 
       stu.setDateBirth(dt);
       stu.setKhoa(khoa);
       stu.setLop(lop);
       stu.setDk1(Float.parseFloat(t1));
   
       stu.setDk2(Float.parseFloat(t2));
  
       stu.setDk3(Float.parseFloat(t3));
    
       stu.setDk4(Float.parseFloat(t4));
  
       stu.setDk5(Float.parseFloat(t5));
     
       stu.setDk6(Float.parseFloat(t6));
     
       stu.setDk7(Float.parseFloat(t7));
    
       stu.setDk8(Float.parseFloat(t8));  
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
 }
return reList;

}

  public int getIndex(List<Student> arrStudent,String id){
       int i = 0;
      long lid= Long.parseLong(id);
       for (;i<arrStudent.size();i++) {
           
           if(arrStudent.get(i).getStt() == lid){
             return i;
           }      
       }
       return -1;
   }
 
  
    public List<Student> edit(int idx,List<Student> nstudent,Student stu){
        
                        
           
             return nstudent;
           
          
       }
    
    public List<Student> db(List<Student> Listin, int tp) throws ClassNotFoundException{
   Student s= new Student();
   List<Student> Listout = new ArrayList<Student>();
        if(tp==0){

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
// set this to a MS Access DB you have on your machine
String filename = "\\TEST.mdb"; //noi luu database
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
s.setDateBirth(rs.getDate("NgaySinh"));
s.setHoten(rs.getString("FullName"));
s.setKhoa(rs.getString("Khoa"));
s.setLop(rs.getString("Lop"));
s.setStt(rs.getLong("STT"));
s.setDk1(rs.getFloat("TB1"));
s.setDk2(rs.getFloat("TB2"));
s.setDk3(rs.getFloat("TB3"));
s.setDk4(rs.getFloat("TB4"));
s.setDk5(rs.getFloat("TB5"));
s.setDk6(rs.getFloat("TB6"));
s.setDk7(rs.getFloat("TB7"));
s.setDk8(rs.getFloat("TB8"));
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
System.out.println(s.getHoten().toString());
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
String filename = "\\TEST.mdb"; //noi luu database
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
           
     s=   (Student)   Listin.get(i);
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        sdf.setLenient(false); 
         String  sdt= ""+ (s.getDateBirth().getYear()+1900)+"-"+ (s.getDateBirth().getMonth()+1)+"-" +(s.getDateBirth().getDate());
  sql ="Insert into Student(ID,STT,FullName,NgaySinh,Lop,Khoa,TB1,TB2,TB3,TB4,TB5,TB6,TB7,TB8) values("+s.getId()+","+s.getStt()+",'"+s.getHoten()+"','"+sdt+"','"+s.getLop()+"','"+s.getKhoa()+"',"+s.getDk1()+","+s.getDk2()+","+s.getDk3()+","+s.getDk4()+","+s.getDk5()+","+s.getDk6()+","+s.getDk7()+","+s.getDk8()+")";
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
e.printStackTrace();
}
finally {
try {
con.close();
} catch (Exception e) {
e.printStackTrace();
}
}
} 

    return null;
    }
}
