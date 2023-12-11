<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.getSession().setAttribute("helyes",null);
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Bejelentkezés</h1>
<form method="post" action="LoginServlet">
    Felhasználónév: <input type="text" name="nickname"><br/>
    Jelszó: <input type="password" name="password"><br/>
    <input type="submit" value="Bejelentkezés">
</form>
<a href="getToRegister.jsp">Regisztráció</a><br/>
<%=
request.getAttribute("message") == null ? "" : request.getAttribute("message")
%>
</body>
</html>