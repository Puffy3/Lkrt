package com.example.lokart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.List;

public class fragment_wishlist extends Fragment {
    private wishViewModel wishViewModel;
    private SharedViewModel sharedViewModel;
    ArrayAdapter<String> arr;

    public fragment_wishlist() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        wishViewModel = new ViewModelProvider(requireActivity()).get(wishViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);


        // Initialize your ListView and ArrayAdapter if not done already
        ListView listView = view.findViewById(R.id.wishlistview);
        Button btn=new Button(getContext());
        btn=view.findViewById(R.id.clrlst);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                arr.clear();
//                arr.notifyDataSetChanged();
                wishViewModel.clearwish();
                sharedViewModel.clearwish();
                // Handle the click event
                // For example, open a new activity or show a dialog

            }
        });

        if (arr == null) {
            arr = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,wishViewModel.getwishItems());
            listView.setAdapter(arr);
        }

        sharedViewModel.getwishItems().observe(getViewLifecycleOwner(), new Observer<List<String>>() {

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