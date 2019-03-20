/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import enumerators.UserType;
import beans.UserDataCustomer;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author chant
 */
@Entity
@Table(name="UserDataCustomer")
public class UserCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    
     @Id
    private String USER_ID;
    private String NAME;
    private String PASSWORD;
    private String ADDRESS;
    private int SSN;
    //private Date REGISTRATION_DATE;
    
    /** Creates a new instance of User */
    public UserCustomer() {
      
    }
    public UserCustomer(String id, String name, String address, int ssn, Date registration_date, String password) {
        this.USER_ID = id;
        this.NAME = name;
        this.ADDRESS = address;
        this.SSN = ssn;
        this.PASSWORD = password;
        //this.REGISTRATION_DATE = registration_date;
    }
    
    
//    public Date getREGISTRATION_DATE() {
//       return  REGISTRATION_DATE;
//    }
//    
//    public void setREGISTRATION_DATE(Date registration_date) {
//        this.REGISTRATION_DATE = registration_date;
//    }
    
    
    public int getSSN(){
        return SSN;
    }
    
    public void setSSN(int ssn){
        this.SSN = ssn;
    }
    
    public String getADDRESS(){
        return ADDRESS;
    }
    
    public void setADDRESS(String address){
        this.ADDRESS = address;
    }
    
    public String getPASSWORD(){
        return PASSWORD;
    }
    
    public void setPASSWORD(String password){
        this.PASSWORD = password;
    }
    
    public String getUSER_ID() {
        return USER_ID;
    }

    public String getNAME() {
        return NAME;
    }
        
    public void setUSER_ID(String id) {
        this.USER_ID = id;
    }
    
    public void setNAME(String name) {
        this.NAME = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.USER_ID.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCustomer)) {
            return false;
        }
        UserCustomer other = (UserCustomer)object;
        return (this.USER_ID.equals(other.USER_ID));
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.User[id=" + USER_ID + "]";
    }

    /**
     * 
     * @param userDataCustomer
     * @return true if this User matches the userDataCustomer bean
     */
    public boolean matches(UserDataCustomer userDataCustomer) {
        if (!"".equals(userDataCustomer.getId()) && !this.getUSER_ID().trim().equals(userDataCustomer.getId().trim())) {
            return false;
        } else if (!"".equals(userDataCustomer.getName()) && !this.getNAME().trim().equals(userDataCustomer.getName().trim())) {
                return false;
        }
        return true;
    }
    
}
