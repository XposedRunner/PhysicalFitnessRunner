package cn.jpush.android.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.b.b;
import cn.jiguang.d.b.a;
import cn.jiguang.d.b.d;
import cn.jiguang.d.b.g;
import cn.jiguang.d.d.i;
import cn.jiguang.e.c;

public class PushService extends Service {
    private static final String TAG = "PushService";
    private static b mBinder;
    private BroadcastReceiver mPowerBroadcastReceiver = null;
    private BroadcastReceiver receiver;

    public IBinder onBind(Intent intent) {
        a.a(this);
        return mBinder;
    }

    public void onCreate() {
        a.a(this);
        if (mBinder == null) {
            mBinder = new cn.jiguang.g.a.a();
        }
        JCoreInterface.execute("SDK_MAIN", new cn.jiguang.service.a(this, 1, null), new int[0]);
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        JCoreInterface.execute("SDK_MAIN", new cn.jiguang.service.a(this, 3, null), new int[0]);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("onStartCommand - intent:");
        stringBuilder.append(intent);
        stringBuilder.append(", pkg:");
        stringBuilder.append(cn.jiguang.d.a.c);
        stringBuilder.append(", connection:");
        stringBuilder.append(g.a.get());
        c.a(str, stringBuilder.toString());
        a.a(this);
        JCoreInterface.execute("SDK_MAIN", new cn.jiguang.service.a(this, 2, intent), new int[0]);
        return 1;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A:{Catch:{ Throwable -> 0x004a }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* JADX WARNING: Failed to process nested try/catch */
    public void runCreate() {
        /*
        r3 = this;
        r0 = r3.getApplicationContext();
        r1 = cn.jiguang.d.a.d(r0);
        if (r1 != 0) goto L_0x0012;
    L_0x000a:
        r0 = "PushService";
        r1 = "onCreate:JCoreInterface init failed";
        cn.jiguang.e.c.c(r0, r1);
        return;
    L_0x0012:
        cn.jiguang.g.a.m(r0);
        r1 = cn.jiguang.d.b.d.a();
        r1.a(r0);
        r1 = cn.jiguang.d.b.d.a();
        r1.a(r3);
        r1 = cn.jiguang.d.i.f.a();	 Catch:{ OutOfMemoryError -> 0x002b }
        r2 = 1;
        r1.a(r0, r2);	 Catch:{ OutOfMemoryError -> 0x002b }
    L_0x002b:
        r0 = new android.content.IntentFilter;	 Catch:{ Throwable -> 0x004a }
        r0.<init>();	 Catch:{ Throwable -> 0x004a }
        r1 = r3.receiver;	 Catch:{ Throwable -> 0x004a }
        if (r1 != 0) goto L_0x003b;
    L_0x0034:
        r1 = new cn.jpush.android.service.PushReceiver;	 Catch:{ Throwable -> 0x004a }
        r1.<init>();	 Catch:{ Throwable -> 0x004a }
        r3.receiver = r1;	 Catch:{ Throwable -> 0x004a }
    L_0x003b:
        r1 = "android.intent.action.USER_PRESENT";
        r0.addAction(r1);	 Catch:{ Throwable -> 0x004a }
        r1 = "android.net.conn.CONNECTIVITY_CHANGE";
        r0.addAction(r1);	 Catch:{ Throwable -> 0x004a }
        r1 = r3.receiver;	 Catch:{ Throwable -> 0x004a }
        r3.registerReceiver(r1, r0);	 Catch:{ Throwable -> 0x004a }
    L_0x004a:
        r3.setDozePowerReceiver();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PushService.runCreate():void");
    }

    public void runDestroy() {
        d a = d.a();
        getApplicationContext();
        a.c();
        try {
            if (this.receiver != null) {
                unregisterReceiver(this.receiver);
            }
            if (this.mPowerBroadcastReceiver != null) {
                unregisterReceiver(this.mPowerBroadcastReceiver);
            }
        } catch (Throwable unused) {
        }
    }

    public void runStart(Intent intent) {
        Context applicationContext = getApplicationContext();
        if (cn.jiguang.d.a.d(applicationContext)) {
            String action;
            Bundle bundle = null;
            if (intent != null) {
                try {
                    action = intent.getAction();
                    try {
                        bundle = intent.getExtras();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                }
                if (!(action == null || bundle == null)) {
                    i.a().a(applicationContext, action, bundle);
                }
                return;
            }
            action = null;
            try {
                i.a().a(applicationContext, action, bundle);
            } catch (Throwable th) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("PushService onStartCommand error:");
                stringBuilder.append(th.getMessage());
                c.c(str, stringBuilder.toString());
            }
        } else {
            c.c(TAG, "onStartCommand:JCoreInterface init failed");
        }
    }

    public void setDozePowerReceiver() {
        try {
            if (cn.jiguang.d.a.d.q(this)) {
                if (this.mPowerBroadcastReceiver != null) {
                    unregisterReceiver(this.mPowerBroadcastReceiver);
                    this.mPowerBroadcastReceiver = null;
                }
            } else if (this.mPowerBroadcastReceiver == null) {
                this.mPowerBroadcastReceiver = new PushReceiver();
                IntentFilter intentFilter = new IntentFilter();
                if (VERSION.SDK_INT >= 21) {
                    intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                }
                if (VERSION.SDK_INT >= 23) {
                    intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
                }
                registerReceiver(this.mPowerBroadcastReceiver, intentFilter);
            }
        } catch (Throwable unused) {
        }
    }
}
