<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="org.example.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: mr_rashad
  Date: 25.02.2023
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP page</title>
</head>
<body>
    <%
        UserDaoInter userDao = Context.instanceUserDao();
           User u = userDao.getById(8);

    %>
<div>
    <form action="UserController" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <label>name:</label>
        <input type="text" name="name" value="<%=u.getName()%>"/>
        <br/> <br/> 
        <label>surname:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>"/>
        <input type="submit" name="save" value="Save" >
            <br/> <br/>
            <label>address:</label>
            <input type="text" name="address" value="<%=u.getAddress()%>"/>
            <br/> <br/>
            <label>phone:</label>
            <input type="text" name="phone" value="<%=u.getPhone()%>"/>
            <br/> <br/>
            <label>email:</label>
            <input type="text" name="email" value="<%=u.getEmail()%>"/>

    </form>
</div>
</body>
</html>
