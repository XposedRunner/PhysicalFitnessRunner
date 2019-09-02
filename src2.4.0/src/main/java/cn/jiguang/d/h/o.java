package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;

final class o extends s {
    o() {
    }

    /* Access modifiers changed, original: final */
    public final ExecutorService a() {
        v a = v.a("REPORT_HISTORY", 3, 1);
        a.setRejectedExecutionHandler(new p(this));
        return a;
    }
}
