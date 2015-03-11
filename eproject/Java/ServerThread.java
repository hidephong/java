/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demoftp;

import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ServerThread implements Runnable{
	private Scanner in=null;
	private PrintWriter out=null;
	private Socket socket;
	private String name;

	public ServerThread(Socket socket,String name) throws IOException{
		this.socket=socket;
		this.name=name;
		this.in=new Scanner(this.socket.getInputStream());
		this.out=new PrintWriter(this.socket.getOutputStream(),true);

		new Thread(this).start();
	}

	public void run(){
        Scanner sc=null;
		try{
			while(true){
				String s=in.nextLine().trim();
				sc=null;
				String pre="";
				String str="";
				try{
					sc=new Scanner(s);
					sc.useDelimiter("@");
					pre=sc.next();
                    str=sc.next();
				}catch(Exception e){}
				
				if(pre.equals("update")){
                    DBAccess acc=new DBAccess();
                    acc.Update(str);
                }else if(pre.equals("dangky")){
					DBAccess acc=new DBAccess();
                    String username=str;
                    String password=sc.next();
                    String query="insert into taikhoan values('"+username+"','"+password+"','user')";
                    if(acc.Update(query)!=0){
                        out.println("OK");
                        // Tao ra thu muc trong ổ đĩa C:\Users\Tuan\Documents\NetBeansProjects\DemoFTP
                         try{
                             //Lấy đường dẫn của project hiện hành
                            File directory = new File ("");
                            String path = directory.getCanonicalPath ()+"\\Home\\"+username;

                           
                            (new File(path)).mkdir();
                            }catch (Exception e){//Catch exception if any
                              System.err.println("Error: " + e.getMessage());
                            }
                    }else{
                        out.println("NOTOK");
                    }
				}else if(pre.equals("query")){
					DBAccess acc=new DBAccess();
                    ResultSet rs=acc.Query(str);
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    int numberOfColumns = rsMetaData.getColumnCount();
                    String chuoi="";
                    int i;
                    while(rs.next()){
                        for(i=1;i<numberOfColumns;i++){
                            chuoi=chuoi+rs.getString(i)+"@";
                        }
                        if(rs.isLast())
                            chuoi=chuoi+rs.getString(i);
                        else
                            chuoi=chuoi+rs.getString(i)+"@";
                    }
                    out.println(chuoi);
				}else if(pre.equals("dangnhap")){
                    DBAccess acc=new DBAccess();
                    ResultSet rs=acc.Query(str);
                    if(rs.next())
                        out.println("OK");
                    else
                        out.println("NOTOK");
                }else if(pre.equals("file")){
                        String usename=str;
                        String password=sc.next();
                        String path=sc.next();

                }
			}
		}catch(Exception e){
			System.out.println(name+" has departed");
		}finally{
			try{socket.close();}catch(IOException e){}
            if(sc!=null)sc.close();
		}
	}
}
