package com.example.lokart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class fragment_home extends Fragment{

    private SharedViewModel sharedViewModel;
    private ArrayList<products> productsArraylist;
    private RecyclerView recyclerview;

    public fragment_home() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        // Inflate the layout for this fragment
        datainitialise();
        View rootview= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerview=rootview.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter md = new myAdapter(getContext(), productsArraylist, new btnclick() {
            @Override
            public void onbtnclick(int position, String title) {
                sharedViewModel.addToCart(title);
                Toast.makeText(getContext(), title, Toast.LENGTH_SHORT).show();
//                fragment_cart fragment=new fragment_cart();
//                Bundle bundle =new Bundle();
//                bundle.putString("Title",title);
//                fragment.setArguments(bundle);
//               new MainActivity().s=title;
//                Toast.makeText(getActivity(), "Clicked "+title, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerview.setAdapter(md);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        recyclerview = view.findViewById(R.id.recyclerview);
//        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerview.setHasFixedSize(true);
//        myAdapter md = new myAdapter(getContext(), productsArraylist,btnclick);
//
//        recyclerview.setAdapter(md);
//
//        md.notifyDataSetChanged();
        
    }

 void add(String s)
 {
     Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
 }

    private void datainitialise() {
        productsArraylist= new ArrayList<>();
        products product =new products("Under Armour Men's Tech","<--description-->","\n₹999",R.drawable.apparel1);
        productsArraylist.add(product);
        products product2 =new products("Women's Lightweight Knit Hoodie Sweater Pullover","<--description-->","\n₹999",R.drawable.apparel2);
        productsArraylist.add(product2);
        products product3 =new products("Happy Sailed Womens Summer Boho Floral","<--description-->","\n₹999",R.drawable.apparel3);
        productsArraylist.add(product3);
        products product4 =new products("Womens Summer Boho Floral","<--description-->","\n₹999",R.drawable.apparel4);
        productsArraylist.add(product4);
        products product5 =new products("Iphone 14 pro max","<--description-->","\n₹999",R.drawable.electronic2);
        productsArraylist.add(product5);
        products product6 =new products("Skechers Women's Go Joy Walking Shoe Sneaker","<--description-->","\n₹999",R.drawable.shoe2);
        productsArraylist.add(product6);
        products product7 =new products("Walking Shoe Sneaker Womens","<--description-->","\n₹999",R.drawable.shoe3);
        productsArraylist.add(product7);
        products product8 =new products("Womens Summer Tosca Shoe","<--description-->","\n₹999",R.drawable.shoe4);
        productsArraylist.add(product8);
        products product9 =new products("Wireless Headphones Over Ear, Bluetooth Headphones with","<--description-->","\n₹999",R.drawable.electronic3);
        productsArraylist.add(product9);
//        products product3 =new products("jacket","jshgnengiergijeri\nwuiehwhe","\n₹999",R.drawable.wmnfsh);
//        productsArraylist.add(product3);
//        products product3 =new products("jacket","jshgnengiergijeri\nwuiehwhe","\n₹999",R.drawable.wmnfsh);
//        productsArraylist.add(product3);
//        products product3 =new products("jacket","jshgnengiergijeri\nwuiehwhe","\n₹999",R.drawable.wmnfsh);
//        productsArraylist.add(product3);



    }
    public interface btnclick{
        void onbtnclick(int position,String title);
    }
}