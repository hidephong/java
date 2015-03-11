/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cmp.entities;

import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author TuanNA
 */
public interface CMPBeanLocalHome extends EJBLocalHome {
    
    bean.cmp.entities.CMPBeanLocal findByPrimaryKey(java.lang.Long key) throws FinderException;
}
