<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Éttermi asztalfoglalás
</h1>
<br/>
<form method="post" action="LoginServlet">
    E-mail cím: <input type="text" name="email">
    <input type="submit" value="Belépés">
</form>
<%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
</body>
</html>