package com.example.lokart;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<List<String>> cartItems = new MutableLiveData<>();
    private final MutableLiveData<List<String>> wishItems = new MutableLiveData<>();
    public SharedViewModel() {
        cartItems.setValue(new ArrayList<>());
        wishItems.setValue(new ArrayList<>());
    }

    public LiveData<List<String>> getCartItems() {
        return cartItems;
    }
    public LiveData<List<String>> getwishItems() {
        return wishItems;
    }
    public void addToCart(String item) {
        List<String> currentItems = cartItems.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            cartItems.setValue(currentItems);
        }
    }
    public void clearCart() {
        cartItems.setValue(new ArrayList<>());
    }
    public void clearwish() {
        wishItems.setValue(new ArrayList<>());
    }
    public void addTowish(String item) {
        List<String> currentItems = wishItems.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            wishItems.setValue(currentItems);
        }
    }
}

