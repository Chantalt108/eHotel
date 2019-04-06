/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Room;
import persistence.RoomDBHelper;
import persistence.ViewDBHelper;

/**
 *
 * @author chant
 */
@Named(value = "view1Bean")
@RequestScoped
public class View1Bean implements Serializable{
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    List<Room> lookupResults;
    private int room_id;
    private int hotel_id;
    private int area;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    public View1Bean(){
    
    }
    
    public String searchRoomsByArea(){
        if (getRoom_Id() == 0 && getHotel_Id() == 0 && getArea() == 0){
            setNoCriteria(true);
            return(null);
        }
        
       List<Room> results = ViewDBHelper.searchRoomsByArea(em, this);
       setLookupResults(results);
       if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
        setNoCriteria(false);
       return("viewRooms");
    }
    
    public int getRoom_Id() {
        return room_id;
    }

    public void setRoom_Id(int room_id) {
        this.room_id = room_id;
    }
    
    public int getHotel_Id() {
        return hotel_id;
    }

    public void setHotel_Id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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
