package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static boolean b = true;
    private static final String c = "c";
    HttpURLConnection a;
    private String d = null;
    private String e = null;
    private int f;
    private int g;
    private String h;
    private e i;

    public enum a {
        SUCCESS,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public c(String str, e eVar) {
        this.h = str;
        this.i = eVar;
    }

    private void a(InputStream inputStream, BufferedReader bufferedReader, HttpURLConnection httpURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "IOException happened when release res", e);
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String str = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("responseCode is: ");
            stringBuilder.append(responseCode);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, stringBuilder.toString());
            if (200 != responseCode) {
                a(httpURLConnection, responseCode);
            } else {
                b(httpURLConnection);
            }
        } catch (IOException unused) {
            httpURLConnection.disconnect();
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Catch connection exception, INNER_ERROR");
            this.i.a(a.INNER_ERROR);
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        a aVar = a.SUCCESS;
        aVar = i >= 500 ? a.SERVER_ERROR : i >= SecExceptionCode.SEC_ERROR_DYN_ENC ? a.REQUEST_ERROR : a.INNER_ERROR;
        InputStream errorStream = httpURLConnection.getErrorStream();
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, errorStream.toString());
        String str = c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response error, response code = ");
        stringBuilder.append(i);
        stringBuilder.append(", error = ");
        stringBuilder.append(aVar);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, stringBuilder.toString());
        if (errorStream != null) {
            try {
                errorStream.close();
            } catch (IOException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "IOException caught", e);
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.i.a(aVar);
    }

    private boolean a() {
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (!activeNetworkInfo.isAvailable()) {
                    return false;
                }
                z = true;
            }
            return z;
        } catch (Exception e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Exception happened when check network", e);
            e.printStackTrace();
            return false;
        }
    }

    private HttpURLConnection b() {
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(this.d);
            if (b) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new d(this));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.h);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.f);
            httpURLConnection.setReadTimeout(this.g);
            return httpURLConnection;
        } catch (Exception e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "url connect failed", e);
            return null;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable e;
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HttpUtils.ENCODING_UTF_8));
            } catch (IOException e2) {
                th = e2;
                bufferedReader = null;
                e = th;
                try {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Catch exception. INNER_ERROR", e);
                    this.i.a(a.INNER_ERROR);
                    a(inputStream, bufferedReader, httpURLConnection);
                } catch (Throwable th2) {
                    e = th2;
                    a(inputStream, bufferedReader, httpURLConnection);
                    throw e;
                }
            } catch (Throwable e22) {
                th = e22;
                bufferedReader = null;
                e = th;
                a(inputStream, bufferedReader, httpURLConnection);
                throw e;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = bufferedReader.read();
                    if (read != -1) {
                        stringBuffer.append((char) read);
                    } else {
                        this.e = stringBuffer.toString();
                        c(this.e);
                        a(inputStream, bufferedReader, httpURLConnection);
                        this.i.a(this.e);
                        return;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Catch exception. INNER_ERROR", e);
                this.i.a(a.INNER_ERROR);
                a(inputStream, bufferedReader, httpURLConnection);
            }
        } catch (IOException e4) {
            bufferedReader = null;
            e = e4;
            inputStream = bufferedReader;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Catch exception. INNER_ERROR", e);
            this.i.a(a.INNER_ERROR);
            a(inputStream, bufferedReader, httpURLConnection);
        } catch (Throwable e42) {
            bufferedReader = null;
            e = e42;
            inputStream = bufferedReader;
            a(inputStream, bufferedReader, httpURLConnection);
            throw e;
        }
    }

    private boolean b(String str) {
        if (!TextUtils.isEmpty(str) && this.i != null) {
            return true;
        }
        String str2 = c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RequestUrl or ResultCallback is null. RequestUrl = ");
        stringBuilder.append(str);
        stringBuilder.append("; ResultCallback is: ");
        stringBuilder.append(this.i);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, stringBuilder.toString());
        this.i.a(a.REQUEST_ERROR);
        return false;
    }

    private void c(String str) {
        if (d(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Permission check failed, try again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str2 = c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The authorized result is: ");
                stringBuilder.append(permissionCheck);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, stringBuilder.toString());
            }
        }
    }

    private boolean d(String str) {
        return e(str) || f(str);
    }

    private boolean e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                int i = jSONObject.getInt(jSONObject.has("status") ? "status" : "status_sp");
                if (106 == i || 105 == i) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Permission check failed due token");
                    return true;
                }
            }
        } catch (JSONException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Parse json happened exception", e);
        }
        return false;
    }

    private boolean f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "Permission check error due other");
                return true;
            }
        } catch (JSONException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(c, "Parse json happened exception", e);
        }
        return false;
    }

    public void a(int i) {
        this.g = i;
    }

    /* Access modifiers changed, original: protected */
    public void a(String str) {
        if (b(str)) {
            this.d = str;
            str = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mRequestUrl is: ");
            stringBuilder.append(this.d);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, stringBuilder.toString());
            if (a()) {
                this.a = b();
                if (this.a == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, "url connection failed");
                    this.i.a(a.INNER_ERROR);
                    return;
                }
                a(this.a);
                return;
            }
            this.i.a(a.NETWORK_ERROR);
        }
    }

    public void b(int i) {
        this.f = i;
    }
}
