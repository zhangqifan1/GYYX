package com.v.gyyx.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.v.gyyx.R;

/**
 * Created by Administrator on 2017/12/17.
 */

public class AddCareView extends RelativeLayout {
    public AddCareView(Context context) {
        this(context,null);
    }

    public AddCareView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddCareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.addcareview, this);
    }

}
