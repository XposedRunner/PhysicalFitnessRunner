package cn.jiguang.d.g;

import android.support.v4.app.NotificationManagerCompat;
import cn.jiguang.e.c;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public final class b extends a {
    private ByteBuffer f = ByteBuffer.allocate(8192);

    private boolean b(byte[] bArr) {
        try {
            if (!b() || bArr == null || bArr.length <= 0) {
                return false;
            }
            int write = this.b.write(ByteBuffer.wrap(bArr));
            return write > 0 || write >= 0;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("send data error:");
            stringBuilder.append(e.getMessage());
            c.c("NioSocketClient", stringBuilder.toString());
            a();
            return false;
        }
    }

    public final synchronized int a(String str, int i) {
        super.a(str, i);
        try {
            this.b = SocketChannel.open();
            this.d = Selector.open();
            this.b.configureBlocking(false);
            this.b.connect(new InetSocketAddress(str, i));
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.b.finishConnect()) {
                if (!this.e) {
                    return -991;
                }
                if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                    a();
                    return -994;
                }
            }
            if (!this.e) {
                return -991;
            }
            this.b.register(this.d, 1);
            return 0;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("tcp connect has failed:");
            stringBuilder.append(th);
            c.c("NioSocketClient", stringBuilder.toString());
            return th instanceof SocketTimeoutException ? -994 : NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        }
    }

    public final int a(byte[] bArr) {
        return bArr == null ? 103 : bArr.length >= 8128 ? 6026 : b(bArr) ? 0 : 103;
    }

    public final d a(int i) {
        try {
            if (!b()) {
                return new d(-991, "recv error,the connect is invalid");
            }
            int c = c();
            if (c > 0) {
                ByteBuffer b = b(c);
                if (b != null) {
                    return new d(0, b);
                }
            }
            int i2 = 1048576;
            while (b() && this.c < i2) {
                if ((i > 0 ? this.d.select((long) i) : this.d.select()) != 0) {
                    Iterator it = this.d.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey selectionKey = (SelectionKey) it.next();
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        if (selectionKey.isReadable()) {
                            int read = socketChannel.read(this.f);
                            StringBuilder stringBuilder;
                            if (read < 0) {
                                stringBuilder = new StringBuilder("read len < 0:");
                                stringBuilder.append(read);
                                return new d(-996, stringBuilder.toString());
                            }
                            this.f.flip();
                            read = this.f.limit();
                            if (this.a.remaining() < read) {
                                stringBuilder = new StringBuilder("the total buf remaining less than readLen,remaining:");
                                stringBuilder.append(this.a.remaining());
                                stringBuilder.append(",readLen:");
                                stringBuilder.append(read);
                                return new d(-996, stringBuilder.toString());
                            }
                            this.a.put(this.f);
                            this.c += read;
                            this.f.compact();
                            if (this.c >= 20) {
                                i2 = c();
                            }
                        } else {
                            selectionKey.isWritable();
                        }
                        it.remove();
                    }
                    continue;
                } else if (i > 0) {
                    return new d(-994, "recv time out");
                }
            }
            if (i2 == 1048576) {
                return new d(-997, "recv empty data or tcp has close");
            }
            ByteBuffer b2 = b(i2);
            return b2 != null ? new d(0, b2) : new d(-1001, "parse error");
        } catch (Throwable th) {
            d dVar = new d(-997, th.getMessage());
            if (th instanceof SocketTimeoutException) {
                dVar.a(-994);
            }
            return dVar;
        }
    }

    public final void a() {
        super.a();
        if (this.d != null) {
            try {
                this.d.close();
            } catch (IOException unused) {
            }
        }
        if (this.b != null) {
            try {
                this.b.close();
            } catch (Exception unused2) {
            }
        }
        this.b = null;
    }
}
