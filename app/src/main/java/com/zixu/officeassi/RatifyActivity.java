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

public class RatifyActivity extends AutoLayoutActivity implements View.OnClickListener {

    private TextView tv_quxiao3;
    private TextView tv_hold3;
    private CheckBox ck_1;
    private CheckBox ck_2;
    private EditText et_ratifyremark;
    private String checked;
    private int ch1;
    private int ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratify);

        tv_quxiao3 = (TextView) findViewById(R.id.tv_quxiao3);
        tv_hold3 = (TextView) findViewById(R.id.tv_hold3);
        ck_1 = (CheckBox) findViewById(R.id.ck_1);
        ck_2 = (CheckBox) findViewById(R.id.ck_2);
        et_ratifyremark = (EditText) findViewById(R.id.et_ratifyremark);
        tv_quxiao3.setOnClickListener(this);
        tv_hold3.setOnClickListener(this);

        ck_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ch1=88;
                }else{
                    ch1=0;
                }
            }
        });
        ck_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ch2=421;
                }else {
                    ch2=0;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_quxiao3:
                finish();
                break;
            case R.id.tv_hold3:
                String ratifyremark = et_ratifyremark.getText().toString().trim();
                if (TextUtils.isEmpty(ratifyremark)) {
                    Toast.makeText(getApplicationContext(), "请输入备注", Toast.LENGTH_SHORT).show();

                } else {
                    checked="";
                    if(ch1!=0){
                        checked=checked+ch1;
                        if (ch2!=0){
                            checked=checked+","+ch2;
                        }
                    }else {
                        if (ch2!=0){
                            checked=checked+ch2;
                        }else {
                            Toast.makeText(getApplicationContext(), "请选择会签人员", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    Intent intent = new Intent();
                    intent.putExtra("ratifyremark", ratifyremark);
                    intent.putExtra("checkId",checked);
                    setResult(3, intent);
                    Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            default:
                break;

        }
    }
}
