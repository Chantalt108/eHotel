/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import enumerators.UserType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
/**
 *
 * @author chant
 */
@Named(value = "typeBean")
@RequestScoped
public class TypeBean {
    private UserType userType;
    private String status;
    
    public TypeBean(){
        
    }
    
    public UserType[] getUserTypes() {
        return UserType.values();
    }
    
    /**
     * @return the userType message
     */
    public UserType getUserType(){
        return userType;
    }
    
    public void setUserType(UserType userType){
        this.userType = userType;
    }
    
    /**
     * @return the status message
     */
    public String getStatus() {
        return status;
    }
    
    public String addUserPage(){
        if(userType == userType.EMPLOYEE){
            return ("addEmployee?faces-redirect=true");
        }
        
        return ("addCustomer?faces-redirect=true");
    }
    
}
