package com.geetest.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: HttpUtils */
final class O0OOo implements HostnameVerifier {
    O0OOo() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
