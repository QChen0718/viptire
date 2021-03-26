package com.example.notificationtest.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notificationtest.R;
import com.example.notificationtest.entity.HomeResponse;
import com.example.notificationtest.entity.HomeResultResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    item类型
    private List<HomeResultResponse> homeResponseList;
    private Context context;
    private View view;
    private static final int HEAD_VIEW = 0;
    private static final int CONTENT_VIEW = 1;
    private static final int BOTTOM_VIEW = 2;

    public FruitAdapter(List<HomeResultResponse> homeResponseList,Context context) {
        this.homeResponseList = homeResponseList;
        this.context = context;
    }

//    判断当前item是否是HeadView
    public boolean isHeaderView(int position){
        return  position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return HEAD_VIEW;
        }
        else {
            return CONTENT_VIEW;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == HEAD_VIEW){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);
//            StaggeredGridLayoutManager.LayoutParams sglp =
            holder = new HeadViewHolder(view,context);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fruit_adapter,parent,false);
            holder = new ViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        cell赋值
        if (holder instanceof ViewHolder){
            HomeResultResponse homeResponse = homeResponseList.get(position-1);
            ((ViewHolder) holder).fruitName.setText(homeResponse.getTitle());
            ((ViewHolder) holder).fruitPrice.setText(homeResponse.getPrice().toString());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"视图被点击"+position,Toast.LENGTH_SHORT).show();
                }
            });
        }else if (holder instanceof HeadViewHolder){
            ((HeadViewHolder) holder).headText.setText("测试一下");
        }

    }

    @Override
    public int getItemCount() {
        return homeResponseList.size() + 1;
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

    static class HeadViewHolder extends RecyclerView.ViewHolder{
        private List<Map<String,Object>> itemListData = new ArrayList<Map<String, Object>>(){
            {
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item1);
                        put("title","轮胎");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item2);
                        put("title","油品");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item3);
                        put("title","蓄电池");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item4);
                        put("title","刹车片");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item5);
                        put("title","火花塞");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item6);
                        put("title","机滤");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item7);
                        put("title","空滤");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item8);
                        put("title","空调滤");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item9);
                        put("title","变速箱滤");
                    }
                });
                add(new HashMap<String, Object>() {
                    {
                        put("image",R.mipmap.icon_item10);
                        put("title","防冻液");
                    }
                });
            }
        };
        TextView headText;
        ImageView headImage;
        EditText editText;
        RecyclerView itemRecycleView;
        public HeadViewHolder(View itemView,Context context) {
            super(itemView);
            headText = (TextView) itemView.findViewById(R.id.head_text);
            headImage = (ImageView) itemView.findViewById(R.id.head_image);
            editText = (EditText) itemView.findViewById(R.id.edit_text);
            itemRecycleView = (RecyclerView) itemView.findViewById(R.id.recycler_item);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,5);
            gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
            itemRecycleView.setLayoutManager(gridLayoutManager);
            ProductItemAdapter adapter = new ProductItemAdapter(itemListData);
            itemRecycleView.setAdapter(adapter);
        }
    }
}