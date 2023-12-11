<%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 29.
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("helyes",null);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Szia :)</h1>
Hogy regisztrálhass az oldalra, ismerned kell a regisztrációhoz szükséges jelszót ;)

<form method="post" action="GetToRegisterPageServlet">
    A jelszó: <input type="password" name="password">
    <input type="submit">
</form>

<%=
request.getAttribute("message") == null ? "" : request.getAttribute("message")
%>
</body>
</html>
