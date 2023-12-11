<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Zöldséges-Online" %>
</h1>
<br/>
<form method="post" action="LoginServlet">
    Email cím:<%="\t"%><input type="text" name="email"><br/>
    Jelszó:<%="\t"%><input type="password" name="password"><br/>
    <input type="submit" value="Bejelentkezés">
</form>
<%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
</body>
</html>