package com.example.ftkj.scroll_vp_fg_lv_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by FTKJ on 2017/8/10.
 */

public class WelcomActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
    }

    public void goBtn1(View view) {
        GoManager.goProject1(this);
        finish();
    }

    public void goBtn2(View view) {
        GoManager.goProject2(this);
        finish();
    }

    public void goBtn3(View view) {
        GoManager.goProject3(this);
        finish();

    }
}
