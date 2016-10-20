package com.zixu.officeassi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;

public class ZhratifyActivity extends AutoLayoutActivity implements View.OnClickListener {

    private TextView tv_quxiao4;
    private TextView tv_hold4;
    private CheckBox ck;
    private EditText et_zhratifyremark;
    private int cb;
    private String checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhratify);

        tv_quxiao4 = (TextView) findViewById(R.id.tv_quxiao4);
        tv_hold4 = (TextView) findViewById(R.id.tv_hold4);
        ck = (CheckBox) findViewById(R.id.ck);
        et_zhratifyremark = (EditText) findViewById(R.id.et_zhratifyremark);

        tv_quxiao4.setOnClickListener(this);
        tv_hold4.setOnClickListener(this);

        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cb = 216;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_quxiao4:
                finish();
                break;
            case R.id.tv_hold4:
                String zhratifyremark = et_zhratifyremark.getText().toString().trim();
                if (TextUtils.isEmpty(zhratifyremark)) {
                    Toast.makeText(getApplicationContext(), "请输入备注", Toast.LENGTH_SHORT).show();

                } else {
                    checked = cb+"";
                    Intent intent = new Intent();
                    intent.putExtra("zhratifyremark", zhratifyremark);
                    intent.putExtra("checked", checked);

                    setResult(3, intent);
                    Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

            default:
                break;

        }
    }
}
