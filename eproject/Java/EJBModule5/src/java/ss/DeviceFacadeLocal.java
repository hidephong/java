/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss;

import cmp.Device;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TuanNA
 */
@Local
public interface DeviceFacadeLocal {

    void create(Device device);

    void edit(Device device);

    void remove(Device device);

    Device find(Object id);

    List<Device> findAll();

    List<Device> findRange(int[] range);

    int count();
    
}
