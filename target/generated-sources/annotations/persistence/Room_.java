package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-27T14:03:48")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, Integer> room_id;
    public static volatile SingularAttribute<Room, String> amenities;
    public static volatile SingularAttribute<Room, Integer> price;
    public static volatile SingularAttribute<Room, Integer> hotel_id;
    public static volatile SingularAttribute<Room, String> outside_view;
    public static volatile SingularAttribute<Room, Boolean> extendable;
    public static volatile SingularAttribute<Room, Integer> capacity;
    public static volatile SingularAttribute<Room, String> problems;

}