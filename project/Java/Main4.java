
package doityourself3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Lovely
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

       
        int nChoose = 0;
        Scanner input = new Scanner(System.in);
        Student stus[] = new Student[100];
        int index = 0;
        do
        {
            System.out.println("Menu");
            System.out.println("-----------------------------------------------");
            System.out.println("1.	Add a list of Students and save to File");
            System.out.println("2.	Loading list of Students from a File");
            System.out.println("3.	Exit");
            System.out.println();
            System.out.println("Your choise: ");

            nChoose = input.nextInt();

            switch(nChoose)
            {
                case 1:
                {
                    String ask = "y";
                    do
                    {
                        stus[index] = new Student();
                        stus[index].input();
                        index++;
                        
                        System.out.println("Do you want to add more account?(y/n)");
                        input = new Scanner(System.in);
                        ask = input.next();
                    }
                    while(!ask.equalsIgnoreCase("n"));

                    FileWriter fr = new FileWriter("doityourself.dat");
                    fr.write(index + "\n");
                    for(int i=0;i<index;i++)
                    {
                        fr.write(stus[i].getName() + "\t" + stus[i].getAge() + "\t" + stus[i].getMark() + "\n");
                    }
                    fr.close();
                }
                    break;
                case 2:
                {
                    BufferedReader br = new BufferedReader(new FileReader("doityourself.dat"));
                    String str = br.readLine();
                    int n = Integer.parseInt(str);
                    for(int i=0;i<n;i++)
                    {
                        String line = br.readLine();
                        StringTokenizer strToken = new StringTokenizer(line, "\t");
                        
                        Student stu = new Student();
                        stu.setName(strToken.nextToken());
                        stu.setAge(Integer.parseInt(strToken.nextToken()));
                        stu.setMark(Float.parseFloat(strToken.nextToken()));

                        stu.display();;
                    }
                }
                    break;
                case 3:
                    System.exit(0);
            }
            
        }
        while(nChoose!=4);

    }

}
