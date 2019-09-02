package com.qiyukf.nimlib.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.d;

public class NimReceiver extends BroadcastReceiver {
    private static int a(String str) {
        return "com.qiyukf.nim.ACTION.ALARM.REPEATING".equals(str) ? 2 : "com.qiyukf.unicorn.ACTION.CHECK_MESSAGE".equals(str) ? 5 : 3;
    }

    public static void a(Context context) {
        a.d("service", "start repeating alarm");
        context = context.getApplicationContext();
        Intent intent = new Intent(context, NimReceiver.class);
        intent.setAction("com.qiyukf.nim.ACTION.ALARM.REPEATING");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
            if (broadcast != null) {
                try {
                    alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + 600000, 600000, broadcast);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if ("com.qiyukf.unicorn.ACTION.CHECK_MESSAGE".equals(intent.getAction())) {
                if (!d.e().logined()) {
                    if (!d.a()) {
                        NimService.a(context, a(intent.getAction()));
                    }
                    if (b.a() != null) {
                        com.qiyukf.unicorn.g.a.a(context, true);
                    }
                }
            } else if (!d.a()) {
                if (TextUtils.isEmpty(b.b())) {
                    a.d("service", "stop alarm");
                    context = context.getApplicationContext();
                    intent = new Intent(context, NimReceiver.class);
                    intent.setAction("com.qiyukf.nim.ACTION.ALARM.REPEATING");
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                    if (alarmManager != null) {
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, AMapEngineUtils.MAX_P20_WIDTH);
                        if (broadcast != null) {
                            alarmManager.cancel(broadcast);
                        }
                    }
                } else {
                    NimService.a(context, a(intent.getAction()));
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("NimReceiver on Receive exception, e=");
            stringBuilder.append(th.getMessage());
            a.c("NimReceiver", stringBuilder.toString());
        }
    }
}
