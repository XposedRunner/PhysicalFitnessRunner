package com.zjwh.android_wh_physicalfitness.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: WeakHandler */
public class O00Oo0o0 {
    private final Callback O000000o;
    private final O00000Oo O00000Oo;
    @VisibleForTesting
    private final O000000o O00000o;
    private Lock O00000o0;

    /* compiled from: WeakHandler */
    static class O000000o {
        @Nullable
        O000000o O000000o;
        @Nullable
        O000000o O00000Oo;
        @NonNull
        final O00000o0 O00000o;
        @NonNull
        final Runnable O00000o0;
        @NonNull
        Lock O00000oO;

        public O000000o(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.O00000o0 = runnable;
            this.O00000oO = lock;
            this.O00000o = new O00000o0(new WeakReference(runnable), new WeakReference(this));
        }

        public O00000o0 O000000o() {
            this.O00000oO.lock();
            try {
                if (this.O00000Oo != null) {
                    this.O00000Oo.O000000o = this.O000000o;
                }
                if (this.O000000o != null) {
                    this.O000000o.O00000Oo = this.O00000Oo;
                }
                this.O00000Oo = null;
                this.O000000o = null;
                return this.O00000o;
            } finally {
                this.O00000oO.unlock();
            }
        }

        @Nullable
        public O00000o0 O000000o(Runnable runnable) {
            this.O00000oO.lock();
            try {
                for (O000000o o000000o = this.O000000o; o000000o != null; o000000o = o000000o.O000000o) {
                    if (o000000o.O00000o0 == runnable) {
                        O00000o0 O000000o = o000000o.O000000o();
                        return O000000o;
                    }
                }
                this.O00000oO.unlock();
                return null;
            } finally {
                this.O00000oO.unlock();
            }
        }

        public void O000000o(@NonNull O000000o o000000o) {
            this.O00000oO.lock();
            try {
                if (this.O000000o != null) {
                    this.O000000o.O00000Oo = o000000o;
                }
                o000000o.O000000o = this.O000000o;
                this.O000000o = o000000o;
                o000000o.O00000Oo = this;
            } finally {
                this.O00000oO.unlock();
            }
        }
    }

    /* compiled from: WeakHandler */
    private static class O00000Oo extends Handler {
        private final WeakReference<Callback> O000000o;

        O00000Oo() {
            this.O000000o = null;
        }

        O00000Oo(Looper looper) {
            super(looper);
            this.O000000o = null;
        }

        O00000Oo(Looper looper, WeakReference<Callback> weakReference) {
            super(looper);
            this.O000000o = weakReference;
        }

        O00000Oo(WeakReference<Callback> weakReference) {
            this.O000000o = weakReference;
        }

        public void handleMessage(@NonNull Message message) {
            if (this.O000000o != null) {
                Callback callback = (Callback) this.O000000o.get();
                if (callback != null) {
                    callback.handleMessage(message);
                }
            }
        }
    }

    /* compiled from: WeakHandler */
    static class O00000o0 implements Runnable {
        private final WeakReference<Runnable> O000000o;
        private final WeakReference<O000000o> O00000Oo;

        O00000o0(WeakReference<Runnable> weakReference, WeakReference<O000000o> weakReference2) {
            this.O000000o = weakReference;
            this.O00000Oo = weakReference2;
        }

        public void run() {
            Runnable runnable = (Runnable) this.O000000o.get();
            O000000o o000000o = (O000000o) this.O00000Oo.get();
            if (o000000o != null) {
                o000000o.O000000o();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public O00Oo0o0() {
        this.O00000o0 = new ReentrantLock();
        this.O00000o = new O000000o(this.O00000o0, null);
        this.O000000o = null;
        this.O00000Oo = new O00000Oo();
    }

    public O00Oo0o0(@Nullable Callback callback) {
        this.O00000o0 = new ReentrantLock();
        this.O00000o = new O000000o(this.O00000o0, null);
        this.O000000o = callback;
        this.O00000Oo = new O00000Oo(new WeakReference(callback));
    }

    public O00Oo0o0(@NonNull Looper looper) {
        this.O00000o0 = new ReentrantLock();
        this.O00000o = new O000000o(this.O00000o0, null);
        this.O000000o = null;
        this.O00000Oo = new O00000Oo(looper);
    }

    public O00Oo0o0(@NonNull Looper looper, @NonNull Callback callback) {
        this.O00000o0 = new ReentrantLock();
        this.O00000o = new O000000o(this.O00000o0, null);
        this.O000000o = callback;
        this.O00000Oo = new O00000Oo(looper, new WeakReference(callback));
    }

    private O00000o0 O00000o(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        O000000o o000000o = new O000000o(this.O00000o0, runnable);
        this.O00000o.O000000o(o000000o);
        return o000000o.O00000o;
    }

    public final Looper O000000o() {
        return this.O00000Oo.getLooper();
    }

    public final void O000000o(int i, Object obj) {
        this.O00000Oo.removeMessages(i, obj);
    }

    public final void O000000o(Object obj) {
        this.O00000Oo.removeCallbacksAndMessages(obj);
    }

    public final void O000000o(Runnable runnable, Object obj) {
        O00000o0 O000000o = this.O00000o.O000000o(runnable);
        if (O000000o != null) {
            this.O00000Oo.removeCallbacks(O000000o, obj);
        }
    }

    public final boolean O000000o(int i) {
        return this.O00000Oo.sendEmptyMessage(i);
    }

    public final boolean O000000o(int i, long j) {
        return this.O00000Oo.sendEmptyMessageDelayed(i, j);
    }

    public final boolean O000000o(Message message) {
        return this.O00000Oo.sendMessage(message);
    }

    public final boolean O000000o(Message message, long j) {
        return this.O00000Oo.sendMessageDelayed(message, j);
    }

    public final boolean O000000o(@NonNull Runnable runnable) {
        return this.O00000Oo.post(O00000o(runnable));
    }

    public final boolean O000000o(@NonNull Runnable runnable, long j) {
        return this.O00000Oo.postAtTime(O00000o(runnable), j);
    }

    public final boolean O000000o(Runnable runnable, Object obj, long j) {
        return this.O00000Oo.postAtTime(O00000o(runnable), obj, j);
    }

    public final void O00000Oo(int i) {
        this.O00000Oo.removeMessages(i);
    }

    public final boolean O00000Oo(int i, long j) {
        return this.O00000Oo.sendEmptyMessageAtTime(i, j);
    }

    public final boolean O00000Oo(int i, Object obj) {
        return this.O00000Oo.hasMessages(i, obj);
    }

    public final boolean O00000Oo(Message message) {
        return this.O00000Oo.sendMessageAtFrontOfQueue(message);
    }

    public boolean O00000Oo(Message message, long j) {
        return this.O00000Oo.sendMessageAtTime(message, j);
    }

    public final boolean O00000Oo(Runnable runnable) {
        return this.O00000Oo.postAtFrontOfQueue(O00000o(runnable));
    }

    public final boolean O00000Oo(Runnable runnable, long j) {
        return this.O00000Oo.postDelayed(O00000o(runnable), j);
    }

    public final void O00000o0(Runnable runnable) {
        O00000o0 O000000o = this.O00000o.O000000o(runnable);
        if (O000000o != null) {
            this.O00000Oo.removeCallbacks(O000000o);
        }
    }

    public final boolean O00000o0(int i) {
        return this.O00000Oo.hasMessages(i);
    }
}
