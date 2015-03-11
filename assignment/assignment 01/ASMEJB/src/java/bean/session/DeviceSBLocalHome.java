/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author TuanNA
 */
public interface DeviceSBLocalHome extends EJBLocalHome {
    
    bean.session.DeviceSBLocal create() throws CreateException;
}
