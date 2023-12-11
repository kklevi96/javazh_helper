package com.example.MintaZH.controller;

import com.example.MintaZH.model.Advertiser;
import com.example.MintaZH.model.AdvertiserRepository;
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
        String email=request.getParameter("email");
        Advertiser a=AdvertiserRepository.getInstance().findAdvertiser(email);
        if (a!=null){
            request.getSession().setAttribute("advertiser",a);
            request.getRequestDispatcher("MainPage.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("bad_password.html").forward(request,response);
        }
    }
}
