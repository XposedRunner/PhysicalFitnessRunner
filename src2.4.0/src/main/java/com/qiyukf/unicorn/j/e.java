package com.qiyukf.unicorn.j;

import android.os.Handler;
import android.os.Looper;
import com.qiyukf.basesdk.c.a;

public final class e {
    private static Handler a;

    private static synchronized Handler a() {
        Handler handler;
        synchronized (e.class) {
            if (a == null) {
                a = a.b();
            }
            handler = a;
        }
        return handler;
    }

    public static void a(Runnable runnable) {
        b(runnable);
    }

    public static void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }
}
