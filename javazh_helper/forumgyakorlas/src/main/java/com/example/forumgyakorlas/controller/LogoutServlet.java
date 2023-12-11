package com.example.forumgyakorlas.controller;

import com.example.forumgyakorlas.model.Felhasznalo;
import com.example.forumgyakorlas.model.Forum;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Felhasznalo felhasznalo = (Felhasznalo) request.getSession().getAttribute("felhasznalo");

        if (felhasznalo == null) {
            request.setAttribute("message", "Ugyan már ki voltál jelentkezve, a kezdőoldalra irányítottunk.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("felhasznalo", null);
            request.getSession().invalidate();
            request.setAttribute("message", "Sikeresen kijelentkeztettünk.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
