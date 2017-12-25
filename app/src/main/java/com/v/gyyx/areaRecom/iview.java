package com.v.gyyx.areaRecom;

import android.content.Context;

import com.v.gyyx.beans.MultipleItem;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface iview {
    Object getObject();
    void setList(List<MultipleItem> list);
    Context getContext1();
}
