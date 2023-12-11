package com.example.pizza.controller;

import com.example.pizza.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").toLowerCase(Locale.ROOT);
        String password = request.getParameter("password");
        Admin admin = AdminRepository.getInstance().findAdmin(username);
        //ArrayList<Order> orders = OrderRepository.getInstance().getOrders();
        //ArrayList<Pizza> pizzas = PizzaRepository.getInstance().getPizzas();
        if(admin==null){
            AdminRepository.getInstance().addAdmin(new Admin(username,password));
            request.getSession().setAttribute("admin",admin);
            //request.getServletContext().setAttribute("pizzas",pizzas);
            request.setAttribute("message","Még nem létezett ilyen felhasználónév, de sikeresen regisztráltál " + username + " felhasználónévvel.");
            request.getRequestDispatcher("Admin.jsp").forward(request,response);
        } else {
            if(admin.getPassword().equals(password)){
                request.getSession().setAttribute("admin",admin);
                //request.getServletContext().setAttribute("pizzas",pizzas);
                request.setAttribute("message","Sikeresen bejelentkeztél. Hello " + username + "! :)");
                request.getRequestDispatcher("Admin.jsp").forward(request,response);
            }else{
                request.setAttribute("message", "helytelen jelszó");
                request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            }
        }
    }
}
