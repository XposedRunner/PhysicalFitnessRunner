package cn.jiguang.g.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d {
    private static Boolean e;
    private static Map<String, d> f = new HashMap();
    private static final Object g = new Object();
    private final String a;
    private String b;
    private SharedPreferences c;
    private ContentResolver d;

    private d(Context context, String str) {
        this.a = str;
        a(context);
    }

    public static d a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = (d) f.get(str);
        if (dVar != null) {
            return dVar;
        }
        synchronized (g) {
            dVar = (d) f.get(str);
            if (dVar == null) {
                dVar = new d(context, str);
                f.put(str, dVar);
            }
        }
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A:{RETURN} */
    private boolean a(android.content.Context r6) {
        /*
        r5 = this;
        r0 = e;
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0037;
    L_0x0006:
        r0 = cn.jiguang.d.a.a(r6);
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        r0 = r2;
        goto L_0x0038;
    L_0x000e:
        r3 = cn.jiguang.g.a.c(r0);
        if (r3 == 0) goto L_0x0030;
    L_0x0014:
        r0 = cn.jiguang.d.b.a.c(r0);
        r4 = android.text.TextUtils.isEmpty(r0);
        if (r4 != 0) goto L_0x002e;
    L_0x001e:
        r4 = r3.processName;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x002e;
    L_0x0026:
        r3 = r3.processName;
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x0030;
    L_0x002e:
        r0 = r1;
        goto L_0x0031;
    L_0x0030:
        r0 = r2;
    L_0x0031:
        r0 = java.lang.Boolean.valueOf(r0);
        e = r0;
    L_0x0037:
        r0 = r1;
    L_0x0038:
        if (r0 != 0) goto L_0x003b;
    L_0x003a:
        return r2;
    L_0x003b:
        r0 = r5.c;
        if (r0 == 0) goto L_0x0040;
    L_0x003f:
        return r1;
    L_0x0040:
        r6 = cn.jiguang.d.a.a(r6);
        if (r6 != 0) goto L_0x0047;
    L_0x0046:
        return r2;
    L_0x0047:
        r0 = r5.a;
        r0 = r6.getSharedPreferences(r0, r2);
        r5.c = r0;
        r0 = e;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x007b;
    L_0x0057:
        r0 = new java.lang.StringBuilder;
        r2 = "content://";
        r0.<init>(r2);
        r2 = r6.getPackageName();
        r0.append(r2);
        r2 = ".DataProvider/";
        r0.append(r2);
        r2 = r5.a;
        r0.append(r2);
        r0 = r0.toString();
        r5.b = r0;
        r6 = r6.getContentResolver();
        r5.d = r6;
    L_0x007b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.b.d.a(android.content.Context):boolean");
    }

    public final a a(a aVar) {
        if (aVar == null || aVar.b() == 0) {
            return new a();
        }
        if (a(null)) {
            if (e.booleanValue()) {
                try {
                    return c.a(this.d, this.b, aVar);
                } catch (Throwable unused) {
                    return b.a(this.c, aVar);
                }
            }
            aVar = b.a(this.c, aVar);
        }
        return aVar;
    }

    public final Serializable a(String str, int i) {
        return a(null) ? b.a(this.c, str, i) : null;
    }

    public final <T extends Serializable> T a(String str, T t) {
        if (!a(null)) {
            return t;
        }
        if (e.booleanValue()) {
            try {
                String type = this.d.getType(Uri.parse(this.b).buildUpon().appendQueryParameter("key", str).appendQueryParameter("type", String.valueOf(a.a(t))).build());
                if (type == null) {
                    return t;
                }
                if (t == null) {
                    return type;
                }
                if (t instanceof Integer) {
                    return Integer.valueOf(type);
                }
                if (t instanceof Boolean) {
                    return Boolean.valueOf(type);
                }
                if (t instanceof Long) {
                    return Long.valueOf(type);
                }
                if (t instanceof Float) {
                    return Float.valueOf(type);
                }
                if (t instanceof String) {
                    return type;
                }
                if (t instanceof HashSet) {
                }
                return null;
            } catch (Throwable unused) {
            }
        }
        return b.a(this.c, str, (Serializable) t);
    }

    public final boolean a() {
        return a(null) ? this.c.edit().clear().commit() : false;
    }

    public final boolean a(ContentValues contentValues) {
        return a(null) ? b.a(this.c, contentValues) : false;
    }

    public final boolean b(a aVar) {
        if (!a(null)) {
            return false;
        }
        if (e.booleanValue()) {
            try {
                return c.b(this.d, this.b, aVar);
            } catch (Throwable unused) {
            }
        }
        return b.b(this.c, aVar);
    }

    public final <T extends Serializable> boolean b(String str, T t) {
        if (!a(null)) {
            return false;
        }
        if (e.booleanValue()) {
            try {
                return c.a(this.d, this.b, str, t);
            } catch (Throwable unused) {
            }
        }
        return b.b(this.c, str, t);
    }
}
