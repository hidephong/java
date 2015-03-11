/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nha.HV
 */
public class StatiticsData {
    Connection conn = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    int[] statitic;

    public StatiticsData()
    {
        conn = TheConnection.getConnection();
    }

    public int[] getStatitics()
    {
        try
        {
            String sql = "{CALL Statitics}";
            cs = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = cs.executeQuery();


            statitic = new int[11];

            while(rs.next()){
                statitic[0] = rs.getInt(1);
                statitic[1] = rs.getInt(2);
                statitic[2] = rs.getInt(3);
                statitic[3] = rs.getInt(4);
                statitic[4] = rs.getInt(5);
                statitic[5] = rs.getInt(6);
                statitic[6] = rs.getInt(7);
                statitic[7] = rs.getInt(8);
                statitic[8] = rs.getInt(9);
                statitic[9] = rs.getInt(10);
                statitic[10] = rs.getInt(11);

            }


          return statitic;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


}