<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Főoldal</title>
</head>
<body>
<h1>Szia!</h1>
<br/>
<form method="post" action="FoglalasAdatokServlet">
    TAJ: <input type="text" name="TAJ"/><br/>
    <input type="submit" value="Foglalás lekérdezése"/>
</form>
<%=request.getAttribute("message")!=null?request.getAttribute("message"):""%>
<a href="elojegyzes.jsp">Új regisztráció</a>
</body>
</html>