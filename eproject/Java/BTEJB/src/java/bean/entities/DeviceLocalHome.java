/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.entities;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author TuanNA
 */
public interface DeviceLocalHome extends EJBLocalHome {
    
    bean.entities.DeviceLocal findByPrimaryKey(java.lang.Integer key) throws FinderException;
    
    bean.entities.DeviceLocal create(java.lang.Integer key) throws CreateException;

    Collection findById(Integer id) throws FinderException;

    Collection findByDeviceName(String deviceName) throws FinderException;

    Collection findByDvStatus(String dvStatus) throws FinderException;
}
