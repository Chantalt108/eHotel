package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.UserAccount;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-31T23:39:56")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, Integer> CAPACITY;
    public static volatile SingularAttribute<Room, Integer> ROOM_ID;
    public static volatile SingularAttribute<Room, Integer> PRICE;
    public static volatile SingularAttribute<Room, String> PROBLEMS;
    public static volatile SingularAttribute<Room, String> OUTSIDE_VIEW;
    public static volatile SingularAttribute<Room, String> AMENITIES;
    public static volatile SingularAttribute<Room, Boolean> EXTENDABLE;
    public static volatile SingularAttribute<Room, Integer> HOTEL_ID;
    public static volatile SetAttribute<Room, UserAccount> users;

}