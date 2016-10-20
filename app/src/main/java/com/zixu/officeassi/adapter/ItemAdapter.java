package com.zixu.officeassi.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zixu.officeassi.R;


public class ItemAdapter extends BaseAdapter {
    private Integer[] pic = {R.drawable.bg1};

    //private String [] icname ={"审批","工作"};

    private Context context;

    public ItemAdapter() {

    }

    public ItemAdapter(Activity activity) {
        this.context = activity;
    }

    @Override
    public int getCount() {
        return pic.length;
    }

    @Override
    public Object getItem(int position) {

        return getItemId(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        //创建复杂的布局作为返回值
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.item_mind, null);
            holder = new ViewHolder();
            holder.iv_sp = (ImageView) convertView.findViewById(R.id.iv_sp);
            holder.tv_sp = (TextView) convertView.findViewById(R.id.tv_sp);
            convertView.setTag(holder);
        //复用convertView
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //设置内容
        holder.iv_sp.setImageResource(pic[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView iv_sp;
        TextView tv_sp;
    }
}
