package com.example.ftkj.scroll_vp_fg_lv_test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment implements AdapterView.OnItemClickListener {


    public TestFragment() {

    }


    public static TestFragment getNewInstance(String key) {

        TestFragment testFragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", key);
        testFragment.setArguments(bundle);
        return testFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String key = bundle.getString("key");
        View ret;

        ret = inflater.inflate(R.layout.fragment_test, container, false);

        MyListView listView = (MyListView) ret.findViewById(R.id.fragment_listview);
        ArrayList<String> strings = new ArrayList<>();
        switch (key) {
            case "0":
                for (int i = 0; i < 20; i++) {
                    strings.add("内容0   " + i);
                }
                break;
            case "1":
                for (int i = 0; i < 30; i++) {
                    strings.add("内容1   " + i);
                }

                break;
            case "2":
                for (int i = 0; i < 5; i++) {
                    strings.add("内容2   " + i);
                }
                break;

            case "3":
                strings.add("内容   3");
                break;
        }
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, strings));
        listView.setOnItemClickListener(this);

        return ret;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "位置"+position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(),TestActivity.class);
        startActivity(intent);
    }
}
