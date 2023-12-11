package com.example.MintaZH.controller;

import com.example.MintaZH.model.Advertiser;
import com.example.MintaZH.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ReservationServlet", value = "/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("product");
        ArrayList<Product> products=(ArrayList<Product>)request.getSession().getAttribute("searchresults");
        Product productToReserve=products.stream().filter(p->p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        Advertiser currentUser=(Advertiser) request.getSession().getAttribute("advertiser");
        productToReserve.setReservedBy(currentUser.getEmail());

        request.getRequestDispatcher("SearchResults.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
