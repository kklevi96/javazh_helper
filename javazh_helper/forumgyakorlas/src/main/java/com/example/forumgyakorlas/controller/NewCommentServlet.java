package com.example.forumgyakorlas.controller;

import com.example.forumgyakorlas.model.Felhasznalo;
import com.example.forumgyakorlas.model.Forum;
import com.example.forumgyakorlas.model.Hozzaszolas;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "NewCommentServlet", value = "/NewCommentServlet")
public class NewCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Felhasznalo commenter = (Felhasznalo) request.getSession().getAttribute("felhasznalo");
        String comment = request.getParameter("comment");
        if (comment == "")
            request.setAttribute("message", "Üres hozzászólást nem lehet írni");
        else
            Forum.getInstance().getHozzaszolasok().add(new Hozzaszolas(comment, commenter.getId()));
        request.getRequestDispatcher("mainpage.jsp").forward(request, response);
    }
}
