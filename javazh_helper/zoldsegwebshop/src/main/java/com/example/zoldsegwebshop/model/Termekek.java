package com.example.zoldsegwebshop.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Termekek {
    private static Termekek instance;
    public static Termekek getInstance(){
        if(instance==null)
            instance=new Termekek();
        return instance;
    }
    private ArrayList<Termek> termekek;
    public Termekek(){
        termekek = new ArrayList<>();
        termekek.add(new Termek("banán", 600));
        termekek.add(new Termek("alma",  400));
        termekek.add(new Termek("körte", 500));
        termekek.add(new Termek("citrom",800));
    }
    public ArrayList<Termek> getTermekek(){
        return termekek;
    }
}
