/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;


import Language.Language;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author nhahv
 */
public class MD5Encrypt {

        public String encryptMD5(String Password) {
        try {
          
            MessageDigest messageDigest =  MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(Password.getBytes());
            
            byte[] degestBs = messageDigest.digest();
            
            BigInteger bigInteger = new BigInteger(1,degestBs);
            
            
            String hashtextString = bigInteger.toString(16).toUpperCase();
            
            while(hashtextString.length() < 32){
                hashtextString = "0" + hashtextString;
            }
            
            return hashtextString;
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("Language.Language", Language.getLocale()).getString("ENCRYPT_ERPOR"));              
            return null;
        }
       
    }
}

  

