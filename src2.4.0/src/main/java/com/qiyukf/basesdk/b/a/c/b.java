package com.qiyukf.basesdk.b.a.c;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class b {
    private static HostnameVerifier a = new HostnameVerifier() {
        public final boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(a.f(), sSLSession);
        }
    };
    private static HostnameVerifier b = new HostnameVerifier() {
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), HttpUtils.ENCODING_UTF_8);
            return str;
        } finally {
            a((Closeable) inputStream);
            a(byteArrayOutputStream);
        }
    }

    public static HttpURLConnection a(String str, String str2) {
        HttpURLConnection a = a(str, Constants.HTTP_POST, str2, com.qiyukf.basesdk.b.a.b.a.c().a(), com.qiyukf.basesdk.b.a.b.a.c().b());
        a.setRequestProperty("Host", a.f());
        if (a instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a;
            httpsURLConnection.setSSLSocketFactory(com.qiyukf.basesdk.b.a.c.a.a.a());
            httpsURLConnection.setHostnameVerifier(a);
        }
        return a;
    }

    public static HttpURLConnection a(String str, String str2, String str3) {
        return a(str, str2, str3, 30000, 30000);
    }

    private static HttpURLConnection a(String str, String str2, String str3, int i, int i2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        StringBuilder stringBuilder = new StringBuilder("Qiyu-Android-");
        stringBuilder.append(str3);
        stringBuilder.append("-V1.0");
        httpURLConnection.setRequestProperty("User-Agent", stringBuilder.toString());
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setUseCaches(false);
        if (Constants.HTTP_POST.equals(httpURLConnection.getRequestMethod())) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, int i) {
        if (Constants.HTTP_POST.equals(httpURLConnection.getRequestMethod())) {
            if (i <= 0) {
                httpURLConnection.setChunkedStreamingMode(0);
                return;
            }
            httpURLConnection.setFixedLengthStreamingMode(i);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            httpURLConnection.addRequestProperty(str, str2);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                a(httpURLConnection, str, (String) map.get(str));
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        Closeable dataOutputStream = new DataOutputStream(outputStream);
        try {
            dataOutputStream.write(bArr);
            outputStream.flush();
        } finally {
            a(dataOutputStream);
        }
    }

    public static String b(String str, String str2, String str3) {
        HttpURLConnection a = a(str, str2, str3);
        a(a, "charset", HttpUtils.ENCODING_UTF_8);
        int responseCode = a.getResponseCode();
        if (responseCode == 200) {
            return a(a.getInputStream());
        }
        StringBuilder stringBuilder = new StringBuilder("query url: ");
        stringBuilder.append(str);
        stringBuilder.append("failed: ");
        stringBuilder.append(responseCode);
        com.qiyukf.basesdk.a.a.a("HttpUtil", stringBuilder.toString());
        throw new IOException("invalid response code");
    }

    public static HttpURLConnection b(String str, String str2) {
        HttpURLConnection a = a(str, Constants.HTTP_GET, str2, com.qiyukf.basesdk.b.a.b.a.c().a(), com.qiyukf.basesdk.b.a.b.a.c().b());
        if (a instanceof HttpsURLConnection) {
            ((HttpsURLConnection) a).setSSLSocketFactory(com.qiyukf.basesdk.b.a.c.a.a.a());
        }
        return a;
    }

    public static HttpURLConnection c(String str, String str2) {
        HttpURLConnection a = a(str, Constants.HTTP_GET, str2);
        if (a instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a;
            httpsURLConnection.setSSLSocketFactory(com.qiyukf.basesdk.b.a.c.a.a.a());
            httpsURLConnection.setHostnameVerifier(b);
        }
        return a;
    }
}
