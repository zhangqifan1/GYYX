package com.v.gyyx.areaCare;

/**
 * Created by Administrator on 2017/12/20.
 */

public class CarePresenter {
    CareModel careModel;
    CareView careView;

    public CarePresenter(CareView careView) {
        this.careView = careView;
        careModel=new CareModelImpl();
    }

    public void mvp(){
        careModel.RequestData(careView.getCancenObject(), new CareModel.CareCallBack() {
            @Override
            public void setData(int id) {
                careView.setResponse(id);
            }
        },careView.getContextCare());
    }
}
