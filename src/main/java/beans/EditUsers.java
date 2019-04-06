/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import persistence.Room;
import persistence.RoomDBHelper;
import persistence.UserAccount;
import persistence.UserDBHelper;

/**
 *
 * @author chant
 */
@Named("editUsers")
@RequestScoped
public class EditUsers implements Serializable{
    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Inject
    UserTransaction ut;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    List<UserAccount> lookupResults;
    private Boolean foundNoResults;
    private Boolean noCriteria;
    
    private String userId;
    
    public String getUserId() {
        return userId;
    }
        
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String doDeleteUser() {
       if(null == getUserId()){
            setNoCriteria(true);
            return(null);
       }
       
       try{
            List<UserAccount> results = UserDBHelper.deleteUserAccount(em, this);
            setLookupResults(results);
            if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
                setNoCriteria(false);
                
            List<UserAccount> resultsEmployee = UserDBHelper.deleteUserEmployee(em, this);
            setLookupResults(results);
            if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
                setNoCriteria(false);
                
            List<UserAccount> resultsCustomer = UserDBHelper.deleteUserCustomer(em, this);
            setLookupResults(results);
            if(results == null || results.isEmpty()){setFoundNoResults((Boolean) true);}
                setNoCriteria(false);
       }
       catch(Exception e){
       return("index");
       }
       return ("index");
    }
    
    public void setLookupResults(List<UserAccount> results) {
        this.lookupResults = results;
    }
    
    public List<UserAccount> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }

    /**
     * @return the foundNoResults
     */
    public Boolean getFoundNoResults() {
        return foundNoResults;
    }
    
    /**
     * @param foundNoResults the foundNoResults to set
     */
    public void setFoundNoResults(Boolean foundNoResults) {
        this.foundNoResults = foundNoResults;
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }

    /**
     * @return the noCriteria
     */
    public Boolean getNoCriteria() {
        return noCriteria;
    }

    /**
     * @param noCriteria the noCriteria to set
     */
    public void setNoCriteria(Boolean noCriteria) {
        this.noCriteria = noCriteria;
    }
}
