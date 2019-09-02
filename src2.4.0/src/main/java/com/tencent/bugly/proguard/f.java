package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class f extends k {
    private static byte[] k = null;
    private static Map<String, String> l = null;
    private static /* synthetic */ boolean m = true;
    public short a = (short) 0;
    public int b = 0;
    public String c = null;
    public String d = null;
    public byte[] e;
    private byte f = (byte) 0;
    private int g = 0;
    private int h = 0;
    private Map<String, String> i;
    private Map<String, String> j;

    public final void a(i iVar) {
        try {
            HashMap hashMap;
            this.a = iVar.a(this.a, 1, true);
            this.f = iVar.a(this.f, 2, true);
            this.g = iVar.a(this.g, 3, true);
            this.b = iVar.a(this.b, 4, true);
            this.c = iVar.b(5, true);
            this.d = iVar.b(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            byte[] bArr = k;
            this.e = iVar.c(7, true);
            this.h = iVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) iVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) iVar.a(l, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder("RequestPacket decode error ");
            stringBuilder.append(e.a(this.e));
            printStream.println(stringBuilder.toString());
            throw new RuntimeException(e);
        }
    }

    public final void a(j jVar) {
        jVar.a(this.a, 1);
        jVar.a(this.f, 2);
        jVar.a(this.g, 3);
        jVar.a(this.b, 4);
        jVar.a(this.c, 5);
        jVar.a(this.d, 6);
        jVar.a(this.e, 7);
        jVar.a(this.h, 8);
        jVar.a(this.i, 9);
        jVar.a(this.j, 10);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        h hVar = new h(stringBuilder, i);
        hVar.a(this.a, "iVersion");
        hVar.a(this.f, "cPacketType");
        hVar.a(this.g, "iMessageType");
        hVar.a(this.b, "iRequestId");
        hVar.a(this.c, "sServantName");
        hVar.a(this.d, "sFuncName");
        hVar.a(this.e, "sBuffer");
        hVar.a(this.h, "iTimeout");
        hVar.a(this.i, "context");
        hVar.a(this.j, "status");
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        f fVar = (f) obj;
        return l.a(1, fVar.a) && l.a(1, fVar.f) && l.a(1, fVar.g) && l.a(1, fVar.b) && l.a(Integer.valueOf(1), fVar.c) && l.a(Integer.valueOf(1), fVar.d) && l.a(Integer.valueOf(1), fVar.e) && l.a(1, fVar.h) && l.a(Integer.valueOf(1), fVar.i) && l.a(Integer.valueOf(1), fVar.j);
    }
}
