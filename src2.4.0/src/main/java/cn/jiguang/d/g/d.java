package cn.jiguang.d.g;

import java.nio.ByteBuffer;

public final class d {
    private int a;
    private ByteBuffer b;
    private String c;

    public d(int i, String str) {
        this.a = i;
        this.c = str;
    }

    public d(int i, ByteBuffer byteBuffer) {
        this.a = 0;
        this.b = byteBuffer;
    }

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = -994;
    }

    public final ByteBuffer b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
