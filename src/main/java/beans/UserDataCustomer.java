/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import persistence.UserCustomer;

/**
 *
 * @author chant
 */
@Named(value = "userDataCustomer")
@RequestScoped
public class UserDataCustomer {
    private String id;
    private String name;
    private String address;
    private int ssn;
    private Date registrationDate;
    private String password;
    private String addstatus;
    private List<UserCustomer> lookupResults;
    
    
    /**
     * Creates a new instance of UserData
     */
    public UserDataCustomer() {
    }
    
//    public Date getRegistrationDate() {
//        return registrationDate;
//    }
//
//    /**
//     * @param registrationDate the registrationDate to set
//     */
//    public void setRegistrationDate(Date registrationDate) {
//        this.registrationDate = registrationDate;
//    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @return the password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * @return the ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    
       
    public String getAddstatus() {
        return addstatus;
    }

    public void setAddstatus(String addstatus) {
        this.addstatus = addstatus;
    }

    public void setLookupResults(List<UserCustomer> results) {
        this.lookupResults = results;
    }
    
    public List<UserCustomer> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }
}
