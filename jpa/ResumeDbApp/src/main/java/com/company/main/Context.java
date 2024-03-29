package com.company.main;

import com.company.dao.imple.CountryDaoImpl;
import com.company.dao.imple.EmploymentHistoryDaoImpl;
import com.company.dao.imple.SkillDaoImpl;
import com.company.dao.imple.UserDaoImpl;
import com.company.dao.imple.UserSkillDaoImpl;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;

public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }
    
    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }

    
}
