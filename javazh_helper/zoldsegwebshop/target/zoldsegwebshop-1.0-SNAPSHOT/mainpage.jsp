<%@ page import="com.example.zoldsegwebshop.model.Termekek" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 30.
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bolt</title>
</head>
<body>
<h1>Hello <%=session.getAttribute("email")%></h1>
<h2>Termékek</h2>
<table border="1">
    <tr>
        <td><b>Név</b></td>
        <td><b>Ár</b></td>
        <td></td>
    </tr>
<%
  for (int i = 0; i < Termekek.getInstance().getTermekek().size(); i++) {
      %>
        <tr>
            <td><%=Termekek.getInstance().getTermekek().get(i).getNev()%></td>
            <td><%=Termekek.getInstance().getTermekek().get(i).getAr()%></td>
            <td><a href="BasketServlet?nev=<%=Termekek.getInstance().getTermekek().get(i).getNev()%>
                    &ar=<%=Termekek.getInstance().getTermekek().get(i).getAr()%>">Megveszem</a></td>
        </tr>
      <%
  }
%>
</table>
<h2>
    Kosár
</h2>
Termékek:  <%=session.getAttribute("osszdb")==null? "0" :session.getAttribute("osszdb")%><br/>
Teljes ár: <%=session.getAttribute("osszar")==null?"0.0":session.getAttribute("osszar")%>
</body>
</html>
