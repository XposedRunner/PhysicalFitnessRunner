package com.zjwh.android_wh_physicalfitness.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import com.umeng.commonsdk.proguard.c;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.kl;
import defpackage.kz;
import s.h.e.l.l.C;

public class DaemonService extends Service {
    public static final String O000000o = "com.zjwh.android_wh_physicalfitness.service.DaemonService";
    protected static final int O00000Oo = 2;
    private static final String O00000o = "DaemonService";
    protected static PendingIntent O00000o0 = null;
    private static final int O00000oO = 60000;
    private static Handler O00000oo = new Handler();
    private static Runnable O0000O0o;

    public static class DaemonInnerService extends Service {
        public IBinder onBind(Intent intent) {
            throw new UnsupportedOperationException("onBind 未实现");
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            startForeground(2, new Notification());
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
    }

    static {
        C.i(16777315);
    }

    public static native void O000000o();

    public native IBinder onBind(Intent intent);

    public native void onDestroy();

    public int onStartCommand(Intent intent, int i, int i2) {
        kz.O00000o0(O00000o, "VMDaemonService->onStartCommand");
        if (VERSION.SDK_INT <= 24) {
            startForeground(2, new Notification());
            if (VERSION.SDK_INT >= 18) {
                try {
                    startService(new Intent(this, DaemonInnerService.class));
                } catch (Exception unused) {
                }
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Builder builder = new Builder(2, new ComponentName(MyApplication.O000000o(), DaemonJobService.class));
            builder.setPeriodic(O000000o.O00000o);
            if (VERSION.SDK_INT >= 24) {
                builder.setPeriodic(JobInfo.getMinPeriodMillis(), JobInfo.getMinFlexMillis());
            }
            builder.setPersisted(true);
            ((JobScheduler) getSystemService("jobscheduler")).schedule(builder.build());
        } else {
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            intent = new Intent();
            intent.setAction(RunLocationService.O00000oO);
            O00000o0 = PendingIntent.getService(MyApplication.O000000o(), 2, intent, 134217728);
            alarmManager.setRepeating(0, System.currentTimeMillis() + O000000o.O00000o, O000000o.O00000o, O00000o0);
        }
        O0000O0o = new Runnable() {
            public void run() {
                if (!O00Oo0.O000000o(RunLocationService.O00000oO)) {
                    DaemonService.this.sendBroadcast(new Intent(kl.O000000o));
                }
                DaemonService.O00000oo.postDelayed(DaemonService.O0000O0o, c.d);
            }
        };
        O00000oo.removeCallbacks(O0000O0o);
        O00000oo.post(O0000O0o);
        getPackageManager().setComponentEnabledSetting(new ComponentName(getPackageName(), RunLocationService.class.getName()), 1, 1);
        return 1;
    }
}
