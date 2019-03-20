/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.UserDataCustomer;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author chant
 */
public class DBHelperCustomer {
    
    
    
    public static UserCustomer findUser(EntityManager em,String id) {
        UserCustomer u = em.find(UserCustomer.class, id);
        return u;
    }
    
    public static List findUsersByName(EntityManager em,String name) {
        Query query = em.createQuery(
                "SELECT u FROM User u" +
                " WHERE u.NAME = :userName");
        query.setParameter("userName",name);
        return performQuery(query);
    }
    
    private static List performQuery(final Query query) {
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<UserCustomer> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }

   public static boolean addUserCustomer(EntityManager em, UserTransaction utx, UserDataCustomer userDataCustomer) {
        try {
            utx.begin();
            UserCustomer CustomerAcc = new UserCustomer();
            CustomerAcc.setUSER_ID(userDataCustomer.getId());
            CustomerAcc.setADDRESS(userDataCustomer.getAddress());
            CustomerAcc.setNAME(userDataCustomer.getName());
            //CustomerAcc.setREGISTRATION_DATE(userDataCustomer.getRegistrationDate());
            CustomerAcc.setPASSWORD(userDataCustomer.getPassword());      
            CustomerAcc.setSSN(userDataCustomer.getSsn());
            em.persist(CustomerAcc);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
