package com.example.ftkj.scroll_vp_fg_lv_test;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private HashMap<String, List> mDataMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        mDataMap = new HashMap<>();
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, mDataMap);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL,false));
        initData();
    }

    private void initData() {
        List<Integer> heads = new ArrayList<>();
        heads.add(R.mipmap.ic_launcher);
        heads.add(android.R.drawable.ic_menu_call);
        mDataMap.put("head",heads);

        ArrayList<List<String>> pagers = new ArrayList<>();

        ArrayList<String> page1 = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            page1.add("页面1    "+i);
        }
        pagers.add(page1);

        ArrayList<String> page2 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            page2.add("页面2    "+i);
        }
        pagers.add(page2);

        ArrayList<String> page3 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            page3.add("页面3    "+i);
        }
        pagers.add(page3);

        ArrayList<String> page4 = new ArrayList<>();
        for (int i = 0; i <2; i++) {
            page4.add("页面4    "+i);
        }

        pagers.add(page4);

        mDataMap.put("pager",pagers);


    }



}
