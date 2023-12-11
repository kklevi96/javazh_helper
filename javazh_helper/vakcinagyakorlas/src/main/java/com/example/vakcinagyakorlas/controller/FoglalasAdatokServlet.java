package com.example.vakcinagyakorlas.controller;

import com.example.vakcinagyakorlas.model.ElojegyzesMenedzser;
import com.example.vakcinagyakorlas.model.Foglalas;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FoglalasAdatokServlet", value = "/FoglalasAdatokServlet")
public class FoglalasAdatokServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Foglalas foglalas = ElojegyzesMenedzser.getInstance().findFoglalas(request.getParameter("TAJ"));
        if(foglalas!=null){
            request.getSession().setAttribute("foglalas",foglalas);
            request.getRequestDispatcher("foglalasadatok.jsp").forward(request,response);
        }else{
            request.setAttribute("message","Nincsen regisztráció ehhez a TAJ számhoz.");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
