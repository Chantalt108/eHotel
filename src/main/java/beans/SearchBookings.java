/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import persistence.Booking;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.BookingDBHelper;

/**
 *
 * @author chant
 */
@Named(value = "searchBookings")
@RequestScoped
public class SearchBookings implements Serializable {
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    List<Booking> lookupResults;
    private int booking_id;
    private Date checkin_date;
    private Date checkout_date;
    private Boolean is_renting;
    private int room_id;
    private int cust_id;
    private int emp_id;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    
    /**
     * Creates a new instance of searchBookings
     */
    public SearchBookings() {
        
    }
    
    public String search() {
       if(0 == getBooking_Id() 
               && null == getCheckin_Date()
               && getCheckout_Date() == null
               && null == getIs_Renting()
               && 0 == getRoom_Id()
               && 0 == getCust_Id()
               && 0 == getEmp_Id()){
            setNoCriteria(true);
            return(null);
       }
       
       List<Booking> results = BookingDBHelper.findBookingsWithCriteria(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("viewBookings");
    }
    
    public void setLookupResults(List<Booking> results) {
        this.lookupResults = results;
    }
    
    public List<Booking> getLookupResults() {
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
     * @param checkin_date the checkin_date to set
     */
    public void setCheckin_Date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }
    /**
     * @return the checkin_date
     */
    public Date getCheckin_Date() {
        return checkin_date;
    }
    
    /**
     * @param checkout_date the checkout_date to set
     */
    public void setCheckout_Date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }
    /**
     * @return the checkout_date
     */
    public Date getCheckout_Date() {
        return checkout_date;
    }
    
    /**
     * @param is_renting the is_renting to set
     */
    public void setIs_Renting(Boolean is_renting) {
        this.is_renting = is_renting;
    }
    /**
     * @return the is_renting
     */
    public Boolean getIs_Renting() {
        return is_renting;
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
     * @return the cust_id
     */
    public int getCust_Id() {
        return cust_id;
    }

    /**
     * @param cust_id the cust_id to set
     */
    public void setCust_Id(int cust_id) {
        this.cust_id = cust_id;
    }
    
    /**
     * @return the emp_id
     */
    public int getEmp_Id() {
        return emp_id;
    }

    /**
     * @param emp_id the emp_id to set
     */
    public void setEmp_Id(int emp_id) {
        this.emp_id = emp_id;
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
     * @return the booking_id
     */
    public int getBooking_Id() {
        return booking_id;
    }

    /**
     * @param booking_id the booking_id to set
     */
    public void setBooking_Id(int booking_id) {
        this.booking_id = booking_id;
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
