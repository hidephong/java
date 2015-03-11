/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import Entity.Location;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author nhahv
 */
public class LocationData {
    Connection kinect;
    CallableStatement statement;
    ResultSet resultSet;
    public LocationData(){
      kinect = TheConnection.getConnection();
        statement = null;
        resultSet = null;
    }
   
   
    public Vector<Location> getAllLocation(){
        try {
            String sql = "{Call GetAllLocation}";
            Location location = null;
            statement = null;
            resultSet = null;
            Vector<Location> locationVector  = new Vector<Location>();
           
                statement =     kinect.prepareCall(sql);
                resultSet =     statement.executeQuery();
                while(resultSet.next()){
                    location = new Location();
                    location.setLocationID(resultSet.getInt(1));
                    location.setLocationAddress(resultSet.getString(2));
                    location.setLocationAllowance(resultSet.getFloat(3));
                    location.setLocationStatus(resultSet.getString(4));
                    
                    locationVector.add(location);
                }
                resultSet.close();
                statement.close();
                return locationVector;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
     
        
    }
    public boolean deleteAllocation(int id){
        String SQLDelALocation = "{call DeleteALocation(?)}";
        statement = null;
        resultSet = null;
        try {
            statement = kinect.prepareCall(SQLDelALocation);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
   
    public boolean addALocation(Location location){
        String SQLAddALocation = "{call addAlocation(?,?,?)}";
        statement = null;
        resultSet = null;
       
        try {
            
            statement = kinect.prepareCall(SQLAddALocation);
            statement.setString(1, location.getLocationAddress());
            statement.setFloat(2,  location.getLocationAllowance());
            statement.setString(3, location.getLocationStatus());
            boolean execute = statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

     /*
     * @ update after unsuccessfully deleting
     */


      public boolean updateALocation(Location location){
        String SQLUpdateALocation = "{call updateAlocation(?,?,?,?)}";
        statement = null;
        resultSet = null;

        try {

            statement = kinect.prepareCall(SQLUpdateALocation);
            statement.setInt(1,location.getLocationID());
            statement.setString(2, location.getLocationAddress());
            statement.setFloat(3,  location.getLocationAllowance());
            statement.setString(4, location.getLocationStatus());
            boolean execute = statement.execute();
            return !execute;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    /*
     * @ update after unsuccessfully deleting
     */
    public void UpdateAfterDelete(int locationID)
    {
        try
        {
            if(kinect == null)
                    return;

            String sql = "{CALL UpdateAfterDelete_Location(?)}";
            statement = kinect.prepareCall(sql);
            statement.setInt(1, locationID);
            boolean execute = statement.execute();
        }
        catch(SQLException e)
        {
        }
    }
}
