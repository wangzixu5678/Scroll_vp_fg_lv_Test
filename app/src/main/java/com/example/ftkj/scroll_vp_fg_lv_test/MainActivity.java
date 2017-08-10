package com.example.ftkj.scroll_vp_fg_lv_test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String[] mStrings = {"标题0","标题1","标题2","标题3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyViewpager viewPager = (MyViewpager) findViewById(R.id.main_pager);

        TabLayout tablayout = (TabLayout) findViewById(R.id.main_tab);
        ArrayList<TestFragment> frgamengs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            TestFragment testFragment = TestFragment.getNewInstance(String.valueOf(i));
            frgamengs.add(testFragment);
        }

        MyViewpagerAdapter adapter = new MyViewpagerAdapter(getSupportFragmentManager(),frgamengs,mStrings);
        viewPager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewPager);



    }


    class MyViewpagerAdapter extends FragmentPagerAdapter{
        private List<? extends Fragment> mFragments;
        private String[] mStrings;

        public MyViewpagerAdapter(FragmentManager fm,List<? extends Fragment> fragments,String[] strings) {
            super(fm);
            mFragments = fragments;
            mStrings = strings;

        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mStrings[position];
        }
    }
}
