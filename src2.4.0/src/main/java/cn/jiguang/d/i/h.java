package cn.jiguang.d.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends a {
    private static final Object f = new Object();
    private ConcurrentLinkedQueue<a> e = new ConcurrentLinkedQueue();
    private boolean g = false;
    private AtomicBoolean h = new AtomicBoolean(false);

    /* JADX WARNING: Missing block: B:14:0x001a, code skipped:
            return null;
     */
    private synchronized java.util.ArrayList<cn.jiguang.d.d.a> a(android.content.Context r2, java.lang.String r3) {
        /*
        r1 = this;
        monitor-enter(r1);
        r2 = cn.jiguang.d.h.f.a(r2, r3);	 Catch:{ all -> 0x001b }
        r3 = 0;
        if (r2 == 0) goto L_0x0019;
    L_0x0008:
        r0 = r2.exists();	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0019;
    L_0x000f:
        r2 = cn.jiguang.d.h.f.c(r2);	 Catch:{ Throwable -> 0x0017 }
        r2 = (java.util.ArrayList) r2;	 Catch:{ Throwable -> 0x0017 }
        monitor-exit(r1);
        return r2;
    L_0x0017:
        monitor-exit(r1);
        return r3;
    L_0x0019:
        monitor-exit(r1);
        return r3;
    L_0x001b:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.i.h.a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    private static JSONObject a(String str, ComponentName componentName, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (componentName == null) {
            return null;
        }
        try {
            jSONObject.put("awake_from", str);
            jSONObject.put("awake_to", componentName.getPackageName());
            jSONObject.put("awake_class", componentName.getClassName());
            jSONObject.put("awake_count", 1);
            jSONObject.put("success", z);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0014, code skipped:
            return;
     */
    private synchronized <T> void a(android.content.Context r1, java.lang.String r2, java.util.ArrayList<T> r3) {
        /*
        r0 = this;
        monitor-enter(r0);
        r1 = cn.jiguang.d.h.f.a(r1, r2);	 Catch:{ all -> 0x0015 }
        if (r1 == 0) goto L_0x0013;
    L_0x0007:
        r2 = r1.exists();	 Catch:{ all -> 0x0015 }
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0013;
    L_0x000e:
        cn.jiguang.d.h.f.a(r1, r3);	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x0013:
        monitor-exit(r0);
        return;
    L_0x0015:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.i.h.a(android.content.Context, java.lang.String, java.util.ArrayList):void");
    }

    private void a(Context context, ArrayList<d> arrayList) {
        a(context, "app_awake", b(context, (ArrayList) arrayList));
    }

    private static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        HashMap b = dVar.b();
        if (b == null || b.isEmpty()) {
            return false;
        }
        for (Integer intValue : b.keySet()) {
            if (((Boolean) b.get(Integer.valueOf(intValue.intValue()))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private JSONObject b(Context context, ArrayList<d> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return null;
                }
                String packageName = context.getApplicationContext().getPackageName();
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar != null) {
                        JSONObject a = a(packageName, dVar.a(), a(dVar));
                        if (a != null) {
                            jSONArray.put(a);
                        }
                    }
                }
                jSONObject.put("awake_path", jSONArray);
                return jSONObject;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private void e(Context context) {
        if (this.g) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.e);
            a(context, "Jpush_awake_file_list", arrayList);
            this.g = false;
        }
    }

    public final void a(Context context, a aVar) {
        int i = 1;
        try {
            if (!this.e.contains(aVar)) {
                this.e.add(aVar);
                this.g = true;
            }
        } catch (Throwable unused) {
        }
        e(context);
        if (!this.h.get()) {
            ApplicationInfo g = cn.jiguang.g.a.g(context, aVar.a);
            if (g != null) {
                aVar.c = g.targetSdkVersion;
            }
            if (VERSION.SDK_INT >= 26 && aVar.c >= 26) {
                i = 2;
            }
            ArrayList arrayList = new ArrayList();
            d a = c.a(context, 2, i, aVar, null);
            if (a != null) {
                arrayList.add(a);
            }
            a(context, arrayList);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(Context context) {
        if (context == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long k = d.k(context);
        return -1 == k || Math.abs(currentTimeMillis - k) > this.a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(Context context) {
        d.b(context, System.currentTimeMillis() / 1000);
    }

    public final void b(Context context, a aVar) {
        if (this.e.contains(aVar)) {
            try {
                this.e.remove(aVar);
                this.g = true;
            } catch (Throwable unused) {
            }
        }
        e(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final ArrayList<a> c(Context context) {
        return null;
    }

    public final void d(Context context) {
        ArrayList a;
        this.h.set(true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.e.isEmpty()) {
            a = a(context, "Jpush_awake_file_list");
            if (a != null) {
                this.e.clear();
                this.e.addAll(a);
            }
        }
        if (!(this.e == null || this.e.isEmpty())) {
            a = new ArrayList();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                int i = (VERSION.SDK_INT < 26 || aVar.c < 26) ? 1 : 2;
                d a2 = c.a(context, 2, i, aVar, null);
                if (a2 != null) {
                    a.add(a2);
                }
            }
            a(context, a);
        }
        this.h.set(false);
    }
}
