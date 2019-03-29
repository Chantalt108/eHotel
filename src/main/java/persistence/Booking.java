/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author chant
 */
@Entity
@Table(name = "BOOKINGS")
public class Booking implements Serializable{
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int booking_id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkin_date;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkout_date;
    private Boolean is_renting;
    private int room_id;
    private int cust_id;
    private int emp_id;
    
    public Booking(int booking_id, Date checkin_date, Date checkout_date, Boolean is_renting, int room_id, int cust_id, int emp_id){
        this.booking_id = booking_id;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.is_renting = is_renting;
        this.room_id = room_id;
        this.cust_id = cust_id;
        this.emp_id = emp_id;
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
