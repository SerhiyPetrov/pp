package com.company;

public class Product {
    int id;
    String name;
    String producer;
    double cost;
    Date date;
    int amount;
    public Product(){
        date = new Date();
    }
    public Product(int id, String name, String producer, double cost, Date date, int
            amount) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.cost = cost;
        this.date = date;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id =" + id +
                ", name ='" + name + '\'' +
                ", producer ='" + producer + '\'' +
                ", cost =" + cost +
                ", " + date.toString() +
                ", amount =" + amount +
                '}';
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
