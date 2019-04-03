/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author chant
 */
@Entity
@Table(name="HotelChains")
public class HotelChain implements Serializable {
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
    private int chain_id;
    private String office_address;
    private int num_hotels;
    private String email;
    private String phone;

    public HotelChain() {
        
    }
    
    public HotelChain(int chain_id, String office_address, 
            int num_hotels, String email, String phone) {
        this.chain_id = chain_id;
        this.office_address = office_address;
        this.num_hotels = num_hotels;
        this.email = email;
        this.phone = phone;
        }
    
    @Override
    public String toString() {
        return "model.Chain[ chain_id=" + chain_id + " ]";
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
     * @return the office_address
     */
    public String getOffice_Address() {
        return office_address;
    }

    /**
     * @param office_address the office_address to set
     */
    public void setOffice_Address(String office_address) {
        this.office_address = office_address;
    }
    
    /**
     * @return the num_hotels
     */
    public int getNum_Hotels() {
        return num_hotels;
    }

    /**
     * @param num_hotels the num_hotels to set
     */
    public void setNum_Hotels(int num_hotels) {
        this.num_hotels = num_hotels;
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
