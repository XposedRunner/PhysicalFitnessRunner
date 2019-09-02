package com.qiyukf.unicorn.i;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.e.k;
import com.qiyukf.unicorn.f.c;
import java.util.UUID;
import org.json.JSONObject;

public final class b {
    private SparseArray<String> a;
    private Handler b;

    private static class a {
        private static b a = new b();
    }

    private b() {
        this.a = new SparseArray();
        this.b = com.qiyukf.basesdk.c.a.a().a("StatisticsManager");
        this.b.post(new Runnable() {
            public final void run() {
                JSONObject f = com.qiyukf.basesdk.c.b.f(c.b(), "result");
                if (f != null) {
                    boolean z = true;
                    if (com.qiyukf.basesdk.c.b.b(f, "track") != 1) {
                        z = false;
                    }
                    com.qiyukf.unicorn.b.b.c(z);
                }
                StringBuilder stringBuilder = new StringBuilder("track switch ");
                stringBuilder.append(com.qiyukf.unicorn.b.b.s());
                com.qiyukf.basesdk.a.a.a("StatisticsManager", stringBuilder.toString());
            }
        });
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.a;
    }

    private String a(Object obj, int i) {
        String toLowerCase;
        if (i == 0) {
            toLowerCase = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
            this.a.put(obj.hashCode(), toLowerCase);
            return toLowerCase;
        }
        toLowerCase = (String) this.a.get(obj.hashCode());
        if (TextUtils.isEmpty(toLowerCase)) {
            toLowerCase = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        }
        this.a.remove(obj.hashCode());
        return toLowerCase;
    }

    private void a(Object obj, CharSequence charSequence, int i) {
        if (com.qiyukf.unicorn.b.b.s()) {
            final String name = obj.getClass().getName();
            final String a = a(obj, i);
            final long currentTimeMillis = System.currentTimeMillis();
            final CharSequence charSequence2 = charSequence;
            final int i2 = i;
            this.b.post(new Runnable() {
                public final void run() {
                    try {
                        b.a(name, charSequence2, a, i2, currentTimeMillis);
                    } catch (Throwable th) {
                        com.qiyukf.basesdk.a.a.d("StatisticsManager", "handle action error", th);
                    }
                }
            });
        }
    }

    private void a(Object obj, CharSequence charSequence, JSONObject jSONObject) {
        if (com.qiyukf.unicorn.b.b.s()) {
            final String name = obj.getClass().getName();
            final String a = a(obj, 0);
            final long currentTimeMillis = System.currentTimeMillis();
            final CharSequence charSequence2 = charSequence;
            final JSONObject jSONObject2 = jSONObject;
            this.b.post(new Runnable() {
                public final void run() {
                    try {
                        b.a(name, charSequence2, a, currentTimeMillis, jSONObject2);
                    } catch (Throwable th) {
                        com.qiyukf.basesdk.a.a.d("StatisticsManager", "handle action error", th);
                    }
                }
            });
        }
    }

    private static boolean d() {
        for (k kVar : d.g().e().values()) {
            if (kVar != null && kVar.g == 0) {
                return true;
            }
        }
        return false;
    }

    private static String e() {
        com.qiyukf.basesdk.a.c a = com.qiyukf.basesdk.a.a.a();
        if (a == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.a());
        stringBuilder.append("/statistics/record.log");
        return stringBuilder.toString();
    }

    public final void a(Activity activity) {
        if (activity != null) {
            a(activity, activity.getTitle());
        }
    }

    public final void a(Activity activity, CharSequence charSequence) {
        if (activity != null) {
            a((Object) activity, charSequence, 0);
        }
    }

    public final void a(Activity activity, CharSequence charSequence, JSONObject jSONObject) {
        if (activity != null) {
            a((Object) activity, charSequence, jSONObject);
        }
    }

    public final void a(Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            a(fragment.getClass().getName(), charSequence, 0);
        }
    }

    public final void a(Fragment fragment, CharSequence charSequence, JSONObject jSONObject) {
        if (fragment != null) {
            a((Object) fragment, charSequence, jSONObject);
        }
    }

    public final void a(android.support.v4.app.Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            a((Object) fragment, charSequence, 0);
        }
    }

    public final void a(android.support.v4.app.Fragment fragment, CharSequence charSequence, JSONObject jSONObject) {
        if (fragment != null) {
            a((Object) fragment, charSequence, jSONObject);
        }
    }

    public final void b() {
        if (com.qiyukf.unicorn.b.b.s()) {
            this.b.post(new Runnable() {
                public final void run() {
                    c.a(b.e());
                }
            });
        }
    }

    public final void b(Activity activity) {
        if (activity != null) {
            b(activity, activity.getTitle());
        }
    }

    public final void b(Activity activity, CharSequence charSequence) {
        if (activity != null) {
            a((Object) activity, charSequence, 1);
        }
    }

    public final void b(Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            a((Object) fragment, charSequence, 1);
        }
    }

    public final void b(android.support.v4.app.Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            a((Object) fragment, charSequence, 1);
        }
    }
}
