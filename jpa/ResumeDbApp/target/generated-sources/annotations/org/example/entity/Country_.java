package org.example.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.example.entity.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-04T16:34:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile ListAttribute<Country, User> userList;
    public static volatile SingularAttribute<Country, String> nationality;
    public static volatile ListAttribute<Country, User> userList1;
    public static volatile SingularAttribute<Country, String> name;
    public static volatile SingularAttribute<Country, Integer> id;

}