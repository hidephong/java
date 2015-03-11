/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Truong Le
 */
public class CipherDemo {

    public static void main(String[] args) throws Exception {
        String message = "This is just an example";

        // Get the KeyGenerator

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128); // 192 and 256 bits may not be available


        // Generate the secret key specs.
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();

        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");


        // Instantiate the cipher

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        System.out.println("Original String: " + message);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        System.out.println("encrypted string: " + new String(encrypted));

        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original =
                cipher.doFinal(encrypted);
        String originalString = new String(original);
        System.out.println("Plain string: " + originalString);
    }
}
