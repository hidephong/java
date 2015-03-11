/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author TuanNA
 */
public interface DeviceLocal extends EJBLocalObject {

    Integer getId();

    void setId(Integer id);

    String getDeviceName();

    void setDeviceName(String deviceName);

    String getDvStatus();

    void setDvStatus(String dvStatus);
    
    
}
