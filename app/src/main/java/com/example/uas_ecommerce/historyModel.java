package com.example.uas_ecommerce;

public class historyModel {
    private String name,status,amt,date;

    public historyModel(){}

    public historyModel(String name, String status, String amt, String date) {
        this.name = name;
        this.status = status;
        this.amt = amt;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
