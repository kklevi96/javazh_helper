<%@ page import="com.example.vakcinagyakorlas.model.ElojegyzesMenedzser" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 27.
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Új regisztráció</title>
</head>
<body>
<table border="1">
    <tr>
        <td>
            <b>Vakcina neve</b>
        </td>
        <td>
            <b>Elérhető darabszám</b>
        </td>
    </tr>
    <%
        for (int i = 0; i < ElojegyzesMenedzser.getInstance().getVakcinak().size(); i++) {
            %>
                <tr>
                    <td>
                        <%=ElojegyzesMenedzser.getInstance().getVakcinak().get(i).getNev()%>
                    </td>
                    <td>
                        <%=ElojegyzesMenedzser.getInstance().getVakcinak().get(i).getDarabszam()%>
                    </td>
                </tr>
            <%
        }
    %>

</table>
<form method="post" action="UjFoglalasServlet">
    TAJ számod: <input type="text" name="TAJ"><br/>
    Korod: <input type="number" name="eletkor"><br/>
    Vakcinád: <select name="vakcina">
    <%for (int i = 0; i < ElojegyzesMenedzser.getInstance().getVakcinak().size(); i++) {
            %><option><%=ElojegyzesMenedzser.getInstance().getVakcinak().get(i).getNev()%></option><%
        }%>
    </select><br/>
    <input type="submit" value="Foglalás beküldése!"/>
</form>
<%=request.getAttribute("message")!=null?request.getAttribute("message"):""%>
</body>
</html>
