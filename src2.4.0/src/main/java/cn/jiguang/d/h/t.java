package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class t {
    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            try {
                executorService.shutdown();
                if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                    executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException unused) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            } catch (Throwable unused2) {
            }
        }
    }

    public static void a(ExecutorService executorService, w wVar) {
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            if (threadPoolExecutor.getQueue().size() > 30) {
                threadPoolExecutor.getPoolSize();
            }
        }
        if (executorService instanceof v) {
            int a = ((v) executorService).a;
            if (a > 0) {
                wVar.a = a;
            }
        }
        executorService.execute(wVar);
    }
}
