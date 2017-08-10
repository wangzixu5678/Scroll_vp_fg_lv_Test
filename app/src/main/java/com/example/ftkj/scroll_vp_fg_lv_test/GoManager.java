package com.example.ftkj.scroll_vp_fg_lv_test;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LauncherActivityInfo;

import com.example.ftkj.scroll_vp_fg_lv_test.useless.MainActivity3;

/**
 * Created by FTKJ on 2017/8/10.
 */

public class GoManager {

    public static void goProject1(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public static void goProject2(Context context){
        Intent intent = new Intent(context,MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
    public static void goProject3(Context context){
        Intent intent = new Intent(context,MainActivity3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}
