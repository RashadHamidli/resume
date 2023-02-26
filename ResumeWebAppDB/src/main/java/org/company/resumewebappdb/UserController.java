package org.company.resumewebappdb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;

import java.io.IOException;


@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        

        System.out.println("name=" + name);
        System.out.println("surname=" + surname);
        System.out.println("address=" + address);
        System.out.println("phone=" + phone);
        System.out.println("email=" + email);

        User user = userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        userDao.updateUser(user);
        response.sendRedirect("user.jsp");

    }
}
