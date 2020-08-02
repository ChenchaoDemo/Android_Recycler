package com.example.chen.recyclerview2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen on 2020/7/24.
 */

//定义一个Model,用于模拟数据加载
public class Model {
    private String textView1;
    private String textView2;
    private int imageId;
    public Model(String text1,String text2,int image){
        this.textView1=text1;
        this.textView2=text2;
        this.imageId=image;
    }

    public String getTextView1() {
        return textView1;
    }

    public void setTextView1(String textView1) {
        this.textView1 = textView1;
    }

    public String getTextView2() {
        return textView2;
    }

    public void setTextView2(String textView2) {
        this.textView2 = textView2;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    //获取数据
    public static List<Model> getData(){
        List<Model> Modellist=new ArrayList<>();
        for(int i=0;i<30;i++){
            Model model=new Model("大标题"+i,"小标题"+i,R.drawable.image);
            Modellist.add(model);
        }
        return Modellist;
    }
}
