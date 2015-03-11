/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv;

import javax.ejb.Local;

/**
 *
 * @author TuanNA
 */
@Local
public interface NewSessionBeanLocal {

    void insertMethod(String name, String status);
    
}
