/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.EditBookings;
import beans.EditHotels;
import beans.SearchHotels;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chant
 */
public class HotelDBHelper {
    public static Hotel findHotel(EntityManager em,String id) {
        Hotel h = em.find(Hotel.class, id);
        return h;
    }
    
    public static List<Hotel> deleteHotelsWithCriteria(EntityManager em, EditHotels editHotel){
        Query query = em.createNativeQuery("DELETE FROM HOTELS "
                + "WHERE hotel_id = " + editHotel.getHotel_Id());
        
        return performQuery(query);
    }
    
    
    public static List<Hotel> findHotelsWithCriteria(EntityManager em, SearchHotels searchHotel){
        String initQueryString = "SELECT h FROM Room h";
        String whereClauseConditions = "";
        Query query;
        
        //Set conditions for the WHERE clause of the Query
        
        
        if(!(0 == searchHotel.getHotel_Id())){ //If the hotel_id field was used by the User
            whereClauseConditions += " h.hotel_id = :hotelNum";
        }
        if(!(0 == searchHotel.getChain_Id())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " h.chain_id = :chainNum";
        }
        if(!(searchHotel.getRating() == 0)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " h.rating = :hRating";
        }
        if(!(searchHotel.getNum_Rooms() == 0)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " h.num_rooms = :hNumRooms";
        }
        if(!(searchHotel.getAddress() == null)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " h.address = hAddress";
        }
        if(!(searchHotel.getEmail() == null)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " h.email = hEmail";
        }
        if(!(searchHotel.getPhone() == null)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " h.phone = hPhone";
        }
              
        
        //If there are conditions add the WHERE clause and its conditions 
        if(!"".equals(whereClauseConditions)){
            initQueryString += " WHERE"; 
            initQueryString += whereClauseConditions; 
            query = em.createQuery(initQueryString);
        
            //Set Parameters of the Query
            if(!(0 == searchHotel.getHotel_Id())){
                query.setParameter("hotelNum", searchHotel.getHotel_Id());
            }
            if(!(0 == searchHotel.getChain_Id())){
                query.setParameter("chainNum", searchHotel.getChain_Id());
            }
            if(!(searchHotel.getRating() == 0)){
                query.setParameter("hRating", searchHotel.getRating());
            }
            if(!(0 == searchHotel.getNum_Rooms())){
                query.setParameter("hNumRooms", searchHotel.getNum_Rooms());
            }
            if(!(null == searchHotel.getAddress())){
                query.setParameter("hAddress", searchHotel.getAddress());
            }
            if(!(null == searchHotel.getEmail())){
                query.setParameter("hEmail", searchHotel.getEmail());
            }
            if(!(null == searchHotel.getPhone())){
                query.setParameter("hPhone", searchHotel.getPhone());
            }
                        
        }else{
            //Select all Rooms
            query = em.createQuery("SELECT h FROM Room h");
        }
        return performQuery(query);
    }
    
    private static List<Hotel> performQuery(final Query query) {
        List<Hotel> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<Hotel> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
    
    

}
