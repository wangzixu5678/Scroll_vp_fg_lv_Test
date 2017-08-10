package com.example.ftkj.scroll_vp_fg_lv_test;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by FTKJ on 2017/8/10.
 */
public  class MyRecyclerViewAdapter extends RecyclerView.Adapter{


    private  int TYPE_1 = 1;
    private  int TYPE_2 = 2;


    private Context mContext;
    private HashMap<String,List> mHashMap;
    private LayoutInflater mInflater;

    public MyRecyclerViewAdapter(Context context, HashMap<String, List> hashMap) {
        mContext = context;
        mHashMap = hashMap;
        Log.d("AAA", "onCreate: "+mHashMap);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 1:
                view = mInflater.inflate(R.layout.item_type1, parent, false);
                return new Type1Holer(view);
            case 2:
                view = mInflater.inflate(R.layout.item_type2, parent, false);
                return  new Type2Holer(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Type1Holer) {
            Type1Holer type1Holer = (Type1Holer) holder;
            type1Holer.bindView(mHashMap.get("head"));
        }else if (holder instanceof Type2Holer){
            Type2Holer type2Holer = (Type2Holer) holder;
            type2Holer.bindView(mHashMap.get("pager"));
        }
    }

    @Override
    public int getItemViewType(int position) {
        int ret = -1;
        switch (position){
            case 0:
                ret = TYPE_1;
                break;
            case 1:
                ret = TYPE_2;
                break;
        }
        return ret;
    }

    @Override
    public int getItemCount() {
        return mHashMap.size();
    }

    class Type1Holer extends RecyclerView.ViewHolder{
        public Type1Holer(View itemView) {
            super(itemView);
        }
        void bindView(List<Integer> list){
            Banner banner = (Banner) itemView.findViewById(R.id.recycler_banner);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(list);
            //banner设置方法全部调用完毕时最后调用
            banner.start();

        }

    }

    class Type2Holer extends RecyclerView.ViewHolder{
        public Type2Holer(View itemView) {
            super(itemView);
        }

        void bindView(List<List<String>> list){
            TabLayout tabLayout = (TabLayout) itemView.findViewById(R.id.recycler_tab);
            ViewPager viewPager = (ViewPager) itemView.findViewById(R.id.recycler_pager);
            ArrayList<TestFragment2> fragments = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                fragments.add(TestFragment2.getNewInstance(list.get(i)));
            }
            MyPagerAdapter adapter = new  MyPagerAdapter(((AppCompatActivity) mContext).getSupportFragmentManager(), fragments);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    class  MyPagerAdapter extends FragmentPagerAdapter{
        private String mString[] = {"标题1","标题2","标题3","标题4"};
        private List<? extends Fragment> mFragments;
        public  MyPagerAdapter(FragmentManager fm,List<? extends Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments==null?0:mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mString[position];
        }
    }




     class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */
            imageView.setImageResource(((Integer) path));


        }


    }

}
