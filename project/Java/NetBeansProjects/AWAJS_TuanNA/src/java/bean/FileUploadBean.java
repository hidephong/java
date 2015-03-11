package bean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author HAO HAO
 */
@ManagedBean
@SessionScoped
public class FileUploadBean {

    /** Creates a new instance of FileUploadBean */
    public FileUploadBean() {
    }

    public void fileUpload(FileUploadEvent event) {
        FileOutputStream fos = null;
        try {
            UploadedFile file = event.getFile();
            byte[] buff = file.getContents();
            File f = new File("D:\\" + file.getFileName());
            if (!f.exists()) {
                f.createNewFile();
            }
            fos = new FileOutputStream(f);
            fos.write(buff);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
