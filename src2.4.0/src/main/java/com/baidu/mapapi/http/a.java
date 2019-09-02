package com.baidu.mapapi.http;

import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;
import com.tencent.connect.common.Constants;

class a extends a {
    final /* synthetic */ ProtoResultCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ AsyncHttpClient c;

    a(AsyncHttpClient asyncHttpClient, ProtoResultCallback protoResultCallback, String str) {
        this.c = asyncHttpClient;
        this.a = protoResultCallback;
        this.b = str;
        super();
    }

    public void a() {
        HttpClient httpClient = new HttpClient(Constants.HTTP_GET, this.a);
        httpClient.setMaxTimeOut(this.c.a);
        httpClient.setReadTimeOut(this.c.b);
        httpClient.request(this.b);
    }
}
