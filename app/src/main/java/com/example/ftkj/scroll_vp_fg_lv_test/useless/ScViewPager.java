package com.example.ftkj.scroll_vp_fg_lv_test.useless;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by FTKJ on 2017/8/10.
 */

public class ScViewPager extends ViewPager {
    private float xDistance, yDistance, xLast, yLast;

    public ScViewPager(Context context) {
        super(context);
    }

    public ScViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 事件分发，判断是否是左右滑动并且右侧有没有子项
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                Log.e("Client", xDistance + "移动" + yDistance);

                if (xDistance > yDistance && (getCurrentItem() > 0 || getCurrentItem() < getChildCount() - 1)) {
                    Log.e("Client", "右侧还有");
                    return true;
                } else if (yDistance > xDistance) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
// else if (xDistance > yDistance &&(getCurrentItem()==getChildCount()-1)){
// Log.e("Client","右侧没有");
// return false;
// }else{
// getParent().requestDisallowInterceptTouchEvent(false);
// Log.e("Client","其他");
// return true;
// }

        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int viewHeight = 0;
        View childView = getChildAt(getCurrentItem());
        if (childView != null) {
            childView.measure(widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            viewHeight = childView.getMeasuredHeight();
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(viewHeight,
                    MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
