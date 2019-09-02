package com.qiyukf.basesdk.b.b.d;

import android.util.SparseArray;
import com.qiyukf.basesdk.b.b.a.c;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private com.qiyukf.basesdk.b.b.a.a a;
    private SocketChannel b;
    private SelectionKey c;
    private boolean d = false;
    private final List<a> e = new LinkedList();

    private static class a {
        ByteBuffer a;
        c b;

        a(ByteBuffer byteBuffer, c cVar) {
            this.a = byteBuffer;
            this.b = cVar;
        }
    }

    public a(com.qiyukf.basesdk.b.b.a.a aVar) {
        this.a = aVar;
    }

    private boolean b(SocketAddress socketAddress) {
        try {
            boolean connect = this.b.connect(socketAddress);
            if (!connect) {
                this.c.interestOps(8);
            }
            return connect;
        } catch (Throwable th) {
            try {
                this.b.close();
            } catch (IOException unused) {
            }
        }
    }

    private boolean b(ByteBuffer byteBuffer, c cVar) {
        boolean z = true;
        if (byteBuffer.remaining() == 0) {
            cVar.b();
            return true;
        }
        int i = 9;
        while (i < 16) {
            try {
                if (this.b.write(byteBuffer) == 0) {
                    break;
                } else if (byteBuffer.remaining() <= 0) {
                    cVar.b();
                    return true;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                this.a.a().a(th);
                return false;
            }
        }
        z = false;
        if (z) {
            this.c.interestOps(4);
            return false;
        }
        this.a.c().execute(new Runnable() {
            public final void run() {
                a.this.d();
            }
        });
        return false;
    }

    public final int a(ByteBuffer byteBuffer) {
        return this.b.read(byteBuffer);
    }

    public final SelectionKey a(Selector selector, com.qiyukf.basesdk.b.b.a.a aVar) {
        this.c = this.b.register(selector, 0, aVar);
        return this.c;
    }

    public final <T> void a(SparseArray<Object> sparseArray) {
        this.b = SelectorProvider.provider().openSocketChannel();
        this.b.configureBlocking(false);
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            Object valueAt = sparseArray.valueAt(i);
            if (keyAt == 4098) {
                this.b.socket().setReceiveBufferSize(((Integer) valueAt).intValue());
            } else if (keyAt == 4097) {
                this.b.socket().setSendBufferSize(((Integer) valueAt).intValue());
            } else {
                boolean z = true;
                if (keyAt == 1) {
                    this.b.socket().setTcpNoDelay(((Boolean) valueAt).booleanValue());
                } else if (keyAt == 8) {
                    this.b.socket().setKeepAlive(((Boolean) valueAt).booleanValue());
                } else if (keyAt == 4) {
                    this.b.socket().setReuseAddress(((Boolean) valueAt).booleanValue());
                } else if (keyAt == 128) {
                    keyAt = ((Integer) valueAt).intValue();
                    Socket socket = this.b.socket();
                    if (keyAt <= 0) {
                        z = false;
                    }
                    socket.setSoLinger(z, keyAt);
                } else if (keyAt == 3) {
                    this.b.socket().setTrafficClass(((Integer) valueAt).intValue());
                }
            }
        }
    }

    public final void a(ByteBuffer byteBuffer, c cVar) {
        this.e.add(new a(byteBuffer, cVar));
        d();
    }

    public final boolean a() {
        return this.b != null && this.b.isOpen();
    }

    public final boolean a(SocketAddress socketAddress) {
        return b(socketAddress);
    }

    public final boolean b() {
        return this.b != null && this.b.isOpen() && this.b.isConnected();
    }

    public final void c() {
        this.b.close();
        for (a aVar : this.e) {
            aVar.b.a(com.qiyukf.basesdk.b.b.e.a.a(this.a));
        }
        this.e.clear();
    }

    public final void d() {
        if (!this.d) {
            this.d = true;
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (!b(aVar.a, aVar.b)) {
                    break;
                }
                it.remove();
            }
            this.d = false;
        }
    }

    public final boolean e() {
        return this.d;
    }

    public final void f() {
        if (!this.b.finishConnect()) {
            throw new Error();
        }
    }
}
