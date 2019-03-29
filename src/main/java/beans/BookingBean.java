/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Booking;

/**
 *
 * @author chant
 */
@Named(value = "BookingBean")
@ManagedBean(name="BookingBean")
@ViewScoped
public class BookingBean implements Serializable{
    private int booking_id;
    private int room_id;
    private int cust_id;
    private int emp_id;
    private Date checkin_date;
    private Date checkout_date;
    private Boolean is_renting;
    
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    private List<Booking> lookupResults;
    private Map<String, Map<String, String>> data = new HashMap<>();
    
    public BookingBean(){
        
    }
    
    /**
     * @return the booking_id
     */
    public int getBooking_Id(){
        return booking_id;
    }
    
    /**
     * @param booking_id the booking_id to set
     */
    public void setBooking_Id(int booking_id){
        this.booking_id = booking_id;
    }
    
    /**
     * @return the checkin_date
     */
    public Date getCheckin_Date(){
        return checkin_date;
    }
    
    /**
     * @param checkin_date the checkin_date to set
     */
    public void setCheckin_Date(Date checkin_date){
        this.checkin_date = checkin_date;
    }
    
    /**
     * @return the checkout_date
     */
    public Date getCheckout_Date(){
        return checkout_date;
    }
    
    /**
     * @param checkout_date the checkout_date to set
     */
    public void setCheckout_Date(Date checkout_date){
        this.checkout_date = checkout_date;
    }
    
    /**
     * @return the is_renting
     */
    public Boolean getIs_Renting(){
        return is_renting;
    }
    
    /**
     * @param is_renting the is_renting to set
     */
    public void setIs_Renting(Boolean is_renting){
        this.is_renting = is_renting;
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
}
