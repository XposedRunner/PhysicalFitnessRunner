package com.qiyukf.unicorn.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.qiyukf.nimlib.f.d;
import com.qiyukf.nimlib.h.f;
import com.qiyukf.nimlib.service.NimReceiver;
import com.qiyukf.unicorn.api.SavePowerConfig;

public final class c {
    private Context a;
    private Handler b;
    private Runnable c;

    private static class a {
        public static final c a = new c();
    }

    private c() {
        this.c = new Runnable() {
            public final void run() {
                a.a(c.this.a, false);
            }
        };
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a(Context context) {
        if (a.a.a == null && context != null) {
            a.a.a = context;
            a.a.b = new Handler(context.getMainLooper());
        }
        return a.a;
    }

    public final boolean a() {
        f.a().a(this.a);
        return false;
    }

    public final void b() {
        d a = d.a();
        int d = a.d();
        StringBuilder stringBuilder = new StringBuilder("switch to saver mode from: ");
        stringBuilder.append(d);
        com.qiyukf.basesdk.a.a.a("PowerSaver", stringBuilder.toString());
        SavePowerConfig f = d.a().f();
        int i = (f != null && f.customPush && d.a().h()) ? 1 : 0;
        if (i == 0) {
            if (d != 1) {
                a.e();
                f.a().c();
            }
            d.a().a(System.currentTimeMillis());
            Context context = this.a;
            SavePowerConfig f2 = d.a().f();
            long j = f2 == null ? -1 : f2.checkInterval * 1000;
            if (j >= 0) {
                long max = Math.max(j, 900);
                Intent intent = new Intent(context, NimReceiver.class);
                intent.setAction("com.qiyukf.unicorn.ACTION.CHECK_MESSAGE");
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                if (alarmManager != null) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
                    if (broadcast != null) {
                        alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + Math.max(max - (System.currentTimeMillis() - d.a().c()), 0), max, broadcast);
                    }
                }
            }
        } else if (d != 1) {
            d.b();
        }
    }
}
