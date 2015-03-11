/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author TuanNA
 */
public interface DeviceLocalHome extends EJBLocalHome {

    cmp.DeviceLocal findByPrimaryKey(java.lang.Integer key) throws FinderException;

    cmp.DeviceLocal create(java.lang.Integer key) throws CreateException;

    Collection findById(Integer id) throws FinderException;

    Collection findByDeviceName(String deviceName) throws FinderException;

    Collection findByDvStatus(String dvStatus) throws FinderException;

    public DeviceLocal findByPrimaryKey(int id);

    Collection findAll() throws FinderException;
}
