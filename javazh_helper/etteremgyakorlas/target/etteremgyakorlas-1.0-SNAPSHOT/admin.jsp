<%@ page import="com.example.etteremgyakorlas.model.Etterem" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 30.
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Etterem etterem=Etterem.getInstance();
    if(session.getAttribute("email")==null || !etterem.FonokContains((String)session.getAttribute("email"))){
        request.setAttribute("message","Te most komolyan be akarod hekkelni magadat az admin felületbe?");
        request.getRequestDispatcher("mainpage.jsp").forward(request,response);
    }
%>
<html>
<head>
    <title>Foglalások</title>
</head>
<body>

<h1>Super User</h1><br/>
<table border="=1">

    <tr><td></td>
        <%
            for (int i = 0; i < etterem.getIdopontok().length; i++) {
        %>
        <td>
            <b><%=etterem.getIdopontok()[i]%></b>
        </td>
        <%
            };
        %>
    </tr>
    <%
        for (int i = 0; i < etterem.getNapok().length; i++) {
    %><tr>
    <td>
        <b><%=etterem.getNapok()[i]%></b>
    </td>
        <%
            for (int j=0; j<etterem.getIdopontok().length; j++){
                if(etterem.getFoglalasok()[i][j]==null){
                        %>
    <td>
        <form method="get" action = FoglalasServlet>
            <input type="text" name="emailA"><br/>
            <input type="hidden" name="i" value="<%=i%>">
            <input type="hidden" name="j" value="<%=j%>">
            <input type="submit" name="Foglalás">
        </form>
    </td> <%
                    }
                    else {
                        %><td>
    <a href="TorlesServlet?i=<%=i%>&j=<%=j%>&admin=true"><%=etterem.getFoglalasok()[i][j] +" foglalásának törlése"%></a>
</td><%
                    }
            }
        }%>
</table>


<a href="LogoutServlet">Kijelentkezés</a><br/>
<a href="mainpage.jsp">Vendég felület</a>
<%=request.getAttribute("message")==null?"":request.getAttribute("message")%><br/>

</body>
</html>
