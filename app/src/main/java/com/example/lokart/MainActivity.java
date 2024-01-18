package com.example.lokart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;

import com.example.lokart.R;
import com.example.lokart.fragment_cart;
import com.example.lokart.fragment_home;
import com.example.lokart.fragment_setting;
import com.example.lokart.fragment_wishlist;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements fragment_home.btnclick {
BottomNavigationView bn;
 public String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn = findViewById(R.id.bnView);

        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                // Check if the target fragment is already added
                Fragment currentFragment = fm.findFragmentById(R.id.container);

                if (id == R.id.home && !(currentFragment instanceof fragment_home)) {
                    ft.replace(R.id.container, new fragment_home());
                    ft.addToBackStack(null);  // Add to back stack
                } else if (id == R.id.wishlist && !(currentFragment instanceof fragment_wishlist)) {
                    ft.replace(R.id.container, new fragment_wishlist());
                    ft.addToBackStack(null);  // Add to back stack
                } else if (id == R.id.cart && !(currentFragment instanceof fragment_cart)) {
                    ft.replace(R.id.container, new fragment_cart());
                    ft.addToBackStack(null);  // Add to back stack
                } else if (id == R.id.settings && !(currentFragment instanceof fragment_setting)) {
                    ft.replace(R.id.container, new fragment_setting());
                    ft.addToBackStack(null);  // Add to back stack
                }

                ft.commit();
                return true;
            }
        });

// Set the default selected item
        bn.setSelectedItemId(R.id.home);


    }

    @Override
    public void onbtnclick(int position, String title) {


        // Navigate to fragment_cart and pass the title
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        fragment_cart fh = new fragment_cart();
        Bundle bundle = new Bundle();
        bundle.putString("Title", title);
        fh.setArguments(bundle);

        ft.replace(R.id.container, fh);
        ft.addToBackStack(null);  // Add to back stack
        ft.commit();
    }
}