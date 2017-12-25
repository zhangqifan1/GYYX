package com.v.gyyx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.umeng.socialize.UMShareAPI;
import com.v.gyyx.adapter.FragmentAdapter;
import com.v.gyyx.base.BaseActivity;
import com.v.gyyx.fragment.Care_Fragment;
import com.v.gyyx.fragment.LogWebFragment;
import com.v.gyyx.fragment.Recom_Fragment;
import com.v.gyyx.utils.DialogUtils;
import com.v.gyyx.utils.NetWorkUtils;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {

    private String[] mTitles = {"推荐", "关注"};
    private SlidingTabLayout mSlidTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragmentList;
    private LogWebFragment logWebFragment;
    private RelativeLayout main;
    private FragmentManager fragmentManager;
    private UMShareAPI mShareAPI = null;
    private ImageView first_img;
    private Care_Fragment care_fragment;
    private Recom_Fragment recom_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        if (savedInstanceState != null) {
            logWebFragment = (LogWebFragment) fragmentManager.findFragmentByTag("logweb");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean available = NetWorkUtils.isNetWorkAvailable(this);
        if (available == false) {
            DialogUtils.setNetDialog(this);
        } else {
            //QQ第三方初始化
            mShareAPI = UMShareAPI.get(this);
            initView();
            if (logWebFragment == null) {
                logWebFragment = new LogWebFragment();
            }
            fragmentManager.beginTransaction().add(R.id.main, logWebFragment, "logweb").hide(logWebFragment).commit();

            initData();

            FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
            fragmentAdapter.setFragList(fragmentList);
            mVp.setAdapter(fragmentAdapter);
            mSlidTab.setViewPager(mVp, mTitles);
            mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    if (position == 1) {
                        care_fragment.send();
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        care_fragment = new Care_Fragment();
        recom_fragment = new Recom_Fragment();
        fragmentList.add(recom_fragment);
        fragmentList.add(care_fragment);
    }

    private void initView() {
        mSlidTab = (SlidingTabLayout) findViewById(R.id.slidTab);
        mVp = (ViewPager) findViewById(R.id.vp);
        main = (RelativeLayout) findViewById(R.id.main);
        first_img = (ImageView) findViewById(R.id.first_img);
        first_img.setImageResource(R.mipmap.log);
    }

    //跳转登录界面
    public void imgLog(View view) {
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.tranlateyenter, R.anim.nullanim).show(logWebFragment).commit();
    }

    //跳转发布界面
    public void imgWrite(View view) {
    }


    //记得要重写这个方法

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
    }

    @Override
    protected void onRestart() {
        recreate();
        super.onRestart();
    }
}
