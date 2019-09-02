package cn.jiguang.net;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class DefaultHostVerifier implements HostnameVerifier {
    public String a = null;

    public DefaultHostVerifier(String str) {
        this.a = str;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return TextUtils.isEmpty(str) ? false : TextUtils.equals(this.a, str);
    }
}
