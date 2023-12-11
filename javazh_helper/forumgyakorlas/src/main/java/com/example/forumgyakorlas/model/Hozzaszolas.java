package com.example.forumgyakorlas.model;

public class Hozzaszolas {
    private String hozzaszolas;
    private int hozzaszolasSzerzo;

    public Hozzaszolas(String hozzaszolas, int hozzaszolasSzerzo) {
        this.hozzaszolas = hozzaszolas;
        this.hozzaszolasSzerzo = hozzaszolasSzerzo;
    }


    public String getHozzaszolas() {
        return hozzaszolas;
    }

    public int getHozzaszolasSzerzo() {
        return hozzaszolasSzerzo;
    }
}
