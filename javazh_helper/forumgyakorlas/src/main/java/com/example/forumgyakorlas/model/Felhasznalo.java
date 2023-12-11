package com.example.forumgyakorlas.model;

import org.apache.commons.codec.digest.DigestUtils;

public class Felhasznalo {
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    static int nextId = 0;
    private String name;
    final private String nickname;
    private String password;
    private String email;

    public Felhasznalo(String name, String nickname, String password, String email) {
        this.id = nextId++;
        this.name = name;
        this.nickname = nickname;
        this.password = DigestUtils.md5Hex(password);
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
