package com.example.resume.controller;

import com.example.resume.util.ControllerUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private final UserDaoInter userDao = Context.instanceUserDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           User user = userDao.findByEmailAndPassword(email, password);
           if (user==null){
               throw new IllegalArgumentException("email or password is incorrect!");
           }
           request.getSession().setAttribute("loggedInUser", user);
           response.sendRedirect("/users");
       }catch (Exception ex){
           ControllerUtil.errorPage(response, ex);
       }
    }
}
