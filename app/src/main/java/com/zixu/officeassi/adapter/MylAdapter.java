package com.zixu.officeassi.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zixu.officeassi.R;
import com.zixu.officeassi.bean.UserBean;

import java.util.ArrayList;
import java.util.List;


public class MylAdapter extends BaseAdapter {

    private Context context;
    private List<UserBean.DataListBean> userBean = new ArrayList<UserBean.DataListBean>();
    private int type;

    public MylAdapter(Activity activity, List<UserBean.DataListBean> userBean) {
        this.context = activity;
        this.userBean = userBean;
    }


    @Override
    public int getCount() {

        return userBean.size();
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

        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.my_adapter, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_conte = (TextView) convertView.findViewById(R.id.tv_conte);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            holder.im_tria = (ImageView) convertView.findViewById(R.id.iv_tria);
            holder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        holder.tv_name.setText(userBean.get(position).getApplyNum());
        holder.tv_conte.setText(userBean.get(position).getMc_kem());


                holder.tv_state.setText("已审核");
                holder.im_tria.setImageResource(R.mipmap.trialimg3);

        return convertView;
    }


    static class ViewHolder {
        TextView tv_name;
        TextView tv_conte;
        TextView tv_date;
        ImageView im_tria;
        TextView tv_state;
    }
}
