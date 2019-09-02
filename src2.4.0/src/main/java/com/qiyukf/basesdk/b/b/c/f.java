package com.qiyukf.basesdk.b.b.c;

import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.b.b.a.b;
import com.qiyukf.basesdk.b.b.a.k;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f extends h {
    private static final String a = "f";
    private Selector b = m();
    private final SelectorProvider c = SelectorProvider.provider();
    private final AtomicBoolean d = new AtomicBoolean();
    private boolean e;
    private boolean f;

    private void a(Set<SelectionKey> set) {
        if (!set.isEmpty()) {
            loop0:
            while (true) {
                Iterator it = set.iterator();
                do {
                    SelectionKey selectionKey = (SelectionKey) it.next();
                    Object attachment = selectionKey.attachment();
                    it.remove();
                    if (attachment instanceof k) {
                        k kVar = (k) attachment;
                        if (selectionKey.isValid()) {
                            try {
                                int readyOps = selectionKey.readyOps();
                                if ((readyOps & 1) != 0 || readyOps == 0) {
                                    kVar.h();
                                    if (!kVar.d()) {
                                    }
                                }
                                if ((readyOps & 4) != 0) {
                                    kVar.b().d();
                                }
                                if ((readyOps & 8) != 0) {
                                    selectionKey.interestOps(selectionKey.interestOps() & -9);
                                    kVar.a().b();
                                }
                            } catch (CancelledKeyException unused) {
                            }
                        }
                        kVar.e();
                    }
                    if (!it.hasNext()) {
                        break loop0;
                    }
                } while (!this.f);
                Set set2 = this.b.selectedKeys();
                if (set2.isEmpty()) {
                    break;
                }
            }
        }
    }

    private Selector m() {
        try {
            return this.c.openSelector();
        } catch (IOException e) {
            throw new b("failed to open a new selector", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018 A:{LOOP_START, SYNTHETIC, LOOP:0: B:9:0x0018->B:25:0x005c, Splitter:B:9:0x0018} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0020 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067 A:{Catch:{ ConcurrentModificationException -> 0x0018 }} */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:9|10|(6:13|14|15|(1:42)(2:17|(2:19|43)(2:20|(3:22|23|45)(1:44)))|41|11)|40|30|31|32|33) */
    private void n() {
        /*
        r7 = this;
        r0 = r7.h();
        if (r0 != 0) goto L_0x000f;
    L_0x0006:
        r0 = new com.qiyukf.basesdk.b.b.c.f$1;
        r0.<init>();
        r7.execute(r0);
        return;
    L_0x000f:
        r0 = r7.b;
        if (r0 != 0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r1 = r7.m();	 Catch:{ Exception -> 0x007c }
    L_0x0018:
        r2 = r0.keys();	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r2 = r2.iterator();	 Catch:{ ConcurrentModificationException -> 0x0018 }
    L_0x0020:
        r3 = r2.hasNext();	 Catch:{ ConcurrentModificationException -> 0x0018 }
        if (r3 == 0) goto L_0x006d;
    L_0x0026:
        r3 = r2.next();	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r3 = (java.nio.channels.SelectionKey) r3;	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r4 = r3.attachment();	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r5 = r3.isValid();	 Catch:{ Exception -> 0x005b }
        if (r5 == 0) goto L_0x0020;
    L_0x0036:
        r5 = r3.channel();	 Catch:{ Exception -> 0x005b }
        r5 = r5.keyFor(r1);	 Catch:{ Exception -> 0x005b }
        if (r5 == 0) goto L_0x0041;
    L_0x0040:
        goto L_0x0020;
    L_0x0041:
        r5 = r3.interestOps();	 Catch:{ Exception -> 0x005b }
        r3.cancel();	 Catch:{ Exception -> 0x005b }
        r3 = r3.channel();	 Catch:{ Exception -> 0x005b }
        r3 = r3.register(r1, r5, r4);	 Catch:{ Exception -> 0x005b }
        r5 = r4 instanceof com.qiyukf.basesdk.b.b.a.k;	 Catch:{ Exception -> 0x005b }
        if (r5 == 0) goto L_0x0020;
    L_0x0054:
        r5 = r4;
        r5 = (com.qiyukf.basesdk.b.b.a.k) r5;	 Catch:{ Exception -> 0x005b }
        r5.a(r3);	 Catch:{ Exception -> 0x005b }
        goto L_0x0020;
    L_0x005b:
        r3 = move-exception;
        r5 = a;	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r6 = "Failed to re-register a Channel to the new Selector.";
        com.qiyukf.basesdk.a.a.d(r5, r6, r3);	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r3 = r4 instanceof com.qiyukf.basesdk.b.b.a.k;	 Catch:{ ConcurrentModificationException -> 0x0018 }
        if (r3 == 0) goto L_0x0020;
    L_0x0067:
        r4 = (com.qiyukf.basesdk.b.b.a.k) r4;	 Catch:{ ConcurrentModificationException -> 0x0018 }
        r4.e();	 Catch:{ ConcurrentModificationException -> 0x0018 }
        goto L_0x0020;
    L_0x006d:
        r7.b = r1;
        r0.close();	 Catch:{ Throwable -> 0x0073 }
        return;
    L_0x0073:
        r0 = move-exception;
        r1 = a;
        r2 = "Failed to close the old Selector.";
        com.qiyukf.basesdk.a.a.d(r1, r2, r0);
        return;
    L_0x007c:
        r0 = move-exception;
        r1 = a;
        r2 = "Failed to create a new Selector.";
        com.qiyukf.basesdk.a.a.d(r1, r2, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.b.c.f.n():void");
    }

    private void o() {
        Set<SelectionKey> keys = this.b.keys();
        ArrayList<k> arrayList = new ArrayList(keys.size());
        for (SelectionKey attachment : keys) {
            Object attachment2 = attachment.attachment();
            if (attachment2 instanceof k) {
                arrayList.add((k) attachment2);
            }
        }
        for (k e : arrayList) {
            e.e();
        }
    }

    public final Selector a() {
        return this.b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(boolean z) {
        if (!z && this.d.compareAndSet(false, true)) {
            this.b.wakeup();
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:11:0x002a, code skipped:
            if (r4 == 0) goto L_0x002c;
     */
    /* JADX WARNING: Missing block: B:12:0x002c, code skipped:
            r0.selectNow();
     */
    public final void b() {
        /*
        r10 = this;
    L_0x0000:
        r0 = r10.d;
        r1 = 0;
        r0 = r0.getAndSet(r1);
        r10.e = r0;
        r0 = r10.e();	 Catch:{ Throwable -> 0x00e7 }
        if (r0 == 0) goto L_0x0014;
    L_0x000f:
        r10.d();	 Catch:{ Throwable -> 0x00e7 }
        goto L_0x00c9;
    L_0x0014:
        r0 = r10.b;	 Catch:{ Throwable -> 0x00e7 }
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ CancelledKeyException -> 0x009f }
        r4 = r10.g();	 Catch:{ CancelledKeyException -> 0x009f }
        r6 = r2 + r4;
        r4 = r1;
    L_0x0021:
        r8 = r6 - r2;
        r2 = 0;
        r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        r2 = 1;
        if (r5 > 0) goto L_0x0032;
    L_0x002a:
        if (r4 != 0) goto L_0x0030;
    L_0x002c:
        r0.selectNow();	 Catch:{ CancelledKeyException -> 0x009f }
        goto L_0x0081;
    L_0x0030:
        r2 = r4;
        goto L_0x0081;
    L_0x0032:
        r3 = r0.select(r8);	 Catch:{ CancelledKeyException -> 0x009f }
        r4 = r4 + 1;
        if (r3 != 0) goto L_0x0030;
    L_0x003a:
        r3 = r10.e;	 Catch:{ CancelledKeyException -> 0x009f }
        if (r3 != 0) goto L_0x0030;
    L_0x003e:
        r3 = r10.d;	 Catch:{ CancelledKeyException -> 0x009f }
        r3 = r3.get();	 Catch:{ CancelledKeyException -> 0x009f }
        if (r3 != 0) goto L_0x0030;
    L_0x0046:
        r3 = r10.e();	 Catch:{ CancelledKeyException -> 0x009f }
        if (r3 != 0) goto L_0x0030;
    L_0x004c:
        r3 = java.lang.Thread.interrupted();	 Catch:{ CancelledKeyException -> 0x009f }
        if (r3 == 0) goto L_0x005a;
    L_0x0052:
        r0 = a;	 Catch:{ CancelledKeyException -> 0x009f }
        r3 = "Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.";
        com.qiyukf.basesdk.a.a.d(r0, r3);	 Catch:{ CancelledKeyException -> 0x009f }
        goto L_0x0081;
    L_0x005a:
        r3 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r4 < r3) goto L_0x007c;
    L_0x005e:
        r0 = a;	 Catch:{ CancelledKeyException -> 0x009f }
        r3 = new java.lang.StringBuilder;	 Catch:{ CancelledKeyException -> 0x009f }
        r5 = "Selector.select() returned prematurely ";
        r3.<init>(r5);	 Catch:{ CancelledKeyException -> 0x009f }
        r3.append(r4);	 Catch:{ CancelledKeyException -> 0x009f }
        r4 = " times in a row; rebuilding selector.";
        r3.append(r4);	 Catch:{ CancelledKeyException -> 0x009f }
        r3 = r3.toString();	 Catch:{ CancelledKeyException -> 0x009f }
        com.qiyukf.basesdk.a.a.d(r0, r3);	 Catch:{ CancelledKeyException -> 0x009f }
        r10.n();	 Catch:{ CancelledKeyException -> 0x009f }
        r0 = r10.b;	 Catch:{ CancelledKeyException -> 0x009f }
        goto L_0x002c;
    L_0x007c:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ CancelledKeyException -> 0x009f }
        goto L_0x0021;
    L_0x0081:
        r0 = 3;
        if (r2 <= r0) goto L_0x00bc;
    L_0x0084:
        r0 = a;	 Catch:{ CancelledKeyException -> 0x009f }
        r3 = new java.lang.StringBuilder;	 Catch:{ CancelledKeyException -> 0x009f }
        r4 = "Selector.select() returned prematurely ";
        r3.<init>(r4);	 Catch:{ CancelledKeyException -> 0x009f }
        r2 = r2 + -1;
        r3.append(r2);	 Catch:{ CancelledKeyException -> 0x009f }
        r2 = " times in a row.";
        r3.append(r2);	 Catch:{ CancelledKeyException -> 0x009f }
        r2 = r3.toString();	 Catch:{ CancelledKeyException -> 0x009f }
        com.qiyukf.basesdk.a.a.d(r0, r2);	 Catch:{ CancelledKeyException -> 0x009f }
        goto L_0x00bc;
    L_0x009f:
        r0 = move-exception;
        r2 = a;	 Catch:{ Throwable -> 0x00e7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e7 }
        r3.<init>();	 Catch:{ Throwable -> 0x00e7 }
        r4 = java.nio.channels.CancelledKeyException.class;
        r4 = r4.getSimpleName();	 Catch:{ Throwable -> 0x00e7 }
        r3.append(r4);	 Catch:{ Throwable -> 0x00e7 }
        r4 = " raised by a Selector - JDK bug?";
        r3.append(r4);	 Catch:{ Throwable -> 0x00e7 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00e7 }
        com.qiyukf.basesdk.a.a.c(r2, r3, r0);	 Catch:{ Throwable -> 0x00e7 }
    L_0x00bc:
        r0 = r10.d;	 Catch:{ Throwable -> 0x00e7 }
        r0 = r0.get();	 Catch:{ Throwable -> 0x00e7 }
        if (r0 == 0) goto L_0x00c9;
    L_0x00c4:
        r0 = r10.b;	 Catch:{ Throwable -> 0x00e7 }
        r0.wakeup();	 Catch:{ Throwable -> 0x00e7 }
    L_0x00c9:
        r10.f = r1;	 Catch:{ Throwable -> 0x00e7 }
        r0 = r10.b;	 Catch:{ Throwable -> 0x00e7 }
        r0 = r0.selectedKeys();	 Catch:{ Throwable -> 0x00e7 }
        r10.a(r0);	 Catch:{ Throwable -> 0x00e7 }
        r10.f();	 Catch:{ Throwable -> 0x00e7 }
        r0 = r10.j();	 Catch:{ Throwable -> 0x00e7 }
        if (r0 == 0) goto L_0x0000;
    L_0x00dd:
        r10.o();	 Catch:{ Throwable -> 0x00e7 }
        r0 = r10.k();	 Catch:{ Throwable -> 0x00e7 }
        if (r0 == 0) goto L_0x0000;
    L_0x00e6:
        return;
    L_0x00e7:
        r0 = move-exception;
        r1 = a;
        r2 = "Unexpected exception in the selector loop.";
        com.qiyukf.basesdk.a.a.d(r1, r2, r0);
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0000 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.b.c.f.b():void");
    }

    /* Access modifiers changed, original: protected|final */
    public final void c() {
        try {
            this.b.close();
        } catch (IOException e) {
            a.d(a, "Failed to close a selector.", e);
        }
    }

    public final void d() {
        try {
            this.b.selectNow();
        } finally {
            if (this.d.get()) {
                this.b.wakeup();
            }
        }
    }
}
