package org.example;

import org.example.dao.imple.UserDaoImpl;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;
import org.example.entity.User;
import org.example.main.Context;

public class Main {

    public static void main(String[] args) throws Exception {
        User u = new User(0, "Rashad", "Hamidli", "+994708288899", "mr_rashad@email.com", "new Java Application", null, null, null, "Baku, Azerbaijan");
       u.setPassword("12345");
        new UserDaoImpl().addUser(u);
        System.out.println("test");
    }

}
