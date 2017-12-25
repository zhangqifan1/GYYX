package com.v.gyyx.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.v.gyyx.R;
import com.v.gyyx.areaCare.CarePresenter;
import com.v.gyyx.areaCare.CareView;
import com.v.gyyx.utils.CallServer;


/**
 * A simple {@link Fragment} subclass.
 */
public class Care_Fragment extends Fragment implements CareView {


    private LinearLayout care_fragment;
    private CarePresenter carePresenter;
    private Object o;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_care_, container, false);
        initView(inflate);
        carePresenter = new CarePresenter(this);
        carePresenter.mvp();
        return inflate;
    }

    public void send(){
        if(carePresenter!=null){
            carePresenter.mvp();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView(View inflate) {
        care_fragment = (LinearLayout) inflate.findViewById(R.id.care_fragment);
    }

    @Override
    public void setResponse(int id) {
        if(id==1){
            ImageView imageView = new ImageView(getActivity());
            TextView textView = new TextView(getActivity());
            textView.setText("还没有关注的作者,快去关注把");
            imageView.setImageResource(R.mipmap.img_no_attention_person_default);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);

            ViewGroup.LayoutParams layoutParamsR = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setLayoutParams(layoutParamsR);
            care_fragment.addView(imageView);
            care_fragment.addView(textView);
            care_fragment.setPadding(0,200,0,0);
        }
        if(id==100){
            carePresenter.mvp();
        }
    }

    @Override
    public Context getContextCare() {
        return getActivity();
    }

    @Override
    public Object getCancenObject() {
        o = new Object();
        return o;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        CallServer.getInstance().cancelBySign(o);
    }
}
