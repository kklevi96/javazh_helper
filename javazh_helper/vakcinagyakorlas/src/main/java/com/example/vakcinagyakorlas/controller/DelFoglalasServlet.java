package com.example.vakcinagyakorlas.controller;

import com.example.vakcinagyakorlas.model.ElojegyzesMenedzser;
import com.example.vakcinagyakorlas.model.Foglalas;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DelFoglalasServlet", value = "/DelFoglalasServlet")
public class DelFoglalasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TAJ = request.getParameter("TAJ");
        ElojegyzesMenedzser e = ElojegyzesMenedzser.getInstance();
        request.setAttribute("message","Foglalás törlése sikeres!");
        //növelni kellene az adott foglaláshoz tartozó vakcina mennyiségét 1-el
        //e.findVakcina(e.findFoglalas(TAJ).getVakcinaNev()).setDarabszam(e.findVakcina(e.findFoglalas(TAJ).getVakcinaNev()).getDarabszam()+1);
        e.findVakcina(e.findFoglalas(TAJ).getVakcinaNev()).increaseDarabszam();
        e.delFoglalas(TAJ);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
