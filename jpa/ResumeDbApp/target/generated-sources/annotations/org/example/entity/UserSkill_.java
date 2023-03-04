package org.example.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.example.entity.Skill;
import org.example.entity.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-04T16:34:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(UserSkill.class)
public class UserSkill_ { 

    public static volatile SingularAttribute<UserSkill, Skill> skillId;
    public static volatile SingularAttribute<UserSkill, Integer> id;
    public static volatile SingularAttribute<UserSkill, Integer> power;
    public static volatile SingularAttribute<UserSkill, User> userId;

}