package com.example.pizza.model;

import java.util.ArrayList;

public class ToppingRepository {
    private ArrayList<Topping> toppings;
    private static ToppingRepository instance;

    public static ToppingRepository getInstance(){
        if(instance==null)
            instance=new ToppingRepository();
        return instance;
    }

    private ToppingRepository(){
        toppings=new ArrayList<>();
        toppings.add(new Topping("mushrooms",100));
        toppings.add(new Topping("tomatoes",150));
        toppings.add(new Topping("beans",150));
        toppings.add(new Topping("broccoli",200));
        toppings.add(new Topping("corn",100));
        toppings.add(new Topping("cheddar cheese",300));
        toppings.add(new Topping("mozzarella cheese",200));
        toppings.add(new Topping("parmesan cheese",300));
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public Topping findTopping(String input){
        return toppings.stream().filter(topping -> topping.getName().equals(input)).findFirst().orElse(null);
    }
}
