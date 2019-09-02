package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class ConnectionFactory {

    private static class MyHostnameVerifier implements HostnameVerifier {
        private String host;

        public MyHostnameVerifier(String str) {
            this.host = str;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.host, sSLSession);
        }
    }

    public static HttpURLConnection createConnect(String str, Context context) {
        if (TextUtils.isEmpty(str) || !(str.startsWith("http://") || str.startsWith("https://"))) {
            throw new RuntimeException("非法url请求");
        }
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(str);
            Pair apn = NetStateManager.getAPN();
            Proxy proxy = apn != null ? new Proxy(Type.HTTP, new InetSocketAddress((String) apn.first, ((Integer) apn.second).intValue())) : null;
            HttpURLConnection httpURLConnection2;
            if (str.startsWith("http://")) {
                httpURLConnection2 = proxy == null ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(proxy);
                httpURLConnection2.setUseCaches(false);
                try {
                    httpURLConnection2.setRequestMethod(Constants.HTTP_POST);
                } catch (ProtocolException unused) {
                }
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection2.setRequestProperty("Charset", HttpUtils.ENCODING_UTF_8);
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.setConnectTimeout(25000);
                return httpURLConnection2;
            }
            if (proxy == null) {
                httpURLConnection2 = (HttpsURLConnection) url.openConnection();
            } else {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(proxy);
            }
            httpURLConnection = httpURLConnection2;
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new MyHostnameVerifier(url.getHost()));
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(HttpsHelper.getSSL(context));
            httpURLConnection2 = httpURLConnection;
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection2.setRequestProperty("Charset", HttpUtils.ENCODING_UTF_8);
            httpURLConnection2.setReadTimeout(20000);
            httpURLConnection2.setConnectTimeout(25000);
            return httpURLConnection2;
        } catch (IOException | MalformedURLException unused2) {
        }
    }
}
