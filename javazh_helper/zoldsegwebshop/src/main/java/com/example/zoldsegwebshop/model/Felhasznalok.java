package com.example.zoldsegwebshop.model;

import java.util.HashMap;

public class Felhasznalok {
    private HashMap<String,String> felhasznalok;
    private static Felhasznalok instance;

    public static Felhasznalok getInstance(){
        if(instance==null)
            instance=new Felhasznalok();
        return instance;
    }



    public Felhasznalok() {
        this.felhasznalok=new HashMap<>();
        felhasznalok.put("a@gmail.com","jelszo1");
        felhasznalok.put("b@gmail.com","jelszo2");
    }


    public boolean helyesJelszo(String email, String jelszo){
        if(felhasznalok.get(email)!=null)
            return felhasznalok.get(email).equals(jelszo);
        return false;
    }
}
