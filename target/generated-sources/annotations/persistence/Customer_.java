package persistence;

import enumerators.UserType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-29T15:18:55")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, byte[]> password;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, byte[]> salt;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, Date> registrationDate;
    public static volatile SingularAttribute<Customer, UserType> userType;
    public static volatile SingularAttribute<Customer, String> userId;
    public static volatile SingularAttribute<Customer, Integer> ssn;

}