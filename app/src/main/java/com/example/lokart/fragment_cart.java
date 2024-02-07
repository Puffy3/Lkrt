package com.example.lokart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class fragment_cart extends Fragment {
    private CartViewModel cartViewModel;
    private SharedViewModel sharedViewModel;
    ArrayAdapter<String> arr;

    public fragment_cart() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        cartViewModel = new ViewModelProvider(requireActivity()).get(CartViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);


        // Initialize your ListView and ArrayAdapter if not done already
        ListView listView = view.findViewById(R.id.listview);
        FloatingActionButton checkout=new FloatingActionButton(getContext());
        checkout=view.findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                arr.clear();
//                arr.notifyDataSetChanged();
                cartViewModel.clearCart();
                sharedViewModel.clearCart();
                // Handle the click event
                // For example, open a new activity or show a dialog

            }
        });

        if (arr == null) {
            arr = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,cartViewModel.getCartItems());
            listView.setAdapter(arr);
        }

        sharedViewModel.getCartItems().observe(getViewLifecycleOwner(), new Observer<List<String>>() {

            @Override
            public void onChanged(List<String> newTitles) {
                // Notify the adapter that the data set has changed

                arr.clear();
                arr.addAll(newTitles);
                arr.notifyDataSetChanged();
            }
        });

        return view;
    }
}
