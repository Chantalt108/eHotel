/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.SearchBookings;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chant
 */
public class BookingDBHelper {
    public static Booking findBooking(EntityManager em,String id) {
        Booking h = em.find(Booking.class, id);
        return h;
    }
    
    
    public static List<Booking> findBookingsWithCriteria(EntityManager em, SearchBookings searchBooking){
        String initQueryString = "SELECT b FROM Booking b";
        String whereClauseConditions = "";
        Query query;
        
        //Set conditions for the WHERE clause of the Query
        
        
        if(!(0 == searchBooking.getBooking_Id())){ //If the booking_id field was used by the User
            whereClauseConditions += " b.booking_id = :bookingNum";
        }
        if(!(null == searchBooking.getCheckin_Date())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " b.checkin_date = :checkinDate";
        }
        if(!(null == searchBooking.getCheckout_Date())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " b.checkout_date = :checkoutDate";
        }
        if(!(null == searchBooking.getIs_Renting())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " b.is_renting = :isRentingBool";
        }
        if(!(0 == searchBooking.getRoom_Id())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " b.room_id = :roomIdNum";
        }
        if(!(0 == searchBooking.getCust_Id())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " b.cust_id = :custIdNum";
        }
        if(!(0 == searchBooking.getEmp_Id())){
            if(!"".equals(whereClauseConditions)){whereClauseConditions += " AND";} //If a Condition has been added already
            whereClauseConditions += " b.emp_id = :empIdNum";
        }
        
        //If there are conditions add the WHERE clause and its conditions 
        if(!"".equals(whereClauseConditions)){
            initQueryString += " WHERE"; 
            initQueryString += whereClauseConditions; 
            query = em.createQuery(initQueryString);
        
            //Set Parameters of the Query
            if(!(0 == searchBooking.getBooking_Id())){
                query.setParameter("bookingNum", searchBooking.getBooking_Id());
            }
            if(!(null == searchBooking.getCheckin_Date())){
                query.setParameter("checkinDate", searchBooking.getCheckin_Date());
            }
            if(!(null == searchBooking.getCheckout_Date())){
                query.setParameter("checkoutDate", searchBooking.getCheckout_Date());
            }
            if(!(null == searchBooking.getIs_Renting())){
                query.setParameter("isRentingBool", searchBooking.getIs_Renting());
            }
            if(!(0 == searchBooking.getRoom_Id())){
                query.setParameter("roomIdNum", searchBooking.getRoom_Id());
            }
            if(!(0 == searchBooking.getCust_Id())){
                query.setParameter("custIdNum", searchBooking.getCust_Id());
            }
            if(!(0 == searchBooking.getEmp_Id())){
                query.setParameter("empIdNum", searchBooking.getEmp_Id());
            }
            
                        
        }else{
            //Select all Rooms
            query = em.createQuery("SELECT h FROM Room h");
        }
        return performQuery(query);
    }
    
    private static List<Booking> performQuery(final Query query) {
        List<Booking> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<Booking> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
    
    

}
