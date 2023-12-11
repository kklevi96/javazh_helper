package com.example.forumgyakorlas.controller;

import com.example.forumgyakorlas.model.Felhasznalo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SettingsServlet", value = "/SettingsServlet")
public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Felhasznalo felhasznalo = (Felhasznalo) request.getSession().getAttribute("felhasznalo");
        String newEmail = request.getParameter("newEmail");
        String newPassword = request.getParameter("newPassword");
        String newName = request.getParameter("newName");
        if (newName != "")
            felhasznalo.setName(newName);
        if (newPassword != "")
            felhasznalo.setPassword(newPassword);
        if (newEmail != "")
            felhasznalo.setEmail(newEmail);
        request.setAttribute("message", "Sikeres adatmódosítás!");
        request.getRequestDispatcher("settings.jsp").forward(request, response);

    }
}
