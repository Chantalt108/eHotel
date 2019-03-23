/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.SearchRooms;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chant
 */
public class RoomDBHelper {
    public static Room findRoom(EntityManager em,String id) {
        Room r = em.find(Room.class, id);
        return r;
    }
    
    
    public static List<Room> findRoomsWithCriteria(EntityManager em, SearchRooms searchRoom){
        String initQueryString = "SELECT r FROM Room r";
        String whereClauseConditions = "";
        Query query;
        
        //Set conditions for the WHERE clause of the Query
        
        
        if(!(0 == searchRoom.getRoom_Id())){ //If the room_id field was used by the User
            whereClauseConditions += " r.room_id = :roomNum";
        }
        if(!(0 == searchRoom.getHotel_Id())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.hotel_id = :hotelNum";
        }
        if(!(searchRoom.getPrice() == 0)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.price = :rPrice";
        }
        if(!(searchRoom.getAmenities() == null)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.amenities = :rAmenities";
        }
        if(!(searchRoom.getCapacity() == 0)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.capacity = rCapacity";
        }
        if(!(searchRoom.getOutside_View() == null)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.outside_view = rOutside_View";
        }
//        if(!(searchRoom.getExtendable() == null)){
//            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
//            whereClauseConditions += " r.extendable = rExtendable";
//        }
//        if(!(searchRoom.getProblems() == null)){
//            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
//            whereClauseConditions += " r.problems = rProblems";
//        }
        
        
        //If there are conditions add the WHERE clause and its conditions 
        if(!"".equals(whereClauseConditions)){
            initQueryString += " WHERE"; 
            initQueryString += whereClauseConditions; 
            query = em.createQuery(initQueryString);
        
            //Set Parameters of the Query
            if(!(0 == searchRoom.getRoom_Id())){
                query.setParameter("roomNum", searchRoom.getRoom_Id());
            }
            if(!(0 == searchRoom.getHotel_Id())){
                query.setParameter("hotelNum", searchRoom.getHotel_Id());
            }
            if(!(searchRoom.getPrice() == 0)){
                query.setParameter("rPrice", searchRoom.getPrice());
            }
            if(!(null == searchRoom.getAmenities())){
                query.setParameter("rAmenities", searchRoom.getAmenities());
            }
            if(!(0 == searchRoom.getCapacity())){
                query.setParameter("rCapacity", searchRoom.getCapacity());
            }
            if(!(null == searchRoom.getOutside_View())){
                query.setParameter("rOutside_view", searchRoom.getOutside_View());
            }
//            if(!(null == searchRoom.getExtendable())){
//                query.setParameter("rExtendable", searchRoom.getExtendable());
//            }
//            if(!(null == searchRoom.getProblems())){
//                query.setParameter("rProblems", searchRoom.getProblems());
//            }
            
        }else{
            //Select all Properties
            query = em.createQuery("SELECT r FROM Room r");
        }
        return performQuery(query);
    }

    public static List<Room> getEmployeeRooms(EntityManager em, String userId){
        String queryString = "SELECT r FROM Property r WHERE r.employeeId = '" + userId +"'";
        Query ownerQuery = em.createQuery(queryString);
        return performQuery(ownerQuery);
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
