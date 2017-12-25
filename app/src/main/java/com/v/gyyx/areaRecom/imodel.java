package com.v.gyyx.areaRecom;

import android.content.Context;

import com.v.gyyx.beans.MultipleItem;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface imodel {
    void request(Object cancelobj, CallBack3 callBack, Context context);
     interface CallBack3{
        void setList(List<MultipleItem> list);
    }
}
