<%@ page import="com.example.MintaZH.model.Product" %>
<%@ page import="com.example.MintaZH.model.Advertiser" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nagygabi
  Date: 2021. 11. 26.
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<table border="1">
    <tr><th>Product name</th><th>Product price</th><th>Keyword</th><th>Reserved</th></tr>
    <% for (Product p: ((ArrayList<Product>)session.getAttribute("searchresults"))) { %>
    <tr>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%> HUF</td>
        <td><%=p.getKeyword()%></td>
        <td><% if (p.getReservedBy()==null){ %>
            <a href="ReservationServlet?product=<%=p.getName()%>">Reserve</a>
            <% }else{ %>
            Not available
            <% } %>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
