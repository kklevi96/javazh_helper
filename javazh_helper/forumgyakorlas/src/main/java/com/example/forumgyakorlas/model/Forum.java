package com.example.forumgyakorlas.model;

import java.util.ArrayList;

public class Forum {
    private static Forum instance;
    private ArrayList<Felhasznalo> felhasznalok;

    public ArrayList<Felhasznalo> getFelhasznalok() {
        return felhasznalok;
    }

    public ArrayList<Hozzaszolas> getHozzaszolasok() {
        return hozzaszolasok;
    }

    private ArrayList<Hozzaszolas> hozzaszolasok;

    public static Forum getInstance() {
        if (instance == null) {
            instance = new Forum();
        }
        return instance;
    }

    private Forum() {
        felhasznalok = new ArrayList<>();
        hozzaszolasok = new ArrayList<>();

        felhasznalok.add(new Felhasznalo("Első Ember", "nick1", "jelszo1","nick1@gmail.com"));
        felhasznalok.add(new Felhasznalo("Második Mária", "nick2", "jelszo2","nick2@gmail.com"));
        felhasznalok.add(new Felhasznalo("Harmadik Huba","nick3", "jelszo3","nick3@gmail.com"));
        hozzaszolasok.add(new Hozzaszolas("Elmentem a boltba",felhasznalok.get(0).getId()));
        hozzaszolasok.add(new Hozzaszolas("Mit vettél ott?",felhasznalok.get(1).getId()));
        hozzaszolasok.add(new Hozzaszolas("Kenyeret.",felhasznalok.get(0).getId()));
        hozzaszolasok.add(new Hozzaszolas("Ez meg mégis kit érdekelt?",felhasznalok.get(2).getId()));
    }

    public Felhasznalo FindFelhasznalo(String nickname) {
        return felhasznalok.stream().filter(a -> a.getNickname().equals(nickname)).findFirst().orElse(null);
    }

    public void AddFelhasznalo(Felhasznalo felhasznalo) {
            felhasznalok.add(felhasznalo);
    }

    public Felhasznalo FindFelhasznaloId(int id) {
        return felhasznalok.get(id);
    }
}
