<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.getSession().setAttribute("order",null);
    request.getSession().setAttribute("pizza",null);
    request.getSession().setAttribute("toppings",null);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Pizza Paradise - create your favorite pizza!</h1>
<form action="NewOrderServlet" method="post">
    <fieldset style="display:inline"><legend>Select size:</legend>
        <input type="radio" name="size" value="24"/>24 cm<br/>
        <input type="radio" name="size" value="32" checked="checked"/>32 cm<br/>
        <input type="radio" name="size" value="45"/>45 cm
    </fieldset><br/>
    <input type="submit" value="Next"/>
</form>
<br/>
<a href="AdminLogin.jsp">Admin login</a>
</body>
</html>
