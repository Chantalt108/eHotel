/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.EditHotels;
import beans.EditRooms;
import beans.SearchRooms;
import beans.View1Bean;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chant
 */
public class ViewDBHelper {
    public static Room findRoom(EntityManager em, int id) {
        Room r = em.find(Room.class, id);
        return r;       
    }
    
    public static Hotel findHotel(EntityManager em, int id) {
        Hotel h = em.find(Hotel.class, id);
        return h;       
    }
    
    public static HotelChain findHotelChain(EntityManager em, int id) {
        HotelChain c = em.find(HotelChain.class, id);
        return c;       
    }
    
    public static List<Room> searchRoomsByArea(EntityManager em, View1Bean view1) {
        Query query = em.createNativeQuery("SELECT rooms.room_id, hotels.hotel_id, hotels.area "
                + "FROM hotels JOIN rooms ON hotels.area = " + view1.getArea(),"view1");
        //List<Room> rooms = query.getResultList();
        
        return performQuery(query);
    }
    
        
    private static List<Room> performQuery(final Query query) {
        List<Room> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<Room> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
  
    

}
