package com.v.gyyx.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.v.gyyx.MainActivity;
import com.v.gyyx.R;
import com.v.gyyx.application.App;
import com.v.gyyx.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

public class GuideActivity extends BaseActivity {

    private BGABanner banner_guide_content;
    private Button butEnter;
    private TextView butSkip;
    private int YDColor;
    private RelativeLayout guiMain;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(GuideActivity.this, MainActivity.class));
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        boolean flag = App.getSp().getBoolean("flag", false);
        if (flag == false) {
            App.getSp().edit().putBoolean("flag", true).commit();
            setColor(R.color.colorYD1);
        } else  if (flag == true){
//            ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(R.mipmap.img_splashing);
            setColor(R.color.colorBlack);
            banner_guide_content.setVisibility(View.GONE);
            butSkip.setVisibility(View.GONE);
            butEnter.setVisibility(View.GONE);
            guiMain.setBackgroundResource(R.mipmap.img_splashing);
            new Thread(){
                @Override
                public void run() {
                    SystemClock.sleep(600);
                    handler.sendEmptyMessage(0);
                }
            }.start();
        }

        final List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(this, R.mipmap.a));
        views.add(BGABannerUtil.getItemImageView(this, R.mipmap.b));
        views.add(BGABannerUtil.getItemImageView(this, R.mipmap.c));

        banner_guide_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //这里只有三页 依次添加
                if (position == 0) {
                    setColor(R.color.colorYD1);
                }
                if (position == 1) {
                    setColor(R.color.colorYD2);
                }
                if (position == views.size() - 1) {
                    setColor(R.color.colorYD3);
                    butEnter.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        banner_guide_content.setData(views);

        banner_guide_content.setEnterSkipViewIdAndDelegate(R.id.butEnter, R.id.butSkip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void initView() {
        banner_guide_content = (BGABanner) findViewById(R.id.banner_guide_content);
        butEnter = (Button) findViewById(R.id.butEnter);
        butSkip = (TextView) findViewById(R.id.butSkip);
        guiMain = (RelativeLayout) findViewById(R.id.guiMain);
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
    }
}
