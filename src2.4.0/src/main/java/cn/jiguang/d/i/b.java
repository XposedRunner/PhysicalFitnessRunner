package cn.jiguang.d.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b implements ServiceConnection {
    public static HashMap<String, WeakReference<ServiceConnection>> a = new HashMap();
    public Context b;
    private boolean c = false;

    public b(Context context, boolean z) {
        this.b = context;
        this.c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A:{Catch:{ Throwable -> 0x0069 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002e */
    /* JADX WARNING: Failed to process nested try/catch */
    public final void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
        /*
        r2 = this;
        r4 = 0;
        if (r3 == 0) goto L_0x001a;
    L_0x0003:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002e }
        r4.<init>();	 Catch:{ Throwable -> 0x002e }
        r0 = r3.getPackageName();	 Catch:{ Throwable -> 0x002e }
        r4.append(r0);	 Catch:{ Throwable -> 0x002e }
        r0 = r3.getClassName();	 Catch:{ Throwable -> 0x002e }
        r4.append(r0);	 Catch:{ Throwable -> 0x002e }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x002e }
    L_0x001a:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x002e }
        if (r0 != 0) goto L_0x0025;
    L_0x0020:
        r0 = a;	 Catch:{ Throwable -> 0x002e }
        r0.remove(r4);	 Catch:{ Throwable -> 0x002e }
    L_0x0025:
        r4 = r2.b;	 Catch:{ Throwable -> 0x002e }
        r4 = r4.getApplicationContext();	 Catch:{ Throwable -> 0x002e }
        r4.unbindService(r2);	 Catch:{ Throwable -> 0x002e }
    L_0x002e:
        r4 = r2.c;	 Catch:{ Throwable -> 0x0069 }
        if (r4 == 0) goto L_0x0069;
    L_0x0032:
        r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0069 }
        r4.<init>();	 Catch:{ Throwable -> 0x0069 }
        r0 = new cn.jiguang.d.i.d;	 Catch:{ Throwable -> 0x0069 }
        r0.<init>();	 Catch:{ Throwable -> 0x0069 }
        r0.a(r3);	 Catch:{ Throwable -> 0x0069 }
        r1 = 2;
        if (r3 == 0) goto L_0x0047;
    L_0x0042:
        r3 = 1;
        r0.a(r1, r3);	 Catch:{ Throwable -> 0x0069 }
        goto L_0x004b;
    L_0x0047:
        r3 = 0;
        r0.a(r1, r3);	 Catch:{ Throwable -> 0x0069 }
    L_0x004b:
        r4.add(r0);	 Catch:{ Throwable -> 0x0069 }
        r3 = cn.jiguang.d.i.f.a();	 Catch:{ Throwable -> 0x0069 }
        r3 = r3.b();	 Catch:{ Throwable -> 0x0069 }
        r0 = r2.b;	 Catch:{ Throwable -> 0x0069 }
        r0 = r0.getPackageName();	 Catch:{ Throwable -> 0x0069 }
        r3 = r3.a(r0, r4);	 Catch:{ Throwable -> 0x0069 }
        if (r3 == 0) goto L_0x0069;
    L_0x0062:
        r4 = r2.b;	 Catch:{ Throwable -> 0x0069 }
        r0 = "android_awake";
        cn.jiguang.d.i.e.b(r4, r0, r3);	 Catch:{ Throwable -> 0x0069 }
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.i.b.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
