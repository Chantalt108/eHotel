package beans;

/*
 * To change this license header, choose License Headers in Project eHotel.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import enumerators.UserType;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import persistence.UserAccount;

/**
 *
 * @author chant
 */
@ManagedBean
public class MenuView {
 
    private MenuModel model;
 
    @PostConstruct
    public void init() {
        
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        UserAccount user = (UserAccount)session.getAttribute("User");
        
        model = new DefaultMenuModel();
        
        if (user == null) {
          
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("eHotel");
        
        DefaultMenuItem itemIndex = new DefaultMenuItem("Home");
        itemIndex.setOutcome("index");
        firstSubmenu.addElement(itemIndex);
        
        model.addElement(firstSubmenu);
        
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("");
 
        DefaultMenuItem itemAddAccount = new DefaultMenuItem("Add Account");
        itemAddAccount.setOutcome("signIn");
        secondSubmenu.addElement(itemAddAccount);
        
        DefaultMenuItem itemLogin = new DefaultMenuItem("Login");
        itemLogin.setOutcome("login");
        secondSubmenu.addElement(itemLogin);
  
        model.addElement(secondSubmenu);
            
            
        } else if(user.getUserType().equals(UserType.EMPLOYEE)){
            
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("eHotel");
        
        DefaultMenuItem itemIndex = new DefaultMenuItem("Home");
        itemIndex.setOutcome("index");
        firstSubmenu.addElement(itemIndex);
               
//        DefaultMenuItem itemViewAllRooms = new DefaultMenuItem("View All Rooms");
//        itemViewAllRooms.setOutcome("viewAllRooms");
//        firstSubmenu.addElement(itemViewAllRooms);
        
        DefaultMenuItem itemAddRooms = new DefaultMenuItem("Add Rooms");
        itemAddRooms.setOutcome("addRoom");
        firstSubmenu.addElement(itemAddRooms);
        
        DefaultMenuItem itemSearchRooms = new DefaultMenuItem("Search Rooms");
        itemSearchRooms.setOutcome("searchRooms");
        firstSubmenu.addElement(itemSearchRooms);
        
        DefaultMenuItem itemAddBooking = new DefaultMenuItem("Add Booking");
        itemAddBooking.setOutcome("addBooking");
        firstSubmenu.addElement(itemAddBooking);
        
        DefaultMenuItem itemSearchBookings = new DefaultMenuItem("Search Bookings");
        itemSearchBookings.setOutcome("searchBookings");
        firstSubmenu.addElement(itemSearchBookings);
        
        model.addElement(firstSubmenu);
        
        DefaultSubMenu secondSubmenu = new DefaultSubMenu(user.getName() + " - " + user.getUserType());
        
        DefaultMenuItem itemLogout = new DefaultMenuItem("Logout");
        itemLogout.setCommand("#{menuView.logout}");
        secondSubmenu.addElement(itemLogout);
  
        model.addElement(secondSubmenu);
        
                   
        } else if(user.getUserType().equals(UserType.CUSTOMER)){
            
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("eHotel");
        
        DefaultMenuItem itemIndex = new DefaultMenuItem("Home");
        itemIndex.setOutcome("index");
        firstSubmenu.addElement(itemIndex);
               
        DefaultMenuItem itemSearchRooms = new DefaultMenuItem("Search Rooms");
        itemSearchRooms.setOutcome("searchRooms");
        firstSubmenu.addElement(itemSearchRooms);
                
        model.addElement(firstSubmenu);
        
        
        DefaultSubMenu secondSubmenu = new DefaultSubMenu(user.getName() + " - " + user.getUserType());
        
        DefaultMenuItem itemLogout = new DefaultMenuItem("Logout");
        itemLogout.setCommand("#{menuView.logout}");
        secondSubmenu.addElement(itemLogout);
  
        model.addElement(secondSubmenu);
   
        }

    }
 
    public MenuModel getModel() {
        return model;
    }
 
    public String logout() {
        // invalidate session to remove User
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        // navigate to index - see faces-config.xml for navigation rules
        return "index?faces-redirect=true";
    }
 
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}