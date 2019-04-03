/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.EditBookings;
import beans.SearchBookings;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author chant
 */
public class BookingDBHelper {
    public static Booking findBooking(EntityManager em,String id) {
        Booking h = em.find(Booking.class, id);
        return h;
    }
    
    public static void addToBooking(UserTransaction utx, EntityManager em, int roomId){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserAccount user = (UserAccount) session.getAttribute("User");
        user.addRoom(RoomDBHelper.findRoom(em, roomId));
        merge(user, utx, em);
    }
    
    public static void merge(Object object, UserTransaction utx, EntityManager em) {
        try {
            utx.begin();
            em.merge(object);
            utx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static List<Booking> editBookingsWithCriteria(EntityManager em, EditBookings editBooking){
        //String initQueryString = "SELECT b FROM Booking b WHERE b.booking_id = :bookingNum";
        //Query querySet;
//        Query querySet = em.createQuery("UPDATE PUBLIC.BOOKINGS b SET b.is_renting = :boolTrue WHERE b.is_renting = :boolFalse"); 
        Query querySet = em.createQuery("UPDATE PUBLIC.BOOKINGS b SET b.is_renting = "
                + "CASE b.is_renting "
                + "WHEN FALSE THEN TRUE "
                + "ELSE FALSE END "
                + "WHERE b.booking_id in :bookingNum"); 
                
        querySet.setParameter("boolTrue", true)
                .setParameter("boolFalse", false)
                .setParameter("bookingNum", editBooking.getBooking_Id()).executeUpdate();  
        
        
        //Query queryReturn = em.createQuery("SELECT b FROM Booking b WHERE b.booking_id = :bookingNum");
        return performQuery(querySet);
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
            query = em.createQuery("SELECT b FROM Room b");
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
