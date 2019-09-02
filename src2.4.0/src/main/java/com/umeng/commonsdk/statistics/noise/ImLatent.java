package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o;

public class ImLatent implements d {
    private static ImLatent instanse;
    private final int LATENT_MAX = 1800000;
    private final int LATENT_WINDOW = 10;
    private final long _360HOURS_IN_MS = 1296000000;
    private final long _36HOURS_IN_MS = 129600000;
    private final int _DEFAULT_HOURS = 360;
    private final int _DEFAULT_MAX_LATENT = 1800;
    private final int _DEFAULT_MIN_HOURS = 36;
    private final int _DEFAULT_MIN_LATENT = 1;
    private final long _ONE_HOURS_IN_MS = O000000o.O00000oo;
    private Context context;
    private long latentHour = 1296000000;
    private int latentWindow = 10;
    private long mDelay = 0;
    private long mElapsed = 0;
    private boolean mLatentActivite = false;
    private Object mLatentLock = new Object();
    private StatTracer statTracer;
    private com.umeng.commonsdk.statistics.common.d storeHelper;

    private ImLatent(Context context, StatTracer statTracer) {
        this.context = context;
        this.storeHelper = com.umeng.commonsdk.statistics.common.d.a(context);
        this.statTracer = statTracer;
    }

    public static synchronized ImLatent getService(Context context, StatTracer statTracer) {
        ImLatent imLatent;
        synchronized (ImLatent.class) {
            if (instanse == null) {
                instanse = new ImLatent(context, statTracer);
                instanse.onImprintChanged(ImprintHandler.getImprintService(context).c());
            }
            imLatent = instanse;
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j;
        synchronized (this.mLatentLock) {
            j = this.mDelay;
        }
        return j;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    public void onImprintChanged(a aVar) {
        int intValue = Integer.valueOf(aVar.a("latent_hours", String.valueOf(360))).intValue();
        if (intValue <= 36) {
            intValue = 360;
        }
        this.latentHour = ((long) intValue) * O000000o.O00000oo;
        int intValue2 = Integer.valueOf(aVar.a(e.az, "0")).intValue();
        if (intValue2 < 1 || intValue2 > 1800) {
            intValue2 = 0;
        }
        if (intValue2 != 0) {
            this.latentWindow = intValue2;
        } else if (com.umeng.commonsdk.statistics.a.c <= 0 || com.umeng.commonsdk.statistics.a.c > 1800000) {
            this.latentWindow = 10;
        } else {
            this.latentWindow = com.umeng.commonsdk.statistics.a.c;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x001d, code skipped:
            r6 = java.lang.System.currentTimeMillis() - r8.statTracer.getLastReqTime();
     */
    /* JADX WARNING: Missing block: B:15:0x002e, code skipped:
            if (r6 <= r8.latentHour) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:16:0x0030, code skipped:
            r0 = com.umeng.commonsdk.statistics.idtracking.Envelope.getSignature(r8.context);
            r3 = r8.mLatentLock;
     */
    /* JADX WARNING: Missing block: B:17:0x0038, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r8.mDelay = (long) com.umeng.commonsdk.statistics.common.DataHelper.random(r8.latentWindow, r0);
            r8.mElapsed = r6;
            r8.mLatentActivite = true;
     */
    /* JADX WARNING: Missing block: B:20:0x0046, code skipped:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:21:0x0047, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:26:0x0050, code skipped:
            if (r6 <= 129600000) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:27:0x0052, code skipped:
            r0 = r8.mLatentLock;
     */
    /* JADX WARNING: Missing block: B:28:0x0054, code skipped:
            monitor-enter(r0);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r8.mDelay = 0;
            r8.mElapsed = r6;
            r8.mLatentActivite = true;
     */
    /* JADX WARNING: Missing block: B:32:0x005d, code skipped:
            monitor-exit(r0);
     */
    /* JADX WARNING: Missing block: B:33:0x005e, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:37:0x0062, code skipped:
            return false;
     */
    public boolean shouldStartLatency() {
        /*
        r8 = this;
        r0 = r8.storeHelper;
        r0 = r0.c();
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = r8.statTracer;
        r0 = r0.isFirstRequest();
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r0 = r8.mLatentLock;
        monitor-enter(r0);
        r2 = r8.mLatentActivite;	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r0);	 Catch:{ all -> 0x0063 }
        return r1;
    L_0x001c:
        monitor-exit(r0);	 Catch:{ all -> 0x0063 }
        r0 = r8.statTracer;
        r2 = r0.getLastReqTime();
        r4 = java.lang.System.currentTimeMillis();
        r6 = r4 - r2;
        r2 = r8.latentHour;
        r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        r2 = 1;
        if (r0 <= 0) goto L_0x004b;
    L_0x0030:
        r0 = r8.context;
        r0 = com.umeng.commonsdk.statistics.idtracking.Envelope.getSignature(r0);
        r3 = r8.mLatentLock;
        monitor-enter(r3);
        r1 = r8.latentWindow;	 Catch:{ all -> 0x0048 }
        r0 = com.umeng.commonsdk.statistics.common.DataHelper.random(r1, r0);	 Catch:{ all -> 0x0048 }
        r0 = (long) r0;	 Catch:{ all -> 0x0048 }
        r8.mDelay = r0;	 Catch:{ all -> 0x0048 }
        r8.mElapsed = r6;	 Catch:{ all -> 0x0048 }
        r8.mLatentActivite = r2;	 Catch:{ all -> 0x0048 }
        monitor-exit(r3);	 Catch:{ all -> 0x0048 }
        return r2;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0048 }
        throw r0;
    L_0x004b:
        r3 = 129600000; // 0x7b98a00 float:2.7916815E-34 double:6.40309077E-316;
        r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1));
        if (r0 <= 0) goto L_0x0062;
    L_0x0052:
        r0 = r8.mLatentLock;
        monitor-enter(r0);
        r3 = 0;
        r8.mDelay = r3;	 Catch:{ all -> 0x005f }
        r8.mElapsed = r6;	 Catch:{ all -> 0x005f }
        r8.mLatentActivite = r2;	 Catch:{ all -> 0x005f }
        monitor-exit(r0);	 Catch:{ all -> 0x005f }
        return r2;
    L_0x005f:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x005f }
        throw r1;
    L_0x0062:
        return r1;
    L_0x0063:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0063 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.noise.ImLatent.shouldStartLatency():boolean");
    }
}
