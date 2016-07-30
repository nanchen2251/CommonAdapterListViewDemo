package com.example.nanchen.commonadapterforlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Data> list;

    private CommonAdaper<Data> commonAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_lv);
        initList();

        initAdapter();

        listView.setAdapter(commonAdaper);
    }

    private void initAdapter() {
        commonAdaper = new CommonAdaper<Data>(this,list,R.layout.list_item) {
            @Override
            public void convert(ViewHolder holder, Data item) {
                holder.setText(R.id.item_text,item.getText());
                if (item.getImageUrl() != null){
                    holder.setImageByUrl(R.id.item_image,item.getImageUrl());
                }else {
                    holder.setImageResource(R.id.item_image,item.getImageId());
                }
            }
        };
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Data("本地 "+i,R.mipmap.ic_launcher));
        }

        for (int i = 0; i < 5; i++) {
            list.add(new Data("网络 "+i,"http://pic.cnblogs.com/face/845964/20160301162812.png"));
        }
    }

    public void btnClick(View view) {
        for (int i = 0; i < 5; i++) {
            list.add(new Data("本地 "+i,R.mipmap.ic_launcher));
        }
        for (int i = 0; i < 5; i++) {
            list.add(new Data("网络 "+i,"http://pic.cnblogs.com/face/845964/20160301162812.png"));
        }

        commonAdaper.notifyDataSetChanged();
    }
}
