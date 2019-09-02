package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.ac.a;

/* compiled from: TProtocolUtil */
public class al {
    private static int a = Integer.MAX_VALUE;

    public static ak a(byte[] bArr, ak akVar) {
        return bArr[0] > ap.n ? new a() : (bArr.length <= 1 || (bArr[1] & 128) == 0) ? akVar : new a();
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(ai aiVar, byte b) throws p {
        a(aiVar, b, a);
    }

    public static void a(ai aiVar, byte b, int i) throws p {
        if (i <= 0) {
            throw new p("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case (byte) 2:
                aiVar.t();
                return;
            case (byte) 3:
                aiVar.u();
                return;
            case (byte) 4:
                aiVar.y();
                return;
            case (byte) 6:
                aiVar.v();
                return;
            case (byte) 8:
                aiVar.w();
                return;
            case (byte) 10:
                aiVar.x();
                return;
            case (byte) 11:
                aiVar.A();
                return;
            case (byte) 12:
                aiVar.j();
                while (true) {
                    ad l = aiVar.l();
                    if (l.b == (byte) 0) {
                        aiVar.k();
                        return;
                    } else {
                        a(aiVar, l.b, i - 1);
                        aiVar.m();
                    }
                }
            case (byte) 13:
                af n = aiVar.n();
                while (i2 < n.c) {
                    int i3 = i - 1;
                    a(aiVar, n.a, i3);
                    a(aiVar, n.b, i3);
                    i2++;
                }
                aiVar.o();
                return;
            case (byte) 14:
                am r = aiVar.r();
                while (i2 < r.b) {
                    a(aiVar, r.a, i - 1);
                    i2++;
                }
                aiVar.s();
                return;
            case (byte) 15:
                ae p = aiVar.p();
                while (i2 < p.b) {
                    a(aiVar, p.a, i - 1);
                    i2++;
                }
                aiVar.q();
                return;
            default:
                return;
        }
    }
}
