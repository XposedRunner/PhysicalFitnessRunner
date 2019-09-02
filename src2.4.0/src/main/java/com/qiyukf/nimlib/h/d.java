package com.qiyukf.nimlib.h;

import android.content.Context;
import android.os.SystemClock;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

final class d {
    private final int a = 0;
    private final int b = 1;
    private Timer c;
    private AtomicInteger d = new AtomicInteger();
    private c e;
    private a f;
    private boolean g = false;
    private AtomicInteger h = new AtomicInteger(0);
    private long i = SystemClock.elapsedRealtime();

    public interface a {
        void b();

        void c();
    }

    /* renamed from: com.qiyukf.nimlib.h.d$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[com.qiyukf.nimlib.h.b.c.a.a().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Missing block: B:9:?, code skipped:
            return;
     */
        static {
            /*
            r0 = com.qiyukf.nimlib.h.b.c.a.a();
            r0 = r0.length;
            r0 = new int[r0];
            a = r0;
            r0 = 1;
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = com.qiyukf.nimlib.h.b.c.a.e;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = r2 - r0;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = com.qiyukf.nimlib.h.b.c.a.f;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = r2 - r0;
            r3 = 2;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = com.qiyukf.nimlib.h.b.c.a.d;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = r2 - r0;
            r0 = 3;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.h.d$AnonymousClass3.<clinit>():void");
        }
    }

    public d(a aVar) {
        this.f = aVar;
    }

    private void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    private boolean c() {
        c cVar = this.e;
        boolean z = cVar != null && cVar.a();
        if (z) {
            this.f.b();
            this.i = SystemClock.elapsedRealtime();
            return true;
        }
        com.qiyukf.basesdk.a.a.b("core", "network is not available");
        return false;
    }

    public final void a() {
        com.qiyukf.basesdk.a.a.b("test", "networkKeeper shutdown");
        if (this.h.compareAndSet(1, 0)) {
            if (this.e != null) {
                this.e.c();
                this.e = null;
            }
            b();
        }
    }

    public final void a(Context context) {
        if (this.h.compareAndSet(0, 1)) {
            com.qiyukf.basesdk.a.a.b("test", "networkKeeper startup");
            if (this.e == null) {
                this.e = new c(context, new com.qiyukf.nimlib.h.c.a() {
                    public final void a(int i) {
                        switch (AnonymousClass3.a[i - 1]) {
                            case 1:
                                break;
                            case 2:
                                d.this.f.c();
                                break;
                            case 3:
                                d.this.f.c();
                                return;
                            default:
                                return;
                        }
                        d.a(d.this);
                    }
                });
                this.e.b();
            }
        }
    }

    /* JADX WARNING: Missing block: B:16:0x0058, code skipped:
            return;
     */
    public final void a(com.qiyukf.nimlib.sdk.StatusCode r9) {
        /*
        r8 = this;
        r0 = r8.h;
        r0 = r0.get();
        r1 = 1;
        if (r0 == r1) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = com.qiyukf.nimlib.sdk.StatusCode.LOGINED;
        if (r9 != r0) goto L_0x0012;
    L_0x000e:
        r8.b();
        return;
    L_0x0012:
        r9 = r9.shouldReLogin();
        if (r9 == 0) goto L_0x0058;
    L_0x0018:
        r9 = r8.h;
        r9 = r9.get();
        if (r9 == 0) goto L_0x0058;
    L_0x0020:
        r9 = r8.c;
        if (r9 == 0) goto L_0x0025;
    L_0x0024:
        return;
    L_0x0025:
        r9 = new java.util.Random;
        r9.<init>();
        r9 = r9.nextInt();
        r9 = r9 % 10;
        r9 = java.lang.Math.abs(r9);
        r0 = r9 + 10;
        r0 = r0 * 1000;
        r1 = r8.d;
        r2 = 0;
        r1.set(r2);
        r1 = new java.util.Timer;
        r1.<init>();
        r8.c = r1;
        r3 = new com.qiyukf.nimlib.h.d$2;
        r3.<init>();
        r2 = r8.c;
        r1 = 5;
        r9 = r9 / 2;
        r1 = r1 + r9;
        r1 = r1 * 1000;
        r4 = (long) r1;
        r6 = (long) r0;
        r2.schedule(r3, r4, r6);
        return;
    L_0x0058:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.h.d.a(com.qiyukf.nimlib.sdk.StatusCode):void");
    }
}
