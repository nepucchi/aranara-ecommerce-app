package com.example.uas_ecommerce;

public class itemModel {
    private String itemName, itemPrice;
    private int reviewCount;

    public itemModel(){}

    public itemModel(String itemName, String itemPrice, int reviewCount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.reviewCount = reviewCount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
}
