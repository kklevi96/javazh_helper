package com.example.MintaZH.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Advertiser {
    private String email;
    private ArrayList<Product> products;

    public Advertiser(String email) {
        this.email = email;
        products=new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> findProductsByMultipleKeywords(String[] keywords){
        return products.stream().filter(p->Arrays.asList(keywords).contains(p.getKeyword())).collect(Collectors.toList());
    }
}
