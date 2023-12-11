package com.example.forumgyakorlas.controller;

import com.example.forumgyakorlas.model.Felhasznalo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ShowPasswordHashServlet", value = "/ShowPasswordHashServlet")
public class ShowPasswordHashServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Felhasznalo f = (Felhasznalo) request.getSession().getAttribute("felhasznalo");
        request.setAttribute("password", f.getPassword());
        request.getRequestDispatcher("settings.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
