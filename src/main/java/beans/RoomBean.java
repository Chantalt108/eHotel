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
       
    private int room_id;
    private int price;
    private String amenities;
    private int capacity;
    private String outside_view;
    private Boolean extendable;
    private String problems;
    private int hotel_id;
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
     * @return the room_id
     */
    public int getRoom_Id() {
        return room_id;
    }

    /**
     * @param room_id the room_id to set
     */
    public void setRoom_Id(int room_id) {
        this.room_id = room_id;
    }

     /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /**
     * @return the amenities
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * @param amenities the amenities to set
     */
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the outside_view
     */
    public String getOutside_View() {
        return outside_view;
    }

    /**
     * @param outside_view the outside_view to set
     */
    public void setOutside_View(String outside_view) {
        this.outside_view = outside_view;
    }
    
    /**
     * @return the extendable
     */
    public Boolean getExtendable(){
        return extendable;
    }
    
    /**
     * @param extendable the extendable to set
     */
    public void setExtendable(Boolean extendable){
        this.extendable = extendable;
    }

    /**
     * @return the problems
     */
    public String getProblems() {
        return problems;
    }

    /**
     * @param problems the problems to set
     */
    public void setProblems(String problems) {
        this.problems = problems;
    }
    
    /**
     * @return the hotel_id
     */
    public int getHotel_Id() {
        return hotel_id;
    }

    /**
     * @param hotel_id the hotel_id to set
     */
    public void setHotel_Id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
    /**
     * Add the user to the database
     * @param actionEvent
     * @return 
     */
    public String doAddRoom() {
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserAccount u = (UserAccount) session.getAttribute("User");
        
        Room room = new Room(room_id, hotel_id, price, amenities, capacity, outside_view, extendable, problems);
        
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
