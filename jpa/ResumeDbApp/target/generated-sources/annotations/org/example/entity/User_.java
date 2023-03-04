package org.example.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.example.entity.Country;
import org.example.entity.EmploymentHistory;
import org.example.entity.UserSkill;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-04T16:34:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, Date> birthdate;
    public static volatile SingularAttribute<User, String> profileDescription;
    public static volatile SingularAttribute<User, Country> nationalityId;
    public static volatile SingularAttribute<User, Country> birthplaceId;
    public static volatile ListAttribute<User, EmploymentHistory> employmentHistoryList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, UserSkill> userSkillList;

}