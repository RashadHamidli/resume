<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="org.example.entity.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>JSP page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();

    String name = request.getParameter("name");
    String surname = request.getParameter("surname");

    String nationalityIdStr = request.getParameter("nid");
    Integer nationalityId = null;
    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }

    List<User> list = userDao.getAll(name, surname, nationalityId);
%>

<div class="container">
    <div class="row">
        <div class="col col-4">
            <form action="users.jsp" method="GET">
                <div class="form-group">
                    <label>name:</label>
                    <input placeholder="Enter name" class="form-control" type="text" name="name" value=""/>
                </div>
                <div class="form-group">
                    <label>surname:</label>
                    <input placeholder="Enter surname" class="form-control" type="text" name="surname" value=""/>
                </div>
                <input class="btn btn-primary" type="submit" name="search" value="Search">
            </form>
        </div>

    </div>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <th>name</th>
                    <th>surname</th>
                    <th>nationality</th>
                    <th>operations</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (User u : list) {
                %>
                <tr>
                    <td><%=u.getName()%></td>
                    <td><%=u.getSurname()%></td>
                    <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%></td>

                    <td>
                        <button class="btn btn-danger btn_table" type="submit" value="delete" name="actions">
                            <span class="btn_table material-symbols-outlined">delete</span>
                        </button>
                        <button class="btn btn-secondary btn_table" type="submit" value="delete" name="actions">
                            <span class="material-symbols-outlined">update</span>
                        </button>
                    </td>

                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
