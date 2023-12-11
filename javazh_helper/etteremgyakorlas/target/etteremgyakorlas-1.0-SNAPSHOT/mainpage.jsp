<%@ page import="com.example.etteremgyakorlas.model.Etterem" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2021. 12. 30.
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Foglalások</title>
</head>
<body>
<h1>Foglalások</h1><br/>
Bejelentkezve mint: <%=session.getAttribute("email")==null?"vendég":session.getAttribute("email")%>
<%
    Etterem etterem=Etterem.getInstance();
    //if(session.getAttribute("email")==null){
    //    request.setAttribute("message","Ezt a felületet csak az email címed megadása után láthatod.");
    //    request.getRequestDispatcher("index.jsp").forward(request,response);
    //}

%>
<table border="=1">
    <tr><td></td>
        <%
            for (int i = 0; i < etterem.getIdopontok().length; i++) {
        %>
        <td><b><%=etterem.getIdopontok()[i]%></b></td>
        <%
            };
        %>
    </tr>

    <%
        for (int i = 0; i < etterem.getNapok().length; i++) {
    %>
    <tr>
        <td>
            <b><%=etterem.getNapok()[i]%></b>
        </td>
            <%
                for (int j=0; j<etterem.getIdopontok().length; j++){
                    if(etterem.getFoglalasok()[i][j]==null&&session.getAttribute("email")!=null){
                        %><td>
                            <a href="FoglalasServlet?i=<%=i%>&j=<%=j%>">Foglalás</a>
                        </td><%
                    }else if(etterem.getFoglalasok()[i][j]==null){
                        %><td>
                            Foglalható
                        </td><%
                    }
                    else if(etterem.getFoglalasok()[i][j].equals(session.getAttribute("email"))){
                        %><td>
        <a href="TorlesServlet?i=<%=i%>&j=<%=j%>&admin=false">Törlés</a>
    </td><%
                    }
                    else{
                        %><td>
        Foglalt
    </td><%
                    }
                }
    }%>

</table>
<%
    if(session.getAttribute("email")==null)
    {
        %>  <h1>Bejelentkezés foglaláshoz</h1>
            <form method="post" action="LoginServlet">
                E-mail cím: <input type="text" name="email">
                <input type="submit" value="Belépés">
            </form><%
    }else {
%> <a href="LogoutServlet">Kijelentkezés</a><br/>
<%
    }
%>
<%
    if(etterem.FonokContains((String)request.getSession().getAttribute("email"))){
        %><a href="admin.jsp">Admin felület</a>
        <%}
%>
<%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
</body>
</html>
