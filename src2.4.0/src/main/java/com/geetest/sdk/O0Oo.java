package com.geetest.sdk;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThreadPoolUtils */
final class O0Oo implements ThreadFactory {
    private final AtomicInteger O000000o = new AtomicInteger(1);

    O0Oo() {
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("SenseBotTask #");
        stringBuilder.append(this.O000000o.getAndIncrement());
        return new Thread(runnable, stringBuilder.toString());
    }
}
