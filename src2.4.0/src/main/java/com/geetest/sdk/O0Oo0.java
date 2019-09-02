package com.geetest.sdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils */
public class O0Oo0 {
    private static volatile O0Oo0 O000000o;
    private static final int O00000Oo = Runtime.getRuntime().availableProcessors();
    private static final int O00000o = ((O00000Oo << 1) + 1);
    private static final int O00000o0 = Math.max(2, Math.min(O00000Oo - 1, 4));
    private static final ThreadFactory O00000oO = new O0Oo();
    private static final BlockingQueue<Runnable> O00000oo = new LinkedBlockingQueue(128);
    private ThreadPoolExecutor O0000O0o = new ThreadPoolExecutor(O00000o0, O00000o, 30, TimeUnit.SECONDS, O00000oo, O00000oO);

    private O0Oo0() {
        this.O0000O0o.allowCoreThreadTimeOut(true);
    }

    public static O0Oo0 O000000o() {
        if (O000000o == null) {
            synchronized (O0Oo0.class) {
                if (O000000o == null) {
                    O000000o = new O0Oo0();
                }
            }
        }
        return O000000o;
    }

    public final void O000000o(Runnable runnable) {
        try {
            this.O0000O0o.execute(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
