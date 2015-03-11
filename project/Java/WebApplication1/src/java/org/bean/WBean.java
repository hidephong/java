/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import session.bean.DeviceSBRemote;
import session.bean.DeviceSBRemoteHome;

/**
 *
 * @author TuanNA
 */
@ManagedBean
@SessionScoped
public class WBean {
    @EJB
    private DeviceSBRemoteHome deviceSBRemoteHome;

    /**
     * Creates a new instance of WBean
     */
    public WBean() {
    }
    private DeviceSBRemote deviceSB;

    @PostConstruct
    private void initialize() {
        try {
            deviceSB = deviceSBRemoteHome.create();
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }
    
}
