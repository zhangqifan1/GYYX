package com.v.gyyx.areaRecom;

import com.v.gyyx.beans.MultipleItem;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Presenter {
    private iview iview;
    private imodel imodel;

    public Presenter(iview iview) {
        this.iview = iview;
        imodel=new imodelImpl();
    }
    public void mvp(){
        imodel.request(iview.getObject(), new imodel.CallBack3() {
            @Override
            public void setList(List<MultipleItem> list) {
                iview.setList(list);
            }

        },iview.getContext1());
    }
}
