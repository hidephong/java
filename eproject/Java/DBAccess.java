/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demoftp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tuan
 */
public class DBAccess {
    private Connection con;
    private Statement stmt;
    public DBAccess() {
        try {
            MyConnection mycon=new MyConnection();
            con = mycon.getConnection();
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
        }
    }

    public int Update(String str){
        try{
        int i=stmt.executeUpdate(str);
        return i;
        }catch(Exception e){
            return -1;
        }
    }
    public ResultSet Query(String srt){
        try {
            ResultSet rs=stmt.executeQuery(srt);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
}
