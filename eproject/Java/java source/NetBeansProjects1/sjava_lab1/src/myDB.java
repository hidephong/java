import java.sql.*;
public class myDB {
Connection con = null;
public void setupConnection(){
try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
System.out.println("Loading driver successful");
} catch (ClassNotFoundException ex) {
System.out.println("Loading driver unsuccessful");
}
try {con = DriverManager.getConnection("jdbc:odbc:myBank");
System.out.println("Connection successful ");
} catch (SQLException ex) {
System.out.println("Connecting unsuccessful");
}
}
protected void finalize() throws Throwable {
try {
if(con != null)
con.close();
con = null;
} catch (SQLException ex) {
System.out.println("Can not close connection");
}
}
public void viewRecords()
{
ResultSet rs = null;
Statement sa = null;
try
{
sa = con.createStatement();
rs = sa.executeQuery("select * from myCustomer");
while(rs.next())
{
System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
}
}
catch(SQLException ex)
{
System.out.println(ex);
}
finally{
try{
rs.close();
sa.close();
}
catch(Exception ex){
}
}
}
public myDB() {
this.setupConnection();
this.viewRecords();
}
public static void main(String []args) {
new myDB();
}
}