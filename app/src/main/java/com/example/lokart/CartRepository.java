package com.example.lokart;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private List<String> cartItems = new ArrayList<>();

    public List<String> getCartItems() {
        return cartItems;
    }

    public void addToCart(String title) {

        cartItems.add(title);
    }
}
