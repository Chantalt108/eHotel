/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author chant
 */
@Entity
@Table(name="Hotels")
public class Hotel implements Serializable {
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hotel_id;
    private int chain_id;
    private int rating;
    private int num_rooms;
    private String address;
    private String email;
    private String phone;
    
//    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name="PROPERTY_ADDRESS",
//            referencedColumnName="id")
//    private Address address;
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, 
//            mappedBy="property")
//    private Collection<Image> pictures;
//    @ManyToMany(mappedBy = "properties")
//    private Set<UserAccount> users = new HashSet<>();
    
    
    public Hotel() {
        
    }
    
    public Hotel(int hotel_id, int chain_id, int rating, 
            int num_rooms, String address, String email, String phone) {
        this.hotel_id = hotel_id;
        this.chain_id = chain_id;
        this.rating = rating;
        this.num_rooms = num_rooms;
        this.address = address;
        this.email = email;
        this.phone = phone;
        }
    
    //    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (room_id != null ? room_id.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Room)) {
//            return false;
//        }
//        Room other = (Room) object;
//        if ((this.room_id == null && other.room_id != null) || (this.room_id != null && !this.room_id.equals(other.room_id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "model.Property[ room_id=" + hotel_id + " ]";
    }

    /**
     * @return the hotel_id
     */
    public int getHotel_Id() {
        return hotel_id;
    }

    /**
     * @param hotel_id the hotel_id to set
     */
    public void setHotel_Id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
     /**
     * @return the chain_id
     */
    public int getChain_Id() {
        return chain_id;
    }

    /**
     * @param chain_id the chain_id to set
     */
    public void setChain_Id(int chain_id) {
        this.chain_id = chain_id;
    }

     /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /**
     * @return the num_rooms
     */
    public int getNum_Rooms() {
        return num_rooms;
    }

    /**
     * @param num_rooms the num_rooms to set
     */
    public void setNum_Rooms(int num_rooms) {
        this.num_rooms = num_rooms;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the phone
     */
    public String getPhone(){
        return phone;
    }
    
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone){
        this.phone = phone;
    }


  
    
}
