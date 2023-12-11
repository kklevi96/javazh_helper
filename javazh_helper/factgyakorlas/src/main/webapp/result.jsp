<%@ page import="com.example.factgyakorlas.mymath.MyMath" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>
    (<%=request.getAttribute("n")%> <%=request.getAttribute("k")%>) is: <%=session.getAttribute("currResult")%>
</h1>
My previous result: <%=request.getSession().getAttribute("prevResult")%>
All visits: <%=MyMath.getInstance().getVisits()%>
</body>
</html>
