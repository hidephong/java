/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author TuanNA
 */
public interface NewSessionBeanLocalHome extends EJBLocalHome {
    
    ss.NewSessionBeanLocal create() throws CreateException;
}
