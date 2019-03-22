/*
 * To change this license header, choose License Headers in Project Rooms.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import persistence.Room;
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
    private int room_id;
    private int hotel_id;
    private int price;
    private String amenities;
    private int capacity;
    private String outside_view;
    private Boolean extendable;
    private String problems;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    
    /**
     * Creates a new instance of searchRooms
     */
    public SearchRooms() {
        
    }
    
    public String search() {
       if(0 == getRoom_Id() 
               && 0 == getHotel_Id()
               && getPrice() == 0
               && null == getAmenities()
               && 0 == getCapacity()
               && null == getOutside_View()
               && false == getExtendable()
               && null == getProblems()){
            setNoCriteria(true);
            return(null);
       }
       
       List<Room> results = RoomDBHelper.findRoomsWithCriteria(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("viewRooms");
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
    
    
    public int getRoom_Id() {
        return room_id;
    }

    public void setroom_id(int room_id) {
        this.room_id = room_id;
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
    public Boolean getExtendable() {
      return extendable;
    }

    /**
     * @param extendable the extendable to set
     */
    public void setExtendable(Boolean extendable) {
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
