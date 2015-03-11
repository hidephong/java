import java.io.*;
import java.security.*;
import javax.crypto.*;
public class myEncryption {
String originalText="This is a secret", encryptText, decryptText;
Cipher ci = null;
SecretKey secretKey = null;
//generate a secrectKey and Cipher object
public void doGenKey(){
try {
KeyGenerator keyGen = KeyGenerator.getInstance("DES");
secretKey = keyGen.generateKey();
ci = Cipher.getInstance("DES/ECB/PKCS5Padding");
} catch (NoSuchAlgorithmException ex) {
ex.printStackTrace();
} catch (NoSuchPaddingException ex) {
ex.printStackTrace();
}
}
//encrypt originalText
public void doEncrypt(){
try {
ci.init(Cipher.ENCRYPT_MODE,secretKey);
byte [] byteToEncrypt = ci.doFinal(originalText.getBytes());
encryptText = new String(byteToEncrypt);
} catch (InvalidKeyException ex) {
ex.printStackTrace();
} catch (IllegalBlockSizeException ex) {
ex.printStackTrace();
} catch (BadPaddingException ex) {
ex.printStackTrace();
}
}
//decrypt encryptText
public void doDecrypt(){
try {
ci.init(Cipher.DECRYPT_MODE,secretKey);
byte [] byteToDecrypt = ci.doFinal(encryptText.getBytes());
decryptText = new String(byteToDecrypt);
} catch (InvalidKeyException ex) {
ex.printStackTrace();
} catch (IllegalBlockSizeException ex) {
ex.printStackTrace();
} catch (BadPaddingException ex) {
ex.printStackTrace();
}
}
public myEncryption() {
this.doGenKey();
this.doEncrypt();
this.doDecrypt();
System.out.println("originalText: "+originalText);
System.out.println("encryptText: "+encryptText);
System.out.println("decryptText: "+decryptText);
}
public static void main(String []args){
new myEncryption();
}
}