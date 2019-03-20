/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import beans.UserDataEmployee;
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
public class DBHelperEmployee {
    
    
    
    public static UserEmployee findUser(EntityManager em,String id) {
        UserEmployee u = em.find(UserEmployee.class, id);
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
        ArrayList<UserEmployee> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }

   public static boolean addUserEmployee(EntityManager em, UserTransaction utx, UserDataEmployee userDataEmployee) {
        try {
            utx.begin();
            UserEmployee employeeAcc = new UserEmployee();
            employeeAcc.setUSER_ID(userDataEmployee.getId());
            employeeAcc.setADDRESS(userDataEmployee.getAddress());
            employeeAcc.setJOB_POSITION(userDataEmployee.getJob_Position());
            employeeAcc.setNAME(userDataEmployee.getName());  
            employeeAcc.setPASSWORD(userDataEmployee.getPassword());      
            employeeAcc.setSSN(userDataEmployee.getSsn());
            em.persist(employeeAcc);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
