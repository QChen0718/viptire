package com.example.notificationtest.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notificationtest.R;
import com.example.notificationtest.entity.HomeResponse;
import com.example.notificationtest.entity.HomeResultResponse;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<HomeResultResponse> homeResponseList;

    public FruitAdapter(List<HomeResultResponse> homeResponseList) {
        this.homeResponseList = homeResponseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fruit_adapter,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        cell赋值
        HomeResultResponse homeResponse = homeResponseList.get(position);
        holder.fruitName.setText(homeResponse.getTitle());
        holder.fruitPrice.setText(homeResponse.getPrice());
    }

    @Override
    public int getItemCount() {
        return homeResponseList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitPrice;
        public ViewHolder(View view){
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.cell_image);
            fruitName = (TextView) view.findViewById(R.id.product_name);
            fruitPrice = (TextView) view.findViewById(R.id.product_price);
        }
    }
}