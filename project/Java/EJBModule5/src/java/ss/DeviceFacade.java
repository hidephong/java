/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss;

import cmp.Device;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TuanNA
 */
@Stateless
public class DeviceFacade extends AbstractFacade<Device> implements DeviceFacadeLocal {
    @PersistenceContext(unitName = "EJBModule5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeviceFacade() {
        super(Device.class);
    }
    
}
