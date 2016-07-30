package com.example.nanchen.commonadapterforlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 常见的ListView的Adapter适配器
 * Created by 南尘 on 16-7-28.
 */
public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<Data> list;

    public MyListAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
            holder = new MyViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.item_image);
            holder.tv = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        Data data = (Data) getItem(position);
        holder.iv.setImageResource(data.getImageId());
        holder.tv.setText(data.getText());
        return convertView;
    }

    public static class MyViewHolder {
        ImageView iv;
        TextView tv;
    }
}
