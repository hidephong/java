/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.modul.entity;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author TuanNA
 */
public interface DeviceLocalHome extends EJBLocalHome {
    
    ejb.modul.entity.DeviceLocal findByPrimaryKey(java.lang.Integer key) throws FinderException;
    
    ejb.modul.entity.DeviceLocal create(java.lang.Integer key) throws CreateException;

    Collection findById(Integer id) throws FinderException;

    Collection findByDeviceName(String deviceName) throws FinderException;

    Collection findByDvStatus(String dvStatus) throws FinderException;
}
