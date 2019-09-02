package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;

abstract class s {
    private ExecutorService a;

    s() {
    }

    public abstract ExecutorService a();

    /* Access modifiers changed, original: final */
    public final ExecutorService a(boolean z) {
        if (this.a == null || this.a.isShutdown()) {
            this.a = a();
        }
        return this.a;
    }
}
