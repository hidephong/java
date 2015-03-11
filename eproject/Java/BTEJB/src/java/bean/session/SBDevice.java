/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.session;

import bean.entities.DeviceLocal;
import bean.entities.DeviceLocalHome;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
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

    public String test() {
        return "abc";
    }

    public String insertDevice(String Name) {
        DeviceLocalHome home=lookupDeviceLocal();
        try {
            DeviceLocal p=home.create(new Integer(1000));
            p.setDeviceName(Name);
            p.setDvStatus("off");
        return "ok";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
        return null;
    }

    
    public List getAll() {
        
        List result=new ArrayList();
       
       
                DeviceLocalHome home=lookupDeviceLocal();
        try {
            DeviceLocal p;
             Collection c=home.findByDeviceName("Tivi");
            Iterator it=c.iterator();
            while(it.hasNext()) {
                p=(DeviceLocal)it.next();
                result.add(p.getDeviceName());
            }
             return result;
     
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
      return result;
    }

    private DeviceLocalHome lookupDeviceLocal() {
        try {
            Context c = new InitialContext();
            DeviceLocalHome rv = (DeviceLocalHome) c.lookup("java:comp/env/Device1");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String findByName(String name) {
        String result=null;
             DeviceLocalHome home=lookupDeviceLocal();
        try {
            DeviceLocal p;
             Collection c=home.findByDeviceName("Tivi");
            Iterator it=c.iterator();
            while(it.hasNext()) {
                p=(DeviceLocal)it.next();
                result=p.getDvStatus();
            }
             return result;
     
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
      return result;
   
    }
    
}
