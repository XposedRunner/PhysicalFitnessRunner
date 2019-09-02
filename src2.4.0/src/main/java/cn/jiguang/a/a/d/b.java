package cn.jiguang.a.a.d;

import android.app.Application;
import android.content.Context;
import cn.jiguang.a.b.c;
import cn.jiguang.d.a;
import cn.jiguang.d.d.x;
import cn.jiguang.g.i;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static boolean a;
    public static boolean b;
    private static volatile b c;
    private ExecutorService d = Executors.newSingleThreadExecutor();
    private String e = null;
    private String f = null;
    private long g = 30;
    private long h = 0;
    private long i = 0;
    private boolean j = true;
    private boolean k = false;
    private boolean l = true;
    private long m = 0;
    private JSONObject n = null;
    private final Object o = new Object();

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                c = new b();
            }
        }
        return c;
    }

    private JSONObject a(Context context, long j) {
        c.a().b(context, "cur_session_start", this.h);
        StringBuilder stringBuilder = new StringBuilder();
        String b = a.b(context);
        if (!i.a(b)) {
            stringBuilder.append(b);
        }
        b = cn.jiguang.g.a.i(context);
        if (!i.a(b)) {
            stringBuilder.append(b);
        }
        stringBuilder.append(j);
        this.f = cn.jiguang.g.a.a(stringBuilder.toString());
        c.a().b(context, "session_id", this.f);
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            x.a(context, jSONObject, "active_launch");
            jSONObject.put("session_id", this.f);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void a(JSONObject jSONObject) {
        String a = cn.jiguang.d.h.c.a();
        Object obj = a.split("_")[0];
        Object obj2 = a.split("_")[1];
        jSONObject.put("date", obj);
        jSONObject.put("time", obj2);
    }

    private boolean c(Context context, String str) {
        if (!this.l || context == null) {
            return false;
        }
        if (!(context instanceof Application)) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("Context should be an Activity on this method : ");
        stringBuilder.append(str);
        cn.jiguang.e.c.d("JPushSA", stringBuilder.toString());
        return false;
    }

    private JSONObject d(Context context) {
        if (this.n == null) {
            this.n = x.a(context, "jpush_stat_cache.json");
        }
        return this.n;
    }

    public final void a(Context context) {
        if (c(context, "onResume")) {
            a = true;
            try {
                this.k = false;
            } catch (ClassCastException | Exception unused) {
            }
            if (!this.k) {
                this.k = true;
                this.h = System.currentTimeMillis();
                this.e = context.getClass().getName();
                try {
                    this.d.execute(new e(this, context.getApplicationContext()));
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public final void a(Context context, String str) {
        if (!this.k) {
            this.k = true;
            this.e = str;
            this.h = System.currentTimeMillis();
            try {
                this.d.execute(new c(this, context.getApplicationContext()));
            } catch (Throwable unused) {
            }
        }
    }

    public final void b(Context context) {
        if (c(context, "onPause")) {
            b = true;
            try {
                this.k = true;
            } catch (ClassCastException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.k) {
                this.k = false;
                if (this.e != null && this.e.equals(context.getClass().getName())) {
                    this.i = System.currentTimeMillis();
                    this.m = this.h;
                    try {
                        this.d.execute(new f(this, context.getApplicationContext()));
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public final void b(Context context, String str) {
        if (this.k) {
            this.k = false;
            if (this.e == null || !this.e.equals(str)) {
                cn.jiguang.e.c.d("JPushSA", "page name didn't match the last one passed by onResume");
                return;
            }
            this.i = System.currentTimeMillis();
            try {
                this.d.execute(new d(this, context.getApplicationContext()));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public final void c(android.content.Context r3) {
        /*
        r2 = this;
        r0 = r2.e;	 Catch:{  }
        if (r0 == 0) goto L_0x001d;
    L_0x0004:
        r0 = r2.k;	 Catch:{  }
        if (r0 == 0) goto L_0x001d;
    L_0x0008:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{  }
        r2.i = r0;	 Catch:{  }
        r3 = r3.getApplicationContext();	 Catch:{  }
        r0 = r2.d;	 Catch:{ Exception -> 0x001d }
        r1 = new cn.jiguang.a.a.d.g;	 Catch:{ Exception -> 0x001d }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x001d }
        r0.execute(r1);	 Catch:{ Exception -> 0x001d }
        return;
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.b.c(android.content.Context):void");
    }
}
