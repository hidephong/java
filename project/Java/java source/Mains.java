/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Nguyen Van Hien
 */
public class Main {

    public static void main(String[] args) {
        //Instance variable to encrypt and decrypt data.
        Cipher c = null;

        //Instance variable to store the secret key used for encryption and decryption.
        SecretKey sKey = null;
        String txtInput = "Hello world";
        String txtEncrypt = "";
        String txtDecrypt = "";

        // Initialization process
        try {
            // Generate the secret key
            KeyGenerator g = KeyGenerator.getInstance("DES");
            sKey = g.generateKey();
            //System.out.println(sKey.toString());

            // Initialize the cipher instance to use DES algorithm, ECB mode, and PKCS#5 padding scheme
            c = Cipher.getInstance("DES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Encryption process
        try {
            // Initialize the cipher with secret key to encrypt data
            c.init(Cipher.ENCRYPT_MODE, sKey);

            // Read the data into byte array
            byte[] text = txtInput.getBytes();

            // Store the encrypted data in a byte array
            byte[] encryptedData = c.doFinal(text);

            // make the encrypted text
            txtEncrypt = new String(encryptedData);

        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        }

        // Decryption process
        try {
            // Initialize the cipher with secret key to decrypt data
            c.init(Cipher.DECRYPT_MODE, sKey);

            // Read the encrypted data into byte array
            byte[] text = txtEncrypt.getBytes();

            // Store the decrypted data into byte array
            byte[] decryptedData = c.doFinal(text);

            // Display the decrypted data
            txtDecrypt = new String(decryptedData);
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        }

        System.out.println("\nInput text: " + txtInput);
        System.out.println("\nEncrypted text: " + txtEncrypt);
        System.out.println("\nDecrypted text: " + txtDecrypt);
    }
}
