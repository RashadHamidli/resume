package org.example;

import org.example.dao.imple.UserDaoImpl;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;
import org.example.main.Context;

public class Main {

    public static void main(String[] args) throws Exception {

        UserDaoInter dao = Context.instanceUserDao();
        System.out.println(dao.getAll());
    }

}
