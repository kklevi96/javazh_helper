package com.example.etteremgyakorlas.controller;

import com.example.etteremgyakorlas.model.Etterem;
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
        Etterem etterem = Etterem.getInstance();
        if(email!="")
            request.getSession().setAttribute("email",email);
        //getServletContext().setAttribute("etterem",etterem);
        if(etterem.FonokContains(email))
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        else
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);

    }
}
