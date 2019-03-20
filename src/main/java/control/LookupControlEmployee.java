/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import beans.UserDataEmployee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.DBHelperEmployee;
import persistence.UserEmployee;

/**
 *
 * @author chant
 */
@Named(value = "lookupControlEmployee")
@RequestScoped
public class LookupControlEmployee implements Serializable {
    @Inject
    private UserDataEmployee userDataEmployee;
    
    @PersistenceContext
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    /**
     * Creates a new instance of LookupControl
     */
    public LookupControlEmployee() {
    }
    public void lookup() {
       List<UserEmployee> resultsEmployee = new ArrayList();
       if (!"".equals(userDataEmployee.getId())) {
            // lookup by id
            resultsEmployee = getUserById(em,userDataEmployee);
       } else if (!"".equals(userDataEmployee.getName())) {
            // lookup by name
            resultsEmployee = getUsersByName(em,userDataEmployee);

       }
       userDataEmployee.setLookupResults(resultsEmployee);
    }
    public void addEmployee() {
        if (DBHelperEmployee.addUserEmployee(em,utx,userDataEmployee)) {
            userDataEmployee.setAddstatus("The User Was Successfuly Added");
        } else {
            userDataEmployee.setAddstatus("Addition of the User Failed");
        }
    }
    
        /**
     * Find a user by id and check if any that the other fields are valid
     */
    private List<UserEmployee> getUserById(EntityManager em,UserDataEmployee userDataEmployee) {
        ArrayList<UserEmployee> result = new ArrayList<>();
        UserEmployee user = DBHelperEmployee.findUser(em,userDataEmployee.getId());
        if (user != null && user.matches(userDataEmployee)) {
            result.add(user);  
        }
        return result;
    }

    private List<UserEmployee> getUsersByName(EntityManager em,UserDataEmployee userDataEmployee) {
       List<UserEmployee> allresults = DBHelperEmployee.findUsersByName(em,userDataEmployee.getName());
       if (allresults == null) return null;
       return checkResults(allresults,userDataEmployee);          
    }

//    private List getUsersByBirthDate(EntityManager em,userDataEmployee userDataEmployee) {
//       List<User> allresults = DBHelper.findUsersByBirthDate(em,userDataEmployee.getBirthdate());
//       if (allresults == null) return null;
//       return checkResults(allresults,userDataEmployee);       
//    }
    
    private List<UserEmployee> checkResults(List<UserEmployee> allresults,UserDataEmployee userDataEmployee) {
        ArrayList<UserEmployee> results = new ArrayList<>();
        for (UserEmployee user: allresults) {
            if (user.matches(userDataEmployee)) results.add(user);
        }
        return results;
    }
}
