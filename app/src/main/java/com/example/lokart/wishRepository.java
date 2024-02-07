package com.example.lokart;

import java.util.ArrayList;
import java.util.List;

public class wishRepository {
    private List<String> wishItems = new ArrayList<>();

    public List<String> getwishItems() {
        return wishItems;
    }

    public void addTowish(String title) {

        wishItems.add(title);
    }
    public void clearwish() {
        wishItems.clear();
    }
}