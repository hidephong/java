
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class sv {
    String tensv;
    Date ngaysinh;
    String lop;
    float toan;
    float van;
    float ngoaingu;
   void nhap() throws IOException{
   BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
   System.out.print("Nhap vao ten sv");
   tensv=in.readLine();
   System.out.print("Nhap diem toan");
   toan=Float.parseFloat(in.readLine());  
   System.out.print("Nhap diem van");
   van=Float.parseFloat(in.readLine());  
   System.out.print("Nhap diem ngoai ngu");
   ngoaingu=Float.parseFloat(in.readLine());  
   }
   float tinhtb(){
    return (toan+van+ngoaingu)/3;
    }
   void insv(){
   float ftb=tinhtb();
   System.out.println(tensv+"   "+ftb);
  
   }
}
