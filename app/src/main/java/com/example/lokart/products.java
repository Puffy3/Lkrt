package com.example.lokart;

import android.widget.Button;

public class products {
    String title,description,price;
    int img;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public products(String title, String description, String price, int img) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.img = img;

    }
}
