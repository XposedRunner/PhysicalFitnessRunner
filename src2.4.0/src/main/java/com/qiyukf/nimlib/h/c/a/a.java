package com.qiyukf.nimlib.h.c.a;

public final class a {
    private byte[] a = new byte[256];
    private int b;
    private int c;

    public a(byte[] bArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        this.b = 0;
        this.c = 0;
        if (bArr == null || bArr.length == 0) {
            throw new NullPointerException();
        }
        i = 0;
        int i3 = i;
        while (i2 < 256) {
            i3 = (((bArr[i] & 255) + (this.a[i2] & 255)) + i3) & 255;
            byte b = this.a[i2];
            this.a[i2] = this.a[i3];
            this.a[i3] = b;
            i = (i + 1) % bArr.length;
            i2++;
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (bArr != null && i >= 0 && i2 >= 0) {
            i2 += i;
            if (i2 <= bArr.length) {
                while (i < i2) {
                    byte b = bArr[i];
                    this.b = (this.b + 1) & 255;
                    this.c = ((this.a[this.b] & 255) + this.c) & 255;
                    byte b2 = this.a[this.b];
                    this.a[this.b] = this.a[this.c];
                    this.a[this.c] = b2;
                    bArr[i] = (byte) (b ^ this.a[((this.a[this.b] & 255) + (this.a[this.c] & 255)) & 255]);
                    i++;
                }
                return;
            }
        }
        throw new IllegalArgumentException("illegal rc4 transform arguments");
    }
}
