package com.example.MintaZH.controller;

import com.example.MintaZH.model.Advertiser;
import com.example.MintaZH.model.AdvertiserRepository;
import com.example.MintaZH.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductSearchServlet", value = "/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] keywords=request.getParameterValues("keyword");
        ArrayList<Product> results=new ArrayList<>();
        for (Advertiser a: AdvertiserRepository.getInstance().getAdvertisers()) {
            if (a!=request.getSession().getAttribute("advertiser")){
                results.addAll(a.findProductsByMultipleKeywords(keywords));
            }
        }
        request.getSession().setAttribute("searchresults",results);
        request.getRequestDispatcher("SearchResults.jsp").forward(request,response);
    }
}
