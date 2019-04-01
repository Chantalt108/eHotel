/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.SearchRooms;
import beans.ViewAllRoomsBean;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chant
 */
public class RoomDBHelper {
    public static Room findRoom(EntityManager em, int id) {
        Room r = em.find(Room.class, id);
        return r;
    }
    
    public static List<Room> findAllRooms(EntityManager em, ViewAllRoomsBean viewAllRoomsBean){
        String queryString = "SELECT r FROM Room r";
        Query allQuery = em.createQuery(queryString);
        return performQuery(allQuery);
        
    }
    
    public static List<Room> findRoomsWithCriteria(EntityManager em, SearchRooms searchRoom){       
        String initQueryString = "SELECT r FROM Room r";
        String whereClauseConditions = "";
        Query query;
        
        //Set conditions for the WHERE clause of the Query
        
        
        if(!(0 == searchRoom.getROOM_ID())){ //If the room_id field was used by the User
            whereClauseConditions += " r.ROOM_ID = :roomNum";
        }
        if(!(0 == searchRoom.getHOTEL_ID())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.HOTEL_ID = :hotelNum";
        }
        if(!(searchRoom.getPRICE() == 0)){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.PRICE = :rPrice";
        }
        if(!("".equals(searchRoom.getAMENITIES()))){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " r.AMENITIES = :rAmenities";
        }
        
        //To be implemented later time permitting
//        if(!(searchRoom.getCAPACITY() == 0)){
//            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
//            whereClauseConditions += " r.CAPACITY = rCapacity";
//        }
//        if(!("".equals(searchRoom.getOUTSIDE_VIEW()))){
//            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
//            whereClauseConditions += " r.OUTSIDE_VIEW = rOutside_View";
//        }
//        if(!(searchRoom.getEXTENDABLE() == null)){
//            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
//            whereClauseConditions += " r.EXTENDABLE = rExtendable";
//        }
//        if(!("".equals(searchRoom.getPROBLEMS()))){
//            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
//            whereClauseConditions += " r.PROBLEMS = rProblems";
//        }
        
        
        //If there are conditions add the WHERE clause and its conditions 
        if(!"".equals(whereClauseConditions)){
            initQueryString += " WHERE"; 
            initQueryString += whereClauseConditions; 
            query = em.createQuery(initQueryString);
        
            //Set Parameters of the Query
            if(!(0 == searchRoom.getROOM_ID())){
                query.setParameter("roomNum", searchRoom.getROOM_ID());
            }
            if(!(0 == searchRoom.getHOTEL_ID())){
                query.setParameter("hotelNum", searchRoom.getHOTEL_ID());
            }
            if(!(searchRoom.getPRICE() == 0)){
                query.setParameter("rPrice", searchRoom.getPRICE());
            }
            if(!("".equals(searchRoom.getAMENITIES()))){
                query.setParameter("rAmenities", searchRoom.getAMENITIES());
            }
//            if(!(0 == searchRoom.getCAPACITY())){
//                query.setParameter("rCapacity", searchRoom.getCAPACITY());
//            }
//            if(!("".equals(searchRoom.getOUTSIDE_VIEW()))){
//                query.setParameter("rOutside_View", searchRoom.getOUTSIDE_VIEW());
//            }
//            if(!(null == searchRoom.getEXTENDABLE())){
//                query.setParameter("rExtendable", searchRoom.getEXTENDABLE());
//            }
//            if(!("".equals(searchRoom.getPROBLEMS()))){
//                query.setParameter("rProblems", searchRoom.getPROBLEMS());
//            }
            
        }else{
            //Select all Rooms
            query = em.createQuery("SELECT r FROM Room r");
        }
        return performQuery(query);
    }

    public static List<Room> getAllRooms(EntityManager em, String userId){
        String queryString = "SELECT r FROM Room r";
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
