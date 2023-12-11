package com.example.forumgyakorlas.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

@WebServlet(name = "GetToRegisterPageServlet", value = "/GetToRegisterPageServlet")
public class GetToRegisterPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correctPasswordHash = "04dc72ea3330a6e7ba868a77f1dcb294";
        //M4gv@gyokHivvvAA
        String passwordHash = DigestUtils.md5Hex(request.getParameter("password"));
        request.getSession().setAttribute("helyes", passwordHash.equals(correctPasswordHash));
        if (passwordHash.equals(correctPasswordHash)) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Helytelen jelszó :(");
            request.getRequestDispatcher("getToRegister.jsp").forward(request, response);
        }
    }
}
