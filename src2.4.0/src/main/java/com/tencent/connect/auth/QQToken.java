package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static SharedPreferences f;
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;

    public QQToken(String str) {
        this.a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f == null) {
                f = e.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f;
        }
        return sharedPreferences;
    }

    private static synchronized JSONObject a(String str) {
        synchronized (QQToken.class) {
            if (e.a() == null) {
                f.c("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                return null;
            } else {
                str = a().getString(Base64.encodeToString(j.i(str), 2), null);
                if (str == null) {
                    f.c("QQToken", "loadJsonPreference encoded value null");
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(d.b(str, "asdfghjk"));
                    return jSONObject;
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("loadJsonPreference decode");
                    stringBuilder.append(e.toString());
                    f.c("QQToken", stringBuilder.toString());
                    return null;
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:23:0x005f, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:30:0x0065, code skipped:
            return;
     */
    private static synchronized void a(java.lang.String r8, org.json.JSONObject r9) {
        /*
        r0 = com.tencent.connect.auth.QQToken.class;
        monitor-enter(r0);
        r1 = com.tencent.open.utils.e.a();	 Catch:{ all -> 0x0066 }
        if (r1 != 0) goto L_0x0012;
    L_0x0009:
        r8 = "QQToken";
        r9 = "saveJsonPreference context null";
        com.tencent.open.a.f.c(r8, r9);	 Catch:{ all -> 0x0066 }
        monitor-exit(r0);
        return;
    L_0x0012:
        if (r8 == 0) goto L_0x0064;
    L_0x0014:
        if (r9 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0064;
    L_0x0017:
        r1 = "expires_in";
        r1 = r9.getString(r1);	 Catch:{ Exception -> 0x0062 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0062 }
        if (r2 != 0) goto L_0x0060;
    L_0x0023:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0062 }
        r4 = java.lang.Long.parseLong(r1);	 Catch:{ Exception -> 0x0062 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r6 = r2 + r4;
        r1 = "expires_time";
        r9.put(r1, r6);	 Catch:{ Exception -> 0x0062 }
        r8 = com.tencent.open.utils.j.i(r8);	 Catch:{ all -> 0x0066 }
        r1 = 2;
        r8 = android.util.Base64.encodeToString(r8, r1);	 Catch:{ all -> 0x0066 }
        r9 = r9.toString();	 Catch:{ all -> 0x0066 }
        r1 = "asdfghjk";
        r9 = com.tencent.open.utils.d.a(r9, r1);	 Catch:{ all -> 0x0066 }
        if (r8 == 0) goto L_0x005e;
    L_0x004a:
        if (r9 != 0) goto L_0x004d;
    L_0x004c:
        goto L_0x005e;
    L_0x004d:
        r1 = a();	 Catch:{ all -> 0x0066 }
        r1 = r1.edit();	 Catch:{ all -> 0x0066 }
        r8 = r1.putString(r8, r9);	 Catch:{ all -> 0x0066 }
        r8.commit();	 Catch:{ all -> 0x0066 }
        monitor-exit(r0);
        return;
    L_0x005e:
        monitor-exit(r0);
        return;
    L_0x0060:
        monitor-exit(r0);
        return;
    L_0x0062:
        monitor-exit(r0);
        return;
    L_0x0064:
        monitor-exit(r0);
        return;
    L_0x0066:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.QQToken.a(java.lang.String, org.json.JSONObject):void");
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.c;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public JSONObject loadSession(String str) {
        try {
            return a(str);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("login loadSession");
            stringBuilder.append(e.toString());
            f.c("QQToken", stringBuilder.toString());
            return null;
        }
    }

    public void saveSession(JSONObject jSONObject) {
        try {
            a(this.a, jSONObject);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("login saveSession");
            stringBuilder.append(e.toString());
            f.c("QQToken", stringBuilder.toString());
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(String str) {
        this.c = str;
    }
}
