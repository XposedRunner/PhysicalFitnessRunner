package com.tencent.stat.common;

public class g {
    static final /* synthetic */ boolean a = true;

    private g() {
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        i iVar = new i(i3, new byte[((i2 * 3) / 4)]);
        if (!iVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (iVar.b == iVar.a.length) {
            return iVar.a;
        } else {
            bArr = new byte[iVar.b];
            System.arraycopy(iVar.a, 0, bArr, 0, iVar.b);
            return bArr;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        j jVar = new j(i3, null);
        i3 = (i2 / 3) * 4;
        if (!jVar.d) {
            switch (i2 % 3) {
                case 1:
                    i3 += 2;
                    break;
                case 2:
                    i3 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i3 += 4;
        }
        if (jVar.e && i2 > 0) {
            i3 += (((i2 - 1) / 57) + 1) * (jVar.f ? 2 : 1);
        }
        jVar.a = new byte[i3];
        jVar.a(bArr, i, i2, true);
        if (a || jVar.b == i3) {
            return jVar.a;
        }
        throw new AssertionError();
    }
}
