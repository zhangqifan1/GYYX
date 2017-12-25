package com.v.gyyx.areaLogWeb2;

import android.content.Context;

import com.google.gson.Gson;
import com.v.gyyx.Const;
import com.v.gyyx.beans.YouKeBean;
import com.v.gyyx.utils.CallServer;
import com.v.gyyx.utils.DialogUtils;
import com.v.gyyx.utils.ToastUtils;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

/**
 * Created by Administrator on 2017/12/15.
 */

public class imodelImpl implements imodel {

    @Override
    public void request(Object o, final CallBack3 callBack, final Context context) {
        Request<String> req = NoHttp.createStringRequest(Const.YouKe_POST, RequestMethod.POST);
        req.add("deviceId",Const.Device_ID);
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
                String s = response.get();
                YouKeBean youKeBean = new Gson().fromJson(s, YouKeBean.class);
                callBack.setYoukeBean(youKeBean);
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
    }
}
