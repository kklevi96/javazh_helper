package com.example.etteremgyakorlas.model;

import java.util.ArrayList;

public class Etterem {
    final private String[] napok;
    final private String[] idopontok;
    final private String[][] foglalasok;
    private static Etterem instance;
    final private ArrayList<String> fonokok;

    public boolean FonokContains(String input){
        return fonokok.contains(input);
    }

    public static Etterem getInstance(){
        if(instance==null)
            instance=new Etterem();
        return instance;
    }

    public Etterem() {
        this.napok=new String[]{"Hétfő","Kedd","Szerda","Csütörtök","Péntek"};
        this.idopontok=new String[]{"18-19","19-20","20-21"};
        this.foglalasok=new String[napok.length][idopontok.length];
        this.fonokok=new ArrayList<>();
        fonokok.add("Főni1");
        fonokok.add("szakacs");
        fonokok.add("én");
    }

    public String[] getNapok() {
        return napok;
    }

    public String[] getIdopontok() {
        return idopontok;
    }

    public String[][] getFoglalasok() {
        return foglalasok;
    }
}
