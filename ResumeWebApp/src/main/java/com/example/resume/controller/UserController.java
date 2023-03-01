package com.example.resume.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;

import java.io.IOException;

@WebServlet(name = "UserController", value = "/users")
public class UserController extends HttpServlet {
    private final UserDaoInter userDao = Context.instanceUserDao();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
