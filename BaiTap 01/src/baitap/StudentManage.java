/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap;



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
}
