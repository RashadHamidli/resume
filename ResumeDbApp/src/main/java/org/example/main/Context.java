package org.example.main;

import org.example.dao.imple.EmploymentHistoryDaoImpl;
import org.example.dao.imple.UserDaoImpl;
import org.example.dao.imple.UserSkillDaoImpl;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }
}
