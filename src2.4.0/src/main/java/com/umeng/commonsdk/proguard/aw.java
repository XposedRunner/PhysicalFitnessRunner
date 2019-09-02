package com.umeng.commonsdk.proguard;

/* compiled from: TTransport */
public abstract class aw {
    public abstract int a(byte[] bArr, int i, int i2) throws ax;

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b() throws ax;

    public void b(byte[] bArr) throws ax {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i, int i2) throws ax;

    public abstract void c();

    public int d(byte[] bArr, int i, int i2) throws ax {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot read. Remote side has closed. Tried to read ");
                stringBuilder.append(i2);
                stringBuilder.append(" bytes, but only got ");
                stringBuilder.append(i3);
                stringBuilder.append(" bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
                throw new ax(stringBuilder.toString());
            }
            i3 += a;
        }
        return i3;
    }

    public void d() throws ax {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
