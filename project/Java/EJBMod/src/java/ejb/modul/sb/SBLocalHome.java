/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.modul.sb;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author TuanNA
 */
public interface SBLocalHome extends EJBLocalHome {
    
    ejb.modul.sb.SBLocal create() throws CreateException;
}
