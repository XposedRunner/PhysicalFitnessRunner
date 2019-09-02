package com.qiyukf.nimlib.h.c.c;

import android.support.v4.media.TransportMediator;
import com.qiyukf.nimlib.h.c.b.a;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class f {
    protected ByteBuffer a;

    public f() {
        this.a = null;
    }

    public f(ByteBuffer byteBuffer) {
        this(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    public f(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private f(byte[] bArr, int i, int i2) {
        this.a = ByteBuffer.wrap(bArr, i, i2);
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private byte[] a(int i) {
        try {
            byte[] bArr = new byte[i];
            this.a.get(bArr);
            return bArr;
        } catch (BufferUnderflowException unused) {
            throw new g();
        }
    }

    public final int a() {
        return this.a.limit() - this.a.position();
    }

    public final a a(a aVar) {
        aVar.a(this);
        return aVar;
    }

    public final String a(String str) {
        try {
            return new String(d(), str);
        } catch (UnsupportedEncodingException unused) {
            throw new g();
        }
    }

    public final ByteBuffer b() {
        return this.a.duplicate();
    }

    public final byte c() {
        try {
            return this.a.get();
        } catch (BufferUnderflowException unused) {
            throw new g();
        }
    }

    public final byte[] d() {
        return a(f());
    }

    public final int e() {
        try {
            return this.a.getInt();
        } catch (BufferUnderflowException unused) {
            throw new g();
        }
    }

    public final int f() {
        int i = 1;
        int i2 = 0;
        byte c;
        do {
            c = c();
            i2 += (c & TransportMediator.KEYCODE_MEDIA_PAUSE) * i;
            i <<= 7;
        } while ((c & 128) != 0);
        return i2;
    }

    public final long g() {
        try {
            return this.a.getLong();
        } catch (BufferUnderflowException unused) {
            throw new g();
        }
    }

    public final short h() {
        try {
            return this.a.getShort();
        } catch (BufferUnderflowException unused) {
            throw new g();
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
