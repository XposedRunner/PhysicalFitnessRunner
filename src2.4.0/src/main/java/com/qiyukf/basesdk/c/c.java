package com.qiyukf.basesdk.c;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class c {
    private static AtomicInteger a = new AtomicInteger(0);
    private static SparseArray<a> b = new SparseArray();
    private static Set<String> c;
    private Object d;
    private String[] e;
    private a f;

    public interface a {
        void onDenied();

        void onGranted();
    }

    private c(Object obj) {
        this.d = obj;
    }

    public static c a(@NonNull Activity activity) {
        return new c(activity);
    }

    public static c a(@NonNull Fragment fragment) {
        return new c(fragment);
    }

    private static List<String> a(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void a(int i, @NonNull int[] iArr) {
        a aVar = (a) b.get(i);
        if (aVar != null) {
            b.remove(i);
            for (int i2 : iArr) {
                if (i2 != 0) {
                    aVar.onDenied();
                    return;
                }
            }
            aVar.onGranted();
        }
    }

    private static synchronized void a(Context context) {
        synchronized (c.class) {
            if (c == null) {
                c = new HashSet();
                try {
                    Collections.addAll(c, context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final c a(@Nullable a aVar) {
        this.f = aVar;
        return this;
    }

    public final c a(@NonNull String... strArr) {
        this.e = strArr;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    public final void a() {
        /*
        r6 = this;
        r0 = r6.d;
        if (r0 == 0) goto L_0x0016;
    L_0x0004:
        r1 = r0 instanceof android.app.Activity;
        if (r1 == 0) goto L_0x000b;
    L_0x0008:
        r0 = (android.app.Activity) r0;
        goto L_0x0017;
    L_0x000b:
        r1 = r0 instanceof android.support.v4.app.Fragment;
        if (r1 == 0) goto L_0x0016;
    L_0x000f:
        r0 = (android.support.v4.app.Fragment) r0;
        r0 = r0.getActivity();
        goto L_0x0017;
    L_0x0016:
        r0 = 0;
    L_0x0017:
        if (r0 != 0) goto L_0x003a;
    L_0x0019:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r6.d;
        r2 = r2.getClass();
        r2 = r2.getName();
        r1.append(r2);
        r2 = " is not supported";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x003a:
        a(r0);
        r1 = r6.e;
        r2 = r1.length;
        r3 = 0;
    L_0x0041:
        if (r3 >= r2) goto L_0x005a;
    L_0x0043:
        r4 = r1[r3];
        r5 = c;
        r4 = r5.contains(r4);
        if (r4 != 0) goto L_0x0057;
    L_0x004d:
        r0 = r6.f;
        if (r0 == 0) goto L_0x0056;
    L_0x0051:
        r0 = r6.f;
        r0.onDenied();
    L_0x0056:
        return;
    L_0x0057:
        r3 = r3 + 1;
        goto L_0x0041;
    L_0x005a:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        if (r1 >= r2) goto L_0x006a;
    L_0x0060:
        r0 = r6.f;
        if (r0 == 0) goto L_0x0069;
    L_0x0064:
        r0 = r6.f;
        r0.onGranted();
    L_0x0069:
        return;
    L_0x006a:
        r1 = r6.e;
        r0 = a(r0, r1);
        r1 = r0.isEmpty();
        if (r1 == 0) goto L_0x0080;
    L_0x0076:
        r0 = r6.f;
        if (r0 == 0) goto L_0x007f;
    L_0x007a:
        r0 = r6.f;
        r0.onGranted();
    L_0x007f:
        return;
    L_0x0080:
        r1 = a;
        r1 = r1.incrementAndGet();
        r2 = r0.size();
        r2 = new java.lang.String[r2];
        r0 = r0.toArray(r2);
        r0 = (java.lang.String[]) r0;
        r2 = r6.d;
        r3 = r2 instanceof android.app.Activity;
        if (r3 == 0) goto L_0x009e;
    L_0x0098:
        r2 = (android.app.Activity) r2;
        r2.requestPermissions(r0, r1);
        goto L_0x00a7;
    L_0x009e:
        r3 = r2 instanceof android.support.v4.app.Fragment;
        if (r3 == 0) goto L_0x00a7;
    L_0x00a2:
        r2 = (android.support.v4.app.Fragment) r2;
        r2.requestPermissions(r0, r1);
    L_0x00a7:
        r0 = b;
        r2 = r6.f;
        r0.put(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.c.a():void");
    }
}
