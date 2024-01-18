package com.example.lokart;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends ViewModel {
    private CartRepository cartRepository = new CartRepository();

    public List<String> getCartItems() {
        return cartRepository.getCartItems();
    }

    public void addToCart(String title) {
        cartRepository.addToCart(title);
    }
}
