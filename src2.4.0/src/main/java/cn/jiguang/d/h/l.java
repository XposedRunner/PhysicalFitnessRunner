package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;

final class l extends s {
    l() {
    }

    /* Access modifiers changed, original: final */
    public final ExecutorService a() {
        v a = v.a("BUILD_REPORT", 30);
        a.setRejectedExecutionHandler(new m(this));
        return a;
    }
}
