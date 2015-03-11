/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nhahv.jsf.managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import nhahv.jpa.controllers.AccountEntityJpaController;
import nhahv.jpa.controllers.ImageEntityJpaController;
import nhahv.jpa.controllers.exceptions.PreexistingEntityException;
import nhahv.jpa.entities.AccountEntity;
import nhahv.jpa.entities.ImageEntity;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author NHAHV
 */
@ManagedBean
@SessionScoped
public class UploadImage {
    private ImageEntity entity;
    private static final int BUFFER_SIZE = 6124;  

    public ImageEntity getEntity() {
        return entity;
    }

    public void setEntity(ImageEntity entity) {
        this.entity = entity;
    }
    
    /**
     * Creates a new instance of UploadImage
     */
    public UploadImage() {
        entity = new ImageEntity();
           }
    
    
    public void handleFileUpload(FileUploadEvent event) {
     ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
     
     UploadedFile file = event.getFile();
     UUID uid = UUID.randomUUID();
     String fileName = file.getFileName();
     String fileExt = fileName.substring(fileName.indexOf("."),fileName.length());
     String newFileName = uid.toString() + fileExt;
     String filePath = extContext.getRealPath("//uploadedimages//") +"//"+ newFileName;
     File result = new File(filePath);
       
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(result);

        byte[] buffer = file.getContents();

        int bulk;
        InputStream inputStream = file.getInputstream();
        while (true) {
               bulk = inputStream.read(buffer);
               if (bulk < 0) {
                   break;
                }
               fileOutputStream.write(buffer, 0, bulk);
               fileOutputStream.flush();
         }

        fileOutputStream.close();
        inputStream.close();
        entity.setUrl(newFileName);

       FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName()
                                                                  + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {

            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                 "The files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
     }       
      FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
      FacesContext.getCurrentInstance().addMessage(null, msg);
  }
    
    
    public String save(){
        try {
            ImageEntityJpaController ctrler = new ImageEntityJpaController(Persistence.createEntityManagerFactory("NhaHVJSFPU"));
   
           ctrler.create(entity);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Save succesfull",""));
           return "home";
           
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save error",""));
            return "";
        }
        
    }
}
