package com.v.gyyx.areaRecom;

import android.content.Context;

import com.google.gson.Gson;
import com.v.gyyx.Const;
import com.v.gyyx.R;
import com.v.gyyx.beans.HuaTi7Bean;
import com.v.gyyx.beans.HuatiBean;
import com.v.gyyx.beans.MultipleItem;
import com.v.gyyx.utils.CallServer;
import com.v.gyyx.utils.DialogUtils;
import com.v.gyyx.utils.ToastUtils;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public class imodelImpl implements com.v.gyyx.areaRecom.imodel {
    private List<MultipleItem> datalist = null;

    @Override
    public void request(Object o, final CallBack3 callBack, final Context context) {
        Request<String> req = NoHttp.createStringRequest(Const.Huati_item4, RequestMethod.GET);
        req.setCancelSign(o);
        //设置失败 读缓存
        req.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
        CallServer.getInstance().request(0, req, new SimpleResponseListener<String>() {
            @Override
            public void onStart(int what) {
                DialogUtils.showRoundProcessDialog(context);
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (datalist == null) {
                    datalist = new ArrayList<>();
                }
                String s = response.get();
                HuatiBean huatiBean = new Gson().fromJson(s, HuatiBean.class);
                MultipleItem multipleItem = null;
                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        multipleItem = new MultipleItem();
                        multipleItem.setTitleDate("XXXXXX");
                        multipleItem.setTitleImageResID(R.mipmap.yan);
                        multipleItem.setTitleNum1("" + 4);
                        multipleItem.setTitleNum2("" + 14);
                        multipleItem.setTitleText("无动力空气驱动全身双足外骨骼来了!");
                        multipleItem.itemType = MultipleItem.Type0;
                    }
                    if (i == 1) {
                        multipleItem = new MultipleItem();
                        multipleItem.setImage1_i1(R.mipmap.x1);
                        multipleItem.setImage2_i1(R.mipmap.x2);
                        multipleItem.setImage3_i1(R.mipmap.x1);
                        multipleItem.itemType = MultipleItem.Type1;
                    }
                    if (i == 2) {
                        multipleItem = new MultipleItem();
                        multipleItem.setHuatiBean(huatiBean);
                        multipleItem.itemType = MultipleItem.Type2;
                    }
                    datalist.add(multipleItem);
                }
                callBack.setList(datalist);
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                ToastUtils.Toast("大家都看到了啊,是他先没网了");
            }

            @Override
            public void onFinish(int what) {
                DialogUtils.disMissDialog();
            }
        });

        Request<String> req1 = NoHttp.createStringRequest(Const.Huati_item7, RequestMethod.GET);
        req1.setCancelSign(o);
        //设置失败 读缓存
        req1.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
        CallServer.getInstance().request(0, req1, new SimpleResponseListener<String>() {

            @Override
            public void onSucceed(int what, Response<String> response) {
                String s = response.get();
                HuaTi7Bean huaTi7Bean = new Gson().fromJson(s, HuaTi7Bean.class);
                MultipleItem multipleItem = new MultipleItem();
                multipleItem.setHuaTi7Bean(huaTi7Bean);
                multipleItem.itemType = MultipleItem.Type3;
                if(datalist!=null){
                    datalist.add(multipleItem);
                    callBack.setList(datalist);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                ToastUtils.Toast("大家都看到了啊,是他先没网了");
            }
        });


    }

}
