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

@WebServlet(name = "LogoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String action =request.getParameter("action");
        if(action.equals("logout")) {
            req.getSession().invalidate();
        }
    }
}
