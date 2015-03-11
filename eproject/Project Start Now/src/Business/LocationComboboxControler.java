/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;
import DataAccess.TheConnection;

import Entity.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lovely
 */
public class LocationComboboxControler {
     Connection Conn = null;
LocationComboBoxModel searchResult;
 public  LocationComboboxControler(){
    Conn =new TheConnection().getConnection();
    }

public  LocationComboBoxModel get_AllLocation(){
        ResultSet rs = null;
        CallableStatement cs = null;
        List<Location> list = new ArrayList<Location>();
        Location loc= null;
        String sql = "{call get_AllLocation}";
        try{
            cs = Conn.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                loc= new Location();
                loc.setLocationID(rs.getInt("LocationID"));
                loc.setLocationAddress(rs.getString("LocationAddress"));
                loc.setLocationAllowance(rs.getInt("LocationAllowance"));
                loc.setLocationStatus(rs.getNString("Status"));
                list.add(loc);
            }
            rs.close();
            cs.close();
            List<String> rlist = new ArrayList<String>();
            for(Location ls : list){
            rlist.add(ls.getLocationAddress());
            }
              searchResult = new LocationComboBoxModel(rlist);
            return  searchResult;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
public  float get_LocationAllowanceByName(String locaName){
        ResultSet rs = null;
        CallableStatement cs = null;
        Location loc= null;
        String sql = "{call get_LocationAllowanceByName(?)}";
        try{
             loc= new Location();
            cs = Conn.prepareCall(sql);
            cs.setString(1,"%"+locaName+"%");
            rs = cs.executeQuery();
            rs.next();
               
                loc.setLocationID(rs.getInt("LocationID"));
                loc.setLocationAddress(rs.getString("LocationAddress"));
                loc.setLocationAllowance(rs.getInt("LocationAllowance"));
                loc.setLocationStatus(rs.getNString("Status"));
              
            
            rs.close();
            cs.close();
      return  loc.getLocationAllowance();
        }catch (SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }


}
