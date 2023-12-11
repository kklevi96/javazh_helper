package com.example.MintaZH.model;

public class Product {
    private static String[] allKeywords;
    static{
        allKeywords=new String[]{"food","toys","electronics","furniture","clothing"};
    }

    private String name;
    private int price;
    private String keyword;
    private String reservedBy;

    public Product(String name, int price, String keyword) {
        this.name = name;
        this.price = price;
        this.keyword = keyword;
    }

    public static String[] getAllKeywords() {
        return allKeywords;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }
}
