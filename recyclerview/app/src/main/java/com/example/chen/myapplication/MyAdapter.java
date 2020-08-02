package com.example.chen.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Chen on 2020/7/24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Information> informationList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        View InformationView;//创建视图对象,用于点击视图的时候实现
        TextView item_textView1,item_textView2;
        ImageView item_imageView;
        public ViewHolder(View view){
            super(view);
            InformationView=view;
            item_textView1=view.findViewById(R.id.item_textView1);
            item_textView2=view.findViewById(R.id.item_textView2);
            item_imageView=view.findViewById(R.id.item_imageView);
        }
    }
    public MyAdapter(List<Information> List){
        informationList =List;
    }
    @Override //创建viewholder
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_normal_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        //整个视图添加监听事件
        holder.InformationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position =holder.getAdapterPosition();
                Information information=informationList.get(position);
                Toast.makeText(view.getContext(),"你点击了"+information.getTextView1(),Toast.LENGTH_SHORT).show();
            }
        });
        //图片添加监听事件
        holder.item_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position =holder.getAdapterPosition();
                Information information=informationList.get(position);
                Toast.makeText(view.getContext(),"你点击了图片"+information.getTextView1(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override //绑定数据
    public void onBindViewHolder(ViewHolder holder, int position) {
        Information information = informationList.get(position);
        holder.item_textView1.setText(information.getTextView1());
        holder.item_textView2.setText(information.getTextView2());
        holder.item_imageView.setImageResource((int) information.getImageView());

    }
    @Override
    public int getItemCount() {
        return  informationList.size();
    }



}
