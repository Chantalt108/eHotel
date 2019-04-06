/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author chant
 */
@Entity
@Immutable
@Table(name="VIEW1")
public class View1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int room_id;
    private int hotel_id;
    private int area;

    public View1() {
    }
    
    public View1(int room_id, int hotel_id, int area){
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.area = area;
    }
    
    
    
    public int getRoom_Id() {
        return room_id;
    }

    public void setRoom_Id(int room_id) {
        this.room_id = room_id;
    }
    
    public int getHotel_Id() {
        return hotel_id;
    }

    public void setHotel_Id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) room_id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof View1)) {
            return false;
        }
        View1 other = (View1) object;
        if (this.room_id != other.room_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.View1[ id=" + room_id + " ]";
    }
    
}
