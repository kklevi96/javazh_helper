<%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2022. 01. 02.
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin login - view and manage existing orders</title>
</head>
<body>
<form method="post" action="LoginServlet">
    Username: <input type="text" name="username"><br/>
    Password: <input type="password" name="password"><br/>
    <input type="submit">
</form>
<br/><%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
</body>
</html>
