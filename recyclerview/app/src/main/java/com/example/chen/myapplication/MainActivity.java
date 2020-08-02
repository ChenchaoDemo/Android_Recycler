package com.example.chen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        initView();
    }

    private void initView() {
        //获取数据信息
        List<Information> informationList=getInformatica();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter=new MyAdapter(informationList);
        recyclerView.setAdapter(myAdapter);
    }

    private List<Information>  getInformatica() {
        List<Information> informationList =new ArrayList<>();
        for(int i=0;i<30;i++){
            Information information=new Information("标题"+i,"显示的内容"+i,R.drawable.image);
            informationList.add(information);
        }
        return informationList;
    }
}
