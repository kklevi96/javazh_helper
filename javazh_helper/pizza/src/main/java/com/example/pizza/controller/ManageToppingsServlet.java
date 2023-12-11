package com.example.pizza.controller;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.Topping;
import com.example.pizza.model.ToppingRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageToppingsServlet", value = "/ManageToppingsServlet")
public class ManageToppingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pizza pizza=(Pizza)request.getSession().getAttribute("pizza");
        if (request.getParameter("add")!=null){
            Topping t = ToppingRepository.getInstance().findTopping(request.getParameter("add"));
            if (t!=null){
                pizza.addTopping(t);
                request.setAttribute("message", "Topping added.");
            }
        }

        // A topping has to be removed from the pizza
        if (request.getParameter("remove")!=null){
            Topping t = ToppingRepository.getInstance().findTopping(request.getParameter("remove"));
            if (t!=null){
                pizza.removeTopping(t);
                request.setAttribute("message", "Topping removed.");
            }
        }
        // Forward to the creator page
        request.getRequestDispatcher("PizzaCreator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ArrayList<Topping> toppings = ToppingRepository.getInstance().getToppings();
        //getServletContext().setAttribute("toppings", toppings);
        // Forward to the creator page
        //request.getRequestDispatcher("PizzaCreator.jsp").forward(request, response);
    }
}
