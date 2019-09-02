package com.baidu.mapapi.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class b implements HostnameVerifier {
    final /* synthetic */ HttpClient a;

    b(HttpClient httpClient) {
        this.a = httpClient;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
