<%@ page import="com.example.MintaZH.model.Product" %>
<%@ page import="com.example.MintaZH.model.Advertiser" %><%--
  Created by IntelliJ IDEA.
  User: nagygabi
  Date: 2021. 11. 26.
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product page</title>
</head>
<body>
<h1>Product page</h1>
<h2>Your products:</h2>
<table border="1">
    <tr><th>Product name</th><th>Product price</th><th>Keyword</th><th>Reserved</th></tr>
    <% for (Product p: ((Advertiser)session.getAttribute("advertiser")).getProducts()) { %>
    <tr>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%> HUF</td>
        <td><%=p.getKeyword()%></td>
        <td><%=p.getReservedBy()==null?"-":p.getReservedBy()%></td>
    </tr>
    <% } %>
</table>
<h2>Add a new product:</h2>
<form method="post" action="AddProductServlet">
    Product name:<input type="text" name="name"/><br/>
    Product price:<input type="text" name="price"/><br/>
    Keyword:<br/>
    <select name="keyword">
        <% for (String word: Product.getAllKeywords()) { %>
        <option><%=word%></option>
        <% } %>
    </select><br/>
    <input type="submit" value="Add product"/>
</form>
<h2>Find other advertisers' products:</h2>
<form method="post" action="ProductSearchServlet">
    Keyword:<br/>
    <select name="keyword" multiple="multiple">
        <% for (String word: Product.getAllKeywords()) { %>
        <option><%=word%></option>
        <% } %>
    </select><br/>
    <input type="submit" value="Search"/>
</form>
<%=request.getAttribute("message")==null?"":request.getAttribute("message")%><br/>
</body>
</html>
