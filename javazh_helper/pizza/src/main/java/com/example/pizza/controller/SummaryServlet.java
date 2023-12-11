package com.example.pizza.controller;

import com.example.pizza.model.Order;
import com.example.pizza.model.OrderRepository;
import com.example.pizza.model.Pizza;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SummaryServlet", value = "/SummaryServlet")
public class SummaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        Order order = new Order((Pizza)request.getSession().getAttribute("pizza"), name, address);
        //order.setOrdererAddress(address);
        //order.setOrdererName(name);
        OrderRepository.getInstance().addOrder(order);
        request.getRequestDispatcher("Summary.jsp?name=" + name + "&address=" + address).forward(request,response);
    }
}
