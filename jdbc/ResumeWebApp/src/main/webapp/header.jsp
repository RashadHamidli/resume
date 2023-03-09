<%@ page import="org.example.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: mr_rashad
  Date: 08.03.2023
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user=(User)  session.getAttribute("loggeddInUser");
%>
<%--<%="Wellcome, "+user.getName()%>--%>
