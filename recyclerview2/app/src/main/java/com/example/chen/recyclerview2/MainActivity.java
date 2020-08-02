package com.example.chen.recyclerview2;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFooterAutoLoadMoreListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyRecyclerView myRecyclerView;
    private List<Model> modelList=new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SwipeRefreshLayout布局
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        myRecyclerView=(MyRecyclerView)findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.addFooterAutoLoadMoreListener(this);
        myAdapter=new MyAdapter(modelList);
        myRecyclerView.setAdapter(myAdapter);
        loadMore();//加载数据
        ///设置手势滑动监听器。
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新数据
                myAdapter.notifyAllDatas(modelList,myRecyclerView);
                modelList.clear();
                modelList.addAll(Model.getData());
                //设置组件的刷新状态false代表停止执行，这样，
                //当我们执行完毕获取数据的过程后，就可以将一直转的下拉动画给取消掉啦
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void loadMore() {
        myAdapter.notifyAllDatas(modelList,myRecyclerView);//刷新数据
        List<Model> list=Model.getData();
        modelList.addAll(list);
        swipeRefreshLayout.setRefreshing(false);//初次要停止刷新
    }
}
