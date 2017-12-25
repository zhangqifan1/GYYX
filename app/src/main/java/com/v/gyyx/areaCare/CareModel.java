package com.v.gyyx.areaCare;

import android.content.Context;

/**
 * Created by Administrator on 2017/12/20.
 */

public interface CareModel {
    void RequestData(Object cancelObject,CareCallBack careCallBack,Context context);
    interface CareCallBack{
        void setData(int id);
    }
}
