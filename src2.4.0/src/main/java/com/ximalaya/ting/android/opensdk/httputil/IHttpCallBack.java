package com.ximalaya.ting.android.opensdk.httputil;

import okhttp3.Response;

public interface IHttpCallBack {
    void onFailure(int i, String str);

    void onResponse(Response response);
}
