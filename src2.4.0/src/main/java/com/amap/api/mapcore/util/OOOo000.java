package com.amap.api.mapcore.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadUtil */
public class OOOo000 {
    private static volatile OOOo000 O00000o0;
    private BlockingQueue<Runnable> O000000o = new LinkedBlockingQueue();
    private ExecutorService O00000Oo = null;

    private OOOo000() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.O00000Oo = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, (long) 1, TimeUnit.SECONDS, this.O000000o, new OOO0o00("AMapThreadUtil"), new AbortPolicy());
    }

    public static OOOo000 O000000o() {
        if (O00000o0 == null) {
            synchronized (OOOo000.class) {
                if (O00000o0 == null) {
                    O00000o0 = new OOOo000();
                }
            }
        }
        return O00000o0;
    }

    public static void O00000Oo() {
        if (O00000o0 != null) {
            try {
                O00000o0.O00000Oo.shutdownNow();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            O00000o0.O00000Oo = null;
            O00000o0 = null;
        }
    }

    public void O000000o(Runnable runnable) {
        if (this.O00000Oo != null) {
            try {
                this.O00000Oo.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
