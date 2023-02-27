<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="org.example.entity.User" %>
<%--<%@ page import="com.example.resume.UserRequestUtil" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP page</title>
</head>
<body>
<%
    if (request.getAttribute("owner") == null) {
        response.sendRedirect("error.jsp?msg=not found");
        return;
    }
    User u = (User) request.getAttribute("user");
%>


<div>
    <form action="/userdetail" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <label for="name">name:</label>
        <input type="text" name="name" value="<%=u.getName()%>"/>
        <br/>
        <label for="surname">surname:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>"/>
        <input type="submit" name="save" value="Save"/>
    </form>
</div>
</body>
</html>
