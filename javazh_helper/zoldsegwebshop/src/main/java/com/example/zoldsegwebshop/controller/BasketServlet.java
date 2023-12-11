package com.example.zoldsegwebshop.controller;

import com.example.zoldsegwebshop.model.Kosar;
import com.example.zoldsegwebshop.model.Termek;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static java.lang.Double.parseDouble;

@WebServlet(name = "BasketServlet", value = "/BasketServlet")
public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nev = request.getParameter("nev");
        double ar = parseDouble(request.getParameter("ar"));
        String email = (String)request.getSession().getAttribute("email");
        Kosar kosar = (Kosar)request.getSession().getAttribute("kosar");
        kosar.hozzaadas(new Termek(nev,ar));
        request.getSession().setAttribute("osszar",kosar.getOsszesen());
        request.getSession().setAttribute("osszdb",kosar.getDb());
        request.getRequestDispatcher("mainpage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
