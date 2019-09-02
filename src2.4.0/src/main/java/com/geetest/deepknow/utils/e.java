package com.geetest.deepknow.utils;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SuppressLint({"CommitPrefEdits"})
/* compiled from: DPPersistentIdentity */
abstract class e<T> {
    private final Future<SharedPreferences> a;
    private final a b;
    private final String c;
    private T d;

    /* compiled from: DPPersistentIdentity */
    interface a<T> {
        String a(T t);

        T b();

        T b(String str);
    }

    e(Future<SharedPreferences> future, String str, a<T> aVar) {
        this.a = future;
        this.b = aVar;
        this.c = str;
    }

    public T a() {
        if (this.d == null) {
            synchronized (this.a) {
                String str = null;
                try {
                    SharedPreferences sharedPreferences = (SharedPreferences) this.a.get();
                    if (sharedPreferences != null) {
                        str = sharedPreferences.getString(this.c, null);
                    }
                } catch (ExecutionException e) {
                    Log.e("DPPersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e.getCause());
                } catch (InterruptedException e2) {
                    Log.e("DPPersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e2);
                }
                Object b = str == null ? this.b.b() : this.b.b(str);
                if (b != null) {
                    a(b);
                }
            }
        }
        return this.d;
    }

    /* JADX WARNING: Missing block: B:20:0x004a, code skipped:
            return;
     */
    public void a(T r5) {
        /*
        r4 = this;
        r4.d = r5;
        r5 = r4.a;
        monitor-enter(r5);
        r0 = 0;
        r1 = r4.a;	 Catch:{ ExecutionException -> 0x001b, InterruptedException -> 0x0012 }
        r1 = r1.get();	 Catch:{ ExecutionException -> 0x001b, InterruptedException -> 0x0012 }
        r1 = (android.content.SharedPreferences) r1;	 Catch:{ ExecutionException -> 0x001b, InterruptedException -> 0x0012 }
        r0 = r1;
        goto L_0x0027;
    L_0x0010:
        r0 = move-exception;
        goto L_0x004b;
    L_0x0012:
        r1 = move-exception;
        r2 = "DPPersistentIdentity";
        r3 = "Cannot read distinct ids from sharedPreferences.";
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0010 }
        goto L_0x0027;
    L_0x001b:
        r1 = move-exception;
        r2 = "DPPersistentIdentity";
        r3 = "Cannot read distinct ids from sharedPreferences.";
        r1 = r1.getCause();	 Catch:{ all -> 0x0010 }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0010 }
    L_0x0027:
        if (r0 != 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r5);	 Catch:{ all -> 0x0010 }
        return;
    L_0x002b:
        r0 = r0.edit();	 Catch:{ all -> 0x0010 }
        r1 = r4.c;	 Catch:{ all -> 0x0010 }
        r2 = r4.b;	 Catch:{ all -> 0x0010 }
        r3 = r4.d;	 Catch:{ all -> 0x0010 }
        r2 = r2.a(r3);	 Catch:{ all -> 0x0010 }
        r0.putString(r1, r2);	 Catch:{ all -> 0x0010 }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0010 }
        r2 = 9;
        if (r1 < r2) goto L_0x0046;
    L_0x0042:
        r0.apply();	 Catch:{ all -> 0x0010 }
        goto L_0x0049;
    L_0x0046:
        r0.commit();	 Catch:{ all -> 0x0010 }
    L_0x0049:
        monitor-exit(r5);	 Catch:{ all -> 0x0010 }
        return;
    L_0x004b:
        monitor-exit(r5);	 Catch:{ all -> 0x0010 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.deepknow.utils.e.a(java.lang.Object):void");
    }
}
