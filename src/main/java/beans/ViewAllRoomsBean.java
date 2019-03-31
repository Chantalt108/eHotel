/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import persistence.Room;
import persistence.RoomDBHelper;
import persistence.UserAccount;

/**
 *
 * @author Nick
 */
@Named(value = "ownerViewProperties")
@SessionScoped
public class ViewAllRoomsBean implements Serializable {

    @PersistenceContext(unitName = "CSI2132_eHotel_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    /**
     * Creates a new instance of ViewAllRoomsBean
     */
    public ViewAllRoomsBean() {
    }
    
    public void onload(){
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        SearchRooms searchRooms = (SearchRooms) elContext.getELResolver().getValue(elContext, null, "searchRooms");
        try {
         ArrayList<Room> properties = new ArrayList<>(RoomDBHelper.findAllRooms(em, this));
            searchRooms.setLookupResults(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
