package com.v.gyyx.areaLogWeb2;

import android.content.Context;

import com.v.gyyx.beans.YouKeBean;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface imodel {
    void request(Object o,CallBack3 callBack,Context context);

    public interface CallBack3{
        void setYoukeBean(YouKeBean youkeBean);
    }
}
