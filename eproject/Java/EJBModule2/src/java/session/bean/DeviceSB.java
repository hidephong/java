/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.bean;

import entities.DeviceLocal;
import entities.DeviceLocalHome;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
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
public class DeviceSB implements SessionBean {
    
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
    
    
    
    
//    
//    public List findAll() {
//        
//        return null;
//    }
//
   

    private DeviceLocalHome lookupDeviceLocal() {
        try {
            Context c = new InitialContext();
            DeviceLocalHome rv = (DeviceLocalHome) c.lookup("java:global/EJBModule2/Device");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
//
//    public void editProduct(int id, String name, double price) {
//        ProductLocalHome home=lookupProductLocal();
//        try {
//            ProductLocal p=(ProductLocal) home.findById(new Integer(id));
//            p.setName(name);
//            p.setPrice(new BigDecimal(price));
//        } catch (FinderException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void removeProduct(int id) {
//        ProductLocalHome home=lookupProductLocal();
//        try {
//            home.remove(new Integer(id));
//        } catch (RemoveException ex) {
//            ex.printStackTrace();
//        } catch (EJBException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void insertProduct(int id, String name, double price) {
//       
//    }
//    
//
//    private CategoryLocalHome lookupCategoryLocal() {
//        try {
//            Context c = new InitialContext();
//            CategoryLocalHome rv = (CategoryLocalHome) c.lookup("java:comp/env/Category");
//            return rv;
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }
//
//    public List findAllCategory() throws FinderException {
//        CategoryLocalHome home=lookupCategoryLocal();
//        Collection c=home.findAll();
//        
//        return null;
//    }
//    
//    
//    
//    
//  

    public void getAll() {
        
    }

    public List findByName(String name) {
    
        DeviceLocalHome home=lookupDeviceLocal();
        List result=new ArrayList();
        try {
            Collection c=home.findByDeviceName(name);
            Iterator it=c.iterator();
            while(it.hasNext()) {
                DeviceLocal p=(DeviceLocal)it.next();
                result.add(p.getDvStatus());
            }
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void insertDevice(String Name, String Status) {
        DeviceLocalHome home=lookupDeviceLocal();
        try {
            DeviceLocal p=home.create(new Integer(1));
            p.setDeviceName(Name);
            p.setDvStatus(Status);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
}
