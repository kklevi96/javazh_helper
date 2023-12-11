package com.example.pizza.model;

import java.util.ArrayList;

public class OrderRepository {
    public ArrayList<Order> getOrders() {
        return orders;
    }

    private ArrayList<Order> orders;
    private static OrderRepository instance;
    public static OrderRepository getInstance(){
        if(instance==null)
            instance=new OrderRepository();
        return instance;
    }

    private OrderRepository(){
        orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }
}
