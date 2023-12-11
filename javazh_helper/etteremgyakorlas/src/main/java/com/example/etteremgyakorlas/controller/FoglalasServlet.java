package com.example.etteremgyakorlas.controller;

import com.example.etteremgyakorlas.model.Etterem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Locale;

import static java.lang.Integer.parseInt;

@WebServlet(name = "FoglalasServlet", value = "/FoglalasServlet")
public class FoglalasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email =(String)request.getSession().getAttribute("email");
        String emailAdminAltali=request.getParameter("emailA");
        int i = parseInt(request.getParameter("i"));
        int j = parseInt(request.getParameter("j"));
        if(email!=null){
            if(Etterem.getInstance().getFoglalasok()[i][j]!=null) {
                request.setAttribute("message", Etterem.getInstance().getFoglalasok()[i][j] + " lefoglalta előtted az asztalt");
                if(Etterem.getInstance().FonokContains(email))
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                request.getRequestDispatcher("mainpage.jsp").forward(request,response);
            }
            else {
                if(Etterem.getInstance().FonokContains(email)&&emailAdminAltali==null||!Etterem.getInstance().FonokContains(email)){
                    Etterem.getInstance().getFoglalasok()[i][j] = email;
                    request.setAttribute("message", "Sikeres foglalás "+
                            Etterem.getInstance().getNapok()[i].toLowerCase(Locale.ROOT) + " " +
                            Etterem.getInstance().getIdopontok()[j] + " időpontra.");
                    request.getRequestDispatcher("mainpage.jsp").forward(request,response);
                }else if(Etterem.getInstance().FonokContains(email)) {
                    Etterem.getInstance().getFoglalasok()[i][j] = emailAdminAltali;
                    request.setAttribute("message", "Sikeres foglalás " + emailAdminAltali +" email címnek " +
                            Etterem.getInstance().getNapok()[i].toLowerCase(Locale.ROOT) + " " +
                            Etterem.getInstance().getIdopontok()[j] + " időpontra.");
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }
            }
        }else{
            request.setAttribute("message", "Bejelentkezés nélkül nem lehetséges a foglalás.");
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
