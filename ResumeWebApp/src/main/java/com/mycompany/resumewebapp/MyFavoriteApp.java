/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.resumewebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.dao.imple.UserDaoImpl;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;

/**
 *
 * @author mr_rashad
 */
@WebServlet(name = "MyFavoriteApp", urlPatterns = {"/MyFavoriteApp"})
public class MyFavoriteApp extends HttpServlet {
 private UserDaoInter userDao = new UserDaoImpl();
    

     @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<User> users=userDao.getAll();
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");            
            out.println("</head>");
            out.println("<body>");
            for(User u: users){
                out.println(u+"<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("I GOT POST REQUEST");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
