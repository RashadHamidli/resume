<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="org.example.entity.User" %>
<%@ page import="java.util.List" %><%--
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
    List<User> list = userDao.getAll();
%>
<div>
    <form action="user.jsp" method="POST">
        <input type="hidden" name="id" value=""/>
        <label>name:</label>
        <input type="text" name="name" value=""/>
        <br/>
        <label>surname:</label>
        <input type="text" name="surname" value=""/>
        <input type="submit" name="search" value="Search">
        <div>
            <table>
                <thead>
                <tr>
                    <th>name</th>
                    <th>surname</th>
                    <th>nationality</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (User u : list) {
                %>
                <tr>
                    <td><%=u.getName()%></td>
                    <td><%=u.getSurname()%></td>
                    <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>

        </div>


        <label>address:</label>
        <input type="text" name="address" value=""/>
        <br/>
        <label>phone:</label>
        <input type="text" name="phone" value=""/>
        <br/>
        <label>email:</label>
        <input type="text" name="email" value=""/>
    </form>

</div>
</body>
</html>
