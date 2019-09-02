package com.qiyukf.basesdk.b.b.e;

import com.qiyukf.basesdk.b.b.c.f;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.RejectedExecutionException;

public final class a {
    static final ClosedChannelException a = new ClosedChannelException();
    static final NotYetConnectedException b = new NotYetConnectedException();

    public static Exception a(com.qiyukf.basesdk.b.b.a.a aVar) {
        return !aVar.b().b() ? aVar.d() ? b : a : null;
    }

    public static void a(f fVar, Runnable runnable) {
        try {
            fVar.execute(runnable);
        } catch (RejectedExecutionException unused) {
            com.qiyukf.basesdk.a.a.c("socket", "execute task in terminated event loog");
        }
    }
}
