package com.amap.api.mapcore.util;

/* compiled from: ThreadTask */
public abstract class s implements Runnable {
    O000000o d;

    /* compiled from: ThreadTask */
    interface O000000o {
        void O000000o(s sVar);

        void O00000Oo(s sVar);

        void O00000o0(s sVar);
    }

    public final void cancelTask() {
        try {
            if (this.d != null) {
                this.d.O00000o0(this);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    public final void run() {
        try {
            if (this.d != null) {
                this.d.O000000o(this);
            }
            if (!Thread.interrupted()) {
                runTask();
                if (!(Thread.interrupted() || this.d == null)) {
                    this.d.O00000Oo(this);
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
