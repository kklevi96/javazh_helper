package com.example.zoldsegwebshop.model;

import java.util.ArrayList;

public class Kosar {
    private ArrayList<Termek> elemek;
    private int db;

    public int getDb() {
        return db;
    }

    public double getOsszesen() {
        return osszesen;
    }

    private double osszesen;

    public Kosar(){
        this.db=db;
        this.elemek=new ArrayList<>();
    }

    public void hozzaadas(Termek termek){
        elemek.add(termek);
        db++;
        osszesen=osszesen+termek.getAr();
    }
}
