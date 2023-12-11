package com.example.MintaZH.controller;

import com.example.MintaZH.model.Advertiser;
import com.example.MintaZH.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        int price=Integer.parseInt(request.getParameter("price"));
        String keyword=request.getParameter("keyword");

        Advertiser a=(Advertiser) request.getSession().getAttribute("advertiser");
        a.addProduct(new Product(name, price, keyword));

        request.getRequestDispatcher("MainPage.jsp").forward(request,response);
    }
}
