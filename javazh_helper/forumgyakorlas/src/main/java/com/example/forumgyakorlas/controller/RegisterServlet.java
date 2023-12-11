package com.example.forumgyakorlas.controller;

import com.example.forumgyakorlas.model.Felhasznalo;
import com.example.forumgyakorlas.model.Forum;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = request.getParameter("nickName").toLowerCase(Locale.ROOT);
        String name = request.getParameter("Name");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");
        if(Forum.getInstance().FindFelhasznalo(nickname)!=null) {
            request.setAttribute("errormessage", nickname + " regisztrációval már létezik felhasználó. A regisztráció sikertelen.");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } else{
            Felhasznalo felhasznalo = new Felhasznalo(name,nickname,password,email);
            Forum.getInstance().AddFelhasznalo(felhasznalo);
            request.getSession().setAttribute("felhasznalo", felhasznalo);
            request.setAttribute("message", "Sikeres regisztráció, automatikusan be lettél jelentkeztetve.");
            request.getRequestDispatcher("mainpage.jsp").forward(request, response);
        }
    }
}
