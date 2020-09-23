package com.i9930.android.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SyrupsAdapter extends  RecyclerView.Adapter<SyrupsAdapter.MyViewHolder> {
    private ArrayList<SyrupsModel> list;
    public Context context;

    public SyrupsAdapter(Context context, ArrayList<SyrupsModel> list) {
        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public SyrupsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SyrupsAdapter.MyViewHolder holder, int position) {
        SyrupsModel dto = list.get(position);//return the position
        Picasso.with(context).load(dto.getImage()).into(holder.imageView);
        holder.name.setText(dto.getName());
        holder.price.setText(dto.getPrice());
        holder.brand.setText(dto.getBrand());
        holder.decripition.setText(dto.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name, decripition, brand, price;


        MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.iv_image);
            name = view.findViewById(R.id.card_name);
            price = view.findViewById(R.id.card_price);
            brand = view.findViewById(R.id.card_brand);
            decripition = view.findViewById(R.id.card_description);


        }

    }

}
