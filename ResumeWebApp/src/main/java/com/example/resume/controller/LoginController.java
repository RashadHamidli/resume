package com.example.resume.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private final UserDaoInter userDao = Context.instanceUserDao();
    private static BCrypt.Verifyer verifyer =BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           String email = request.getParameter("email");
           String password=request.getParameter("password");
           User user = userDao.findByEmail(email);
           if (user==null ){
               throw new IllegalArgumentException("User doesn't exist!");
           }
           BCrypt.Result rs=verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
           if(!rs.verified){
               throw new IllegalArgumentException("password is incorrect!");
           }
           request.getSession().setAttribute("loggedInUser", user);
           response.sendRedirect("users");
       }catch (Exception ex){
           ControllerUtil.errorPage(response, ex);
       }
    }
}
