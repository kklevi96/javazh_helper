package com.example.pizza.controller;

import com.example.pizza.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewOrderServlet", value = "/NewOrderServlet")
public class NewOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create the pizza and add it to the session scope
        int size=Integer.parseInt(request.getParameter("size"));
        Pizza newpizza= new Pizza(size);
        request.getSession().setAttribute("pizza", newpizza);
        // Forward the request to the toppings manager (in case available toppings list is not created yet)
        if (getServletContext().getAttribute("availableToppings")==null){
            ArrayList<Topping> availableToppings = ToppingRepository.getInstance().getToppings();
            getServletContext().setAttribute("availableToppings",availableToppings);
        }
        //Order order = new Order(newpizza);
        //request.getSession().setAttribute("order",order);
        //OrderRepository.getInstance().addOrder(order);

        //Pizza pizza=(Pizza)request.getSession().getAttribute("pizza");
        ArrayList<Topping> toppings = (ArrayList<Topping>)getServletContext().getAttribute("availableToppings");
        request.getSession().setAttribute("toppings", toppings);
        //request.getSession().setAttribute("order",order);
        request.getRequestDispatcher("PizzaCreator.jsp").forward(request, response);
    }
}
