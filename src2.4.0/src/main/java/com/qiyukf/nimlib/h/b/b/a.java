package com.qiyukf.nimlib.h.b.b;

import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.nimlib.b.b;
import com.qiyukf.nimlib.b.d;
import com.qiyukf.nimlib.b.f;
import com.qiyukf.nimlib.h.e;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static a f = new a();
    private boolean a = true;
    private a[] b = new a[1];
    private String c;
    private long d;
    private Handler e = com.qiyukf.basesdk.c.a.a().c();

    private static final class a implements Serializable {
        String a;
        String[] b;
        String[] c;
        int d = 1;
        int e;
        int f;
        boolean g;

        a(String str, String[] strArr) {
            this.a = str;
            this.b = strArr;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void a(String[] strArr) {
            this.c = strArr;
            this.e = 0;
            this.f = 0;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* JADX WARNING: Missing block: B:25:0x0039, code skipped:
            return true;
     */
        public final synchronized boolean a() {
            /*
            r5 = this;
            monitor-enter(r5);
            r0 = r5.c;	 Catch:{ all -> 0x003e }
            r1 = 0;
            r2 = 1;
            if (r0 == 0) goto L_0x000e;
        L_0x0007:
            r0 = r5.c;	 Catch:{ all -> 0x003e }
            r0 = r0.length;	 Catch:{ all -> 0x003e }
            if (r0 <= 0) goto L_0x000e;
        L_0x000c:
            r0 = r2;
            goto L_0x000f;
        L_0x000e:
            r0 = r1;
        L_0x000f:
            r3 = r5.g;	 Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x0015;
        L_0x0013:
            monitor-exit(r5);
            return r0;
        L_0x0015:
            r3 = 0;
            if (r0 == 0) goto L_0x003a;
        L_0x0018:
            r0 = r5.e;	 Catch:{ all -> 0x003e }
            r0 = r0 + r2;
            r5.e = r0;	 Catch:{ all -> 0x003e }
            r4 = r5.d;	 Catch:{ all -> 0x003e }
            if (r0 < r4) goto L_0x0038;
        L_0x0021:
            r5.e = r1;	 Catch:{ all -> 0x003e }
            r0 = r5.f;	 Catch:{ all -> 0x003e }
            r4 = r5.c;	 Catch:{ all -> 0x003e }
            r4 = r4.length;	 Catch:{ all -> 0x003e }
            r4 = r4 - r2;
            if (r0 < r4) goto L_0x002f;
        L_0x002b:
            r5.c = r3;	 Catch:{ all -> 0x003e }
            monitor-exit(r5);
            return r1;
        L_0x002f:
            r0 = r5.f;	 Catch:{ all -> 0x003e }
            r0 = r0 + r2;
            r1 = r5.c;	 Catch:{ all -> 0x003e }
            r1 = r1.length;	 Catch:{ all -> 0x003e }
            r0 = r0 % r1;
            r5.f = r0;	 Catch:{ all -> 0x003e }
        L_0x0038:
            monitor-exit(r5);
            return r2;
        L_0x003a:
            r5.c = r3;	 Catch:{ all -> 0x003e }
            monitor-exit(r5);
            return r1;
        L_0x003e:
            r0 = move-exception;
            monitor-exit(r5);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.h.b.b.a$a.a():boolean");
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized String b() {
            if (this.c != null && this.c.length > 0) {
                this.g = false;
                return this.c[this.f];
            } else if (this.b == null || this.b.length <= 0) {
                return null;
            } else {
                this.g = true;
                return this.b[this.f % this.b.length];
            }
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* JADX WARNING: Missing block: B:13:0x000f, code skipped:
            return;
     */
        public final synchronized void b(java.lang.String[] r2) {
            /*
            r1 = this;
            monitor-enter(r1);
            if (r2 == 0) goto L_0x000e;
        L_0x0003:
            r0 = r2.length;	 Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x0007;
        L_0x0006:
            goto L_0x000e;
        L_0x0007:
            r1.b = r2;	 Catch:{ all -> 0x000b }
            monitor-exit(r1);
            return;
        L_0x000b:
            r2 = move-exception;
            monitor-exit(r1);
            throw r2;
        L_0x000e:
            monitor-exit(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.h.b.b.a$a.b(java.lang.String[]):void");
        }
    }

    private a() {
        this.b[0] = new a("link", e());
    }

    public static a a() {
        return f;
    }

    private final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("common");
                for (a aVar : this.b) {
                    aVar.a(a(jSONObject, aVar.a));
                }
                this.c = jSONObject.getString("lbs");
                String string = jSONObject.getString("link.default");
                if (d.b()) {
                    e.b(string);
                } else if (d.d()) {
                    e.c(string);
                } else {
                    e.a(string);
                }
                this.b[0].b(e());
                b.e().a(com.qiyukf.basesdk.c.b.f(jSONObject, "c.aos"));
                this.a = false;
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("LBS Json Error ");
                stringBuilder.append(e.getMessage());
                com.qiyukf.basesdk.a.a.d("lbs", stringBuilder.toString());
            }
        }
    }

    private static String[] a(JSONObject jSONObject, String str) {
        JSONArray g = com.qiyukf.basesdk.c.b.g(jSONObject, str);
        if (g == null) {
            return null;
        }
        String[] strArr = new String[g.length()];
        for (int i = 0; i < g.length(); i++) {
            strArr[i] = com.qiyukf.basesdk.c.b.a(g, i);
        }
        return strArr;
    }

    private static String[] e() {
        CharSequence c = d.b() ? e.c() : d.d() ? e.d() : e.b();
        if (!TextUtils.isEmpty(c)) {
            try {
                JSONArray b = com.qiyukf.basesdk.c.b.b(c);
                String[] strArr = new String[b.length()];
                for (int i = 0; i < b.length(); i++) {
                    strArr[i] = com.qiyukf.basesdk.c.b.a(b, i);
                }
                return strArr;
            } catch (Exception unused) {
            }
        }
        return new String[]{f.b()};
    }

    private synchronized String f() {
        boolean isEmpty = TextUtils.isEmpty(this.b[0].b());
        if (isEmpty || this.a || System.currentTimeMillis() - this.d >= 3600000) {
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    a.a(a.this, a.a(a.this));
                    if (!a.this.a) {
                        a.this.d = System.currentTimeMillis();
                    }
                }
            };
            if (isEmpty) {
                anonymousClass1.run();
            } else {
                this.e.post(anonymousClass1);
            }
        }
        return this.b[0].b();
    }

    private synchronized void g() {
        if (!this.b[0].a()) {
            d();
        }
    }

    public final b b() {
        String f = f();
        StringBuilder stringBuilder = new StringBuilder("connect link ");
        stringBuilder.append(f);
        com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
        return new b(f);
    }

    public final void c() {
        g();
    }

    public final synchronized void d() {
        this.a = true;
    }
}
