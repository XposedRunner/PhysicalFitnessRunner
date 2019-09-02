package com.qiyukf.nimlib.d.e;

import android.text.TextUtils;
import com.qiyukf.nimlib.d.b.a.e;
import com.qiyukf.nimlib.d.b.b.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private Set<String> d = new HashSet(10);

    private static class a {
        private static final a a = new a();
    }

    public static a a() {
        return a.a;
    }

    private String a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject b = b(z);
            if (b != null) {
                jSONObject.put("wifi", b);
            }
            JSONArray c = c(z);
            if (c != null) {
                jSONObject.put("wifi_list", c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("tryCollectWifi error=");
            stringBuilder.append(e.getMessage());
            com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
        }
        return jSONObject.length() == 0 ? null : jSONObject.toString();
    }

    private static JSONObject a(com.qiyukf.nimlib.d.b.a aVar) {
        return aVar != null ? aVar.a() : null;
    }

    private static boolean a(long j, long j2) {
        return System.currentTimeMillis() >= j + (j2 * 1000);
    }

    private JSONObject b(boolean z) {
        if (z || a(a.a.f(), this.b.e().longValue())) {
            com.qiyukf.nimlib.d.b.a a = b.a(this.a);
            this.d.add("wifi");
            StringBuilder stringBuilder = new StringBuilder("* getConnectedWifiInfo=");
            stringBuilder.append(a);
            com.qiyukf.nimlib.d.a.b.a.b(stringBuilder.toString());
            return a(a);
        }
        com.qiyukf.nimlib.d.a.b.a.b("- getConnectedWifiInfo period control!");
        return null;
    }

    private JSONArray c(boolean z) {
        if (z || a(a.a.g(), this.b.f().longValue())) {
            String str;
            List b = b.b(this.a);
            if (b == null) {
                str = "* getWifiList=null";
            } else {
                this.d.add("wifi_list");
                StringBuilder stringBuilder = new StringBuilder("* getWifiList size=");
                stringBuilder.append(b.size());
                stringBuilder.append(", ex=");
                stringBuilder.append(b.get(b.size() / 2));
                str = stringBuilder.toString();
            }
            com.qiyukf.nimlib.d.a.b.a.b(str);
            return com.qiyukf.nimlib.d.b.b.a.a(b);
        }
        com.qiyukf.nimlib.d.a.b.a.b("- getWifiList period control!");
        return null;
    }

    private String d() {
        if (a(a.a.j(), 5)) {
            JSONObject jSONObject = new JSONObject();
            StringBuilder stringBuilder;
            try {
                com.qiyukf.nimlib.d.b.a a;
                Object a2;
                if (a(a.a.b(), this.b.a().longValue())) {
                    a = e.a(this.a);
                    this.d.add("device");
                    stringBuilder = new StringBuilder("* getDeviceInfo=");
                    stringBuilder.append(a);
                    com.qiyukf.nimlib.d.a.b.a.b(stringBuilder.toString());
                    a2 = a(a);
                } else {
                    com.qiyukf.nimlib.d.a.b.a.b("- getDeviceInfo period control!");
                    a2 = null;
                }
                if (a2 != null) {
                    jSONObject.put("device", a2);
                }
                if (a(a.a.e(), this.b.d().longValue())) {
                    a = e.b(this.a);
                    this.d.add("app");
                    stringBuilder = new StringBuilder("* getAppInfo=");
                    stringBuilder.append(a);
                    com.qiyukf.nimlib.d.a.b.a.b(stringBuilder.toString());
                    a2 = a(a);
                } else {
                    com.qiyukf.nimlib.d.a.b.a.b("- getAppInfo period control!");
                    a2 = null;
                }
                if (a2 != null) {
                    jSONObject.put("app", a2);
                }
                if (a(a.a.c(), this.b.b().longValue())) {
                    a = e.d(this.a);
                    this.d.add("carrier");
                    stringBuilder = new StringBuilder("* getOperatorInfo=");
                    stringBuilder.append(a);
                    com.qiyukf.nimlib.d.a.b.a.b(stringBuilder.toString());
                    a2 = a(a);
                } else {
                    com.qiyukf.nimlib.d.a.b.a.b("- getOperatorInfo period control!");
                    a2 = null;
                }
                if (a2 != null) {
                    jSONObject.put("carrier", a2);
                }
                if (a(a.a.i(), this.b.h().longValue())) {
                    a = e.e(this.a);
                    this.d.add("cell");
                    stringBuilder = new StringBuilder("* getCellInfo=");
                    stringBuilder.append(a);
                    com.qiyukf.nimlib.d.a.b.a.b(stringBuilder.toString());
                    a2 = a(a);
                } else {
                    com.qiyukf.nimlib.d.a.b.a.b("- getCellInfo period control!");
                    a2 = null;
                }
                if (a2 != null) {
                    jSONObject.put("cell", a2);
                }
                JSONObject d = d(false);
                if (d != null) {
                    jSONObject.put("gps", d);
                }
                d = b(false);
                if (d != null) {
                    jSONObject.put("wifi", d);
                }
                JSONArray c = c(false);
                if (c != null) {
                    jSONObject.put("wifi_list", c);
                }
                if (a(a.a.d(), this.b.c().longValue())) {
                    String str;
                    List c2 = e.c(this.a);
                    this.d.add("app_list");
                    if (c2 == null) {
                        str = "* getInstalledAppInfoList=null";
                    } else {
                        stringBuilder = new StringBuilder("* getInstalledAppInfoList size=");
                        stringBuilder.append(c2.size());
                        stringBuilder.append(", ex=");
                        stringBuilder.append(c2.get(c2.size() / 2));
                        str = stringBuilder.toString();
                    }
                    com.qiyukf.nimlib.d.a.b.a.b(str);
                    a2 = com.qiyukf.nimlib.d.b.a.a.a(c2);
                } else {
                    com.qiyukf.nimlib.d.a.b.a.b("- getInstalledAppInfoList period control!");
                    a2 = null;
                }
                if (a2 != null) {
                    jSONObject.put("app_list", a2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                stringBuilder = new StringBuilder("tryCollectAll error=");
                stringBuilder.append(e.getMessage());
                com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
            }
            a.a.j(System.currentTimeMillis());
            return jSONObject.length() == 0 ? null : jSONObject.toString();
        } else {
            com.qiyukf.nimlib.d.a.b.a.f("collect all frequency control !!!");
            return null;
        }
    }

    private JSONObject d(boolean z) {
        String str;
        if (this.c == null) {
            str = "- getGPS null, as app has not commit";
        } else if (z || a(a.a.h(), this.b.g().longValue())) {
            this.d.add("gps");
            StringBuilder stringBuilder = new StringBuilder("* getGPS=");
            stringBuilder.append(this.c);
            com.qiyukf.nimlib.d.a.b.a.b(stringBuilder.toString());
            JSONObject a = a(this.c);
            this.c = null;
            return a;
        } else {
            str = "- getGPS period control!";
        }
        com.qiyukf.nimlib.d.a.b.a.b(str);
        return null;
    }

    private String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject d = d(true);
            if (d != null) {
                jSONObject.put("gps", d);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("tryCollectGPS error=");
            stringBuilder.append(e.getMessage());
            com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
        }
        return jSONObject.length() == 0 ? null : jSONObject.toString();
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(int i) {
        CharSequence d;
        boolean z;
        this.d.clear();
        switch (i) {
            case 0:
            case 1:
            case 2:
                d = d();
                break;
            case 3:
                z = true;
                break;
            case 4:
                z = false;
                break;
            case 5:
                d = e();
                break;
            default:
                d = null;
                break;
        }
        d = a(z);
        if (!TextUtils.isEmpty(d)) {
            StringBuilder stringBuilder = new StringBuilder("posting data to DCServer, data=");
            stringBuilder.append(d);
            com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
            com.qiyukf.nimlib.d.c.a.a().a(d, new com.qiyukf.nimlib.d.c.a.a<Void>() {
                public final void a(int i, String str) {
                    StringBuilder stringBuilder = new StringBuilder("on post data failed, code=");
                    stringBuilder.append(i);
                    stringBuilder.append(", error=");
                    stringBuilder.append(str);
                    com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
                    a.this.d.clear();
                }

                public final /* synthetic */ void a(Object obj) {
                    com.qiyukf.nimlib.d.a.b.a.e("on post data success!");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a.this.d.contains("device")) {
                        a.a.b(currentTimeMillis);
                    }
                    if (a.this.d.contains("app")) {
                        a.a.e(System.currentTimeMillis());
                    }
                    if (a.this.d.contains("carrier")) {
                        a.a.c(System.currentTimeMillis());
                    }
                    if (a.this.d.contains("cell")) {
                        a.a.i(System.currentTimeMillis());
                    }
                    if (a.this.d.contains("wifi")) {
                        a.a.f(System.currentTimeMillis());
                    }
                    if (a.this.d.contains("wifi_list")) {
                        a.a.g(System.currentTimeMillis());
                    }
                    if (a.this.d.contains("gps")) {
                        a.a.h(System.currentTimeMillis());
                    }
                    if (a.this.d.contains("app_list")) {
                        a.a.d(System.currentTimeMillis());
                    }
                    StringBuilder stringBuilder = new StringBuilder("save post time, key size=");
                    stringBuilder.append(a.this.d.size());
                    com.qiyukf.nimlib.d.a.b.a.e(stringBuilder.toString());
                    a.this.d.clear();
                }
            });
        }
    }

    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }
}
