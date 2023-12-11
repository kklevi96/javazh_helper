package com.example.vakcinagyakorlas.controller;

import com.example.vakcinagyakorlas.model.ElojegyzesMenedzser;
import com.example.vakcinagyakorlas.model.Foglalas;
import com.example.vakcinagyakorlas.model.Vakcina;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UjFoglalasServlet", value = "/UjFoglalasServlet")
public class UjFoglalasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TAJ = request.getParameter("TAJ");

        ElojegyzesMenedzser e = ElojegyzesMenedzser.getInstance();
        int eletkor;
        if(request.getParameter("eletkor").equals("")){
            eletkor=0;
        }else{
            eletkor = Integer.parseInt(request.getParameter("eletkor"));
        }
        String vakcinaNev = request.getParameter("vakcina");
        Foglalas foglalas = new Foglalas(TAJ, eletkor, vakcinaNev);


        if(TAJ.length()!=9||eletkor<10||eletkor>99||vakcinaNev==null){
            request.setAttribute("message","TAJ szám 9 karakter hosszúnak kell lennie, életkornak 10-99 közöttinek, vakcinatípus választása kötelező!");
        }else if(e.findFoglalas(TAJ)!=null){
            request.setAttribute("message","Ezzel a TAJ számmal már van foglalás a rendszerben!");
        }else if(TAJ.length()==9&&eletkor>=10&&eletkor<=99&&vakcinaNev!=null){
            if(e.findVakcina(vakcinaNev).getDarabszam()<1){
                request.setAttribute("message", "Nincs elegendő mennyiség!");
            }
            else if(e.findVakcina(vakcinaNev).getDarabszam()>=1){
                e.addFoglalas(foglalas);
                request.getSession().setAttribute("foglalas", foglalas);
                //e.findVakcina(e.findFoglalas(TAJ).getVakcinaNev()).setDarabszam(e.findVakcina(e.findFoglalas(TAJ).getVakcinaNev()).getDarabszam()-1);
                e.findVakcina(e.findFoglalas(TAJ).getVakcinaNev()).decreaseDarabszam();
                request.setAttribute("message", "Sikeres foglalás! :)");
            }
        }else{
            request.setAttribute("message","Ismeretlen hiba.");
        }
        request.getRequestDispatcher("elojegyzes.jsp").forward(request,response);
    }
}
