package com.example.notificationtest.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notificationtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    List<HashMap<String,Object>> dataList = new ArrayList<HashMap<String, Object>>(){
        {
          add(new HashMap<String, Object>(){
              {
                  put("isSelect",false);
                  put("title","name1");
              }
          });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name2");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name3");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name4");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name5");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name6");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name7");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name8");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name9");
                }
            });
            add(new HashMap<String, Object>() {
                {
                    put("isSelect", false);
                    put("title","name10");
                }
            });
        }
    };
    private AlertDialog alertDialog;
    private Context mContext;
    public ShoppingAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ShoppingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shopping_adapter,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingAdapter.ViewHolder holder, int position) {
        holder.shoppingTitle.setText((String)dataList.get(position).get("title"));

        if (!(boolean) dataList.get(position).get("isSelect")){
            holder.iconImage.setImageResource(R.mipmap.icon_tik_nor);
        }else {
            holder.iconImage.setImageResource(R.mipmap.icon_tik_act);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((boolean)dataList.get(position).get("isSelect")){
                    dataList.get(position).put("isSelect",false);
                }else {
                    dataList.get(position).put("isSelect",true);
                }
//                刷新单个
                notifyItemChanged(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
//                这块改成true，不然松开后会触发点击事件
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setMessage("是否删除该item");
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alert.setNeutralButton("取消",null);
                alertDialog = alert.create();
                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iconImage;
        private TextView shoppingTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.shopping_select_icon);
            shoppingTitle = (TextView) itemView.findViewById(R.id.shopping_title);
        }
    }
}
