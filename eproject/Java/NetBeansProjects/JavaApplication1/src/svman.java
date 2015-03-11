
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class svman {
   
public static void main(String[] arg) throws IOException{
List<sv> asv=new ArrayList<sv>(); 

for(int i=0;i<2;i++){
sv svt= new sv();
svt.nhap();
asv.add(svt);            
}
for(sv s:asv){
s.insv();            
}
       
}

}
