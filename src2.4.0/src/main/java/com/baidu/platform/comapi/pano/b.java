package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;
import com.baidu.platform.comapi.pano.a.a;

class b extends ProtoResultCallback {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    b(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public void onFailed(HttpStateError httpStateError) {
        this.a.a(httpStateError);
    }

    public void onSuccess(String str) {
        this.a.a(this.b.a(str));
    }
}
