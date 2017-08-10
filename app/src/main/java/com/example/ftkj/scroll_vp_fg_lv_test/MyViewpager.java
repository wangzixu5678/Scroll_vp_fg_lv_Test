package com.example.ftkj.scroll_vp_fg_lv_test;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class MyViewpager extends ViewPager {
    private List<Integer> mlist;
    public MyViewpager(Context context) {
        this(context,null);
    }

    public MyViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mlist = new ArrayList<>();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        //int currentItem = getCurrentItem();
        //View child = getChildAt(currentItem);
        for (int i = 0; i < getChildCount(); i++) {
            View cc = getChildAt(i);
            cc.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            height = cc.getMeasuredHeight();
            if (!mlist.contains(height)) {
                mlist.add(height);
            }
        }


        Log.d("AA", "onMeasure: "+mlist);
//        if (child!=null) {
//            Log.d("AAA", "onMeasure: "+currentItem +"不为空");
//            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//            height = child.getMeasuredHeight();
//
//        }
        if (!mlist.isEmpty()) {
            switch (getCurrentItem()) {
                case 0:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(mlist.get(0), MeasureSpec.EXACTLY);
                    break;
                case 1:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(mlist.get(1), MeasureSpec.EXACTLY);
                    break;
                case 2:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(mlist.get(2), MeasureSpec.EXACTLY);
                    break;
                case 3:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(mlist.get(3), MeasureSpec.EXACTLY);
                    break;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



}

