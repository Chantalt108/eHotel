package persistence;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T22:23:41")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> USER_ID;
    public static volatile SingularAttribute<User, Date> BIRTHDATE;
    public static volatile SingularAttribute<User, String> NAME;

}