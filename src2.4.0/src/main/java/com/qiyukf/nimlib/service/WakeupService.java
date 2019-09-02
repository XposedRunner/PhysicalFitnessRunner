package com.qiyukf.nimlib.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.c.d.e;
import s.h.e.l.l.C;

public class WakeupService extends Service {
    static {
        C.i(29);
    }

    public static void a(Context context) {
        if (context == null) {
            a.a("WakeupService", "send back data while context is null.");
        } else {
            e.a(context, new Intent(context, WakeupService.class));
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public native void onCreate();

    public native int onStartCommand(Intent intent, int i, int i2);
}
