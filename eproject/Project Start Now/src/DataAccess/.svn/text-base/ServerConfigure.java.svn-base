/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Properties;

/**
 *
 * @author nhahv
 */
public class ServerConfigure {
    public ServerConfigure(){}
        public static final String CONFIG_FILENAME      =   "config.properties";
        public static final String CONFIG_SERVERNAME    =   "ServerName";
        public static final String CONFIG_PORTNUMBER    =   "PortNumber";
        public static final String CONFIG_SQLINSTANCE   =   "SQLEXPRESS";
        public static final String CONFIG_DATABASE      =   "Database";
        public static final String CONFIG_USERNAME      =   "UserName";
        public static final String CONFIG_PASSWORD      =   "PassWord";

    public static Properties defaultServerConfig(String fileName){
        Properties prop = new Properties();
            prop.setProperty(CONFIG_SERVERNAME, "10.0.0.102");
            prop.setProperty(CONFIG_PORTNUMBER, "1427");
            prop.setProperty(CONFIG_SQLINSTANCE, "SQLEXPRESS");
            prop.setProperty(CONFIG_USERNAME, "ubuntu");
            prop.setProperty(CONFIG_PASSWORD, "123");
            prop.setProperty(CONFIG_DATABASE, "ETMDB2011");
        return prop;
    }

    public static Properties getDefaultServerConfig(String fileName){
        Properties prop = new Properties();
        FileInputStream readProp;
        try {
            readProp = new FileInputStream(fileName);
            prop.load(readProp);
            readProp.close();
            return prop;
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            return null;
        }
       }
 
    public Properties loadNorSetDefaultServerConfig(){
        Properties nProperties = new Properties();
        try {
            FileInputStream fi = new FileInputStream(CONFIG_FILENAME);
            nProperties = getDefaultServerConfig(CONFIG_FILENAME);
            return nProperties;
        } catch (FileNotFoundException ex) {
             nProperties = defaultServerConfig(CONFIG_FILENAME);
             saveNewProperties(nProperties, CONFIG_FILENAME);
             return nProperties;
        }
    }
    
    
    public static boolean saveNewProperties(Properties prop,String fileName){
        FileOutputStream saveProp;
        try {
            saveProp = new FileOutputStream(fileName);
            prop.store(saveProp, "SERVER CONGIG PROPERTIES");
            saveProp.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            return false;
        }
    }
    
    public static String getConnection(){
        Properties prop;
        try {
            FileInputStream fi = new FileInputStream(CONFIG_FILENAME);
             prop = ServerConfigure.getDefaultServerConfig(CONFIG_FILENAME);
        } catch (FileNotFoundException ex) {
             prop = defaultServerConfig(CONFIG_FILENAME);
             ServerConfigure.saveNewProperties(prop,CONFIG_FILENAME);
    }

        String ServerName   = prop.getProperty(CONFIG_SERVERNAME);
        String PortNumber   = prop.getProperty(CONFIG_PORTNUMBER);
        String Instance     = prop.getProperty(CONFIG_SQLINSTANCE);
        String UserName     = prop.getProperty(CONFIG_USERNAME);
        String PassWord     = prop.getProperty(CONFIG_PASSWORD);
        String Database     = prop.getProperty(CONFIG_DATABASE);

        String cmd = "jdbc:sqlserver://"
                        + ServerName
                +"\\"
                        + Instance
                + ":"
                        + PortNumber
                
                + ";DatabaseName="
                        + Database
                + ";user="
                        + UserName
                + ";password="
                        + PassWord
                + ";timeout=3";
                        
        return cmd;

    }
}
