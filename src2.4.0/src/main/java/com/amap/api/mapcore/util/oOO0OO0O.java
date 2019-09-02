package com.amap.api.mapcore.util;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class oOO0OO0O {
    int a = 20000;
    int b = 20000;
    Proxy c = null;

    /* Access modifiers changed, original: 0000 */
    public String b() {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return getURL();
        }
        Map params = getParams();
        if (params == null) {
            return getURL();
        }
        String O000000o = oOO0O00O.O000000o(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getURL());
        stringBuffer.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuffer.append(O000000o);
        return stringBuffer.toString();
    }

    /* Access modifiers changed, original: 0000 */
    public byte[] c() {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes != null && entityBytes.length != 0) {
            return entityBytes;
        }
        String O000000o = oOO0O00O.O000000o(getParams());
        return !TextUtils.isEmpty(O000000o) ? o0OOOO00.O000000o(O000000o) : entityBytes;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public String getIPDNSName() {
        return "";
    }

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public abstract String getURL();

    /* Access modifiers changed, original: protected */
    public boolean isIPRequest() {
        return TextUtils.isEmpty(getIPDNSName()) ^ 1;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public final void setConnectionTimeout(int i) {
        this.a = i;
    }

    public final void setProxy(Proxy proxy) {
        this.c = proxy;
    }

    public final void setSoTimeout(int i) {
        this.b = i;
    }
}
