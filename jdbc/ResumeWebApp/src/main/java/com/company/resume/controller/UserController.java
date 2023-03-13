package com.company.resume.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.company.dao.inter.UserDaoInter;
import com.company.main.Context;

import java.io.IOException;
@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {
    private final UserDaoInter userDao = Context.instanceUserDao();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
