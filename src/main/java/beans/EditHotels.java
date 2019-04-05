/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import persistence.Booking;
import persistence.BookingDBHelper;
import persistence.Hotel;
import persistence.HotelDBHelper;

/**
 *
 * @author chant
 */
@Named(value = "editHotels")
@RequestScoped
public class EditHotels implements Serializable{
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Inject
    UserTransaction ut;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    List<Hotel> lookupResults;
    private int hotel_id;
    private int chain_id;
    private int rating;
    private int num_rooms;
    private String address;
    private String email;
    private String phone;
    private int area;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    /**
     * Creates a new instance of searchHotels
     */
    public EditHotels() {
        
    }
    
    
    public String doDeleteBooking() {
       if(0 == getHotel_Id() 
               && 0 == getChain_Id()
               && getRating() == 0
               && 0 == getNum_Rooms()
               && null == getAddress()
               && null == getEmail()
               && null == getPhone()
               && 0 == getArea()){
            setNoCriteria(true);
            return(null);
       }
       
       List<Hotel> results = HotelDBHelper.deleteHotelsWithCriteria(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("viewHotels");
    }
    
    public void setLookupResults(List<Hotel> results) {
        this.lookupResults = results;
    }
    
    public List<Hotel> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }

    /**
     * @return the foundNoResults
     */
    public Boolean getFoundNoResults() {
        return foundNoResults;
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
     * @return the chain_id
     */
    public int getChain_Id() {
        return chain_id;
    }

    /**
     * @param chain_id the chain_id to set
     */
    public void setChain_Id(int chain_id) {
        this.chain_id = chain_id;
    }

     /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /**
     * @return the num_rooms
     */
    public int getNum_Rooms() {
        return num_rooms;
    }

    /**
     * @param num_rooms the num_rooms to set
     */
    public void setNum_Rooms(int num_rooms) {
        this.num_rooms = num_rooms;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the phone
     */
    public String getPhone(){
        return phone;
    }
    
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @return the area
     */
    public int getArea(){
        return area;
    }
    
    /**
     * @param area the area to set
     */
    public void setArea(int area){
        this.area = area;
    }

    /**
     * @param foundNoResults the foundNoResults to set
     */
    public void setFoundNoResults(Boolean foundNoResults) {
        this.foundNoResults = foundNoResults;
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }

    /**
     * @return the noCriteria
     */
    public Boolean getNoCriteria() {
        return noCriteria;
    }

    /**
     * @param noCriteria the noCriteria to set
     */
    public void setNoCriteria(Boolean noCriteria) {
        this.noCriteria = noCriteria;
    }
}
