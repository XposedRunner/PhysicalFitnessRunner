package com.baidu.mapsdkplatform.comapi.synchronization.c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class d implements HostnameVerifier {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
