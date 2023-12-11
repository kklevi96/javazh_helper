package com.example.pizza.model;

import java.util.ArrayList;

public class Pizza
{
    private int size;
    private ArrayList<Topping> toppings;
    private static Pizza instance;

    public Pizza(int size) {
        this.size = size;
        toppings=new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping t){
        toppings.add(t);
    }

    public void removeTopping(Topping t){
            // It is possible to order multiple servings of one topping, therefore we will remove just one
        toppings.remove(t);
    }

    public int totalPrice(){
        //Let base price be proportional to size
        return toppings.stream().mapToInt(Topping::getPrice).sum() + size*50;
    }
}
