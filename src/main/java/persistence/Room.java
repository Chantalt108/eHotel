/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author chant
 */
@Entity
@Table(name="ROOMS")
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
    private int ROOM_ID;
//    @ManyToOne
//    @JoinColumn(name = "HOTEL_ID")
    private int HOTEL_ID;
    private int PRICE;
    private String AMENITIES;
    private int CAPACITY;
    private String OUTSIDE_VIEW;
    private Boolean EXTENDABLE;
    private String PROBLEMS;
    @ManyToMany(mappedBy = "rooms")
    private Set<UserAccount> users = new HashSet<>();
    
    public Room() {
        
    }
    
    public Room(int ROOM_ID, int HOTEL_ID, int PRICE, 
            String AMENITIES, int CAPACITY, String OUTSIDE_VIEW, Boolean EXTENDABLE,
            String PROBLEMS) {
        this.ROOM_ID = ROOM_ID;
        this.HOTEL_ID = HOTEL_ID;
        this.PRICE = PRICE;
        this.AMENITIES = AMENITIES;
        this.CAPACITY = CAPACITY;
        this.OUTSIDE_VIEW = OUTSIDE_VIEW;
        this.EXTENDABLE = EXTENDABLE;
        this.PROBLEMS = PROBLEMS;
     }
    
    /**
     * @return the users
     */
    public Set<UserAccount> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<UserAccount> users) {
        this.users = users;
    }
    
    public int getROOM_ID() {
        return ROOM_ID;
    }

    public void setROOM_ID(int ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

    @Override
    public String toString() {
        return "model.Room[ ROOM_ID=" + ROOM_ID + " ]";
    }

    /**
     * @return the HOTEL_ID
     */
    public int getHOTEL_ID() {
        return HOTEL_ID;
    }

    /**
     * @param HOTEL_ID the HOTEL_ID to set
     */
    public void setHOTEL_ID(int HOTEL_ID) {
        this.HOTEL_ID = HOTEL_ID;
    }

    /**
     * @return the PRICE
     */
    public int getPRICE() {
        return PRICE;
    }

    /**
     * @param PRICE the PRICE to set
     */
    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    /**
     * @return the AMENITIES
     */
    public String getAMENITIES() {
        return AMENITIES;
    }

    /**
     * @param AMENITIES the AMENITIES to set
     */
    public void setAMENITIES(String AMENITIES) {
        this.AMENITIES = AMENITIES;
    }

    /**
     * @return the CAPACITY
     */
    public int getCAPACITY() {
        return CAPACITY;
    }

    /**
     * @param CAPACITY the CAPACITY to set
     */
    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }
    
    /**
     * @return the OUTSIDE_VIEW
     */
    public String getOUTSIDE_VIEW() {
        return OUTSIDE_VIEW;
    }

    /**
     * @param OUTSIDE_VIEW the OUTSIDE_VIEW to set
     */
    public void setOUTSIDE_VIEW(String OUTSIDE_VIEW) {
        this.OUTSIDE_VIEW = OUTSIDE_VIEW;
    }

    /**
     * @return the EXTENDABLE
     */
    public Boolean getEXTENDABLE() {
      return EXTENDABLE;
    }

    /**
     * @param EXTENDABLE the EXTENDABLE to set
     */
    public void setEXTENDABLE(Boolean EXTENDABLE) {
        this.EXTENDABLE = EXTENDABLE;
    }

  /**
   * @return the PROBLEMS
   */
    public String getPROBLEMS() {
        return PROBLEMS;
    }

    /**
     * @param PROBLEMS the PROBLEMS to set
     */
    public void setPROBLEMS(String PROBLEMS) {
        this.PROBLEMS = PROBLEMS;
    }

  
    
}
