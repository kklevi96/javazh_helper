<%@ page import="com.example.forumgyakorlas.model.Felhasznalo" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 29.
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Beállítások</title>
</head>
<body>
<h1>Felhasználói adataid:</h1>
<%
    Felhasznalo felhasznalo = (Felhasznalo) session.getAttribute("felhasznalo");
%>
<form method="post" action="SettingsServlet">
    <table border="1">
        <tr>
            <td>
                <b>Jelenlegi adat</b>
            </td>
            <td>
                <b>Amire módosítani szeretnéd</b>
            </td>
        </tr>
        <tr>
            <td>
                ID: <%=felhasznalo.getId()%>
            </td>
            <td>
                [nem módosítható]
            </td>
        </tr>
        <tr>
            <td>
                nick: <%=felhasznalo.getNickname()%>
            </td>
            <td>
                [nem módosítható]
            </td>
        </tr>
        <tr>
            <td>
                Név: <%=felhasznalo.getName()%>
            </td>
            <td>
                <input type="text" value=<%=felhasznalo.getName()%> name="newName">
            </td>
        </tr>
        <tr>
            <td>
                Email: <%=felhasznalo.getEmail()%>
            </td>
            <td>
                <input type="text" value=<%=felhasznalo.getEmail()%> name="newEmail">
            </td>
        </tr>
        <tr>
            <td>
                Jelszó: <%=request.getAttribute("password") == null ? "Nem látható" : request.getAttribute("password")%>
                <br/>
                <%
                    if (request.getAttribute("password") == null) {
                %>
                <a href="ShowPasswordHashServlet">md5hex megjelenítése<br/>a jelszó nincs eltárolva</a>
                <%
                    }
                    ;
                %>
            </td>
            <td>
                <input type="password" name="newPassword">
            </td>
        </tr>
        <tr>
            <td>
                Elmentés:
            </td>
            <td>
                <input type="submit" value="Mentés">
            </td>
        </tr>
    </table>
</form>
<%=request.getAttribute("message") == null ? "" : request.getAttribute("message")%>
<a href="mainpage.jsp">Vissza a főoldalra</a><br/>
<a href="LogoutServlet">Kijelentkezés</a>
</body>
</html>
