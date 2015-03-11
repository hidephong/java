
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class connect {
    Connection conn;
    public connect(){
        try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
System.out.print("Lo                                                                                                                ad driver success!");
String connURL="";
conn=DriverManager.getConnection(connURL);
conn.close();
conn.createStatement();


}
        catch(Exception e){};

}


public static void main(String args[]){

}
}
