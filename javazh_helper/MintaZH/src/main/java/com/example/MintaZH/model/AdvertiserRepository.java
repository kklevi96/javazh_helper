package com.example.MintaZH.model;

import java.util.ArrayList;

public class AdvertiserRepository {
    private static AdvertiserRepository instance;
    private ArrayList<Advertiser> advertisers;

    public static AdvertiserRepository getInstance() {
        if (instance==null){
            instance=new AdvertiserRepository();
        }
        return instance;
    }

    private AdvertiserRepository(){
        advertisers=new ArrayList<>();
        Advertiser a1=new Advertiser("a1@gmail.com");
        a1.addProduct(new Product("black jacket",6500,"clothing"));
        a1.addProduct(new Product("fidget spinner",300,"toys"));
        a1.addProduct(new Product("chair",8200,"furniture"));
        advertisers.add(a1);
        Advertiser a2=new Advertiser("a2@gmail.com");
        a2.addProduct(new Product("homemade bread",800,"food"));
        advertisers.add(a2);
    }
    public ArrayList<Advertiser> getAdvertisers() {
        return advertisers;
    }
    public Advertiser findAdvertiser(String email){
        return advertisers.stream().filter(a->a.getEmail().equals(email)).findFirst().orElse(null);
    }
}
