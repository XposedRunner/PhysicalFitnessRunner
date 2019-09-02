package cn.jiguang.d.c;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectionKey;

class a {
    protected long a;
    protected SelectionKey b;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    protected a(java.nio.channels.SelectableChannel r1, long r2) {
        /*
        r0 = this;
        r0.<init>();
        r0.a = r2;
        r2 = java.nio.channels.Selector.open();	 Catch:{ all -> 0x0017 }
        r3 = 0;
        r1.configureBlocking(r3);	 Catch:{ all -> 0x0015 }
        r3 = 1;
        r3 = r1.register(r2, r3);	 Catch:{ all -> 0x0015 }
        r0.b = r3;	 Catch:{ all -> 0x0015 }
        return;
    L_0x0015:
        r3 = move-exception;
        goto L_0x0019;
    L_0x0017:
        r3 = move-exception;
        r2 = 0;
    L_0x0019:
        if (r2 == 0) goto L_0x001e;
    L_0x001b:
        r2.close();
    L_0x001e:
        r1.close();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.c.a.<init>(java.nio.channels.SelectableChannel, long):void");
    }

    protected static void a(SelectionKey selectionKey, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        int select = currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0;
        if (select == 0) {
            throw new SocketTimeoutException();
        }
    }

    /* Access modifiers changed, original: final */
    public final void a() {
        this.b.selector().close();
        this.b.channel().close();
    }
}
