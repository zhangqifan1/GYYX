package com.v.gyyx.areaCare;

import android.content.Context;

import com.v.gyyx.Const;
import com.v.gyyx.utils.CallServer;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

/**
 * Created by Administrator on 2017/12/20.
 */

public class CareModelImpl implements CareModel {
    @Override
    public void RequestData(Object cancelObject, final CareCallBack careCallBack, final Context context) {
        Request<String> rq = NoHttp.createStringRequest(Const.CareURL, RequestMethod.GET);
        rq.setCancelSign(cancelObject);
        //设置不缓存
        rq.setCacheMode(CacheMode.NONE_CACHE_REQUEST_NETWORK);
        CallServer.getInstance().request(10, rq, new SimpleResponseListener<String>() {

            @Override
            public void onSucceed(int what, Response<String> response) {
                String s = response.get();
                if(s.contains("400")){
                    careCallBack.setData(1);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                careCallBack.setData(100);
            }

        });
    }
}
