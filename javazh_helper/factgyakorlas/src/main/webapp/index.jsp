<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Binomial coefficient of:
</h1><br/>
<form method="get" action="CalcServlet">
    n <input type="number" name="n"><br/>
    k <input type="number" name="k"><br/>
    <input type="submit" value="Show result">
</form>
<%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
</body>
</html>