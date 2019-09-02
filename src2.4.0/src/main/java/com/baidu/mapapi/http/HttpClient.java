package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.h;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClient {
    public static boolean isHttpsEnable;
    HttpURLConnection a;
    private String b = null;
    private String c = null;
    private int d;
    private int e;
    private String f;
    private ProtoResultCallback g;

    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f = str;
        this.g = protoResultCallback;
    }

    private HttpURLConnection a() {
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(this.b);
            if (isHttpsEnable) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new b(this));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.d);
            httpURLConnection.setReadTimeout(this.e);
            return httpURLConnection;
        } catch (Exception e) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            return null;
        }
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                switch (jSONObject.getInt(jSONObject.has("status") ? "status" : "status_sp")) {
                    case 105:
                    case 106:
                        int permissionCheck = PermissionCheck.permissionCheck();
                        if (permissionCheck != 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("permissionCheck result is: ");
                            stringBuilder.append(permissionCheck);
                            Log.e("HttpClient", stringBuilder.toString());
                            return;
                        }
                        break;
                    default:
                        return;
                }
            }
        } catch (JSONException e) {
            Log.e("HttpClient", "Parse json happened exception");
            e.printStackTrace();
        }
    }

    public static String getAuthToken() {
        return h.y;
    }

    public static String getPhoneInfo() {
        return h.c();
    }

    /* Access modifiers changed, original: protected */
    public boolean checkNetwork() {
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
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            e.printStackTrace();
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015f A:{Catch:{ Exception -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015f A:{Catch:{ Exception -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0125 A:{Catch:{ all -> 0x0150 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0121 A:{Catch:{ all -> 0x0150 }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014a A:{Catch:{ Exception -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015f A:{Catch:{ Exception -> 0x0165 }} */
    public void request(java.lang.String r7) {
        /*
        r6 = this;
        r6.b = r7;
        r7 = r6.checkNetwork();
        if (r7 != 0) goto L_0x0010;
    L_0x0008:
        r7 = r6.g;
        r0 = com.baidu.mapapi.http.HttpClient.HttpStateError.NETWORK_ERROR;
        r7.onFailed(r0);
        return;
    L_0x0010:
        r7 = r6.a();
        r6.a = r7;
        r7 = r6.a;
        if (r7 != 0) goto L_0x0029;
    L_0x001a:
        r7 = "HttpClient";
        r0 = "url connection failed";
        android.util.Log.e(r7, r0);
        r7 = r6.g;
        r0 = com.baidu.mapapi.http.HttpClient.HttpStateError.INNER_ERROR;
        r7.onFailed(r0);
        return;
    L_0x0029:
        r7 = r6.b;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x0039;
    L_0x0031:
        r7 = r6.g;
        r0 = com.baidu.mapapi.http.HttpClient.HttpStateError.REQUEST_ERROR;
        r7.onFailed(r0);
        return;
    L_0x0039:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        r7.connect();	 Catch:{ Exception -> 0x0165 }
        r7 = 0;
        r0 = r6.a;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r0 = r0.getResponseCode();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r0) goto L_0x00ac;
    L_0x0049:
        r0 = r6.a;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r0 = r0.getInputStream();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        r3 = "UTF-8";
        r2.<init>(r0, r3);	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        r7 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r7.<init>();	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
    L_0x0060:
        r2 = r1.read();	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r3 = -1;
        if (r2 == r3) goto L_0x006c;
    L_0x0067:
        r2 = (char) r2;	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r7.append(r2);	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        goto L_0x0060;
    L_0x006c:
        r7 = r7.toString();	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r6.c = r7;	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r7 = r6.c;	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r6.a(r7);	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        if (r0 == 0) goto L_0x0081;
    L_0x0079:
        if (r1 == 0) goto L_0x0081;
    L_0x007b:
        r1.close();	 Catch:{ Exception -> 0x0165 }
        r0.close();	 Catch:{ Exception -> 0x0165 }
    L_0x0081:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        if (r7 == 0) goto L_0x008a;
    L_0x0085:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        r7.disconnect();	 Catch:{ Exception -> 0x0165 }
    L_0x008a:
        r7 = r6.g;
        r0 = r6.c;
        r7.onSuccess(r0);
        return;
    L_0x0092:
        r7 = move-exception;
        r5 = r0;
        r0 = r7;
        r7 = r5;
        goto L_0x0151;
    L_0x0098:
        r7 = move-exception;
        r5 = r0;
        r0 = r7;
        r7 = r5;
        goto L_0x011b;
    L_0x009e:
        r1 = move-exception;
        r5 = r1;
        r1 = r7;
        r7 = r0;
        r0 = r5;
        goto L_0x0151;
    L_0x00a5:
        r1 = move-exception;
        r5 = r1;
        r1 = r7;
        r7 = r0;
        r0 = r5;
        goto L_0x011b;
    L_0x00ac:
        r1 = "HttpClient";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r2.<init>();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r3 = "responseCode is: ";
        r2.append(r3);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r2.append(r0);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        android.util.Log.e(r1, r2);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 < r1) goto L_0x00c9;
    L_0x00c6:
        r1 = com.baidu.mapapi.http.HttpClient.HttpStateError.SERVER_ERROR;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        goto L_0x00d2;
    L_0x00c9:
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 < r1) goto L_0x00d0;
    L_0x00cd:
        r1 = com.baidu.mapapi.http.HttpClient.HttpStateError.REQUEST_ERROR;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        goto L_0x00d2;
    L_0x00d0:
        r1 = com.baidu.mapapi.http.HttpClient.HttpStateError.INNER_ERROR;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
    L_0x00d2:
        r2 = com.baidu.mapapi.common.Logger.debugEnable();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        if (r2 == 0) goto L_0x00e8;
    L_0x00d8:
        r0 = r6.a;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r0 = r0.getErrorStream();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r2 = "HttpClient";
        r3 = r0.toString();	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        com.baidu.mapapi.common.Logger.logW(r2, r3);	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        goto L_0x0107;
    L_0x00e8:
        r2 = "HttpClient";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r3.<init>();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r4 = "Get response from server failed, http response code=";
        r3.append(r4);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r3.append(r0);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r0 = ", error=";
        r3.append(r0);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r3.append(r1);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r0 = r3.toString();	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        com.baidu.mapapi.common.Logger.logW(r2, r0);	 Catch:{ Exception -> 0x0119, all -> 0x0116 }
        r0 = r7;
    L_0x0107:
        r2 = r6.g;	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        r2.onFailed(r1);	 Catch:{ Exception -> 0x00a5, all -> 0x009e }
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        if (r7 == 0) goto L_0x0115;
    L_0x0110:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        r7.disconnect();	 Catch:{ Exception -> 0x0165 }
    L_0x0115:
        return;
    L_0x0116:
        r0 = move-exception;
        r1 = r7;
        goto L_0x0151;
    L_0x0119:
        r0 = move-exception;
        r1 = r7;
    L_0x011b:
        r2 = com.baidu.mapapi.common.Logger.debugEnable();	 Catch:{ all -> 0x0150 }
        if (r2 == 0) goto L_0x0125;
    L_0x0121:
        r0.printStackTrace();	 Catch:{ all -> 0x0150 }
        goto L_0x012e;
    L_0x0125:
        r2 = "HttpClient";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0150 }
        com.baidu.mapapi.common.Logger.logW(r2, r0);	 Catch:{ all -> 0x0150 }
    L_0x012e:
        r0 = "HttpClient";
        r2 = "Catch exception. INNER_ERROR";
        android.util.Log.e(r0, r2);	 Catch:{ all -> 0x0150 }
        r0 = r6.g;	 Catch:{ all -> 0x0150 }
        r2 = com.baidu.mapapi.http.HttpClient.HttpStateError.INNER_ERROR;	 Catch:{ all -> 0x0150 }
        r0.onFailed(r2);	 Catch:{ all -> 0x0150 }
        if (r7 == 0) goto L_0x0146;
    L_0x013e:
        if (r1 == 0) goto L_0x0146;
    L_0x0140:
        r1.close();	 Catch:{ Exception -> 0x0165 }
        r7.close();	 Catch:{ Exception -> 0x0165 }
    L_0x0146:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        if (r7 == 0) goto L_0x014f;
    L_0x014a:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        r7.disconnect();	 Catch:{ Exception -> 0x0165 }
    L_0x014f:
        return;
    L_0x0150:
        r0 = move-exception;
    L_0x0151:
        if (r7 == 0) goto L_0x015b;
    L_0x0153:
        if (r1 == 0) goto L_0x015b;
    L_0x0155:
        r1.close();	 Catch:{ Exception -> 0x0165 }
        r7.close();	 Catch:{ Exception -> 0x0165 }
    L_0x015b:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        if (r7 == 0) goto L_0x0164;
    L_0x015f:
        r7 = r6.a;	 Catch:{ Exception -> 0x0165 }
        r7.disconnect();	 Catch:{ Exception -> 0x0165 }
    L_0x0164:
        throw r0;	 Catch:{ Exception -> 0x0165 }
    L_0x0165:
        r7 = move-exception;
        r0 = com.baidu.mapapi.common.Logger.debugEnable();
        if (r0 == 0) goto L_0x0170;
    L_0x016c:
        r7.printStackTrace();
        goto L_0x0179;
    L_0x0170:
        r0 = "HttpClient";
        r7 = r7.getMessage();
        com.baidu.mapapi.common.Logger.logW(r0, r7);
    L_0x0179:
        r7 = "HttpClient";
        r0 = "Catch connection exception, INNER_ERROR";
        android.util.Log.e(r7, r0);
        r7 = r6.g;
        r0 = com.baidu.mapapi.http.HttpClient.HttpStateError.INNER_ERROR;
        r7.onFailed(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.http.HttpClient.request(java.lang.String):void");
    }

    public void setMaxTimeOut(int i) {
        this.d = i;
    }

    public void setReadTimeOut(int i) {
        this.e = i;
    }
}
