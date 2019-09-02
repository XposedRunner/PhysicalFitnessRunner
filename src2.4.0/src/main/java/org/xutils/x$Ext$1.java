package org.xutils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class x$Ext$1 implements HostnameVerifier {
    x$Ext$1() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
