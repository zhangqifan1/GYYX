package com.v.gyyx.utils;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

public class CallServer {

    private static CallServer instance;

    public static CallServer getInstance() {
        if (instance == null) {
            synchronized (CallServer.class) {
                if (instance == null) {
                    instance = new CallServer();
                }

            }
        }

        return instance;
    }


    private RequestQueue queue;

    private CallServer() {
        queue = NoHttp.newRequestQueue(5);
    }

    public <T> void request(int what, Request<T> request, SimpleResponseListener<T> listener) {
        queue.add(what, request, listener);
    }

    // 完全退出app时，调用这个方法释放CPU。
    public void stop() {
        queue.stop();
    }

    /**
     * 取消这个sign标记的所有请求。
     *
     * @param sign 请求的取消标志。
     */
    public void cancelBySign(Object sign) {
        queue.cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求。
     */
    public void cancelAll() {
        queue.cancelAll();
    }
}