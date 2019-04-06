/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import persistence.Room;
import persistence.Hotel;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.RoomDBHelper;

/**
 *
 * @author chant
 */
@Named(value = "searchRooms")
@RequestScoped
public class SearchRooms implements Serializable {
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    List<Room> lookupResults;
    private int ROOM_ID;
    private int HOTEL_ID;
    private int PRICE;
    private String AMENITIES;
    private int CAPACITY;
    private String OUTSIDE_VIEW;
    private Boolean EXTENDABLE;
    private String PROBLEMS;
    private int AREA;
    private int HOTELCHAIN;
    private int RATING;
    private int NUM_ROOMS;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    
    /**
     * Creates a new instance of searchRooms
     */
    public SearchRooms() {
        
    }
    
    public String search() {
       if(0 == getROOM_ID() 
               && 0 == getHOTEL_ID() 
               && getPRICE() == 0 
               && null == getAMENITIES() 
               && 0 == getCAPACITY() 
               && null == getOUTSIDE_VIEW() 
               && false == getEXTENDABLE() 
               && null == getPROBLEMS()
               && 0 == getAREA()
               && 0 == getHOTELCHAIN()
               && 0 == getRATING()
               && 0 == getNUM_ROOMS()
               ){
            setNoCriteria(true);
            return(null);
       }
       
       List<Room> results = RoomDBHelper.findRoomsWithCriteria(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("viewRooms");
    }
    
    public String displayAllRooms() {
             
       List<Room> results = RoomDBHelper.findAllRooms(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("viewRooms");
    }
    
    public String searchRoomsByCap(){
        if (getROOM_ID() == 0 && getHOTEL_ID() == 0 && getAREA() == 0){
            setNoCriteria(true);
            return(null);
        }
        
       List<Room> results = RoomDBHelper.searchRoomsByCap(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("view2Results");
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
     * @param foundNoResults the foundNoResults to set
     */
    public void setFoundNoResults(Boolean foundNoResults) {
        this.foundNoResults = foundNoResults;
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }
    
    
    public int getROOM_ID() {
        return ROOM_ID;
    }

    public void setROOM_ID(int ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
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
    public Boolean getEXTENDABLE() {
      return EXTENDABLE;
    }

    /**
     * @param EXTENDABLE the EXTENDABLE to set
     */
    public void setEXTENDABLE(Boolean EXTENDABLE) {
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
   * @return the AREA
   */
    public int getAREA() {
        return AREA;
    }

    /**
     * @param AREA the AREA to set
     */
    public void setAREA(int AREA) {
        this.AREA = AREA;
    }
    
    /**
   * @return the HOTELCHAIN
   */
    public int getHOTELCHAIN() {
        return HOTELCHAIN;
    }

    /**
     * @param HOTELCHAIN the HOTELCHAIN to set
     */
    public void setHOTELCHAIN(int HOTELCHAIN) {
        this.HOTELCHAIN = HOTELCHAIN;
    }
    
    /**
   * @return the RATING
   */
    public int getRATING() {
        return RATING;
    }

    /**
     * @param RATING the RATING to set
     */
    public void setRATING(int RATING) {
        this.RATING = RATING;
    }
    
    /**
   * @return the NUM_ROOMS
   */
    public int getNUM_ROOMS() {
        return NUM_ROOMS;
    }

    /**
     * @param NUM_ROOMS the NUM_ROOMS to set
     */
    public void setNUM_ROOMS(int NUM_ROOMS) {
        this.NUM_ROOMS = NUM_ROOMS;
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
