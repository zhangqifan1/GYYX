package com.v.gyyx.utils;

import android.widget.Toast;

import com.v.gyyx.application.App;

/**
 * Created by Administrator on 2017/12/13.
 */

public class ToastUtils {
    public static void Toast(String string){
        if(string!=null && !string.equals("")){
            Toast.makeText(App.getContext(), string, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(App.getContext(), "空的谢谢", Toast.LENGTH_SHORT).show();
        }

    }
}
