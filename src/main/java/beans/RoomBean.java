/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
//import persistence.Address;
import persistence.Room;
import persistence.UserAccount;


/**
 *
 * @author chant
 */
@Named(value = "RoomBean")
@ManagedBean(name="RoomBean")
@ViewScoped
public class RoomBean implements Serializable {
       
    private int ROOM_ID;
    private int PRICE;
    private String AMENITIES;
    private int CAPACITY;
    private String OUTSIDE_VIEW;
    private Boolean EXTENDABLE;
    private String PROBLEMS;
    private int HOTEL_ID;
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
        
    private List<Room> lookupResults;
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private Map<String,String> types;
    
    /**
     * Creates a new instance of UserProfileBean
     */
    public RoomBean() {
                
        types = new HashMap<String, String>();
        types.put("", "");
        types.put("Mountain", "Mountain");
        types.put("Sea", "Sea");
        
               
        types = new HashMap<String, String>();
        types.put("Yes", "Yes");
        types.put("No", "No");
             
    }

     /**
     * @return the ROOM_ID
     */
    public int getROOM_ID() {
        return ROOM_ID;
    }

    /**
     * @param ROOM_ID the ROOM_ID to set
     */
    public void setROOM_ID(int ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

     /**
     * @return the PRICE
     */
    public int getPRICE() {
        return PRICE;
    }

    /**
     * @param PRICE the PRICE to set
     */
    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }
    
    /**
     * @return the AMENITIES
     */
    public String getAMENITIES() {
        return AMENITIES;
    }

    /**
     * @param AMENITIES the AMENITIES to set
     */
    public void setAMENITIES(String AMENITIES) {
        this.AMENITIES = AMENITIES;
    }

    /**
     * @return the CAPACITY
     */
    public int getCAPACITY() {
        return CAPACITY;
    }

    /**
     * @param CAPACITY the CAPACITY to set
     */
    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    /**
     * @return the OUTSIDE_VIEW
     */
    public String getOUTSIDE_VIEW() {
        return OUTSIDE_VIEW;
    }

    /**
     * @param OUTSIDE_VIEW the OUTSIDE_VIEW to set
     */
    public void setOUTSIDE_VIEW(String OUTSIDE_VIEW) {
        this.OUTSIDE_VIEW = OUTSIDE_VIEW;
    }
    
    /**
     * @return the EXTENDABLE
     */
    public Boolean getEXTENDABLE(){
        return EXTENDABLE;
    }
    
    /**
     * @param EXTENDABLE the EXTENDABLE to set
     */
    public void setEXTENDABLE(Boolean EXTENDABLE){
        this.EXTENDABLE = EXTENDABLE;
    }

    /**
     * @return the PROBLEMS
     */
    public String getPROBLEMS() {
        return PROBLEMS;
    }

    /**
     * @param PROBLEMS the PROBLEMS to set
     */
    public void setPROBLEMS(String PROBLEMS) {
        this.PROBLEMS = PROBLEMS;
    }
    
    /**
     * @return the HOTEL_ID
     */
    public int getHOTEL_ID() {
        return HOTEL_ID;
    }

    /**
     * @param HOTEL_ID the HOTEL_ID to set
     */
    public void setHOTEL_ID(int HOTEL_ID) {
        this.HOTEL_ID = HOTEL_ID;
    }
    
    /**
     * Add the user to the database
     * @param actionEvent
     * @return 
     */
    public String doAddRoom() {
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserAccount u = (UserAccount) session.getAttribute("User");
        
        Room room = new Room(ROOM_ID, HOTEL_ID, PRICE, AMENITIES, CAPACITY, OUTSIDE_VIEW, EXTENDABLE, PROBLEMS);
        
        try {
           
           persist(room); 
           String msg = "Room Created Successfully";
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
           FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
       
           return (msg);
        } catch(RuntimeException e) {
           String msg = "Error While Creating Room";
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
           FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().setKeepMessages(true);
        }
        return null;
    }
    
      

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
    public void setLookupResults(List<Room> results) {
        this.lookupResults = results;
    }
    
    public List<Room> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
    
    public Map<String, String> getTypes() {
        return types;
    }
       
    

}
