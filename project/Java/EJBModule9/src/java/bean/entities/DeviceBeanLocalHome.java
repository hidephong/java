/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.entities;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author TuanNA
 */
public interface DeviceBeanLocalHome extends EJBLocalHome {
    
    bean.entities.DeviceBeanLocal findByPrimaryKey(java.lang.Long key) throws FinderException;
    
    bean.entities.DeviceBeanLocal create(java.lang.Long key) throws CreateException;
}
