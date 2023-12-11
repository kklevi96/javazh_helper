package com.example.factgyakorlas.controller;

import com.example.factgyakorlas.mymath.MyMath;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "CalcServlet", value = "/CalcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n=parseInt(request.getParameter("n"));
        int k=parseInt(request.getParameter("k"));
        long result= MyMath.bin(n,k);
        if(result<1){
            request.setAttribute("message","Values must be between 0 and 15 and k can't be less than n");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else{
            MyMath.getInstance().setVisits(MyMath.getInstance().getVisits()+1);
            if(request.getSession().getAttribute("prevResult")==null) {
                request.getSession().setAttribute("prevResult", "-1");
            } else {
                request.getSession().setAttribute("prevResult", request.getSession().getAttribute("currResult"));
            }
            request.getSession().setAttribute("currResult", result);
            request.setAttribute("n",n);
            request.setAttribute("k",k);
            request.getRequestDispatcher("result.jsp").forward(request,response);
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
