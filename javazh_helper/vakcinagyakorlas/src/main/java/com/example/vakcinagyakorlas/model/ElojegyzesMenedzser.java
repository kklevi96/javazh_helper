package com.example.vakcinagyakorlas.model;

import java.util.ArrayList;

public class ElojegyzesMenedzser {
    private static ElojegyzesMenedzser instance;
    private ArrayList<Vakcina> vakcinak;
    private ArrayList<Foglalas> foglalasok;

    public static ElojegyzesMenedzser getInstance(){
        if(instance==null){
            instance=new ElojegyzesMenedzser();
        }
        return instance;
    }

    private ElojegyzesMenedzser(){
        vakcinak=new ArrayList<>();
        foglalasok=new ArrayList<>();
        Vakcina astra=new Vakcina("AstraZeneca",10);
        Vakcina moderna=new Vakcina("Moderna",7);
        Vakcina pfizer=new Vakcina("Pfizer",9);
        Vakcina sputnik=new Vakcina("Sputnik",2);
        Foglalas ember1=new Foglalas("111003451",25,moderna.getNev());
        Foglalas ember2=new Foglalas("129812318",18,pfizer.getNev());
        Foglalas ember3=new Foglalas("078213278", 84,astra.getNev());
        vakcinak.add(astra);
        vakcinak.add(moderna);
        vakcinak.add(pfizer);
        vakcinak.add(sputnik);
        foglalasok.add(ember1);
        foglalasok.add(ember2);
        foglalasok.add(ember3);

    }

    public ArrayList<Vakcina> getVakcinak() {
        return vakcinak;
    }

    //public ArrayList<Foglalas> getFoglalasok() {
        //return foglalasok;
    //}

    public Foglalas findFoglalas(String TAJ){
        return foglalasok.stream().filter(a->a.getTAJ().equals(TAJ)).findFirst().orElse(null);
    }

    public Vakcina findVakcina(String nev){
        return vakcinak.stream().filter(a->a.getNev().equals(nev)).findFirst().orElse(null);
    }

    public void addFoglalas(Foglalas foglalas){
        foglalasok.add(foglalas);

        //getVakcinak().stream().
    }

    public void delFoglalas(String TAJ){
        Foglalas f = ElojegyzesMenedzser.getInstance().findFoglalas(TAJ);
        foglalasok.remove(f);
       // f.getVakcina().setDarabszam(f.getVakcina().getDarabszam()+1);

    }

    //.stream().filter(a->a.getNev().equals(foglalas.getVakcinaNev())).findFirst().orElse(null);

}
