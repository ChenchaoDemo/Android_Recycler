package com.example.chen.myapplication;

/**
 * Created by Chen on 2020/7/24.
 */
//数据对象类
public class Information {
    private String textView1;
    private String textView2;
    private Object imageView;

    public Information(String textView1, String textView2, Object imageView){
        this.textView1=textView1;
        this.textView2=textView2;
        this.imageView=imageView;
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

    public Object getImageView() {
        return imageView;
    }

    public void setImageView(Object imageView) {
        this.imageView = imageView;
    }
}
