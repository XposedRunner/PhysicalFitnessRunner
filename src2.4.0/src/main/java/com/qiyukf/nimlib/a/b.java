package com.qiyukf.nimlib.a;

import com.qiyukf.basesdk.sdk.ResponseCode;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static AtomicInteger a = new AtomicInteger(1);

    private static short a(short s, short s2, boolean z) {
        return a.compareAndSet(s, s2) ? s2 : a(z);
    }

    public static short a(boolean z) {
        short addAndGet = (short) a.addAndGet(1);
        return (addAndGet < ResponseCode.RES_EXCEPTION || !z) ? (addAndGet >= ResponseCode.RES_EXCEPTION || z) ? addAndGet : a(addAndGet, ResponseCode.RES_EXCEPTION, false) : a(addAndGet, (short) 2, true);
    }
}
