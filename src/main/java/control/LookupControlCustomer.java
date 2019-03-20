/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import beans.UserDataCustomer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.DBHelperCustomer;
import persistence.UserCustomer;

/**
 *
 * @author chant
 */
@Named(value = "lookupControlCustomer")
@RequestScoped
public class LookupControlCustomer implements Serializable {
    @Inject
    private UserDataCustomer userDataCustomer;
    
    @PersistenceContext
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    /**
     * Creates a new instance of LookupControl
     */
    public LookupControlCustomer() {
    }
    public void lookup() {
       List<UserCustomer> resultsCustomer = new ArrayList();
       if (!"".equals(userDataCustomer.getId())) {
            // lookup by id
            resultsCustomer = getUserById(em,userDataCustomer);
       } else if (!"".equals(userDataCustomer.getName())) {
            // lookup by name
            resultsCustomer = getUsersByName(em,userDataCustomer);
       }
       userDataCustomer.setLookupResults(resultsCustomer);
    }
    public void addCustomer() {
        if (DBHelperCustomer.addUserCustomer(em,utx,userDataCustomer)) {
            userDataCustomer.setAddstatus("The User Was Successfuly Added");
        } else {
            userDataCustomer.setAddstatus("Addition of the User Failed");
        }
    }
    
        /**
     * Find a user by id and check if any that the other fields are valid
     */
    private List<UserCustomer> getUserById(EntityManager em,UserDataCustomer userDataCustomer) {
        ArrayList<UserCustomer> result = new ArrayList<>();
        UserCustomer user = DBHelperCustomer.findUser(em,userDataCustomer.getId());
        if (user != null && user.matches(userDataCustomer)) {
            result.add(user);  
        }
        return result;
    }

    private List<UserCustomer> getUsersByName(EntityManager em,UserDataCustomer userDataCustomer) {
       List<UserCustomer> allresults = DBHelperCustomer.findUsersByName(em,userDataCustomer.getName());
       if (allresults == null) return null;
       return checkResults(allresults,userDataCustomer);          
    }

   
    private List<UserCustomer> checkResults(List<UserCustomer> allresults,UserDataCustomer userDataCustomer) {
        ArrayList<UserCustomer> results = new ArrayList<>();
        for (UserCustomer user: allresults) {
            if (user.matches(userDataCustomer)) results.add(user);
        }
        return results;
    }
}
