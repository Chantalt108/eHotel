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
@Table(name="Rooms")
public class Room implements Serializable {
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
    private int room_id;
    private int hotel_id;
    private int price;
    private String amenities;
    private int capacity;
    private String outside_view;
    private Boolean extendable;
    private String problems;
    
//    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name="PROPERTY_ADDRESS",
//            referencedColumnName="id")
//    private Address address;
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, 
//            mappedBy="property")
//    private Collection<Image> pictures;
//    @ManyToMany(mappedBy = "properties")
//    private Set<UserAccount> users = new HashSet<>();
    
    
    public Room() {
        
    }
    
    public Room(int room_id, int hotel_id, int price, 
            String amenities, int capacity, String outside_view, Boolean extendable,
            String problems) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.price = price;
        this.amenities = amenities;
        this.capacity = capacity;
        this.outside_view = outside_view;
        this.extendable = extendable;
        this.problems = problems;
     }
    
    public int getRoom_Id() {
        return room_id;
    }

    public void setroom_id(int room_id) {
        this.room_id = room_id;
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
        return "model.Property[ room_id=" + room_id + " ]";
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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the amenities
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * @param amenities the amenities to set
     */
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * @return the outside_view
     */
    public String getOutside_View() {
        return outside_view;
    }

    /**
     * @param outside_view the outside_view to set
     */
    public void setOutside_View(String outside_view) {
        this.outside_view = outside_view;
    }

    /**
     * @return the extendable
     */
    public Boolean getExtendable() {
      return extendable;
    }

    /**
     * @param extendable the extendable to set
     */
    public void setExtendable(Boolean extendable) {
        this.extendable = extendable;
    }

  /**
   * @return the problems
   */
    public String getProblems() {
        return problems;
    }

    /**
     * @param problems the problems to set
     */
    public void setProblems(String problems) {
        this.problems = problems;
    }

  
    
}
