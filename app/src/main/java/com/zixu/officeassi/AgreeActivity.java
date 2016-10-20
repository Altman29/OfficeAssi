package com.zixu.officeassi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zixu.officeassi.utils.SharedPreferencesUtils;

public class AgreeActivity extends AutoLayoutActivity implements View.OnClickListener {

    private TextView tv_quxiao1;
    private TextView tv_hold1;
    private EditText et_agreeremark;
    private int wenjie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);
        wenjie = getIntent().getIntExtra("wenjie", 0);

        tv_quxiao1 = (TextView) findViewById(R.id.tv_quxiao1);
        tv_hold1 = (TextView) findViewById(R.id.tv_hold1);
        et_agreeremark = (EditText) findViewById(R.id.et_agreeremark);

        tv_quxiao1.setOnClickListener(this);
        tv_hold1.setOnClickListener(this);

        if (wenjie == 345) {
            String agreeremark = SharedPreferencesUtils.getStringData(this, "agreeremark", "");
            et_agreeremark.setText(agreeremark);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_quxiao1:
                //Intent intent1 = new Intent();
                //intent1.putExtra("rbagree",false);
                //setResult(RESULT_OK, intent1);
                finish();
                break;
            case R.id.tv_hold1:
                String agreeremark = et_agreeremark.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("agreeremark", agreeremark);
                intent.putExtra("wenjie", 345);
                //intent.putExtra("rbagree",true);

                setResult(RESULT_OK, intent);
                Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                finish();
                SharedPreferencesUtils.saveStringData(getApplicationContext(), "agreeremark", agreeremark);
                break;
        }
    }
}
