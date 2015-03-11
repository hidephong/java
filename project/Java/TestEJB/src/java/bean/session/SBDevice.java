/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import cmp.DeviceLocal;
import cmp.DeviceLocalHome;
import entities.DeviceInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author TuanNA
 */
public class SBDevice implements SessionBean {

    private SessionContext context;

    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">;
    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations
    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }

    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
    }

    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
    }

    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
    }

    // </editor-fold>;
    /**
     * See section 7.10.3 of the EJB 2.0 specification See section 7.11.3 of the
     * EJB 2.1 specification
     */
    public void ejbCreate() {
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    public void insertDevice(int id, String name, String status) throws CreateException {
        DeviceLocalHome home = lookupDeviceLocal();
        DeviceLocal dl = home.create(new Integer(id));
        dl.setDeviceName(name);
        dl.setDvStatus(status);
    }

    private DeviceLocalHome lookupDeviceLocal() {
        try {
            Context c = new InitialContext();
            DeviceLocalHome rv = (DeviceLocalHome) c.lookup("java:comp/env/Device");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String removeDevice(int id) throws RemoveException {
        DeviceLocalHome home = lookupDeviceLocal();
        DeviceLocal dl = home.findByPrimaryKey(id);
        dl.remove();
        return "Success!";
    }

    public void updateDevice(int id) {
    }

    public void changeDevice(int id, String Status) {
        DeviceLocalHome home = lookupDeviceLocal();
        DeviceLocal dl = home.findByPrimaryKey(id);
        dl.setDvStatus(Status);
    }

    public List findAll() {
        
          List list = new ArrayList();
        try {
        DeviceLocalHome dlh = lookupDeviceLocal();
        
            Collection c = dlh.findAll();
            Iterator i = c.iterator();
            while(i.hasNext()){
                DeviceLocal dl = (DeviceLocal) i.next();
                int id = (int) dl.getId().intValue();
                String deviceName = dl.getDeviceName();
                String status = dl.getDvStatus();
                list.add(new DeviceInfo(id, deviceName, status));
                
            }
            
            return list;
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}