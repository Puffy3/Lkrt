package com.example.lokart;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class wishViewModel extends ViewModel {
    private wishRepository wishRepository = new wishRepository();

    public List<String> getwishItems() {
        return wishRepository.getwishItems();
    }

    public void addTowish(String title) {
        wishRepository.addTowish(title);
    }
    public void clearwish() {
        wishRepository.clearwish();
    }
}