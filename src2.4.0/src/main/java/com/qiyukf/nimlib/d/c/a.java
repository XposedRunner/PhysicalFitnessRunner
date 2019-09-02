package com.qiyukf.nimlib.d.c;

import android.content.Context;
import android.os.Build;
import com.qiyukf.nimlib.d.d.a.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static a a;

    public interface a<T> {
        void a(int i, String str);

        void a(T t);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private static Map<String, String> b() {
        HashMap hashMap = new HashMap(6);
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        b b = com.qiyukf.nimlib.d.a.d().b();
        if (b != null) {
            hashMap.put("nt-source", b.a());
            String str = "nt-appid";
            Context a = com.qiyukf.nimlib.d.a.d().a();
            hashMap.put(str, a == null ? null : a.getPackageName());
            hashMap.put("nt-appkey", b.b());
            hashMap.put("nt-system", "2");
            hashMap.put("nt-deviceid", com.qiyukf.nimlib.d.b.a.b.c(com.qiyukf.nimlib.d.a.d().a()));
            hashMap.put("nt-deviceid2", com.qiyukf.nimlib.d.b.a.b.h(com.qiyukf.nimlib.d.a.d().a()));
            hashMap.put("nt-deviceid3", Build.SERIAL);
            hashMap.put("nt-version", b.c());
            hashMap.put("nt-time", String.valueOf(System.currentTimeMillis()));
            hashMap.put("Content-Encoding", "gzip");
        }
        return hashMap;
    }

    public final void a(final a<b> aVar) {
        try {
            com.qiyukf.nimlib.d.a.a.b.a().a("https://dt.netease.im/api/getConfig", b(), null, false, new com.qiyukf.nimlib.d.a.a.b.a() {
                public final void a(String str, int i, Throwable th) {
                    a aVar;
                    int i2;
                    if (i == 200 && th == null) {
                        try {
                            aVar.a((b) com.qiyukf.nimlib.d.a.d.a.a(new JSONObject(str), b.class));
                            return;
                        } catch (JSONException e) {
                            aVar = aVar;
                            i2 = -1;
                            str = e.getMessage();
                            aVar.a(i2, str);
                            return;
                        } catch (Throwable th2) {
                            aVar = aVar;
                            i2 = -2;
                            str = th2.getMessage();
                            aVar.a(i2, str);
                            return;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("http fetch strategy failed, code=");
                    stringBuilder.append(i);
                    stringBuilder.append(", error=");
                    stringBuilder.append(th != null ? th.getMessage() : "null");
                    com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
                    if (aVar != null) {
                        aVar.a(i, th != null ? th.getMessage() : null);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("fetch strategy error, e=");
            stringBuilder.append(th.getMessage());
            com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
        }
    }

    public final void a(String str, final a<Void> aVar) {
        try {
            com.qiyukf.nimlib.d.a.a.b.a().a("https://dt.netease.im/api/updateInfo", b(), str, new com.qiyukf.nimlib.d.a.a.b.a() {
                public final void a(String str, int i, Throwable th) {
                    str = null;
                    if (i == 200 && th == null) {
                        aVar.a(null);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder("http post data failed, code=");
                    stringBuilder.append(i);
                    stringBuilder.append(", error=");
                    stringBuilder.append(th != null ? th.getMessage() : "null");
                    com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
                    if (aVar != null) {
                        a aVar = aVar;
                        if (th != null) {
                            str = th.getMessage();
                        }
                        aVar.a(i, str);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("post data error, e=");
            stringBuilder.append(th.getMessage());
            com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
        }
    }
}
