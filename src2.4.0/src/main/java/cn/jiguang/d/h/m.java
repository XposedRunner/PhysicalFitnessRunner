package cn.jiguang.d.h;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

final class m extends CallerRunsPolicy {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        super.rejectedExecution(runnable, threadPoolExecutor);
    }
}
