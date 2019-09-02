package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NamedThreadFactory */
public class OOO0o00 implements ThreadFactory {
    private static final AtomicInteger O000000o = new AtomicInteger(1);
    private final AtomicInteger O00000Oo;
    private final boolean O00000o;
    private final String O00000o0;
    private final ThreadGroup O00000oO;

    public OOO0o00() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("amap-threadpool-");
        stringBuilder.append(O000000o.getAndIncrement());
        this(stringBuilder.toString(), false);
    }

    public OOO0o00(String str) {
        this(str, false);
    }

    public OOO0o00(String str, boolean z) {
        this.O00000Oo = new AtomicInteger(1);
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("-thread-");
            str = stringBuilder.toString();
        }
        this.O00000o0 = str;
        this.O00000o = z;
        SecurityManager securityManager = System.getSecurityManager();
        this.O00000oO = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(this.O00000Oo.getAndIncrement());
        Thread thread = new Thread(this.O00000oO, runnable, stringBuilder.toString(), 0);
        thread.setDaemon(this.O00000o);
        return thread;
    }
}
