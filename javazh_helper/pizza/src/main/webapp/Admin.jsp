<%@ page import="com.example.pizza.model.OrderRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.pizza.model.Order" %>
<%@ page import="com.example.pizza.model.Pizza" %><%--
  Created by IntelliJ IDEA.
  User: kklev
  Date: 2022. 01. 02.
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    ArrayList<Order> orders = OrderRepository.getInstance().getOrders();
%>

<html>
<head>
    <title>Orders</title>
</head>
<h1>
    Orders
</h1>

<body>
<table border="1">
    <tr>
        <td>
            Order#
        </td>
        <td>
            Ordered items
        </td>
        <td>
            Order Name
        </td>
        <td>
            Order Address
        </td>
        <td>
            Order full price
        </td>
    </tr>
    <%
        //On the top we want to see the latest order
        for (int i = orders.size()-1; i >= 0; i--) {
            %>
                <tr>
                    <td>
                        <%=orders.get(i).getId()%>
                    </td>
                    <td>
                        <%
                            for (int j = 0; j < orders.get(i).getPizzas().size(); j++) {
                                %>
                                    Size: <%=orders.get(i).getPizzas().get(j).getSize()%><br/>
                                    Selected toppings: <%=orders.get(i).getPizzas().get(j).getToppings().toString().replace("[","").replace("]","")%><br/>
                                    Price of the pizza: <%=orders.get(i).getPizzas().get(j).totalPrice()%>
                                <%
                            }
                        %>
                    </td>
                    <td>
                        <%=orders.get(i).getOrdererName()%>
                    </td>
                    <td>
                        <%=orders.get(i).getOrdererAddress()%>
                    </td>
                    <td>
                        <%=orders.get(i).orderPrice()%>
                    </td>
                </tr>
            <%
        }
    %>


</table>
<br/><%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
</body>
</html>
