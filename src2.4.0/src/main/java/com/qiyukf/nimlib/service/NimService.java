package com.qiyukf.nimlib.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.c.d.e;
import com.qiyukf.nimlib.f.d;
import s.h.e.l.l.C;

public class NimService extends Service {

    public static final class Aux extends Service {
        private static final Binder a = new Binder();

        public final IBinder onBind(Intent intent) {
            d.e();
            return a;
        }

        public final void onRebind(Intent intent) {
            d.e();
            super.onRebind(intent);
        }

        public final boolean onUnbind(Intent intent) {
            return true;
        }
    }

    static {
        C.i(28);
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), NimService.class);
        intent.setAction("com.qiyukf.desk.ACTION.KEEP_ALIVE");
        intent.putExtra("EXTRA_FROM", 4);
        return intent;
    }

    public static void a(Context context, int i) {
        StringBuilder stringBuilder = new StringBuilder("start service from ");
        stringBuilder.append(i);
        a.d("service", stringBuilder.toString());
        context = context.getApplicationContext();
        Intent intent = new Intent(context, NimService.class);
        intent.putExtra("EXTRA_FROM", i);
        e.a(context, intent);
    }

    public static Intent b(Context context) {
        return new Intent(context, NimService.class);
    }

    public static Intent c(Context context) {
        return new Intent(context, Aux.class);
    }

    public native IBinder onBind(Intent intent);

    public native void onCreate();

    public native void onDestroy();

    public native void onRebind(Intent intent);

    public native int onStartCommand(Intent intent, int i, int i2);

    public native boolean onUnbind(Intent intent);
}
