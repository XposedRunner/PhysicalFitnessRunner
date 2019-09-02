package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class f {
    private static Map<String, f> a = Collections.synchronizedMap(new HashMap());
    private static String b;
    private Context c = null;
    private String d = null;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    private f(Context context, String str) {
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    public static f a(Context context, String str) {
        f fVar;
        synchronized (a) {
            Object str2;
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str2 != null) {
                b = str2;
            }
            if (str2 == null) {
                str2 = b != null ? b : "0";
            }
            fVar = (f) a.get(str2);
            if (fVar == null) {
                fVar = new f(context, str2);
                a.put(str2, fVar);
            }
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return fVar;
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".");
                stringBuilder.append(this.d);
                str = stringBuilder.toString();
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName(HttpUtils.ENCODING_UTF_8));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() {
            public void run() {
                try {
                    f.this.a(j.d(HttpUtils.openUrl2(f.this.c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", Constants.HTTP_GET, bundle).a));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f.this.g = 0;
            }
        }.start();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:8:?, code skipped:
            r1 = r4.c.getAssets().open(r5);
     */
    /* JADX WARNING: Missing block: B:34:0x007d, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x007e, code skipped:
            r5.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:36:0x0081, code skipped:
            return r0;
     */
    private java.lang.String c(java.lang.String r5) {
        /*
        r4 = this;
        r0 = "";
        r1 = r4.d;	 Catch:{ FileNotFoundException -> 0x0025 }
        if (r1 == 0) goto L_0x001d;
    L_0x0006:
        r1 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.<init>();	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.append(r5);	 Catch:{ FileNotFoundException -> 0x0025 }
        r2 = ".";
        r1.append(r2);	 Catch:{ FileNotFoundException -> 0x0025 }
        r2 = r4.d;	 Catch:{ FileNotFoundException -> 0x0025 }
        r1.append(r2);	 Catch:{ FileNotFoundException -> 0x0025 }
        r1 = r1.toString();	 Catch:{ FileNotFoundException -> 0x0025 }
        goto L_0x001e;
    L_0x001d:
        r1 = r5;
    L_0x001e:
        r2 = r4.c;	 Catch:{ FileNotFoundException -> 0x0025 }
        r1 = r2.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x0025 }
        goto L_0x002f;
    L_0x0025:
        r1 = r4.c;	 Catch:{ IOException -> 0x007d }
        r1 = r1.getAssets();	 Catch:{ IOException -> 0x007d }
        r1 = r1.open(r5);	 Catch:{ IOException -> 0x007d }
    L_0x002f:
        r5 = new java.io.BufferedReader;
        r2 = new java.io.InputStreamReader;
        r3 = "UTF-8";
        r3 = java.nio.charset.Charset.forName(r3);
        r2.<init>(r1, r3);
        r5.<init>(r2);
        r2 = new java.lang.StringBuffer;
        r2.<init>();
    L_0x0044:
        r3 = r5.readLine();	 Catch:{ IOException -> 0x0061 }
        if (r3 == 0) goto L_0x004e;
    L_0x004a:
        r2.append(r3);	 Catch:{ IOException -> 0x0061 }
        goto L_0x0044;
    L_0x004e:
        r2 = r2.toString();	 Catch:{ IOException -> 0x0061 }
        r1.close();	 Catch:{ IOException -> 0x0059 }
        r5.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005d;
    L_0x0059:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x005d:
        r0 = r2;
        goto L_0x0070;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0071;
    L_0x0061:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x005f }
        r1.close();	 Catch:{ IOException -> 0x006c }
        r5.close();	 Catch:{ IOException -> 0x006c }
        goto L_0x0070;
    L_0x006c:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0070:
        return r0;
    L_0x0071:
        r1.close();	 Catch:{ IOException -> 0x0078 }
        r5.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x007c;
    L_0x0078:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x007c:
        throw r0;
    L_0x007d:
        r5 = move-exception;
        r5.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.f.c(java.lang.String):java.lang.String");
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= ((long) (optInt * 3600000))) {
            b();
        }
    }

    private void d(String str) {
        if (this.h) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("; appid: ");
            stringBuilder.append(this.d);
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", stringBuilder.toString());
        }
    }

    public int a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get ");
        stringBuilder.append(str);
        d(stringBuilder.toString());
        c();
        return this.e.optInt(str);
    }

    public boolean b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get ");
        stringBuilder.append(str);
        d(stringBuilder.toString());
        c();
        Object opt = this.e.opt(str);
        return opt == null ? false : opt instanceof Integer ? opt.equals(Integer.valueOf(0)) ^ 1 : opt instanceof Boolean ? ((Boolean) opt).booleanValue() : false;
    }
}
