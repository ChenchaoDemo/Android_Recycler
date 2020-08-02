package com.example.chen.recyclerview2;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.chen.recyclerview2.MyRecyclerView.VIEW_TYPE_FOOTER;
import static com.example.chen.recyclerview2.MyRecyclerView.VIEW_TYPE_NOMAL;

/**
 * Created by Chen on 2020/7/24.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyViewHolder> {
    private List<Model> modelList;//数据list
    private static final String TAG="MyAdapter";
    public MyAdapter(List<Model> list) {
        this.modelList = list;
    }

    /**
     * 返回view类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        Log.e(TAG,"position:"+position);
        Log.e(TAG,"getItemViewType");
        if (position == getItemCount() - 1)//如果是最后一个item，则是底部布局
            return VIEW_TYPE_FOOTER;//末尾的item
        return VIEW_TYPE_NOMAL;  //正常item
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG,"onCreateViewHolder");
        if (viewType == VIEW_TYPE_FOOTER)
            return MyViewHolder.createViewHolder(parent, R.layout.item_root_footer);//返回底部布局
        return MyViewHolder.createViewHolder(parent, R.layout.item_normal); //返回正常item
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.e(TAG,"onBindViewHolder");
        int viewType = getItemViewType(position);
        if (viewType == VIEW_TYPE_NOMAL) {//正常item需要绑定数据
            TextView textView1=holder.getView(R.id.item_textView1);
            textView1.setText(modelList.get(position).getTextView1());
            TextView textView2=holder.getView(R.id.item_textView2);
            textView2.setText(modelList.get(position).getTextView2());
            ImageView imageView=holder.getView(R.id.item_imageView);
            imageView.setImageResource(modelList.get(position).getImageId());
        }
        //添加监听事件

//        myViewHolder.ParentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"你点击了"+modelList.get(position).getTextView1(),Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    /**
     * 返回item的数量
     * 因为在原有数据数量基础上加了一个底部布局，所以总的item数量应该+1
     * @return
     */
    @Override
    public int getItemCount() {
        int count = modelList.size();
        count++;
        return count;
    }

    /**
     * 刷新数据
     * @param mList
     */
    public void notifyAllDatas(List<Model> mList,MyRecyclerView recyclerView) {
        this.modelList = mList;
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }
}

