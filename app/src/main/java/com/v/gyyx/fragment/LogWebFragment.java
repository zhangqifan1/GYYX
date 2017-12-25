package com.v.gyyx.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.v.gyyx.R;
import com.v.gyyx.beans.MessageBean;
import com.v.gyyx.customviews.Circle80;
import com.v.gyyx.utils.glideutils.GlideLoadImageUtil.GlideLoadImageUtil;
import com.v.gyyx.utils.glideutils.transform.CircleTransform;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogWebFragment extends Fragment implements View.OnClickListener {
    private ImageView imageLog;
    private ImageView imageView8;
    private RelativeLayout relative_LogWeb;
    private View inflate;
    private FragmentManager fragmentManager;
    private LogWeb2Fragment logWeb2Fragment;
    private SearchFragment searchFragment;
    private Circle80 circle80;
    private ImageView imageLog1;
    private TextView qNameText;
    private TextView tvLog;
    private ImageView imageViewSearch;
    private ImageView imageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (fragmentManager == null) {
            fragmentManager = getActivity().getSupportFragmentManager();
        }
        if (savedInstanceState != null) {
            logWeb2Fragment = (LogWeb2Fragment) fragmentManager.findFragmentByTag("logweb2");
            searchFragment = (SearchFragment) fragmentManager.findFragmentByTag("search");
        }
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.frag_log_web, container, false);
        inflate.setVisibility(View.VISIBLE);
        EventBus.getDefault().register(this);

        initView(inflate);
        init_imageLog();

        if (logWeb2Fragment == null) {
            logWeb2Fragment = new LogWeb2Fragment();
        }
        if (searchFragment == null) {
            searchFragment = new SearchFragment();
        }

        fragmentManager.beginTransaction().add(R.id.main, logWeb2Fragment, "logweb2").hide(logWeb2Fragment).commit();
        fragmentManager.beginTransaction().add(R.id.main, searchFragment, "search").hide(searchFragment).commit();

        inflate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        return inflate;
    }

    //设置按下和离开时显示的图片
    private void init_imageLog() {

        imageLog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.AXIS_PRESSURE:
                        imageLog.setImageResource(R.mipmap.black2);
                        break;
                    case MotionEvent.ACTION_UP:
                        imageLog.setImageResource(R.mipmap.black1);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        imageLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.tranlateyenter, R.anim.nullanim).show(logWeb2Fragment).commit();
            }
        });

        //X图片
        imageView8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.AXIS_PRESSURE:
                        imageView8.setImageResource(R.mipmap.cuo2);
                        break;
                    case MotionEvent.ACTION_UP:
                        imageView8.setImageResource(R.mipmap.cuo1);
                        break;
                    default:
                        break;
                }

                return false;
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.nullanim, R.anim.tranlatey).hide(LogWebFragment.this).commit();

            }
        });
    }


    private void initView(View inflate) {
        imageLog = (ImageView) inflate.findViewById(R.id.imageLog);
        imageView8 = (ImageView) inflate.findViewById(R.id.imageView8);
        relative_LogWeb = (RelativeLayout) inflate.findViewById(R.id.relative_LogWeb);
        circle80 = inflate.findViewById(R.id.circle80);
        qNameText = inflate.findViewById(R.id.textView11);
        tvLog = (TextView) inflate.findViewById(R.id.tvLog);
        imageViewSearch = (ImageView) inflate.findViewById(R.id.imageView);
        imageViewSearch.setOnClickListener(this);
        imageView2 = (ImageView) inflate.findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);
    }

    @Subscribe(sticky = true, priority = 6)
    public void MessageReceive(MessageBean messageBean) {


        if (messageBean != null) {
            circle80.setVisibility(View.GONE);
            String qQicon = messageBean.getQQicon();
            String qQname = messageBean.getQQname();
            GlideLoadImageUtil.load(getContext(), qQicon, imageLog, new CircleTransform(getContext()));
            qNameText.setText(qQname);
            tvLog.setVisibility(View.GONE);
        }
        imageLog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView://搜索
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.translatex, R.anim.nullanim).show(searchFragment).commit();
                break;
            case R.id.imageView2://设置

                break;
            default:
                break;
        }
    }
}
