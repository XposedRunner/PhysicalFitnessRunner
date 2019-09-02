package cn.jiguang.d.h;

public final class w implements Comparable<w>, Runnable {
    private int a;
    private final Runnable b;

    public w(Runnable runnable, int i) {
        if (i <= 0) {
            i = 4;
        } else if (i > 10) {
            i = 10;
        }
        this.a = i;
        this.b = runnable;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return ((w) obj).a - this.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d A:{Catch:{ Throwable -> 0x0012 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0009 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|(2:5|7)(1:9)) */
    /* JADX WARNING: Missing block: B:8:?, code skipped:
            return;
     */
    public final void run() {
        /*
        r2 = this;
        r0 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0009 }
        r1 = r2.a;	 Catch:{ Throwable -> 0x0009 }
        r0.setPriority(r1);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        r0 = r2.b;	 Catch:{ Throwable -> 0x0012 }
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r2.b;	 Catch:{ Throwable -> 0x0012 }
        r0.run();	 Catch:{ Throwable -> 0x0012 }
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.h.w.run():void");
    }
}
