package cn.jiguang.d.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class u implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);
    private final String b;
    private final int c;

    public u(String str, int i) {
        this.b = str;
        this.c = i;
    }

    public final Thread newThread(Runnable runnable) {
        String stringBuilder;
        int i;
        if (this.c == 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.b);
            stringBuilder2.append("_");
            stringBuilder2.append(this.a.getAndIncrement());
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = this.b;
        }
        Thread thread = new Thread(runnable, stringBuilder);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.c != 0) {
            if (this.c != thread.getPriority()) {
                i = this.c;
            }
            return thread;
        }
        if (runnable instanceof w) {
            i = ((w) runnable).a;
        }
        return thread;
        thread.setPriority(i);
        return thread;
    }
}
