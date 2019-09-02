package com.umeng.commonsdk.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TBinaryProtocol */
public class ab extends ai {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final an h = new an();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* compiled from: TBinaryProtocol */
    public static class a implements ak {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = false;
            this.b = true;
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        public ai a(aw awVar) {
            ab abVar = new ab(awVar, this.a, this.b);
            if (this.c != 0) {
                abVar.c(this.c);
            }
            return abVar;
        }
    }

    public ab(aw awVar) {
        this(awVar, false, true);
    }

    public ab(aw awVar, boolean z, boolean z2) {
        super(awVar);
        this.c = false;
        this.d = true;
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    private int a(byte[] bArr, int i, int i2) throws p {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    public ByteBuffer A() throws p {
        int w = w();
        d(w);
        if (this.g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.g.f(), this.g.g(), w);
            this.g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    public void a() {
    }

    public void a(byte b) throws p {
        this.i[0] = b;
        this.g.b(this.i, 0, 1);
    }

    public void a(double d) throws p {
        a(Double.doubleToLongBits(d));
    }

    public void a(int i) throws p {
        this.k[0] = (byte) ((i >> 24) & 255);
        this.k[1] = (byte) ((i >> 16) & 255);
        this.k[2] = (byte) ((i >> 8) & 255);
        this.k[3] = (byte) (i & 255);
        this.g.b(this.k, 0, 4);
    }

    public void a(long j) throws p {
        this.l[0] = (byte) ((int) (255 & (j >> 56)));
        this.l[1] = (byte) ((int) (255 & (j >> 48)));
        this.l[2] = (byte) ((int) (255 & (j >> 40)));
        this.l[3] = (byte) ((int) (255 & (j >> 32)));
        this.l[4] = (byte) ((int) (255 & (j >> 24)));
        this.l[5] = (byte) ((int) (255 & (j >> 16)));
        this.l[6] = (byte) ((int) (255 & (j >> 8)));
        this.l[7] = (byte) ((int) (255 & j));
        this.g.b(this.l, 0, 8);
    }

    public void a(ad adVar) throws p {
        a(adVar.b);
        a(adVar.c);
    }

    public void a(ae aeVar) throws p {
        a(aeVar.a);
        a(aeVar.b);
    }

    public void a(af afVar) throws p {
        a(afVar.a);
        a(afVar.b);
        a(afVar.c);
    }

    public void a(ag agVar) throws p {
        if (this.d) {
            a(b | agVar.b);
            a(agVar.a);
            a(agVar.c);
            return;
        }
        a(agVar.a);
        a(agVar.b);
        a(agVar.c);
    }

    public void a(am amVar) throws p {
        a(amVar.a);
        a(amVar.b);
    }

    public void a(an anVar) {
    }

    public void a(String str) throws p {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new p("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) throws p {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public void a(short s) throws p {
        this.j[0] = (byte) ((s >> 8) & 255);
        this.j[1] = (byte) (s & 255);
        this.g.b(this.j, 0, 2);
    }

    public void a(boolean z) throws p {
        a((byte) z);
    }

    public String b(int i) throws p {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new p("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    public void d() throws p {
        a((byte) 0);
    }

    /* Access modifiers changed, original: protected */
    public void d(int i) throws p {
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Negative length: ");
            stringBuilder.append(i);
            throw new aj(stringBuilder.toString());
        } else if (this.f) {
            this.e -= i;
            if (this.e < 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Message length exceeded: ");
                stringBuilder.append(i);
                throw new aj(stringBuilder.toString());
            }
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public ag h() throws p {
        int w = w();
        if (w < 0) {
            if ((a & w) == b) {
                return new ag(z(), (byte) (w & 255), w());
            }
            throw new aj(4, "Bad version in readMessageBegin");
        } else if (!this.c) {
            return new ag(b(w), u(), w());
        } else {
            throw new aj(4, "Missing version in readMessageBegin, old client?");
        }
    }

    public void i() {
    }

    public an j() {
        return h;
    }

    public void k() {
    }

    public ad l() throws p {
        byte u = u();
        return new ad("", u, u == (byte) 0 ? (short) 0 : v());
    }

    public void m() {
    }

    public af n() throws p {
        return new af(u(), u(), w());
    }

    public void o() {
    }

    public ae p() throws p {
        return new ae(u(), w());
    }

    public void q() {
    }

    public am r() throws p {
        return new am(u(), w());
    }

    public void s() {
    }

    public boolean t() throws p {
        return u() == (byte) 1;
    }

    public byte u() throws p {
        if (this.g.h() >= 1) {
            byte b = this.g.f()[this.g.g()];
            this.g.a(1);
            return b;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    public short v() throws p {
        byte[] bArr = this.n;
        int i = 0;
        if (this.g.h() >= 2) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int w() throws p {
        byte[] bArr = this.o;
        int i = 0;
        if (this.g.h() >= 4) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }

    public long x() throws p {
        byte[] bArr = this.p;
        int i = 0;
        if (this.g.h() >= 8) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return (((((((((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48)) | (((long) (bArr[i + 2] & 255)) << 40)) | (((long) (bArr[i + 3] & 255)) << 32)) | (((long) (bArr[i + 4] & 255)) << 24)) | (((long) (bArr[i + 5] & 255)) << 16)) | (((long) (bArr[i + 6] & 255)) << 8)) | ((long) (bArr[i + 7] & 255));
    }

    public double y() throws p {
        return Double.longBitsToDouble(x());
    }

    public String z() throws p {
        int w = w();
        if (this.g.h() < w) {
            return b(w);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), w, "UTF-8");
            this.g.a(w);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new p("JVM DOES NOT SUPPORT UTF-8");
        }
    }
}
