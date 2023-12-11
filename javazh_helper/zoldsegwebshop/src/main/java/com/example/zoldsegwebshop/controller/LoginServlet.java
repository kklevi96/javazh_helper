package com.example.zoldsegwebshop.controller;

import com.example.zoldsegwebshop.model.Felhasznalok;
import com.example.zoldsegwebshop.model.Kosar;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (Felhasznalok.getInstance().helyesJelszo(email, password)) {
            Kosar kosar = new Kosar();
            request.getSession().setAttribute("kosar", kosar);
            request.getSession().setAttribute("email", email);
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }else {
            request.setAttribute("message", "Hibás e-mail és/vagy jelszó");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
