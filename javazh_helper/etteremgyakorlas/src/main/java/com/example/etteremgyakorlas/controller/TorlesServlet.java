package com.example.etteremgyakorlas.controller;

import com.example.etteremgyakorlas.model.Etterem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "TorlesServlet", value = "/TorlesServlet")
public class TorlesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = parseInt(request.getParameter("i"));
        int j = parseInt(request.getParameter("j"));
        boolean deleteFromAdminJsp = Boolean.parseBoolean(request.getParameter("admin"));
        if(Etterem.getInstance().getFoglalasok()[i][j]==null)
            request.setAttribute("message","Már alapból se volt foglalás itt.");
        else {
            Etterem.getInstance().getFoglalasok()[i][j] = null;
            request.setAttribute("message", "Sikeres törlés");
        }
        if(Etterem.getInstance().FonokContains((String)request.getSession().getAttribute("email"))&&deleteFromAdminJsp)
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        else
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
