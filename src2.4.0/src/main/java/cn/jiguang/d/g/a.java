package cn.jiguang.d.g;

import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public abstract class a {
    protected ByteBuffer a = ByteBuffer.allocate(20480);
    protected SocketChannel b;
    protected int c;
    protected Selector d;
    protected boolean e = false;

    public int a(String str, int i) {
        if (this.a == null) {
            this.a = ByteBuffer.allocate(20480);
        }
        this.a.clear();
        this.c = 0;
        this.e = true;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public abstract d a(int i);

    public void a() {
        b();
        this.e = false;
        if (this.a != null) {
            this.a.clear();
        }
        this.c = 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final ByteBuffer b(int i) {
        if (this.c < i) {
            return null;
        }
        this.c -= i;
        byte[] bArr = new byte[i];
        this.a.flip();
        this.a.get(bArr, 0, i);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.a.compact();
        return wrap;
    }

    public final boolean b() {
        return this.e && this.b != null && this.b.isConnected();
    }

    /* Access modifiers changed, original: protected|final */
    public final int c() {
        if (this.c < 20) {
            return 0;
        }
        int position = this.a.position();
        this.a.position(0);
        int i = this.a.getShort() & 32767;
        this.a.position(position);
        return i;
    }
}
