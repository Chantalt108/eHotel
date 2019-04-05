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
import persistence.Room;
import persistence.RoomDBHelper;
import persistence.Room;

/**
 *
 * @author chant
 */
@Named(value = "editRooms")
@RequestScoped
public class EditRooms implements Serializable{
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Inject
    UserTransaction ut;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    List<Room> lookupResults;
    private int ROOM_ID;
    private int PRICE;
    private String AMENITIES;
    private int CAPACITY;
    private String OUTSIDE_VIEW;
    private Boolean EXTENDABLE;
    private String PROBLEMS;
    private int HOTEL_ID;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    /**
     * Creates a new instance of searchRooms
     */
    public EditRooms() {
        
    }
    
    
    public String doDeleteRoom() {
       if(0 == getROOM_ID() 
               && 0 == getPRICE()
               && getAMENITIES() == null
               && 0 == getCAPACITY()
               && null == getOUTSIDE_VIEW()
               && null == getEXTENDABLE()
               && null == getPROBLEMS()
               && 0 == getROOM_ID()){
            setNoCriteria(true);
            return(null);
       }
       
       try{
            List<Room> results = RoomDBHelper.deleteRoomsWithCriteria(em, this);
            setLookupResults(results);
            if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
                setNoCriteria(false);
       }
       catch(Exception e){
       return("viewRooms");
       }
       return ("viewRooms");
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

    /**
     * @return the foundNoResults
     */
    public Boolean getFoundNoResults() {
        return foundNoResults;
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
