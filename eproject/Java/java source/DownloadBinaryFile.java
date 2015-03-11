/*
 * DownloadBinaryFile.java
 *
 * Created on November 27, 2007, 11:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package URL;

/**
 *
 * @author java2s
 */
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadBinaryFile {
  public static void main(String args[]) {
    try {
      //URL root = new URL("http://");
      URL root = new URL("http://www.codeproject.com/KB/IP/MyDownloader/MyDownloader_demo.zip");
      
      saveBinaryFile(root);
    } catch (MalformedURLException e) {
      System.err.println("not URL I understand.");
    }
  }

  public static void saveBinaryFile(URL u) {
    int bufferLength = 128;
    try {
      URLConnection uc = u.openConnection();
      String ct = uc.getContentType();
      
      int contentLength = uc.getContentLength();
      System.out.println(contentLength);
      /*
      if (ct.startsWith("text/") || contentLength == -1) {
        System.err.println("This is not a binary file.");
        return;
      }
      */

      InputStream stream = uc.getInputStream();
      byte[] buffer = new byte[contentLength];
      int bytesread = 0;
      int offset = 0;
      while (bytesread >= 0) {
        bytesread = stream.read(buffer, offset, bufferLength);
        if (bytesread == -1)
          break;
        offset += bytesread;
      }
      if (offset != contentLength) {
        System.err.println("Error: Only read " + offset + " bytes");
        System.err.println("Expected " + contentLength + " bytes");
      }

      String theFile = u.getFile();
      theFile = theFile.substring(theFile.lastIndexOf('/') + 1);
      FileOutputStream fout = new FileOutputStream(theFile);
      fout.write(buffer);
    } catch (Exception e) {
      System.err.println(e);
    }
    return;
  }
}

