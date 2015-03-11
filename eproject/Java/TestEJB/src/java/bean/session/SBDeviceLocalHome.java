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
public interface SBDeviceLocalHome extends EJBLocalHome {
    
    bean.session.SBDeviceLocal create() throws CreateException;
}
