package com.peanuts.delivery.model;

import java.util.Date;

public class Offer {

    private String name;
    private String cost;
    private Currency currency;
    private Date deadline;

    public Offer() {
    }

    public Offer(String name, String cost, Currency currency, Date deadline) {
        this.name = name;
        this.cost = cost;
        this.currency = currency;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

}
