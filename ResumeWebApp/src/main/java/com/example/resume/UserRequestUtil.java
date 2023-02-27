//package com.example.resume;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.dao.inter.UserDaoInter;
//import org.example.entity.User;
//import org.example.main.Context;
//
//import java.io.IOException;
//
//public class UserRequestUtil {
//    public static void checkRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException {
//
//        String userIdStr = request.getParameter("id");
//        if (userIdStr == null || userIdStr.trim().isEmpty()) {
//            throw new IllegalArgumentException("id is not specified");
//        }
//    }
//
//    public static User processRequest(HttpServletRequest request, HttpServletResponse response) {
//        UserRequestUtil.checkRequest(request, response);
//
//        Integer userId = Integer.parseInt(request.getParameter("id"));
//
//        UserDaoInter userDao = Context.instanceUserDao();
//        User u = userDao.getById(userId);
//        if (u == null) {
//            throw new IllegalArgumentException("there is no user with this id");
//        }
//        return u;
//    }
//}
