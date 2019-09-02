package cn.jiguang.d.c;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class m implements Serializable, Cloneable, Comparable {
    private static final DecimalFormat e;
    protected j a;
    protected int b;
    protected int c;
    protected long d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    protected m() {
    }

    static m a(d dVar, int i) {
        j jVar = new j(dVar);
        int g = dVar.g();
        int g2 = dVar.g();
        if (i == 0) {
            return a(jVar, g, g2);
        }
        long h = dVar.h();
        i = dVar.g();
        m a = a(jVar, g, g2, h);
        if (dVar != null) {
            if (dVar.b() < i) {
                throw new t("truncated record");
            }
            dVar.a(i);
            a.a(dVar);
            if (dVar.b() > 0) {
                throw new t("invalid record length");
            }
            dVar.c();
        }
        return a;
    }

    public static m a(j jVar, int i, int i2) {
        if (jVar.a()) {
            return a(jVar, i, i2, 0);
        }
        throw new n(jVar);
    }

    private static final m a(j jVar, int i, int i2, long j) {
        p pVar = new p();
        pVar.a = jVar;
        pVar.b = i;
        pVar.c = i2;
        pVar.d = j;
        return pVar;
    }

    private byte[] h() {
        e eVar = new e();
        a(eVar, true);
        return eVar.b();
    }

    public abstract String a();

    /* Access modifiers changed, original: final */
    public final void a(long j) {
        this.d = j;
    }

    public abstract void a(d dVar);

    /* Access modifiers changed, original: final */
    public final void a(e eVar, b bVar) {
        this.a.a(eVar, bVar);
        eVar.c(this.b);
        eVar.c(this.c);
    }

    public abstract void a(e eVar, boolean z);

    public final boolean a(m mVar) {
        return this.b == mVar.b && this.c == mVar.c && this.a.equals(mVar.a);
    }

    public final j b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public int compareTo(Object obj) {
        m mVar = (m) obj;
        int i = 0;
        if (this == mVar) {
            return 0;
        }
        int compareTo = this.a.compareTo(mVar.a);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this.c - mVar.c;
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this.b - mVar.b;
        if (compareTo != 0) {
            return compareTo;
        }
        byte[] h = h();
        byte[] h2 = mVar.h();
        while (i < h.length && i < h2.length) {
            int i2 = (h[i] & 255) - (h2[i] & 255);
            if (i2 != 0) {
                return i2;
            }
            i++;
        }
        return h.length - h2.length;
    }

    public final int d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    /* JADX WARNING: Missing block: B:14:0x002e, code skipped:
            return false;
     */
    public boolean equals(java.lang.Object r4) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x002e;
    L_0x0003:
        r1 = r4 instanceof cn.jiguang.d.c.m;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r4 = (cn.jiguang.d.c.m) r4;
        r1 = r3.b;
        r2 = r4.b;
        if (r1 != r2) goto L_0x002e;
    L_0x0010:
        r1 = r3.c;
        r2 = r4.c;
        if (r1 != r2) goto L_0x002e;
    L_0x0016:
        r1 = r3.a;
        r2 = r4.a;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0021;
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = r3.h();
        r4 = r4.h();
        r4 = java.util.Arrays.equals(r0, r4);
        return r4;
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.c.m.equals(java.lang.Object):boolean");
    }

    public final long f() {
        return this.d;
    }

    /* Access modifiers changed, original: final */
    public final m g() {
        try {
            return (m) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public int hashCode() {
        e eVar = new e();
        this.a.a(eVar);
        eVar.c(this.b);
        eVar.c(this.c);
        eVar.a(0);
        int a = eVar.a();
        int i = 0;
        eVar.c(0);
        a(eVar, true);
        eVar.a((eVar.a() - a) - 2, a);
        byte[] b = eVar.b();
        a = 0;
        while (i < b.length) {
            a += (a << 3) + (b[i] & 255);
            i++;
        }
        return a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String a = a();
        if (!a.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}
