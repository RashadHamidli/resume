package com.company;

import com.company.dao.imple.UserDaoImpl;
import com.company.entity.User;

public class Main {

    public static void main(String[] args) throws Exception {
        User u = new User(0, "Rashad", "Hamidli", "+994708288899", "mr_rashad@email.com", "new Java Application", null, null, null, "Baku, Azerbaijan");
       u.setPassword("12345");
        new UserDaoImpl().addUser(u);
        System.out.println("test");
    }

}
