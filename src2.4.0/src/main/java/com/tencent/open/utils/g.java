package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.a.f;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
public class g {
    private static g a;
    private volatile WeakReference<SharedPreferences> b = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    public String a(Context context, String str) {
        Exception e;
        StringBuilder stringBuilder;
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            StringBuilder stringBuilder2;
            if (host == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Get host error. url=");
                stringBuilder2.append(str);
                f.e("openSDK_LOG.ServerSetting", stringBuilder2.toString());
                return str;
            }
            String string = ((SharedPreferences) this.b.get()).getString(host, null);
            if (string != null) {
                if (!host.equals(string)) {
                    host = str.replace(host, string);
                    try {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("return environment url : ");
                        stringBuilder2.append(host);
                        f.a("openSDK_LOG.ServerSetting", stringBuilder2.toString());
                        return host;
                    } catch (Exception e2) {
                        Exception exception = e2;
                        str = host;
                        e = exception;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("getEnvUrl url=");
                        stringBuilder.append(str);
                        stringBuilder.append("error.: ");
                        stringBuilder.append(e.getMessage());
                        f.e("openSDK_LOG.ServerSetting", stringBuilder.toString());
                        return str;
                    }
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("host=");
            stringBuilder3.append(host);
            stringBuilder3.append(", envHost=");
            stringBuilder3.append(string);
            f.a("openSDK_LOG.ServerSetting", stringBuilder3.toString());
            return str;
        } catch (Exception e3) {
            e = e3;
            stringBuilder = new StringBuilder();
            stringBuilder.append("getEnvUrl url=");
            stringBuilder.append(str);
            stringBuilder.append("error.: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.ServerSetting", stringBuilder.toString());
            return str;
        }
    }
}
