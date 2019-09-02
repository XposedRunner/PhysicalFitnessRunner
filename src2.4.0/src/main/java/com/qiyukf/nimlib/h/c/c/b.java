package com.qiyukf.nimlib.h.c.c;

import android.text.TextUtils;
import com.qiyukf.nimlib.h.c.b.a;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b {
    private ByteBuffer a = a.a();
    private int b = 1048576;

    public b() {
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private void c(int i) {
        if (this.a.remaining() < i) {
            int capacity = (this.a.capacity() + i) - this.a.remaining();
            if (capacity > this.b) {
                throw new BufferOverflowException();
            }
            ByteBuffer allocate = ByteBuffer.allocate(Math.min(Math.max(capacity, this.a.capacity() << 1), this.b));
            allocate.order(this.a.order());
            this.a.flip();
            allocate.put(this.a);
            this.a = allocate;
        }
    }

    public final int a() {
        return this.a.position();
    }

    public final b a(byte b) {
        try {
            c(1);
            this.a.put(b);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b a(int i) {
        try {
            c(4);
            this.a.putInt(i);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b a(long j) {
        try {
            c(8);
            this.a.putLong(j);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b a(a aVar) {
        aVar.a(this);
        return this;
    }

    public final b a(String str) {
        try {
            return b(TextUtils.isEmpty(str) ? null : str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new c();
        }
    }

    public final b a(ByteBuffer byteBuffer) {
        try {
            c(byteBuffer.remaining());
            this.a.put(byteBuffer);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b a(short s) {
        try {
            c(2);
            this.a.putShort(s);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b a(boolean z) {
        try {
            c(1);
            this.a.put((byte) z);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b a(byte[] bArr) {
        try {
            c(bArr.length);
            this.a.put(bArr);
            return this;
        } catch (BufferOverflowException unused) {
            throw new c();
        }
    }

    public final b b(int i) {
        return a(d.a(i));
    }

    public final b b(String str) {
        try {
            a(Long.valueOf(str).longValue());
            return this;
        } catch (Exception unused) {
            throw new c();
        }
    }

    public final b b(byte[] bArr) {
        if (bArr == null) {
            try {
                return b(0);
            } catch (BufferOverflowException unused) {
                throw new c();
            }
        } else if (bArr.length > 2147483645) {
            throw new c();
        } else {
            c(d.b(bArr.length) + bArr.length);
            this.a.put(d.a(bArr.length));
            this.a.put(bArr);
            return this;
        }
    }

    public final ByteBuffer b() {
        ByteBuffer duplicate = this.a.duplicate();
        duplicate.flip();
        return duplicate;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append(" Size ");
        stringBuilder.append(this.a.position());
        return stringBuilder.toString();
    }
}
