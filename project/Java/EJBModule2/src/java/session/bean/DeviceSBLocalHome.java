/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.bean;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author TuanNA
 */
public interface DeviceSBLocalHome extends EJBLocalHome {
    
    session.bean.DeviceSBLocal create() throws CreateException;
}
