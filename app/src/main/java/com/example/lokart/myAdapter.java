package com.example.lokart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kotlinx.coroutines.GlobalScope;


public class myAdapter extends RecyclerView.Adapter<myAdapter.Myviewholder> {



    Context context;
    ArrayList<products> productsArraylist;
    fragment_home.btnclick btnclick;
    fragment_home.hrtclick hrtclick;

    public myAdapter(Context context, ArrayList<products> productsArraylist,fragment_home.btnclick btnclick, fragment_home.hrtclick hrtclick){
        this.context=context;
        this.productsArraylist=productsArraylist;
        this.btnclick=btnclick;
        this.hrtclick=hrtclick;
    }
    @NonNull
    @Override
    public myAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.product_list,parent,false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.Myviewholder holder, @SuppressLint("RecyclerView") final int position) {
    products product=productsArraylist.get(position);
    holder.img.setImageResource(product.img);
    holder.title.setText(product.title);
        holder.description.setText(product.description);
        holder.price.setText(product.price);
    holder.cart.setText("Add to cart");
        holder.heart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(hrtclick!=null){
                    products product=productsArraylist.get(position);
                    hrtclick.onhrtclick(1,productsArraylist.get(position).getTitle());
                }
            }


        });
        holder.cart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btnclick!=null){
                    products product=productsArraylist.get(position);
                    btnclick.onbtnclick(1,productsArraylist.get(position).getTitle());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
       return productsArraylist.size();
    }

    public static class Myviewholder extends RecyclerView.ViewHolder {
        ArrayList<String> a = new ArrayList<>();
        ImageView img,heart;
       public TextView title,description,price;
        Button cart;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.product_image);
            title=itemView.findViewById(R.id.product_title);
            description=itemView.findViewById(R.id.product_description);
            price=itemView.findViewById(R.id.product_price);
            cart=itemView.findViewById(R.id.crtbtn);
            heart=itemView.findViewById(R.id.heart);
//            cart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    fragment_home fh=new fragment_home();
//                    fh.add(title.getText().toString());
//                }
//            });
        }


//        public void callFromFragment(){
//            Log.d("demo", a.toString());
//        }
    }

}