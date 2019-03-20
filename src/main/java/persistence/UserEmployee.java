/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import enumerators.UserType;
import beans.UserDataEmployee;
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
@Table(name="UserDataEmployee")
public class UserEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    
     @Id
    private String USER_ID;
    private String NAME;
    private String ADDRESS;
    private int SSN;
    private String JOB_POSITION;
    private String PASSWORD;
    
    /** Creates a new instance of User */
    public UserEmployee() {
      
    }
    public UserEmployee(String id, String name, String address, int ssn, String job_position, String password) {
        this.USER_ID = id;
        this.PASSWORD = password;
        this.NAME = name;
        this.ADDRESS = address;
        this.SSN = ssn;
        this.JOB_POSITION = job_position;
    }
    
    public String getPASSWORD(){
        return PASSWORD;
    }
    
    public void setPASSWORD(String password){
        this.PASSWORD = password;
    }
    
    public String getJOB_POSITION(){
        return JOB_POSITION;
    }
    
    public void setJOB_POSITION(String job_position){
        this.JOB_POSITION = job_position;
    }
    
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
        if (!(object instanceof UserEmployee)) {
            return false;
        }
        UserEmployee other = (UserEmployee)object;
        return (this.USER_ID.equals(other.USER_ID));
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.User[id=" + USER_ID + "]";
    }

    /**
     * 
     * @param userDataEmployee
     * @return true if this User matches the userDataEmployee bean
     */
    public boolean matches(UserDataEmployee userDataEmployee) {
        if (!"".equals(userDataEmployee.getId()) && !this.getUSER_ID().trim().equals(userDataEmployee.getId().trim())) {
            return false;
        } else if (!"".equals(userDataEmployee.getName()) && !this.getNAME().trim().equals(userDataEmployee.getName().trim())) {
                return false;
        }
        return true;
    }
    
}
