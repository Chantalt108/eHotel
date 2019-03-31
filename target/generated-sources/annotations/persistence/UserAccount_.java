package persistence;

import enumerators.UserType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Room;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-31T10:54:45")
@StaticMetamodel(UserAccount.class)
public class UserAccount_ { 

    public static volatile SingularAttribute<UserAccount, byte[]> password;
    public static volatile SetAttribute<UserAccount, Room> rooms;
    public static volatile SingularAttribute<UserAccount, String> address;
    public static volatile SingularAttribute<UserAccount, byte[]> salt;
    public static volatile SingularAttribute<UserAccount, String> name;
    public static volatile SingularAttribute<UserAccount, UserType> userType;
    public static volatile SingularAttribute<UserAccount, String> userId;
    public static volatile SingularAttribute<UserAccount, Integer> ssn;

}