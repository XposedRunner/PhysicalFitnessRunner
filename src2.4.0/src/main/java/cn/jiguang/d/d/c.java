package cn.jiguang.d.d;

import android.content.Context;
import cn.jiguang.d.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static volatile c c;
    private static final Object d = new Object();
    private long a;
    private Map<String, Set<String>> b = new HashMap();

    private c() {
    }

    public static c a() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    /* JADX WARNING: Missing block: B:41:0x008d, code skipped:
            if (r2.b.containsKey(r3) == false) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:43:0x0091, code skipped:
            return "normal";
     */
    /* JADX WARNING: Missing block: B:49:0x009a, code skipped:
            return r3;
     */
    private java.lang.String a(java.lang.String r3) {
        /*
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r3 = "normal";
        return r3;
    L_0x0009:
        r0 = -1;
        r1 = r3.hashCode();
        switch(r1) {
            case -1245458676: goto L_0x007b;
            case -1177318867: goto L_0x0070;
            case -1051289244: goto L_0x0066;
            case -1039745817: goto L_0x005b;
            case -820729752: goto L_0x0051;
            case -693746763: goto L_0x0047;
            case 93223301: goto L_0x003d;
            case 907150721: goto L_0x0032;
            case 1350272347: goto L_0x0028;
            case 1825995239: goto L_0x001e;
            case 1973539834: goto L_0x0013;
            default: goto L_0x0011;
        };
    L_0x0011:
        goto L_0x0084;
    L_0x0013:
        r1 = "identify_account";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x001b:
        r0 = 7;
        goto L_0x0084;
    L_0x001e:
        r1 = "app_awake";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0026:
        r0 = 2;
        goto L_0x0084;
    L_0x0028:
        r1 = "android_awake_target";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0030:
        r0 = 1;
        goto L_0x0084;
    L_0x0032:
        r1 = "detach_account";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x003a:
        r0 = 8;
        goto L_0x0084;
    L_0x003d:
        r1 = "awake";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0045:
        r0 = 3;
        goto L_0x0084;
    L_0x0047:
        r1 = "android_awake";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x004f:
        r0 = 0;
        goto L_0x0084;
    L_0x0051:
        r1 = "active_terminate";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0059:
        r0 = 5;
        goto L_0x0084;
    L_0x005b:
        r1 = "normal";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0063:
        r0 = 10;
        goto L_0x0084;
    L_0x0066:
        r1 = "active_user";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x006e:
        r0 = 6;
        goto L_0x0084;
    L_0x0070:
        r1 = "account";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0078:
        r0 = 9;
        goto L_0x0084;
    L_0x007b:
        r1 = "active_launch";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0083:
        r0 = 4;
    L_0x0084:
        switch(r0) {
            case 0: goto L_0x0098;
            case 1: goto L_0x0098;
            case 2: goto L_0x0098;
            case 3: goto L_0x0098;
            case 4: goto L_0x0095;
            case 5: goto L_0x0095;
            case 6: goto L_0x0095;
            case 7: goto L_0x0092;
            case 8: goto L_0x0092;
            case 9: goto L_0x0092;
            case 10: goto L_0x008f;
            default: goto L_0x0087;
        };
    L_0x0087:
        r0 = r2.b;
        r0 = r0.containsKey(r3);
        if (r0 != 0) goto L_0x009a;
    L_0x008f:
        r3 = "normal";
        return r3;
    L_0x0092:
        r3 = "account";
        return r3;
    L_0x0095:
        r3 = "active_user";
        return r3;
    L_0x0098:
        r3 = "awake";
    L_0x009a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.c.a(java.lang.String):java.lang.String");
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(str);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            linkedHashSet.add(optJSONArray.getString(i));
                        }
                    }
                    hashMap.put(str, linkedHashSet);
                }
                if (!hashMap.isEmpty()) {
                    this.b = hashMap;
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public final cn.jiguang.d.d.c a(android.content.Context r8) {
        /*
        r7 = this;
        r0 = cn.jiguang.d.a.d.n(r8);	 Catch:{  }
        r2 = r7.a;	 Catch:{  }
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 == 0) goto L_0x0012;
    L_0x000c:
        r2 = r7.a;	 Catch:{  }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r4 == 0) goto L_0x0026;
    L_0x0012:
        r7.a = r0;	 Catch:{  }
        r8 = cn.jiguang.d.a.d.o(r8);	 Catch:{  }
        r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{  }
        if (r0 != 0) goto L_0x0026;
    L_0x001e:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0026 }
        r0.<init>(r8);	 Catch:{ Throwable -> 0x0026 }
        r7.a(r0);	 Catch:{ Throwable -> 0x0026 }
    L_0x0026:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.c.a(android.content.Context):cn.jiguang.d.d.c");
    }

    public final String a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return "normal";
        }
        String str = null;
        for (String a : set) {
            String a2 = a(a2);
            if (str == null) {
                str = a2;
            } else if (!str.equals(a2)) {
                return "normal";
            }
        }
        return str;
    }

    public final void a(Context context, JSONObject jSONObject) {
        d.e(context, jSONObject.optJSONArray("sis_ips").toString());
        long j = 3600000;
        try {
            long j2 = jSONObject.getLong("ttl");
            if (j2 >= 0) {
                j = j2;
            }
        } catch (JSONException unused) {
        }
        d.e(context, j * 1000);
        jSONObject = jSONObject.optJSONObject("ips");
        d.c(context, System.currentTimeMillis());
        d.d(context, jSONObject != null ? jSONObject.toString() : "");
        a(jSONObject);
    }

    public final c b(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(context);
            long j = 3600000;
            long d = d.d(context, 3600000);
            if (d >= 0) {
                j = d < 60000 ? 60000 : d;
            }
            if (j > 604800000) {
                j = 604800000;
            }
            cn.jiguang.d.h.c.a("yyyy-MM-dd HH:mm:ss");
            if (this.a == 0 || this.a + r2 < currentTimeMillis) {
                boolean z;
                if (this.b != null) {
                    if (!this.b.isEmpty()) {
                        z = false;
                        v.a(context, z);
                    }
                }
                z = true;
                v.a(context, z);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public final Set<String> b(Set<String> set) {
        if (!(set == null || set.isEmpty())) {
            Set set2 = null;
            for (String a : set) {
                Set set3 = (Set) this.b.get(a(a));
                if (!(set3 == null || set3.isEmpty())) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return (Set) this.b.get("normal");
    }
}
