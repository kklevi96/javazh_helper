<%@ page import="com.example.forumgyakorlas.model.Forum" %>
<%@ page import="com.example.forumgyakorlas.model.Felhasznalo" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 29.
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("helyes",null);
%>
<%
    if (session.getAttribute("felhasznalo") == null) {
        request.setAttribute("message", "Nem vagy bejelentkezve, ne is próbálj csak így betörni :cc");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
<head>
    <title>Hozzászólások</title>
</head>
<body>
<h1>
    <%
        Felhasznalo f = (Felhasznalo) session.getAttribute("felhasznalo");
    %>
    Hello <%=f.getName()%>
</h1>
<table>
    <tr>
        <td>
            <b>Hozzászólás szerzője</b>
        </td>
        <td>
            <b>Hozzászólás tartalma</b>
        </td>
    </tr>
    <%
        for (int i = 0; i < Forum.getInstance().getHozzaszolasok().size(); i++) {
    %>
    <tr>
        <td>
            <%=Forum.getInstance().FindFelhasznaloId(Forum.getInstance().getHozzaszolasok().get(i).getHozzaszolasSzerzo()).getName()%>
        </td>
        <td>
            <%=Forum.getInstance().getHozzaszolasok().get(i).getHozzaszolas()%>
        </td>
    </tr>
    <%
        }
        ;
    %>
    <tr>
        <td>
            Hozzászólás tartalma:
        </td>
        <td>
            <form method="post" action="NewCommentServlet">
                <input type="text" name="comment"><br/>
                <input type="submit" value="Küldés">
            </form>
        </td>
    </tr>

</table>
<%=request.getAttribute("message") == null ? "" : request.getAttribute("message")%><br/>
<a href="settings.jsp">Beállítások</a><br/>
<a href="LogoutServlet">Kijelentkezés</a>
</body>
</html>
