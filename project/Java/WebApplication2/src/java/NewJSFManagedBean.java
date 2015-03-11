/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import brab.NewSessionBeanRemote;
import brab.NewSessionBeanRemoteHome;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@RequestScoped
public class NewJSFManagedBean {
    @EJB
    private NewSessionBeanRemoteHome newSessionBeanRemoteHome;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
        initialize();
    }
    private NewSessionBeanRemote newSessionBean;

    @PostConstruct
    private void initialize() {
        try {
            newSessionBean = newSessionBeanRemoteHome.create();
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }
    
}
