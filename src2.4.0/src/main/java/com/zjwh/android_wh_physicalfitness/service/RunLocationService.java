package com.zjwh.android_wh_physicalfitness.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import com.umeng.commonsdk.proguard.c;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.entity.database.MyLocation;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import com.zjwh.android_wh_physicalfitness.receiver.ChatReceiver;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.map.gaode.O0000o;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.O00Oo;
import defpackage.gf;
import defpackage.il;
import defpackage.lp;
import defpackage.lw;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import s.h.e.l.l.C;

public class RunLocationService extends Service implements lw {
    public static final String O000000o = "extra_sport_id";
    public static final String O00000Oo = "extra_speed_top";
    public static final String O00000o = "extra_service_restart";
    public static final String O00000o0 = "extra_service_type";
    public static final String O00000oO = "com.zjwh.android_wh_physicalfitness.service.RunLocationService";
    public static final String O00000oo = "lastGpsTime";
    public static final String O0000O0o = "goRebootTime";
    public static final int O0000OOo = 0;
    public static final int O0000Oo = 2;
    public static final int O0000Oo0 = 1;
    public static final int O0000OoO = 3;
    public static final int O0000Ooo = 4;
    public static final int O0000o00 = 5;
    private Handler O0000o = new Handler();
    Runnable O0000o0 = new Runnable() {
        public void run() {
            if ((System.currentTimeMillis() - RunLocationService.this.O000OO0o) - RunLocationService.this.O000o00o > c.d && RunLocationService.this.O000o00O == 2) {
                RunLocationService.this.O000o00 = RunLocationService.this.O000o00 + 1;
                if ((RunLocationService.this.O0000oOo instanceof O0000O0o) && RunLocationService.this.O000o00 == 3) {
                    ((O0000O0o) RunLocationService.this.O0000oOo).O000OO();
                    RunLocationService.this.O000o00 = 0;
                }
            }
            if (RunLocationService.this.O000O0o0) {
                RunLocationService.this.O000o0 = RunLocationService.this.O000o0 + 1;
                if (RunLocationService.this.O000o0 == 30) {
                    RunLocationService.this.O000000o((long) RunLocationService.this.O000o0);
                    RunLocationService.this.O000o0 = 0;
                }
            }
            if (RunLocationService.this.O000OOOo == -1) {
                RunLocationService.this.O000OOOo = RunLocationService.this.O0000o0();
            }
            if (!(RunLocationService.this.O0000oOo == null || RunLocationService.this.O000O0o0 || RunLocationService.this.O000O00o || !(RunLocationService.this.O0000oOo instanceof O00000o0))) {
                if (RunLocationService.this.O000O0o) {
                    if (RunLocationService.this.O000Ooo0 != 0) {
                        RunLocationService.this.O0000Oo0();
                        RunLocationService.this.O0000oO0();
                    }
                    ((O00000o0) RunLocationService.this.O0000oOo).O000000o(RunLocationService.O0000o(RunLocationService.this));
                } else {
                    ((O00000o0) RunLocationService.this.O0000oOo).O00000Oo(RunLocationService.O0000oO0(RunLocationService.this));
                }
            }
            RunLocationService.this.O0000o.postDelayed(RunLocationService.this.O0000o0, 1000);
        }
    };
    private Notification O0000o0O;
    private lp O0000o0o;
    private WakeLock O0000oO = null;
    private IBinder O0000oO0 = new O000000o();
    private SportRecord O0000oOO = null;
    private O00000Oo O0000oOo;
    private DbManager O0000oo = null;
    private il O0000oo0;
    private SWLatLng O0000ooO;
    private SWLatLng O0000ooo;
    private boolean O000O00o = false;
    private boolean O000O0OO = false;
    private boolean O000O0Oo = false;
    private boolean O000O0o = false;
    private boolean O000O0o0 = false;
    private boolean O000O0oO = false;
    private boolean O000O0oo = false;
    private long O000OO;
    private long O000OO00 = -1;
    private long O000OO0o;
    private long O000OOOo = -1;
    private double O000OOo;
    private long O000OOo0;
    private double O000OOoO = 0.0d;
    private double O000OOoo = 0.0d;
    private double O000Oo0 = -1.0d;
    private double O000Oo00 = 0.0d;
    private float O000Oo0O;
    private float O000Oo0o;
    private int O000OoO;
    private int O000OoO0;
    private int O000OoOO;
    private int O000OoOo = 0;
    private int O000Ooo;
    private int O000Ooo0;
    private int O000OooO;
    private int O000Oooo;
    private int O000o0 = 0;
    private int O000o00;
    private int O000o000;
    private int O000o00O = 1;
    private long O000o00o;
    private long O000o0O0;
    private int O00O0Oo;
    private boolean O00oOoOo = true;
    private List<FivePoint> O00oOooO = null;
    private boolean O00oOooo = true;

    public interface O00000Oo {
        void O000000o(double d, double d2, double d3, double d4, float f);
    }

    public interface O00000o0 extends O00000Oo {
        void O000000o(long j);

        void O00000Oo(long j);
    }

    public class O000000o extends Binder {
        public RunLocationService O000000o() {
            return RunLocationService.this;
        }
    }

    private static class O00000o extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> O000000o;

        O00000o(Context context) {
            this.O000000o = new WeakReference(context);
        }

        /* Access modifiers changed, original: protected|varargs */
        /* renamed from: O000000o */
        public Void doInBackground(Void... voidArr) {
            Context context = (Context) this.O000000o.get();
            if (context != null) {
                O00Oo.O00000Oo(context.getApplicationContext()).O0000Ooo();
            }
            return null;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: O000000o */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
        }
    }

    public interface O0000O0o extends O00000o0 {
        void O000000o(double d);

        void O000000o(int i, float f);

        void O000000o(int i, boolean z, int i2);

        void O000000o(long j, boolean z);

        void O000000o(MyLocation myLocation);

        void O000000o(boolean z, boolean z2);

        void O00000Oo(double d);

        void O00000Oo(int i);

        void O00000o(int i);

        void O00000o0(int i);

        void O000OO();
    }

    static {
        C.i(16777316);
    }

    private double O000000o(double d) {
        return d == 0.0d ? 0.0d : 50.0d / (d * 3.0d);
    }

    private double O000000o(double d, long j, long j2) {
        long j3 = j - j2;
        d = (d <= 0.0d || j3 <= 0) ? 0.0d : ((double) j3) / (d * 60.0d);
        return (d <= 0.0d || d > 10000.0d) ? 0.0d : d;
    }

    private native int O000000o(int i, float f, int i2, float f2);

    private native int O000000o(int i, int i2);

    private MyLocation O000000o(int i, double d, double d2, String str, int i2, float f, double d3, float f2, int i3, float f3, double d4, double d5) {
        MyLocation myLocation = r1;
        MyLocation myLocation2 = new MyLocation(d4, d5, str, i, d3, f2, i3, f3, this.O000o00O, d, d2);
        MyLocation myLocation3 = myLocation;
        myLocation3.setFlag(this.O000OO00);
        myLocation3.setLocType(i2);
        myLocation3.setRadius(f);
        myLocation3.setTotalTime(this.O000OOOo);
        return myLocation3;
    }

    private void O000000o(long j) {
        try {
            SportRecord O0000o00 = O0000o00();
            long totalPauseTime = O0000o00.getTotalPauseTime() + j;
            O0000o00.setTotalPauseTime(totalPauseTime);
            O0000o0o().saveOrUpdate(O0000o00);
            if (totalPauseTime == 1200 || totalPauseTime == 1800) {
                O000000o((Context) this, totalPauseTime == 1200 ? "本次跑步剩余暂停时长10分钟，请抓紧时间完成跑步" : "本次跑步暂停时间过长，已自动结束");
                if (this.O0000oOo instanceof O0000O0o) {
                    ((O0000O0o) this.O0000oOo).O000000o(1800 - totalPauseTime, true);
                }
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    private void O000000o(Context context, String str) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String string = context.getString(2131689512);
            Builder builder = new Builder(context);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(ChatReceiver.O000000o), 134217728);
            builder.setSmallIcon(R.mipmap.logo).setTicker(string).setContentTitle(string).setContentText(str).setWhen(System.currentTimeMillis()).setContentIntent(broadcast);
            if (VERSION.SDK_INT >= 21) {
                builder.setVisibility(1);
                builder.setFullScreenIntent(broadcast, true);
            }
            Notification build = builder.build();
            build.flags = 16;
            notificationManager.notify(9999, build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean O000000o(SWLatLng sWLatLng) {
        return this.O0000ooO != null && this.O0000ooO.getGLat() == sWLatLng.getGLat() && this.O0000ooO.getGLon() == sWLatLng.getGLon();
    }

    /* JADX WARNING: Missing block: B:28:0x0070, code skipped:
            return 2;
     */
    /* JADX WARNING: Missing block: B:44:0x00cd, code skipped:
            return r9;
     */
    /* JADX WARNING: Missing block: B:71:0x012a, code skipped:
            return r9;
     */
    private synchronized int O00000Oo(com.zjwh.sw.map.entity.SWLatLng r23) {
        /*
        r22 = this;
        r1 = r22;
        r2 = r23;
        monitor-enter(r22);
        r3 = r22.O0000oO();	 Catch:{ all -> 0x0154 }
        r4 = 0;
        if (r3 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r22);
        return r4;
    L_0x000e:
        r5 = r1.O000Ooo0;	 Catch:{ DbException -> 0x0130 }
        r6 = 4;
        r7 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r9 = 2;
        r10 = 1;
        if (r5 != r6) goto L_0x0071;
    L_0x0017:
        r3 = r3.get(r4);	 Catch:{ DbException -> 0x0130 }
        r3 = (com.zjwh.android_wh_physicalfitness.entity.database.FivePoint) r3;	 Catch:{ DbException -> 0x0130 }
        r5 = new com.zjwh.sw.map.entity.SWLatLng;	 Catch:{ DbException -> 0x0130 }
        r12 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r14 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r16 = r3.getLat();	 Catch:{ DbException -> 0x0130 }
        r18 = r3.getLon();	 Catch:{ DbException -> 0x0130 }
        r11 = r5;
        r11.<init>(r12, r14, r16, r18);	 Catch:{ DbException -> 0x0130 }
        r6 = r1.O0000o0o;	 Catch:{ DbException -> 0x0130 }
        r5 = r6.O000000o(r2, r5);	 Catch:{ DbException -> 0x0130 }
        r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r2 > 0) goto L_0x0151;
    L_0x0039:
        r2 = r3.getPosition();	 Catch:{ DbException -> 0x0130 }
        r5 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        if (r2 != r5) goto L_0x0043;
    L_0x0041:
        monitor-exit(r22);
        return r4;
    L_0x0043:
        r3.setIsPass(r10);	 Catch:{ DbException -> 0x0130 }
        r2 = r22.O0000o0o();	 Catch:{ DbException -> 0x0130 }
        r2.saveOrUpdate(r3);	 Catch:{ DbException -> 0x0130 }
        r2 = r1.O0000oOo;	 Catch:{ DbException -> 0x0130 }
        r2 = r2 instanceof com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o;	 Catch:{ DbException -> 0x0130 }
        if (r2 == 0) goto L_0x005e;
    L_0x0053:
        r2 = r1.O0000oOo;	 Catch:{ DbException -> 0x0130 }
        r2 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r2;	 Catch:{ DbException -> 0x0130 }
        r3 = r3.getPosition();	 Catch:{ DbException -> 0x0130 }
        r2.O00000o(r3);	 Catch:{ DbException -> 0x0130 }
    L_0x005e:
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        if (r2 == 0) goto L_0x006f;
    L_0x0062:
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        r2 = r2.size();	 Catch:{ DbException -> 0x0130 }
        if (r2 <= 0) goto L_0x006f;
    L_0x006a:
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        r2.remove(r4);	 Catch:{ DbException -> 0x0130 }
    L_0x006f:
        monitor-exit(r22);
        return r9;
    L_0x0071:
        r5 = r4;
    L_0x0072:
        r6 = r3.size();	 Catch:{ DbException -> 0x0130 }
        if (r5 >= r6) goto L_0x0151;
    L_0x0078:
        r6 = r3.get(r5);	 Catch:{ DbException -> 0x0130 }
        r6 = (com.zjwh.android_wh_physicalfitness.entity.database.FivePoint) r6;	 Catch:{ DbException -> 0x0130 }
        r14 = new com.zjwh.sw.map.entity.SWLatLng;	 Catch:{ DbException -> 0x0130 }
        r12 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r15 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r17 = r6.getLat();	 Catch:{ DbException -> 0x0130 }
        r19 = r6.getLon();	 Catch:{ DbException -> 0x0130 }
        r11 = r14;
        r4 = r14;
        r14 = r15;
        r16 = r17;
        r18 = r19;
        r11.<init>(r12, r14, r16, r18);	 Catch:{ DbException -> 0x0130 }
        r11 = r1.O0000o0o;	 Catch:{ DbException -> 0x0130 }
        r11 = r11.O000000o(r2, r4);	 Catch:{ DbException -> 0x0130 }
        r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1));
        if (r4 > 0) goto L_0x012b;
    L_0x00a0:
        r4 = r1.O000Ooo0;	 Catch:{ DbException -> 0x0130 }
        if (r4 != r10) goto L_0x00ce;
    L_0x00a4:
        r6.setIsPass(r10);	 Catch:{ DbException -> 0x0130 }
        r2 = r22.O0000o0o();	 Catch:{ DbException -> 0x0130 }
        r2.saveOrUpdate(r6);	 Catch:{ DbException -> 0x0130 }
        r2 = r1.O0000oOo;	 Catch:{ DbException -> 0x0130 }
        r2 = r2 instanceof com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o;	 Catch:{ DbException -> 0x0130 }
        if (r2 == 0) goto L_0x00bf;
    L_0x00b4:
        r2 = r1.O0000oOo;	 Catch:{ DbException -> 0x0130 }
        r2 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r2;	 Catch:{ DbException -> 0x0130 }
        r3 = r6.getId();	 Catch:{ DbException -> 0x0130 }
        r2.O00000o(r3);	 Catch:{ DbException -> 0x0130 }
    L_0x00bf:
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        r2.remove(r5);	 Catch:{ DbException -> 0x0130 }
        r2 = r6.getIsFixed();	 Catch:{ DbException -> 0x0130 }
        if (r2 != r10) goto L_0x00cb;
    L_0x00ca:
        goto L_0x00cc;
    L_0x00cb:
        r9 = r10;
    L_0x00cc:
        monitor-exit(r22);
        return r9;
    L_0x00ce:
        r4 = r1.O000Ooo0;	 Catch:{ DbException -> 0x0130 }
        if (r4 != r9) goto L_0x012b;
    L_0x00d2:
        r2 = r6.getIsFixed();	 Catch:{ DbException -> 0x0130 }
        if (r2 == r10) goto L_0x00e7;
    L_0x00d8:
        r6.setIsPass(r10);	 Catch:{ DbException -> 0x0130 }
        r2 = r22.O0000o0o();	 Catch:{ DbException -> 0x0130 }
        r2.saveOrUpdate(r6);	 Catch:{ DbException -> 0x0130 }
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        r2.remove(r5);	 Catch:{ DbException -> 0x0130 }
    L_0x00e7:
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        if (r2 == 0) goto L_0x00f2;
    L_0x00eb:
        r2 = r1.O00oOooO;	 Catch:{ DbException -> 0x0130 }
        r4 = r2.size();	 Catch:{ DbException -> 0x0130 }
        goto L_0x00f3;
    L_0x00f2:
        r4 = 0;
    L_0x00f3:
        r2 = 5 - r4;
        r3 = r22.O0000oOO();	 Catch:{ DbException -> 0x0130 }
        if (r3 == 0) goto L_0x010d;
    L_0x00fb:
        r3 = r6.getIsFixed();	 Catch:{ DbException -> 0x0130 }
        if (r3 != r10) goto L_0x010d;
    L_0x0101:
        r3 = r22.O0000o0();	 Catch:{ DbException -> 0x0130 }
        r7 = 30;
        r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x010d;
    L_0x010b:
        r3 = r10;
        goto L_0x010e;
    L_0x010d:
        r3 = 0;
    L_0x010e:
        r4 = r1.O0000oOo;	 Catch:{ DbException -> 0x0130 }
        r4 = r4 instanceof com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o;	 Catch:{ DbException -> 0x0130 }
        if (r4 == 0) goto L_0x011f;
    L_0x0114:
        r4 = r1.O0000oOo;	 Catch:{ DbException -> 0x0130 }
        r4 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r4;	 Catch:{ DbException -> 0x0130 }
        r5 = r6.getId();	 Catch:{ DbException -> 0x0130 }
        r4.O000000o(r5, r3, r2);	 Catch:{ DbException -> 0x0130 }
    L_0x011f:
        r2 = r6.getIsFixed();	 Catch:{ DbException -> 0x0130 }
        if (r2 != r10) goto L_0x0128;
    L_0x0125:
        if (r3 == 0) goto L_0x0128;
    L_0x0127:
        goto L_0x0129;
    L_0x0128:
        r9 = r10;
    L_0x0129:
        monitor-exit(r22);
        return r9;
    L_0x012b:
        r5 = r5 + 1;
        r4 = 0;
        goto L_0x0072;
    L_0x0130:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();	 Catch:{ all -> 0x0154 }
        r3 = com.zjwh.android_wh_physicalfitness.application.MyApplication.O000000o();	 Catch:{ all -> 0x0154 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0154 }
        r4.<init>();	 Catch:{ all -> 0x0154 }
        r5 = "pass five point error --> ";
        r4.append(r5);	 Catch:{ all -> 0x0154 }
        r2 = com.zjwh.android_wh_physicalfitness.utils.O000o000.O000000o(r2);	 Catch:{ all -> 0x0154 }
        r4.append(r2);	 Catch:{ all -> 0x0154 }
        r2 = r4.toString();	 Catch:{ all -> 0x0154 }
        x.O00000Oo(r3, r2);	 Catch:{ all -> 0x0154 }
    L_0x0151:
        monitor-exit(r22);
        r2 = 0;
        return r2;
    L_0x0154:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r22);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.service.RunLocationService.O00000Oo(com.zjwh.sw.map.entity.SWLatLng):int");
    }

    private boolean O00000Oo(int i) {
        if (i == -1) {
            try {
                SportRecord O0000o00 = O0000o00();
                if (O0000o00 != null) {
                    i = O0000o00.getSelDistance();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return O00Oo0.O00000oO((double) i) <= O00Oo0.O00000oO(this.O000Oo0);
    }

    /* JADX WARNING: Missing block: B:14:0x002d, code skipped:
            return;
     */
    private synchronized void O0000Oo() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.O0000oO;	 Catch:{ all -> 0x002e }
        if (r0 != 0) goto L_0x002c;
    L_0x0005:
        r0 = r3.getApplicationContext();	 Catch:{ all -> 0x002e }
        r1 = "power";
        r0 = r0.getSystemService(r1);	 Catch:{ all -> 0x002e }
        r0 = (android.os.PowerManager) r0;	 Catch:{ all -> 0x002e }
        if (r0 != 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r3);
        return;
    L_0x0015:
        r1 = 536870913; // 0x20000001 float:1.0842023E-19 double:2.652494744E-315;
        r2 = ":PostLocationService";
        r0 = r0.newWakeLock(r1, r2);	 Catch:{ all -> 0x002e }
        r3.O0000oO = r0;	 Catch:{ all -> 0x002e }
        r0 = r3.O0000oO;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r3.O0000oO;	 Catch:{ all -> 0x002e }
        r1 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0.acquire(r1);	 Catch:{ all -> 0x002e }
    L_0x002c:
        monitor-exit(r3);
        return;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000Oo():void");
    }

    private native void O0000Oo0();

    private synchronized void O0000OoO() {
        if (this.O0000oO != null && this.O0000oO.isHeld()) {
            try {
                this.O0000oO.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.O0000oO = null;
        }
    }

    private native void O0000Ooo();

    static /* synthetic */ long O0000o(RunLocationService runLocationService) {
        long j = runLocationService.O000OOOo + 1;
        runLocationService.O000OOOo = j;
        return j;
    }

    private boolean O0000o() {
        long currentTimeMillis = System.currentTimeMillis() - ((Long) O00O0Oo0.O00000o0(O00000oo, Long.valueOf(0))).longValue();
        long currentTimeMillis2 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) - ((Long) O00O0Oo0.O00000o0(O0000O0o, Long.valueOf(0))).longValue();
        boolean z = currentTimeMillis > 0 && currentTimeMillis < 600000;
        boolean z2 = currentTimeMillis2 > 0 && currentTimeMillis2 < 600000;
        return z2 || z;
    }

    private long O0000o0() {
        SportRecord O0000o00 = O0000o00();
        if (O0000o00 == null) {
            return 0;
        }
        try {
            List locList = O0000o00.getLocList(O0000o0o());
            return (locList == null || locList.size() <= 0) ? 0 : ((MyLocation) locList.get(locList.size() - 1)).getTotalTime();
        } catch (DbException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private SportRecord O0000o00() {
        if (this.O0000oOO == null || this.O0000oOO.getId() != this.O000o000) {
            try {
                if (this.O000o000 <= 0) {
                    switch (this.O000Ooo0) {
                        case 1:
                        case 4:
                            this.O0000oOO = (SportRecord) O0000o0o().selector(SportRecord.class).where("stopTime", "<=", Integer.valueOf(1000)).and("uid", "=", Integer.valueOf(O00Oo0.O000000o(this.O0000oo))).and("sportType", "=", Integer.valueOf(1)).orderBy("id", true).findFirst();
                            break;
                        case 2:
                            this.O0000oOO = (SportRecord) O0000o0o().selector(SportRecord.class).where("stopTime", "<=", Integer.valueOf(1000)).and("uid", "=", Integer.valueOf(O00Oo0.O000000o(this.O0000oo))).and("sportType", "=", Integer.valueOf(3)).orderBy("id", true).findFirst();
                            break;
                        case 3:
                            this.O0000oOO = (SportRecord) O0000o0o().selector(SportRecord.class).where("stopTime", "<=", Integer.valueOf(1000)).and("uid", "=", Integer.valueOf(O00Oo0.O000000o(this.O0000oo))).and("sportType", "=", Integer.valueOf(4)).orderBy("id", true).findFirst();
                            break;
                        default:
                            break;
                    }
                }
                this.O0000oOO = (SportRecord) O0000o0o().selector(SportRecord.class).where("id", "=", Integer.valueOf(this.O000o000)).findFirst();
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
        return this.O0000oOO;
    }

    private double O0000o0O() {
        double d = 0.0d;
        try {
            SportRecord O0000o00 = O0000o00();
            if (O0000o00 == null) {
                return 0.0d;
            }
            List locList = O0000o00.getLocList(O0000o0o());
            if (locList != null && locList.size() > 0) {
                MyLocation myLocation = (MyLocation) locList.get(locList.size() - 1);
                if (myLocation != null) {
                    d = myLocation.getTotalDis();
                }
                return d;
            }
            return 0.0d;
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    private native DbManager O0000o0o();

    private List<FivePoint> O0000oO() {
        if (this.O00oOooO == null) {
            try {
                SportRecord O0000o00 = O0000o00();
                if (O0000o00 != null) {
                    this.O00oOooO = O0000o00.getFivePoint(O0000o0o());
                }
                if (this.O00oOooO != null) {
                    if (this.O00oOooO.size() == 5 || this.O000Ooo0 == 5) {
                        Iterator it = this.O00oOooO.iterator();
                        while (it.hasNext()) {
                            if (((FivePoint) it.next()).getIsPass()) {
                                it.remove();
                            }
                        }
                    } else {
                        this.O00oOooO.clear();
                        this.O00oOooO = null;
                    }
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
        return this.O00oOooO;
    }

    static /* synthetic */ long O0000oO0(RunLocationService runLocationService) {
        long j = runLocationService.O000OOo0 + 1;
        runLocationService.O000OOo0 = j;
        return j;
    }

    private void O0000oO0() {
        double selDistance = ((double) O0000o00().getSelDistance()) * 0.2d;
        int i = this.O000Oooo > 2 ? 1 : 0;
        if ((this.O000OOoO + this.O000OOoo >= selDistance ? 1 : 0) != 0 || i == 0 || this.O00oOoOo) {
            this.O00O0Oo = 0;
            return;
        }
        double d = this.O00O0Oo > 0 ? ((double) (this.O000OoO0 - this.O00O0Oo)) * 0.8d : 0.0d;
        if (this.O000O0o0) {
            this.O000Oo00 += d;
        } else {
            if ((this.O000OOoO + this.O000OOoo) + d > selDistance) {
                d = (selDistance - this.O000OOoO) - this.O000OOoo;
            }
            double d2 = d;
            this.O000OOoo += d2;
            this.O000Oo0 += d2;
            if ((this.O0000oOo instanceof O0000O0o) && System.currentTimeMillis() - this.O000o0O0 >= 15000) {
                ((O0000O0o) this.O0000oOo).O00000Oo(O000000o(d2, System.currentTimeMillis(), this.O000o0O0));
                ((O0000O0o) this.O0000oOo).O000000o(this.O000Oo0);
                ((O0000O0o) this.O0000oOo).O00000o0(1);
                this.O000o0O0 = System.currentTimeMillis();
            }
        }
        this.O00O0Oo = this.O000OoO0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    private boolean O0000oOO() {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        r2 = r6.O0000o00();	 Catch:{ Exception -> 0x003a }
        if (r2 == 0) goto L_0x0015;
    L_0x0008:
        r3 = r6.O0000o0o();	 Catch:{ Exception -> 0x003a }
        r3 = r2.getFivePoint(r3);	 Catch:{ Exception -> 0x003a }
        r2 = r2.getSelDistance();	 Catch:{ Exception -> 0x003a }
        goto L_0x0017;
    L_0x0015:
        r3 = 0;
        r2 = r1;
    L_0x0017:
        if (r3 == 0) goto L_0x0040;
    L_0x0019:
        r3 = r3.iterator();	 Catch:{ Exception -> 0x0038 }
        r4 = r1;
    L_0x001e:
        r5 = r3.hasNext();	 Catch:{ Exception -> 0x0038 }
        if (r5 == 0) goto L_0x0033;
    L_0x0024:
        r5 = r3.next();	 Catch:{ Exception -> 0x0038 }
        r5 = (com.zjwh.android_wh_physicalfitness.entity.database.FivePoint) r5;	 Catch:{ Exception -> 0x0038 }
        r5 = r5.getIsPass();	 Catch:{ Exception -> 0x0038 }
        if (r5 == 0) goto L_0x001e;
    L_0x0030:
        r4 = r4 + 1;
        goto L_0x001e;
    L_0x0033:
        r3 = 2;
        if (r4 < r3) goto L_0x0040;
    L_0x0036:
        r3 = r0;
        goto L_0x0041;
    L_0x0038:
        r3 = move-exception;
        goto L_0x003d;
    L_0x003a:
        r2 = move-exception;
        r3 = r2;
        r2 = r1;
    L_0x003d:
        r3.printStackTrace();
    L_0x0040:
        r3 = r1;
    L_0x0041:
        if (r3 == 0) goto L_0x004a;
    L_0x0043:
        r2 = r6.O00000Oo(r2);
        if (r2 == 0) goto L_0x004a;
    L_0x0049:
        goto L_0x004b;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000oOO():boolean");
    }

    public void O000000o() {
        if (this.O000OO00 == -1) {
            SportRecord O0000o00 = O0000o00();
            if (O0000o00 != null) {
                this.O000OO00 = O0000o00.getTimestamp();
            } else {
                return;
            }
        }
        if (this.O000OOOo == -1) {
            this.O000OOOo = O0000o0();
        }
        if (this.O000Oo0 == -1.0d) {
            this.O000Oo0 = O0000o0O();
        }
    }

    public void O000000o(double d, double d2, double d3, double d4) {
        if (this.O0000oOo != null) {
            this.O0000oOo.O000000o(d, d2, d3, d4, this.O000Oo0O);
        }
    }

    public native void O000000o(int i);

    /* JADX WARNING: Removed duplicated region for block: B:86:0x019e A:{Catch:{ Exception -> 0x027a }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019d A:{Catch:{ Exception -> 0x027a }} */
    public void O000000o(int r38, double r39, double r41, java.lang.String r43, int r44, float r45, boolean r46, double r47, float r49, int r50, float r51, double r52, double r54) {
        /*
        r37 = this;
        r15 = r37;
        if (r46 == 0) goto L_0x0011;
    L_0x0004:
        r1 = "lastGpsTime";
        r2 = java.lang.System.currentTimeMillis();
        r2 = java.lang.Long.valueOf(r2);
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r1, r2);
    L_0x0011:
        r1 = r15.O000O0oO;
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r1 = r15.O000OooO;
        r14 = 10;
        r13 = 1;
        if (r1 >= r14) goto L_0x0022;
    L_0x001d:
        r1 = r15.O000OooO;
        r1 = r1 + r13;
        r15.O000OooO = r1;
    L_0x0022:
        r1 = "yyyy-MM-dd HH:mm:ss";
        r7 = r43;
        r1 = com.zjwh.android_wh_physicalfitness.utils.O000O0o0.O000000o(r1, r7);	 Catch:{ Exception -> 0x0282 }
        if (r1 == 0) goto L_0x0036;
    L_0x002c:
        r1 = r1.getTime();	 Catch:{ Exception -> 0x0031 }
        goto L_0x003a;
    L_0x0031:
        r0 = move-exception;
        r1 = r0;
        r9 = r15;
        goto L_0x0285;
    L_0x0036:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0282 }
    L_0x003a:
        r10 = r1;
        r12 = new com.zjwh.sw.map.entity.SWLatLng;	 Catch:{ Exception -> 0x0282 }
        r20 = r12;
        r21 = r39;
        r23 = r41;
        r25 = r52;
        r27 = r54;
        r20.<init>(r21, r23, r25, r27);	 Catch:{ Exception -> 0x0282 }
        r1 = r15.O000O00o;	 Catch:{ Exception -> 0x0282 }
        if (r1 != 0) goto L_0x0280;
    L_0x004e:
        r1 = r15;
        r2 = r38;
        r3 = r52;
        r5 = r54;
        r8 = r44;
        r9 = r45;
        r29 = r10;
        r10 = r47;
        r31 = r12;
        r12 = r49;
        r13 = r50;
        r14 = r51;
        r15 = r39;
        r17 = r41;
        r8 = r1.O000000o(r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r15, r17);	 Catch:{ Exception -> 0x027c }
        r9 = r37;
        r1 = r9.O0000ooO;	 Catch:{ Exception -> 0x027a }
        r10 = 0;
        if (r1 != 0) goto L_0x0079;
    L_0x0075:
        r2 = r10;
        r12 = r31;
        goto L_0x0084;
    L_0x0079:
        r1 = r9.O0000o0o;	 Catch:{ Exception -> 0x027a }
        r2 = r9.O0000ooO;	 Catch:{ Exception -> 0x027a }
        r12 = r31;
        r1 = r1.O000000o(r12, r2);	 Catch:{ Exception -> 0x027a }
        r2 = r1;
    L_0x0084:
        r6 = r9.O000OO0o;	 Catch:{ Exception -> 0x027a }
        r1 = r9;
        r4 = r29;
        r13 = r1.O000000o(r2, r4, r6);	 Catch:{ Exception -> 0x027a }
        r1 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1));
        if (r1 <= 0) goto L_0x009f;
    L_0x0091:
        r1 = r9.O000000o(r13);	 Catch:{ Exception -> 0x027a }
        r3 = r50;
        r4 = r51;
        r6 = r1;
        r1 = r38;
        r2 = r45;
        goto L_0x00a8;
    L_0x009f:
        r1 = r38;
        r2 = r45;
        r3 = r50;
        r4 = r51;
        r6 = r10;
    L_0x00a8:
        r1 = r9.O000000o(r3, r4, r1, r2);	 Catch:{ Exception -> 0x027a }
        r2 = 65;
        r4 = -1;
        r5 = 3;
        r3 = 5;
        r15 = 0;
        if (r1 <= r2) goto L_0x01c3;
    L_0x00b4:
        if (r46 == 0) goto L_0x01c3;
    L_0x00b6:
        r1 = r9.O000000o(r12);	 Catch:{ Exception -> 0x027a }
        if (r1 != 0) goto L_0x01c3;
    L_0x00bc:
        r9.O000Oooo = r15;	 Catch:{ Exception -> 0x027a }
        r1 = r9.O0000ooo;	 Catch:{ Exception -> 0x027a }
        if (r1 != 0) goto L_0x00c5;
    L_0x00c2:
        r16 = r10;
        goto L_0x00cf;
    L_0x00c5:
        r1 = r9.O0000o0o;	 Catch:{ Exception -> 0x027a }
        r2 = r9.O0000ooo;	 Catch:{ Exception -> 0x027a }
        r1 = r1.O000000o(r12, r2);	 Catch:{ Exception -> 0x027a }
        r16 = r1;
    L_0x00cf:
        r1 = r9.O000OO;	 Catch:{ Exception -> 0x027a }
        r18 = r1;
        r1 = r9;
        r2 = r16;
        r4 = r29;
        r33 = r6;
        r6 = r18;
        r1 = r1.O000000o(r2, r4, r6);	 Catch:{ Exception -> 0x027a }
        r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x00e9;
    L_0x00e4:
        r3 = r9.O000000o(r1);	 Catch:{ Exception -> 0x027a }
        goto L_0x00ea;
    L_0x00e9:
        r3 = r10;
    L_0x00ea:
        r5 = r9.O00oOoOo;	 Catch:{ Exception -> 0x027a }
        if (r5 == 0) goto L_0x0124;
    L_0x00ee:
        r5 = r9.O000O0OO;	 Catch:{ Exception -> 0x027a }
        if (r5 != 0) goto L_0x0124;
    L_0x00f2:
        r9.O00oOoOo = r15;	 Catch:{ Exception -> 0x027a }
        r9.O0000ooo = r12;	 Catch:{ Exception -> 0x027a }
        r5 = r29;
        r9.O000OO = r5;	 Catch:{ Exception -> 0x027a }
        r10 = r33;
        r3 = com.zjwh.android_wh_physicalfitness.utils.O00Oo0.O000000o(r10);	 Catch:{ Exception -> 0x027a }
        r8.setAvgSpeed(r3);	 Catch:{ Exception -> 0x027a }
        r3 = com.zjwh.android_wh_physicalfitness.utils.O00Oo0.O000000o(r13);	 Catch:{ Exception -> 0x027a }
        r8.setSpeed(r3);	 Catch:{ Exception -> 0x027a }
        r3 = "running_analyze";
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r3);	 Catch:{ Exception -> 0x027a }
        r3 = r9.O000Ooo;	 Catch:{ Exception -> 0x027a }
        if (r3 <= 0) goto L_0x0117;
    L_0x0113:
        r3 = 50005; // 0xc355 float:7.0072E-41 double:2.47058E-319;
        goto L_0x011a;
    L_0x0117:
        r3 = 50002; // 0xc352 float:7.0068E-41 double:2.47043E-319;
    L_0x011a:
        r4 = com.zjwh.android_wh_physicalfitness.utils.O00Oo0.O0000oO();	 Catch:{ Exception -> 0x027a }
        com.zjwh.android_wh_physicalfitness.utils.O00Oo0.O000000o(r3, r4);	 Catch:{ Exception -> 0x027a }
        r4 = 5;
        goto L_0x01be;
    L_0x0124:
        r5 = r29;
        r13 = r9.O000Oo00;	 Catch:{ Exception -> 0x027a }
        r16 = r16 - r13;
        r13 = r9.O000OOoo;	 Catch:{ Exception -> 0x027a }
        r13 = r16 - r13;
        r7 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1));
        if (r7 >= 0) goto L_0x0137;
    L_0x0132:
        r16 = java.lang.Math.abs(r13);	 Catch:{ Exception -> 0x027a }
        goto L_0x0139;
    L_0x0137:
        r16 = r10;
    L_0x0139:
        r7 = r9.O000O0o0;	 Catch:{ Exception -> 0x027a }
        if (r7 == 0) goto L_0x0149;
    L_0x013d:
        r13 = r9.O000OOoO;	 Catch:{ Exception -> 0x027a }
        r13 = r13 + r16;
        r9.O000OOoO = r13;	 Catch:{ Exception -> 0x027a }
        r35 = r1;
        r1 = r10;
        r32 = 3;
        goto L_0x01a4;
    L_0x0149:
        r7 = r9.O000O0OO;	 Catch:{ Exception -> 0x027a }
        if (r7 == 0) goto L_0x016b;
    L_0x014d:
        r13 = r9.O000OOo;	 Catch:{ Exception -> 0x027a }
        r7 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1));
        if (r7 < 0) goto L_0x0156;
    L_0x0153:
        r9.O00000Oo(r12);	 Catch:{ Exception -> 0x027a }
    L_0x0156:
        r7 = r9.O000O0Oo;	 Catch:{ Exception -> 0x027a }
        if (r7 == 0) goto L_0x015d;
    L_0x015a:
        r7 = 9;
        goto L_0x015f;
    L_0x015d:
        r7 = 8;
    L_0x015f:
        r9.O000O0OO = r15;	 Catch:{ Exception -> 0x027a }
        r9.O00oOoOo = r15;	 Catch:{ Exception -> 0x027a }
        r13 = r9.O000OOoO;	 Catch:{ Exception -> 0x027a }
        r10 = r9.O000OOoo;	 Catch:{ Exception -> 0x027a }
        r13 = r13 + r10;
        r9.O000OOoO = r13;	 Catch:{ Exception -> 0x027a }
        goto L_0x0179;
    L_0x016b:
        r10 = r9.O000OOo;	 Catch:{ Exception -> 0x027a }
        r7 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r7 >= 0) goto L_0x017c;
    L_0x0171:
        r7 = 7;
        r10 = r9.O000OOoO;	 Catch:{ Exception -> 0x027a }
        r13 = r9.O000OOoo;	 Catch:{ Exception -> 0x027a }
        r10 = r10 + r13;
        r9.O000OOoO = r10;	 Catch:{ Exception -> 0x027a }
    L_0x0179:
        r10 = 0;
        goto L_0x0193;
    L_0x017c:
        r7 = r9.O000Ooo0;	 Catch:{ Exception -> 0x027a }
        r10 = 3;
        if (r7 == r10) goto L_0x018b;
    L_0x0181:
        r7 = r9.O000Ooo0;	 Catch:{ Exception -> 0x027a }
        r11 = 5;
        if (r7 != r11) goto L_0x0187;
    L_0x0186:
        goto L_0x018b;
    L_0x0187:
        r15 = r9.O00000Oo(r12);	 Catch:{ Exception -> 0x027a }
    L_0x018b:
        r10 = r9.O000OOoO;	 Catch:{ Exception -> 0x027a }
        r10 = r10 + r16;
        r9.O000OOoO = r10;	 Catch:{ Exception -> 0x027a }
        r10 = r13;
        r7 = r15;
    L_0x0193:
        r13 = r9.O000Oo0;	 Catch:{ Exception -> 0x027a }
        r35 = r1;
        r1 = 0;
        r15 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1));
        if (r15 <= 0) goto L_0x019e;
    L_0x019d:
        goto L_0x019f;
    L_0x019e:
        r10 = r1;
    L_0x019f:
        r13 = r13 + r10;
        r9.O000Oo0 = r13;	 Catch:{ Exception -> 0x027a }
        r32 = r7;
    L_0x01a4:
        r9.O000OOoo = r1;	 Catch:{ Exception -> 0x027a }
        r9.O000Oo00 = r1;	 Catch:{ Exception -> 0x027a }
        r9.O0000ooo = r12;	 Catch:{ Exception -> 0x027a }
        r9.O000OO = r5;	 Catch:{ Exception -> 0x027a }
        r1 = com.zjwh.android_wh_physicalfitness.utils.O00Oo0.O000000o(r3);	 Catch:{ Exception -> 0x027a }
        r8.setAvgSpeed(r1);	 Catch:{ Exception -> 0x027a }
        r1 = r35;
        r3 = com.zjwh.android_wh_physicalfitness.utils.O00Oo0.O000000o(r1);	 Catch:{ Exception -> 0x027a }
        r8.setSpeed(r3);	 Catch:{ Exception -> 0x027a }
        r4 = r32;
    L_0x01be:
        r2 = r1;
        r1 = r4;
        r4 = 1;
        r10 = 2;
        goto L_0x021e;
    L_0x01c3:
        r1 = r10;
        r11 = r3;
        r10 = r5;
        r5 = r29;
        r3 = r9.O000Oooo;	 Catch:{ Exception -> 0x027a }
        r4 = 1;
        r3 = r3 + r4;
        r9.O000Oooo = r3;	 Catch:{ Exception -> 0x027a }
        r3 = r9.O00oOoOo;	 Catch:{ Exception -> 0x027a }
        if (r3 == 0) goto L_0x021b;
    L_0x01d2:
        r3 = r9.O000O0OO;	 Catch:{ Exception -> 0x027a }
        if (r3 != 0) goto L_0x021b;
    L_0x01d6:
        r3 = r9.O000Ooo0;	 Catch:{ Exception -> 0x027a }
        if (r3 == r10) goto L_0x021b;
    L_0x01da:
        r3 = r9.O000OooO;	 Catch:{ Exception -> 0x027a }
        r7 = 10;
        if (r3 == r7) goto L_0x01e8;
    L_0x01e0:
        r3 = r9.O000O0oo;	 Catch:{ Exception -> 0x027a }
        if (r3 == 0) goto L_0x021b;
    L_0x01e4:
        r3 = r9.O000OooO;	 Catch:{ Exception -> 0x027a }
        if (r3 != r11) goto L_0x021b;
    L_0x01e8:
        r3 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r3 = r3 instanceof com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o;	 Catch:{ Exception -> 0x027a }
        if (r3 == 0) goto L_0x021b;
    L_0x01ee:
        r9.O000OooO = r15;	 Catch:{ Exception -> 0x027a }
        r9.O000O0oO = r4;	 Catch:{ Exception -> 0x027a }
        r3 = r9.O000O0oo;	 Catch:{ Exception -> 0x027a }
        if (r3 == 0) goto L_0x0212;
    L_0x01f6:
        r3 = r9.O000Ooo;	 Catch:{ Exception -> 0x027a }
        r3 = r3 + r4;
        r9.O000Ooo = r3;	 Catch:{ Exception -> 0x027a }
        r3 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r3 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r3;	 Catch:{ Exception -> 0x027a }
        r7 = r37.O0000o();	 Catch:{ Exception -> 0x027a }
        if (r7 != 0) goto L_0x020c;
    L_0x0205:
        r7 = r9.O000Ooo;	 Catch:{ Exception -> 0x027a }
        r10 = 2;
        if (r7 < r10) goto L_0x020d;
    L_0x020a:
        r7 = r4;
        goto L_0x020e;
    L_0x020c:
        r10 = 2;
    L_0x020d:
        r7 = r15;
    L_0x020e:
        r3.O000000o(r15, r7);	 Catch:{ Exception -> 0x027a }
        goto L_0x021c;
    L_0x0212:
        r10 = 2;
        r3 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r3 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r3;	 Catch:{ Exception -> 0x027a }
        r3.O000000o(r4, r15);	 Catch:{ Exception -> 0x027a }
        goto L_0x021c;
    L_0x021b:
        r10 = 2;
    L_0x021c:
        r2 = r1;
        r1 = -1;
    L_0x021e:
        r8.setType(r1);	 Catch:{ Exception -> 0x027a }
        r13 = r9.O000Oo0;	 Catch:{ Exception -> 0x027a }
        r8.setTotalDis(r13);	 Catch:{ Exception -> 0x027a }
        r13 = r9.O000OOoO;	 Catch:{ Exception -> 0x027a }
        r8.setStepDistance(r13);	 Catch:{ Exception -> 0x027a }
        r7 = r37.O0000o0o();	 Catch:{ Exception -> 0x027a }
        r7.saveBindingId(r8);	 Catch:{ Exception -> 0x027a }
        r9.O0000ooO = r12;	 Catch:{ Exception -> 0x027a }
        r9.O000OO0o = r5;	 Catch:{ Exception -> 0x027a }
        r5 = r9.O000o00o;	 Catch:{ Exception -> 0x027a }
        r11 = 0;
        r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1));
        if (r7 != 0) goto L_0x0248;
    L_0x023e:
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x027a }
        r11 = r9.O000OO0o;	 Catch:{ Exception -> 0x027a }
        r13 = r5 - r11;
        r9.O000o00o = r13;	 Catch:{ Exception -> 0x027a }
    L_0x0248:
        r5 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r5 = r5 instanceof com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o;	 Catch:{ Exception -> 0x027a }
        if (r5 == 0) goto L_0x0288;
    L_0x024e:
        r5 = r9.O00oOoOo;	 Catch:{ Exception -> 0x027a }
        if (r5 == 0) goto L_0x0256;
    L_0x0252:
        r5 = r9.O000O0OO;	 Catch:{ Exception -> 0x027a }
        if (r5 == 0) goto L_0x026d;
    L_0x0256:
        r5 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r5 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r5;	 Catch:{ Exception -> 0x027a }
        r5.O00000Oo(r2);	 Catch:{ Exception -> 0x027a }
        r2 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r2 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r2;	 Catch:{ Exception -> 0x027a }
        r5 = r9.O000Oo0;	 Catch:{ Exception -> 0x027a }
        r2.O000000o(r5);	 Catch:{ Exception -> 0x027a }
        r2 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r2 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r2;	 Catch:{ Exception -> 0x027a }
        r2.O000000o(r8);	 Catch:{ Exception -> 0x027a }
    L_0x026d:
        r2 = r9.O0000oOo;	 Catch:{ Exception -> 0x027a }
        r2 = (com.zjwh.android_wh_physicalfitness.service.RunLocationService.O0000O0o) r2;	 Catch:{ Exception -> 0x027a }
        r3 = -1;
        if (r1 != r3) goto L_0x0275;
    L_0x0274:
        goto L_0x0276;
    L_0x0275:
        r4 = r10;
    L_0x0276:
        r2.O00000o0(r4);	 Catch:{ Exception -> 0x027a }
        goto L_0x0288;
    L_0x027a:
        r0 = move-exception;
        goto L_0x0284;
    L_0x027c:
        r0 = move-exception;
        r9 = r37;
        goto L_0x0284;
    L_0x0280:
        r9 = r15;
        goto L_0x0288;
    L_0x0282:
        r0 = move-exception;
        r9 = r15;
    L_0x0284:
        r1 = r0;
    L_0x0285:
        r1.printStackTrace();
    L_0x0288:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.service.RunLocationService.O000000o(int, double, double, java.lang.String, int, float, boolean, double, float, int, float, double, double):void");
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O0000oOo = o00000Oo;
    }

    public void O000000o(boolean z) {
        this.O000O0o0 = z;
        if (this.O000O0o0 && (this.O0000oOo instanceof O0000O0o)) {
            ((O0000O0o) this.O0000oOo).O000000o((1800 - O0000o00().getTotalPauseTime()) - ((long) this.O000o0), false);
        }
    }

    public void O000000o(boolean z, boolean z2, long j) {
        this.O000O0o = z2;
        this.O000OOOo = j;
        this.O00oOoOo = false;
        this.O000O0Oo = true;
        O000000o(z);
        O00000o();
    }

    public boolean O000000o(double d, double d2) {
        return this.O0000o0o.O000000o(this.O0000ooO, new SWLatLng(-1.0d, -1.0d, d, d2)) <= 50.0d;
    }

    public native void O00000Oo();

    public void O00000o() {
        this.O000O0OO = true;
        SportRecord O0000o00 = O0000o00();
        if (O0000o00 != null) {
            try {
                MyLocation myLocation = (MyLocation) O0000o0o().selector(MyLocation.class).orderBy("id", true).where(WhereBuilder.b("flag", "=", String.valueOf(O0000o00.getTimestamp()))).findFirst();
                if (myLocation != null) {
                    this.O0000ooO = new SWLatLng(myLocation.getLat(), myLocation.getLng(), myLocation.getgLat(), myLocation.getgLng());
                    Date O000000o = O000O0o0.O000000o(O000O0o0.O0000o0, myLocation.getGainTime());
                    this.O000OO0o = O000000o != null ? O000000o.getTime() : System.currentTimeMillis();
                    this.O000OOoO = myLocation.getStepDistance();
                    MyLocation myLocation2 = (MyLocation) O0000o0o().selector(MyLocation.class).orderBy("id", true).where(WhereBuilder.b("type", "!=", "-1")).and(WhereBuilder.b("flag", "=", String.valueOf(O0000o00.getTimestamp()))).findFirst();
                    if (myLocation2 != null) {
                        this.O0000ooo = new SWLatLng(myLocation2.getLat(), myLocation2.getLng(), myLocation.getgLat(), myLocation.getgLng());
                        Date O000000o2 = O000O0o0.O000000o(O000O0o0.O0000o0, myLocation2.getGainTime());
                        this.O000OO = O000000o2 != null ? O000000o2.getTime() : System.currentTimeMillis();
                        this.O000OOoo = myLocation.getTotalDis() - myLocation2.getTotalDis();
                    }
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
    }

    public native void O00000o0();

    public native boolean O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    @Nullable
    public IBinder onBind(Intent intent) {
        this.O000OOo = intent.getDoubleExtra(O00000Oo, gf.O0000o);
        this.O000Ooo0 = intent.getIntExtra(O00000o0, 0);
        this.O000o000 = intent.getIntExtra(O000000o, -1);
        if (intent.getBooleanExtra(O00000o, false)) {
            this.O00oOoOo = false;
        } else {
            this.O000O0OO = false;
            this.O00oOoOo = true;
        }
        this.O0000o0o = new O0000o(this);
        if (this.O000Ooo0 == 0) {
            O00000o0();
        }
        this.O0000o0.run();
        return this.O0000oO0;
    }

    public native void onCreate();

    public native void onDestroy();

    public native int onStartCommand(Intent intent, int i, int i2);

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i != 20) {
            try {
                if (O000OOo0.O000000o().O00000oO(getApplicationContext()) > 0) {
                    new O00000o(this).execute(new Void[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        O00Oo0.O000000o(40000 + i, this.O0000oOO != null ? this.O0000oOO.getUuid() : "");
    }

    public native boolean onUnbind(Intent intent);
}
