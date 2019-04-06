/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import beans.EditUsers;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistence.Room;

/**
 *
 * @author chant
 */
public class UserDBHelper {
   
    public static List<UserAccount> deleteUserAccount(EntityManager em, EditUsers editUser){
        Query query = em.createNativeQuery("DELETE FROM USERACCOUNT "
                + "WHERE USERID = " + editUser.getUserId());
        
        return performQuery(query);
    }
    
    public static List<UserAccount> deleteUserEmployee(EntityManager em, EditUsers editUser){
        Query query = em.createNativeQuery("DELETE FROM EMPLOYEE "
                + "WHERE USERID = " + editUser.getUserId());
        
        return performQuery(query);
    }
    
    public static List<UserAccount> deleteUserCustomer(EntityManager em, EditUsers editUser){
        Query query = em.createNativeQuery("DELETE FROM CUSTOMER "
                + "WHERE USERID = " + editUser.getUserId());
        
        return performQuery(query);
    }
    
    private static List<UserAccount> performQuery(final Query query) {
        List<UserAccount> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<UserAccount> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
    
}
