package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.main.Context;
import com.company.entity.User;

public class Main {

    public static void main(String[] args) throws Exception {
       UserDaoInter dao= Context.instanceUserDao();
        User u=dao.findByEmail("mr.rashad@minister");
        System.out.println("u "+u);
    }

}
