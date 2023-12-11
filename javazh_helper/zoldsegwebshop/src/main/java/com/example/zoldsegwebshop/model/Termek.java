package com.example.zoldsegwebshop.model;

public class Termek {
    public String getNev() {
        return nev;
    }

    private String nev;

    public double getAr() {
        return ar;
    }

    private double ar;

    public Termek(String nev, double ar){
        this.nev=nev;
        this.ar=ar;
    }
}
