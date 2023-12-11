package com.example.pizza.model;

import java.util.Locale;

public class Admin {
    private int id;
    static int nextId=0;
    private String username;
    private String password;

    public Admin(String username, String password){
        this.id=nextId++;
        this.username=username.toLowerCase(Locale.ROOT);
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
