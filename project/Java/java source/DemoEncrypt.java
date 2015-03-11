/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.sjava.s3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author cibervn
 */
public class DemoEncrypt {

    public static void main(String[] args) {
        String original = "this is a normal text";
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance("DES");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        SecretKey sk = keyGenerator.generateKey();
        System.out.println("original:" + original);
        byte[] encrypted = encrypt(original, sk);
        System.out.println("encrypted:" + encrypted);
        System.out.println("decrypted:" + decrypt(encrypted, sk));
    }

    public static byte [] encrypt(String original, SecretKey sk) {
        try {
            Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, sk);
            byte[] encrypted = c.doFinal(original.getBytes());
            return encrypted;
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String decrypt(byte[] encrypted, SecretKey sk) {
        try {
            Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, sk);
            byte[] decrypted = c.doFinal(encrypted);
            return new String(decrypted);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(DemoEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
