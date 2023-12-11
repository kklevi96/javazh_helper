<%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 29.
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Regisztráció</title>
</head>
<body>
<%
    if (session.getAttribute("helyes") == null) {
        request.setAttribute("message", "Jelszó nélkül nem fogsz tudni regisztrálni az oldalra :(");
        request.getRequestDispatcher("getToRegister.jsp").forward(request, response);
    }
%>
<form method="post" action="RegisterServlet">
    <table border="1">
        <tr>
            <td>
                <b>Adat</b>
            </td>
            <td>
                <b>Amire beállítod</b>
            </td>
        </tr>
        <tr>
            <td>
                Nick (login név):
            </td>
            <td>
                <input type="text" name="nickName">
            </td>
        </tr>
        <tr>
            <td>
                Jelszó:
            </td>
            <td>
                <input type="password" name="Password">
            </td>
        </tr>
        <tr>
            <td>
                Név:
            </td>
            <td>
                <input type="text" name="Name">
            </td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                <input type="text" name="Email">
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
<%=request.getAttribute("errormessage")!=null?request.getAttribute("errormessage"):""%>
<%
    //if(request.getAttribute("errormessage")==null)
        //request.getSession().setAttribute("helyes", null);
%>
</body>
</html>
