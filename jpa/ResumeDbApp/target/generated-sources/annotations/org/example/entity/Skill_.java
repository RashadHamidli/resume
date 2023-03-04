package org.example.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.example.entity.UserSkill;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-04T16:34:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Skill.class)
public class Skill_ { 

    public static volatile SingularAttribute<Skill, String> name;
    public static volatile SingularAttribute<Skill, Integer> id;
    public static volatile ListAttribute<Skill, UserSkill> userSkillList;

}