<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="org.example.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();
    String userIdStr = request.getParameter("id");
    if (userIdStr == null || userIdStr.trim().isEmpty()) {
%>
specify id
<%
    } else {
    Integer userId = Integer.parseInt(request.getParameter("id"));
    User u = userDao.getById(userId);
    if (u == null) {
%>
there is no user with this id
<%
} else {
%>
<div>
    <form action="/UserController" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <label for="name">name:</label>
        <input type="text" name="name" value="<%=u.getName()%>"/>
        <br/>
        <label for="surname">name:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>"/>
        <input type="submit" name="save" value="Save"/>
    </form>
</div>
<%      }
    }
%>
</body>
</html>
