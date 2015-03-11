import java.io.*;
import java.util.*;

class Main1
   {public static void main(String args[])
        {String s1 = "Chao ban, ",s2="ban co khoe khong?";

          //Write text to file
          try{
               File f = new File("vut.txt");//create new text file
               PrintWriter out = new PrintWriter(new FileWriter(f));
               out.print(s1);
               out.print(s2);
               out.println();
               out.println("Cam on, toi khoe.");
               out.close();
              }
           catch(IOException e){}

          //Read from text file
          try{
               //Open a file reader first. It represents a stream to the existing file.
               FileReader f = new FileReader("vut.txt");
               /*BufferedReader provides a convenient method to read lines from a file one
                 at a time. So we need to wrap the filereader created into a BufferedReader.*/
              BufferedReader in = new BufferedReader(f);
               String s="";
               while( (s=in.readLine())!=null ) { //read the file line
               System.out.println(s);
               }
               in.close();
               }
          catch(IOException e){}


         } //end of main() method
   } //end of Main class
 
