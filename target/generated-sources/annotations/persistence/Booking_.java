package persistence;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-29T15:18:54")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Integer> booking_id;
    public static volatile SingularAttribute<Booking, Integer> room_id;
    public static volatile SingularAttribute<Booking, Boolean> is_renting;
    public static volatile SingularAttribute<Booking, Date> checkin_date;
    public static volatile SingularAttribute<Booking, Integer> cust_id;
    public static volatile SingularAttribute<Booking, Date> checkout_date;
    public static volatile SingularAttribute<Booking, Integer> emp_id;

}