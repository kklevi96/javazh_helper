package com.example.forumgyakorlas.controller;

import com.example.forumgyakorlas.model.Felhasznalo;
import com.example.forumgyakorlas.model.Forum;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        Felhasznalo felhasznalo = Forum.getInstance().FindFelhasznalo(nickname);
        if (felhasznalo != null && felhasznalo.getPassword().equals(DigestUtils.md5Hex(password))) {
            request.getSession().setAttribute("felhasznalo", felhasznalo);
            request.getRequestDispatcher("mainpage.jsp").forward(request, response);

        } else if (felhasznalo != null) {
            request.getRequestDispatcher("badpassword.html").forward(request, response);
        } else {
            request.getRequestDispatcher("unknown.html").forward(request, response);
        }
    }
}
