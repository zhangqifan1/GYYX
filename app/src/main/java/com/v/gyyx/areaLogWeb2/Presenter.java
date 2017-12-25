package com.v.gyyx.areaLogWeb2;

import com.v.gyyx.beans.YouKeBean;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Presenter {
    private iview iview;
    private imodel imodel;

    public Presenter(com.v.gyyx.areaLogWeb2.iview iview) {
        this.iview = iview;
        imodel=new imodelImpl();
    }
    public void mvp(){
        imodel.request(iview.getObject(), new imodel.CallBack3() {
            @Override
            public void setYoukeBean(YouKeBean youkeBean) {
                iview.setBean(youkeBean);
            }
        },iview.getContext1());
    }
}
