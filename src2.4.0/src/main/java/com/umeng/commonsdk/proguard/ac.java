package com.umeng.commonsdk.proguard;

import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TCompactProtocol */
public class ac extends ai {
    private static final an d = new an("");
    private static final ad e = new ad("", (byte) 0, (short) 0);
    private static final byte[] f = new byte[16];
    private static final byte h = (byte) -126;
    private static final byte i = (byte) 1;
    private static final byte j = (byte) 31;
    private static final byte k = (byte) -32;
    private static final int l = 5;
    byte[] a;
    byte[] b;
    byte[] c;
    private h m;
    private short n;
    private ad o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* compiled from: TCompactProtocol */
    public static class a implements ak {
        private final long a;

        public a() {
            this.a = -1;
        }

        public a(int i) {
            this.a = (long) i;
        }

        public ai a(aw awVar) {
            return new ac(awVar, this.a);
        }
    }

    /* compiled from: TCompactProtocol */
    private static class b {
        public static final byte a = (byte) 1;
        public static final byte b = (byte) 2;
        public static final byte c = (byte) 3;
        public static final byte d = (byte) 4;
        public static final byte e = (byte) 5;
        public static final byte f = (byte) 6;
        public static final byte g = (byte) 7;
        public static final byte h = (byte) 8;
        public static final byte i = (byte) 9;
        public static final byte j = (byte) 10;
        public static final byte k = (byte) 11;
        public static final byte l = (byte) 12;

        private b() {
        }
    }

    static {
        f[0] = (byte) 0;
        f[2] = (byte) 1;
        f[3] = (byte) 3;
        f[6] = (byte) 4;
        f[8] = (byte) 5;
        f[10] = (byte) 6;
        f[4] = (byte) 7;
        f[11] = (byte) 8;
        f[15] = (byte) 9;
        f[14] = (byte) 10;
        f[13] = (byte) 11;
        f[12] = (byte) 12;
    }

    public ac(aw awVar) {
        this(awVar, -1);
    }

    public ac(aw awVar, long j) {
        super(awVar);
        this.m = new h(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j;
    }

    private int E() throws p {
        int i = 0;
        if (this.g.h() >= 5) {
            byte[] f = this.g.f();
            int g = this.g.g();
            int i2 = 0;
            int i3 = i2;
            while (true) {
                byte b = f[g + i];
                i2 |= (b & XmPlayerService.CODE_GET_RADIO_SCHEDULES) << i3;
                if ((b & 128) != 128) {
                    this.g.a(i + 1);
                    return i2;
                }
                i3 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte u = u();
                i |= (u & XmPlayerService.CODE_GET_RADIO_SCHEDULES) << i4;
                if ((u & 128) != 128) {
                    return i;
                }
                i4 += 7;
            }
        }
    }

    private long F() throws p {
        long j = null;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            while (true) {
                int i;
                byte b = f[g + i];
                long j4 = j2 | (((long) (b & XmPlayerService.CODE_GET_RADIO_SCHEDULES)) << j3);
                if ((b & 128) != 128) {
                    this.g.a(i + 1);
                    return j4;
                }
                j3 += 7;
                i++;
                j2 = j4;
            }
        } else {
            while (true) {
                byte u = u();
                long j5 = j2 | (((long) (u & XmPlayerService.CODE_GET_RADIO_SCHEDULES)) << j);
                if ((u & 128) != 128) {
                    return j5;
                }
                j += 7;
                j2 = j5;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255);
    }

    private void a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) ((int) (j & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 7] = (byte) ((int) ((j >> 56) & 255));
    }

    private void a(ad adVar, byte b) throws p {
        if (b == (byte) -1) {
            b = e(adVar.b);
        }
        if (adVar.c <= this.n || adVar.c - this.n > 15) {
            b(b);
            a(adVar.c);
        } else {
            d(b | ((adVar.c - this.n) << 4));
        }
        this.n = adVar.c;
    }

    private void a(byte[] bArr, int i, int i2) throws p {
        b(i2);
        this.g.b(bArr, i, i2);
    }

    private void b(byte b) throws p {
        this.r[0] = b;
        this.g.b(this.r);
    }

    private void b(int i) throws p {
        int i2;
        int i3 = 0;
        while ((i & -128) != 0) {
            i2 = i3 + 1;
            this.a[i3] = (byte) ((i & XmPlayerService.CODE_GET_RADIO_SCHEDULES) | 128);
            i >>>= 7;
            i3 = i2;
        }
        i2 = i3 + 1;
        this.a[i3] = (byte) i;
        this.g.b(this.a, 0, i2);
    }

    private void b(long j) throws p {
        int i;
        int i2 = 0;
        while ((j & -128) != 0) {
            i = i2 + 1;
            this.b[i2] = (byte) ((int) ((j & 127) | 128));
            j >>>= 7;
            i2 = i;
        }
        i = i2 + 1;
        this.b[i2] = (byte) ((int) j);
        this.g.b(this.b, 0, i);
    }

    private int c(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private long c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private boolean c(byte b) {
        int i = b & 15;
        return i == 1 || i == 2;
    }

    private byte d(byte b) throws aj {
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                return (byte) 0;
            case (byte) 1:
            case (byte) 2:
                return (byte) 2;
            case (byte) 3:
                return (byte) 3;
            case (byte) 4:
                return (byte) 6;
            case (byte) 5:
                return (byte) 8;
            case (byte) 6:
                return (byte) 10;
            case (byte) 7:
                return (byte) 4;
            case (byte) 8:
                return (byte) 11;
            case (byte) 9:
                return ap.m;
            case (byte) 10:
                return ap.l;
            case (byte) 11:
                return ap.k;
            case (byte) 12:
                return (byte) 12;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("don't know what type: ");
                stringBuilder.append(b);
                throw new aj(stringBuilder.toString());
        }
    }

    private long d(long j) {
        return (j >>> 1) ^ (-(j & 1));
    }

    private void d(int i) throws p {
        b((byte) i);
    }

    private byte e(byte b) {
        return f[b];
    }

    private byte[] e(int i) throws p {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.g.d(bArr, 0, i);
        return bArr;
    }

    private void f(int i) throws aj {
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Negative length: ");
            stringBuilder.append(i);
            throw new aj(stringBuilder.toString());
        } else if (this.q != -1 && ((long) i) > this.q) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Length exceeded max allowed: ");
            stringBuilder.append(i);
            throw new aj(stringBuilder.toString());
        }
    }

    private int g(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public ByteBuffer A() throws p {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    public void a() throws p {
    }

    public void a(byte b) throws p {
        b(b);
    }

    /* Access modifiers changed, original: protected */
    public void a(byte b, int i) throws p {
        if (i <= 14) {
            d(e(b) | (i << 4));
            return;
        }
        d(e(b) | 240);
        b(i);
    }

    public void a(double d) throws p {
        byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        a(Double.doubleToLongBits(d), bArr, 0);
        this.g.b(bArr);
    }

    public void a(int i) throws p {
        b(c(i));
    }

    public void a(long j) throws p {
        b(c(j));
    }

    public void a(ad adVar) throws p {
        if (adVar.b == (byte) 2) {
            this.o = adVar;
        } else {
            a(adVar, (byte) -1);
        }
    }

    public void a(ae aeVar) throws p {
        a(aeVar.a, aeVar.b);
    }

    public void a(af afVar) throws p {
        if (afVar.c == 0) {
            d(0);
            return;
        }
        b(afVar.c);
        d(e(afVar.b) | (e(afVar.a) << 4));
    }

    public void a(ag agVar) throws p {
        b((byte) h);
        d(((agVar.b << 5) & -32) | 1);
        b(agVar.c);
        a(agVar.a);
    }

    public void a(am amVar) throws p {
        a(amVar.a, amVar.b);
    }

    public void a(an anVar) throws p {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    public void a(String str) throws p {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new p("UTF-8 not supported!");
        }
    }

    public void a(ByteBuffer byteBuffer) throws p {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    public void a(short s) throws p {
        b(c((int) s));
    }

    public void a(boolean z) throws p {
        byte b = (byte) 2;
        if (this.o != null) {
            ad adVar = this.o;
            if (z) {
                b = (byte) 1;
            }
            a(adVar, b);
            this.o = null;
            return;
        }
        if (z) {
            b = (byte) 1;
        }
        b(b);
    }

    public void b() throws p {
        this.n = this.m.a();
    }

    public void c() throws p {
    }

    public void d() throws p {
        b((byte) 0);
    }

    public void e() throws p {
    }

    public void f() throws p {
    }

    public void g() throws p {
    }

    public ag h() throws p {
        byte u = u();
        if (u != h) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected protocol id ");
            stringBuilder.append(Integer.toHexString(-126));
            stringBuilder.append(" but got ");
            stringBuilder.append(Integer.toHexString(u));
            throw new aj(stringBuilder.toString());
        }
        u = u();
        byte b = (byte) (u & 31);
        if (b != (byte) 1) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Expected version 1 but got ");
            stringBuilder2.append(b);
            throw new aj(stringBuilder2.toString());
        }
        return new ag(z(), (byte) ((u >> 5) & 3), E());
    }

    public void i() throws p {
    }

    public an j() throws p {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    public void k() throws p {
        this.n = this.m.a();
    }

    public ad l() throws p {
        byte u = u();
        if (u == (byte) 0) {
            return e;
        }
        short s = (short) ((u & 240) >> 4);
        byte b = (byte) (u & 15);
        ad adVar = new ad("", d(b), s == (short) 0 ? v() : (short) (this.n + s));
        if (c(u)) {
            this.p = b == (byte) 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = adVar.c;
        return adVar;
    }

    public void m() throws p {
    }

    public af n() throws p {
        int E = E();
        int u = E == 0 ? 0 : u();
        return new af(d((byte) (u >> 4)), d((byte) (u & 15)), E);
    }

    public void o() throws p {
    }

    public ae p() throws p {
        byte u = u();
        int i = (u >> 4) & 15;
        if (i == 15) {
            i = E();
        }
        return new ae(d(u), i);
    }

    public void q() throws p {
    }

    public am r() throws p {
        return new am(p());
    }

    public void s() throws p {
    }

    public boolean t() throws p {
        if (this.p != null) {
            boolean booleanValue = this.p.booleanValue();
            this.p = null;
            return booleanValue;
        }
        boolean z = true;
        if (u() != (byte) 1) {
            z = false;
        }
        return z;
    }

    public byte u() throws p {
        if (this.g.h() > 0) {
            byte b = this.g.f()[this.g.g()];
            this.g.a(1);
            return b;
        }
        this.g.d(this.c, 0, 1);
        return this.c[0];
    }

    public short v() throws p {
        return (short) g(E());
    }

    public int w() throws p {
        return g(E());
    }

    public long x() throws p {
        return d(F());
    }

    public double y() throws p {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    public String z() throws p {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.g.f(), this.g.g(), E, "UTF-8");
            this.g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new p("UTF-8 not supported!");
        }
    }
}
