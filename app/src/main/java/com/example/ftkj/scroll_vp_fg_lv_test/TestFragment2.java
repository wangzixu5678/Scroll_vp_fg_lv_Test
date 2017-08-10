package com.example.ftkj.scroll_vp_fg_lv_test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment2 extends Fragment {


    public TestFragment2() {

    }

    public static TestFragment2 getNewInstance(List<String> list) {
        TestFragment2 testFragment2 = new TestFragment2();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("data", (ArrayList<String>) list);
        testFragment2.setArguments(bundle);
        return testFragment2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        ArrayList<String> data = bundle.getStringArrayList("data");
        Log.d("AAA", "onCreateView: "+data);
        View ret;
        ret = inflater.inflate(R.layout.fragment_test_fragment2, container, false);
        ListView myListView = (ListView) ret.findViewById(R.id.fragment2_listview);
        myListView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, data));
        return ret;
    }

}
