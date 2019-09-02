package com.qiyukf.nimlib.h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.service.NimService;

public class a {
    private long a;
    private long b;
    private boolean c;

    private static void a(Context context, long j) {
        com.qiyukf.basesdk.a.a.d("service", "start keep alive alarm");
        context = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            PendingIntent service = PendingIntent.getService(context, 0, NimService.a(context), AMapEngineUtils.HALF_MAX_P20_WIDTH);
            if (service != null) {
                try {
                    if (VERSION.SDK_INT >= 19) {
                        alarmManager.setExact(2, SystemClock.elapsedRealtime() + j, service);
                    } else {
                        alarmManager.set(2, SystemClock.elapsedRealtime() + j, service);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a() {
    }

    public final void a(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (z) {
            this.b = elapsedRealtime;
            return;
        }
        this.a = elapsedRealtime;
        this.c = false;
    }

    /* Access modifiers changed, original: protected */
    public void b() {
    }

    public final void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.c) {
            com.qiyukf.basesdk.a.a.a("core", "reader idle timeout.");
            b();
        } else if (elapsedRealtime - this.a >= 240000 || elapsedRealtime - this.b >= 250000) {
            this.c = true;
            a();
            a(b.a(), 10000);
        } else {
            a(b.a(), Math.max(Math.min(250000 - (elapsedRealtime - this.b), 240000 - (elapsedRealtime - this.a)), 10000));
        }
    }

    public final void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b = elapsedRealtime;
        this.a = elapsedRealtime;
        this.c = false;
        a(b.a(), 240000);
    }

    public final void e() {
        Context a = b.a();
        com.qiyukf.basesdk.a.a.d("service", "stop alarm");
        a = a.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) a.getSystemService("alarm");
        if (alarmManager != null) {
            PendingIntent service = PendingIntent.getService(a, 0, NimService.a(a), AMapEngineUtils.MAX_P20_WIDTH);
            if (service != null) {
                alarmManager.cancel(service);
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = false;
    }
}
