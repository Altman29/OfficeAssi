package com.zixu.officeassi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;

public class DisagreeActivity extends AutoLayoutActivity implements View.OnClickListener {

    private TextView tv_quxiao2;
    private TextView tv_hold2;
    private EditText et_disagreeremark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disagree);

        tv_quxiao2 = (TextView) findViewById(R.id.tv_quxiao2);
        tv_hold2 = (TextView) findViewById(R.id.tv_hold2);
        et_disagreeremark = (EditText) findViewById(R.id.et_disagreeremark);

        tv_quxiao2.setOnClickListener(this);
        tv_hold2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_quxiao2:
                finish();
                break;
            case R.id.tv_hold2:
                String disagreeremark = et_disagreeremark.getText().toString().trim();
                if (TextUtils.isEmpty(disagreeremark)) {
                    Toast.makeText(getApplicationContext(), "请输入备注", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("disagreeremark", disagreeremark);
                    setResult(2, intent);
                    Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }
}
