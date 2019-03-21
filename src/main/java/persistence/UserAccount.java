/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import enumerators.UserType;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author chant
 */
@Entity
@Table(name="UserAccount")
public class UserAccount implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    private String userId;
    private String address;
    private int ssn;
    private UserType userType;
    private String name;
    //private Date registrationDate;
    @Lob
    private byte[] password; // salted + hashed password
    @Lob
    private byte[] salt; // the salt used for this account
    
//    @ManyToMany(cascade = { 
//        CascadeType.PERSIST, 
//        CascadeType.MERGE
//    })
//    @JoinTable(name = "UserAccount_Property",
//        joinColumns = @JoinColumn(name = "userId"),
//        inverseJoinColumns = @JoinColumn(name = "propertyId")
//    )
//    private Set<Property> properties = new HashSet<>();
//    
//    public void addProperty(Property property){
//        properties.add(property);
//        property.getUsers().add(this);
//    } 
//    
//    public void removeProperty(Property property){
//        properties.remove(property);
//        property.getUsers().remove(this);
//    } 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getUserId() != null ? getUserId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.getUserId() == null && other.getUserId() != null) || (this.getUserId() != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.UserAccount[ id=" + userId + " ]";
    }

     public String getUserId() {
        return userId;
    }
        
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
        public UserType getUserType() {
        return userType;
    }
    
     public void setUserType(UserType userType) {
        this.userType = userType;
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

//    /**
//     * @return the birthDate
//     */
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
     * @return the password
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }
    
        /**
     * @return the salt
     */
    public byte[] getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

//    /**
//     * @return the visitingList
//     */
//    public Set getProperties() {
//        return properties;
//    }
//
//    /**
//     * @param visitingList the visitingList to set
//     */
//    public void setProperties(Set properties) {
//        this.properties = properties;
//    }
    
}
