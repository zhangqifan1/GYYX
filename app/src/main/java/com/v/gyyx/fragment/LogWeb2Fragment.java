package com.v.gyyx.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.v.gyyx.R;
import com.v.gyyx.areaLogWeb2.Presenter;
import com.v.gyyx.areaLogWeb2.iview;
import com.v.gyyx.beans.MessageBean;
import com.v.gyyx.beans.YouKeBean;
import com.v.gyyx.utils.CallServer;
import com.v.gyyx.utils.ToastUtils;

import java.util.Map;
import java.util.Set;

import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogWeb2Fragment extends Fragment implements View.OnClickListener, iview {
    private UMShareAPI mShareAPI = null;
    private SHARE_MEDIA platform = null;
    private FragmentManager fragmentManager;
    private RelativeLayout Logweb2_RelativeLayout;
    private ImageView imgPhone;
    private ImageView imgWeixin;
    private ImageView imgQQ;
    private TextView textView10;
    private Object cancelSign = new Object();
    private Presenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mShareAPI = UMShareAPI.get(getContext());
        if (fragmentManager == null) {
            fragmentManager = getActivity().getSupportFragmentManager();
        }
        View inflate = inflater.inflate(R.layout.fragment_log_web2, container, false);
        initView(inflate);
        Logweb2_RelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().setCustomAnimations(R.anim.nullanim, R.anim.tranlatey).hide(LogWeb2Fragment.this).commit();
            }
        });
        if(presenter==null){
            presenter = new Presenter(this);
        }

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.mvp();
            }
        });

        return inflate;
    }

    private void initView(View inflate) {
        Logweb2_RelativeLayout = (RelativeLayout) inflate.findViewById(R.id.Logweb2_RelativeLayout);
        imgPhone = (ImageView) inflate.findViewById(R.id.imgPhone);
        imgPhone.setOnClickListener(this);
        imgWeixin = (ImageView) inflate.findViewById(R.id.imgWeixin);
        imgWeixin.setOnClickListener(this);
        imgQQ = (ImageView) inflate.findViewById(R.id.imgQQ);
        imgQQ.setOnClickListener(this);
        textView10 = (TextView) inflate.findViewById(R.id.textView10);
        textView10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgPhone:
                break;
            case R.id.imgWeixin:
                break;
            case R.id.imgQQ:
                platform = SHARE_MEDIA.QQ;
                mShareAPI.getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, umAuthListener);
                mShareAPI.deleteOauth(getActivity(), platform, umAuthListener);
                break;
            default:
                break;
        }
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA arg0, int arg1,
                               Map<String, String> data) {
            if (data != null) {
                Set<String> keySet = data.keySet();
                //得到头像
                String iconurl = new String();
                //得到昵称
                MessageBean messageBean = new MessageBean();
                String screenname = new String();
                for (String string : keySet) {
                    if (string.equals("screen_name")) {
                        //获取登录的名字
                        screenname = data.get("screen_name");
                        messageBean.setQQname(screenname);
                    }
                    if (string.equals("profile_image_url")) {
                        //获取登录的图片
                        iconurl = data.get("profile_image_url");
                        messageBean.setQQicon(iconurl);
                    }
                }
                EventBus.getDefault().postSticky(messageBean);
                fragmentManager.beginTransaction().setCustomAnimations(R.anim.nullanim, R.anim.tranlatey).hide(LogWeb2Fragment.this).commit();
            }
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            ToastUtils.Toast("授权失败");
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            ToastUtils.Toast("授权取消");
        }
    };



    @Override
    public void onDestroyView() {
        CallServer.getInstance().cancelBySign(cancelSign);
        super.onDestroyView();
    }

    @Override
    public Object getObject() {
        return cancelSign;
    }

    @Override
    public void setBean(YouKeBean youKeBean) {
        if(youKeBean!=null){
            ToastUtils.Toast(youKeBean.getMsg());
        }
    }

    @Override
    public Context getContext1() {
        return getActivity();
    }
}
