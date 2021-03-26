package com.example.notificationtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notificationtest.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductItemAdapter extends RecyclerView.Adapter<ProductItemAdapter.ViewHolder> {
    private List<Map<String,Object>> dataList;

    public ProductItemAdapter(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_adapter_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Map<String,Object> currentData =  dataList.get(position);
        holder.productTitle.setText(currentData.get("title").toString());
        holder.productImage.setImageResource((Integer) currentData.get("image"));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage;
        TextView productTitle;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             productImage = (ImageView) itemView.findViewById(R.id.product_item_image);
             productTitle = (TextView) itemView.findViewById(R.id.product_item_title);
         }
     }
}
