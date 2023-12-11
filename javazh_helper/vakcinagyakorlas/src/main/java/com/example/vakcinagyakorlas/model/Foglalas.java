package com.example.vakcinagyakorlas.model;

public class Foglalas {
    private String TAJ;
    private int eletkor;
    //private Vakcina vakcina;
    private String vakcinaNev;


    public Foglalas(String TAJ, int eletkor, String vakcinaNev) {
        this.TAJ = TAJ;
        this.eletkor = eletkor;
        //this.vakcina=new Vakcina(vakcinaNev, vakcina.getDarabszam());
        this.vakcinaNev=vakcinaNev;
    }

    public String getTAJ() {
        return TAJ;
    }

    public int getEletkor() {
        return eletkor;
    }

    //public Vakcina getVakcina() {
    //    return vakcina;
    //}

    public String getVakcinaNev(){
        return vakcinaNev;
    }
}
