package com.example.lokart;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<List<String>> cartItems = new MutableLiveData<>();

    public SharedViewModel() {
        cartItems.setValue(new ArrayList<>());
    }

    public LiveData<List<String>> getCartItems() {
        return cartItems;
    }

    public void addToCart(String item) {
        List<String> currentItems = cartItems.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            cartItems.setValue(currentItems);
        }
    }
}

