package com.amap.api.mapcore.util;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool */
public final class r {
    private static r O000000o;
    private ExecutorService O00000Oo;
    private O000000o O00000o = new O000000o() {
        public void O000000o(s sVar) {
        }

        public void O00000Oo(s sVar) {
            r.this.O000000o(sVar, false);
        }

        public void O00000o0(s sVar) {
            r.this.O000000o(sVar, true);
        }
    };
    private ConcurrentHashMap<s, Future<?>> O00000o0 = new ConcurrentHashMap();

    private r(int i) {
        try {
            this.O00000Oo = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256));
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static synchronized r O000000o(int i) {
        r rVar;
        synchronized (r.class) {
            if (O000000o == null) {
                O000000o = new r(i);
            }
            rVar = O000000o;
        }
        return rVar;
    }

    public static synchronized void O000000o() {
        synchronized (r.class) {
            try {
                if (O000000o != null) {
                    O000000o.O00000Oo();
                    O000000o = null;
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "TPool", "onDestroy");
                th.printStackTrace();
            }
        }
        return;
    }

    private synchronized void O000000o(s sVar, Future<?> future) {
        try {
            this.O00000o0.put(sVar, future);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TPool", "addQueue");
            th.printStackTrace();
        }
        return;
    }

    private synchronized void O000000o(s sVar, boolean z) {
        try {
            Future future = (Future) this.O00000o0.remove(sVar);
            if (z && future != null) {
                future.cancel(true);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
        return;
    }

    public static r O00000Oo(int i) {
        return new r(i);
    }

    private void O00000Oo() {
        try {
            for (Entry key : this.O00000o0.entrySet()) {
                Future future = (Future) this.O00000o0.get((s) key.getKey());
                if (future != null) {
                    future.cancel(true);
                }
            }
            this.O00000o0.clear();
            this.O00000Oo.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TPool", "destroy");
            th.printStackTrace();
        }
    }

    private synchronized boolean O00000Oo(s sVar) {
        boolean containsKey;
        try {
            containsKey = this.O00000o0.containsKey(sVar);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TPool", "contain");
            th.printStackTrace();
            containsKey = false;
        }
        return containsKey;
    }

    public void O000000o(s sVar) throws o0O0oo0o {
        try {
            if (!(O00000Oo(sVar) || this.O00000Oo == null)) {
                if (!this.O00000Oo.isShutdown()) {
                    sVar.d = this.O00000o;
                    try {
                        Future submit = this.O00000Oo.submit(sVar);
                        if (submit != null) {
                            O000000o(sVar, submit);
                        }
                    } catch (RejectedExecutionException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ooOOOOoo.O00000o0(th, "TPool", "addTask");
            o0O0oo0o o0o0oo0o = new o0O0oo0o("thread pool has exception");
        }
    }
}
