package cn.jiguang.d.h;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

final class p extends DiscardPolicy {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        super.rejectedExecution(runnable, threadPoolExecutor);
    }
}
