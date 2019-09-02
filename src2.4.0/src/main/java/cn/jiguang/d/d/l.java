package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import cn.jiguang.a.c.c;
import cn.jiguang.d.a.a;
import cn.jiguang.d.a.d;
import cn.jiguang.d.i.f;

public final class l {
    private static volatile l a;
    private static final Object b = new Object();
    private boolean c;
    private Handler d;
    private long e;

    public static l a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    public static void a(Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", false);
        i.a().b(context, "intent.PERIOD_RESUME", bundle);
    }

    private void c(Context context) {
        this.e = SystemClock.uptimeMillis();
        this.d.removeMessages(8000);
        this.d.sendEmptyMessageDelayed(8000, (long) (a.g() * 1000));
        if (d.i(context)) {
            cn.jiguang.g.a.l(context);
        } else {
            cn.jiguang.g.a.k(context);
        }
    }

    private void d(Context context) {
        this.d.removeMessages(8000);
        if (this.c) {
            c(context);
            if (f.a().f() && !d.i(context)) {
                cn.jiguang.d.a.a(context, false, 0);
            }
            c.a(context, 0);
            try {
                f.a().a(context, false);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    public final void a(Context context) {
        this.c = true;
        b(context, true);
    }

    public final void b(Context context) {
        try {
            if (this.d != null) {
                this.d.removeCallbacksAndMessages(null);
                this.d.getLooper().quit();
            }
            this.d = null;
        } catch (Throwable unused) {
        }
        cn.jiguang.g.a.l(context);
    }

    public final void b(Context context, boolean z) {
        if (this.c) {
            if (this.d == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("PeriodWorker");
                    handlerThread.start();
                    this.d = new m(this, handlerThread.getLooper(), context);
                } catch (Throwable unused) {
                }
            }
            if (this.e <= 0 || SystemClock.uptimeMillis() <= this.e + ((long) ((a.g() + 5) * 1000))) {
                if (z || !this.d.hasMessages(8000)) {
                    c(context);
                }
                return;
            }
            d(context);
        }
    }
}
