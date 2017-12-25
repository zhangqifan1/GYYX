package com.v.gyyx.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.v.gyyx.R;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * Created by Administrator on 2017/12/13.
 * @author  zqf
 * Base 继承 重写setclor设置沉浸式颜色
 */

public class BaseActivity extends AppCompatActivity {
    private SystemBarTintManager tintManager;
    /**
     * 请求队列
     */
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        //判断当前系统版本是否>=Andoird4.4
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //设置状态栏背景状态
            //true：表明当前Android系统版本>=4.4
            setTranslucentStatus(true);
        }
        //实例化SystemBarTintManager
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        // 通知标题栏所需颜色
        setColor(R.color.colorWhite);

        // 创建请求队列, 默认并发3个请求, 传入数字改变并发数量
        mRequestQueue = NoHttp.newRequestQueue();
    }



    public void setColor(int color) {
        tintManager.setStatusBarTintResource(color);
    }



    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mRequestQueue.cancelAll(); // 退出页面时时取消所有请求。
        mRequestQueue.stop(); // 退出时销毁队列，回收资源。
    }

}
