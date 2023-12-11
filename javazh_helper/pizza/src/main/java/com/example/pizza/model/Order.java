package com.example.pizza.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Order {
    private ArrayList<Pizza> pizzas;
    private String ordererName;

    private String ordererAddress;
    private int id;
    static int nextId=0;

    public Order(Pizza pizza, String ordererName, String ordererAddress) {
        this.ordererName=ordererName;
        this.ordererAddress=ordererAddress;
        if(pizzas==null)
            pizzas=new ArrayList<>();
        this.id=nextId++;
        //PizzaRepository.getInstance().addPizza(pizza);
        pizzas.add(pizza);
    }

    public int orderPrice(){
        return pizzas.stream().mapToInt(Pizza::totalPrice).sum();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public String getOrdererName() {
        return ordererName;
    }

    public String getOrdererAddress() {
        return ordererAddress;
    }

    //public void setOrdererName(String ordererName) {
        //this.ordererName = ordererName;
    //}

    //public void setOrdererAddress(String ordererAddress) {
        //this.ordererAddress = ordererAddress;
    //}

}
