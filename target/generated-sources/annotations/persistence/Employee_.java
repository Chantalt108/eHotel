package persistence;

import enumerators.UserType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-06T00:57:08")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, byte[]> password;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, byte[]> salt;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, UserType> userType;
    public static volatile SingularAttribute<Employee, String> userId;
    public static volatile SingularAttribute<Employee, Integer> ssn;
    public static volatile SingularAttribute<Employee, String> jobPosition;

}