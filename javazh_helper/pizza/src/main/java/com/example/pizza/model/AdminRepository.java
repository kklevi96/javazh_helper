package com.example.pizza.model;

import java.util.ArrayList;

public class AdminRepository {
    private static AdminRepository instance;
    private ArrayList<Admin> admins;
    public static AdminRepository getInstance(){
        if(instance==null)
            instance=new AdminRepository();
        return instance;
    }

    private AdminRepository(){
        admins=new ArrayList<>();
    }

    public Admin findAdmin(String username){
        return admins.stream().filter(a -> a.getUsername().equals(username)).findFirst().orElse(null);
    }

    public void addAdmin(Admin admin){
        admins.add(admin);
    }
}
