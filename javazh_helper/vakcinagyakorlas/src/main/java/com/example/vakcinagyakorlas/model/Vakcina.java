package com.example.vakcinagyakorlas.model;

public class Vakcina {
    private String nev;
    private int darabszam;

    public Vakcina(String nev, int darabszam) {
        this.nev = nev;
        this.darabszam = darabszam;
    }

    public String getNev() {
        return nev;
    }

    public int getDarabszam() {
        return darabszam;
    }

    public void decreaseDarabszam() {
        this.darabszam = darabszam-1;
    }

    public void increaseDarabszam() {
        this.darabszam = darabszam+1;
    }

    //@Override
    //public String toString() {
        //return this.getNev();
    //}
}
