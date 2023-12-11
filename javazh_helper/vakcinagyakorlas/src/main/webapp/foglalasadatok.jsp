<%@ page import="com.example.vakcinagyakorlas.model.Foglalas" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 27.
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Foglalás adatai</title>
</head>
<body>
<%
    Foglalas f = (Foglalas) session.getAttribute("foglalas");
%>
<table border="1">
    <tr>
        <td>TAJ számod</td><td><%=f.getTAJ()%></td>
    </tr>
    <tr>
        <td>Életkorod</td><td><%=f.getEletkor()%></td>
    </tr>
    <tr>
        <td>Választott vakcinád</td><td><%=f.getVakcinaNev()%></td>
    </tr>
</table>
<form method="post" action="DelFoglalasServlet">
    Törlöd a foglalást? <input type="checkbox" name="TAJ" value="<%=f.getTAJ()%>" checked="checked"><br/>
    <input type="submit" value="Törlés!">
</form>
<%=request.getAttribute("message")!=null?request.getAttribute("message"):""%>
</body>
</html>
