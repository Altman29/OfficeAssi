package com.zixu.officeassi.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zixu.officeassi.ApproveActivity;
import com.zixu.officeassi.R;
import com.zixu.officeassi.adapter.ItemAdapter;


//工作界面九宫格设置
public class ContentFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private GridView gv_item;

    //设置布局
    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragement_content, null);
        findViews(view);
        return view;
    }

    private void findViews(View view) {

        gv_item = (GridView) view.findViewById(R.id.gv_item);
        ItemAdapter adapter = new ItemAdapter(getActivity());
        gv_item.setAdapter(adapter);
        //设置点击事件
        gv_item.setOnItemClickListener(this);

    }
    //跳转到详细界面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ApproveActivity.class);
        startActivity(intent);
    }
}
