package cn.jiguang.d.b.a;

import android.content.Context;
import cn.jiguang.a.a.b.e;
import cn.jiguang.a.a.b.f;
import cn.jiguang.d.a.a;
import cn.jiguang.d.b.g;
import cn.jiguang.d.h.x;
import cn.jiguang.g.k;
import cn.jiguang.g.m;
import cn.jiguang.net.HttpUtils;
import defpackage.O0000Oo0;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import org.json.JSONArray;

public final class d {
    private final Context a;
    private final g b;
    private final long c;
    private final a d = new a();
    private final a e = new a();
    private byte[] f;
    private g g;
    private a h;
    private c i;
    private final LinkedList<f> j;

    public d(Context context, g gVar, long j) {
        this.a = context;
        this.b = gVar;
        this.c = j;
        this.j = f.a(a.m());
    }

    private int a(a aVar, DatagramSocket datagramSocket, byte[] bArr) {
        if (aVar != null) {
            Iterator b = aVar.b();
            while (b.hasNext()) {
                c cVar = (c) ((Entry) b.next()).getKey();
                int a = a(cVar.a, cVar.b, datagramSocket, bArr);
                if (a == 0) {
                    return a;
                }
            }
        }
        return -1;
    }

    private static int a(String str, int i, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            InetAddress b = cn.jiguang.d.d.d.b(str);
            if (b == null) {
                return -1;
            }
            byte[] bArr2 = a(cn.jiguang.d.d.d.a(datagramSocket, new DatagramPacket(bArr, bArr.length, b, i))).b;
            if (bArr2 != null) {
                if (bArr2.length != 0) {
                    if (bArr2.length == 1) {
                        return (short) bArr2[0];
                    }
                    return (short) (((short) (bArr2[1] & 255)) | ((short) ((bArr2[0] & 255) << 8)));
                }
            }
            throw new Exception("byte could not be empty");
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static b a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new e(3, "response is empty!");
        }
        try {
            byte[] b;
            cn.jiguang.g.g gVar = new cn.jiguang.g.g(bArr);
            gVar.a();
            String str = new String(gVar.a(2));
            long b2 = gVar.b();
            int i = (int) (b2 >>> 24);
            long j = b2 & 16777215;
            gVar.a();
            byte[] c = gVar.c();
            if (j != 0) {
                try {
                    c = cn.jiguang.d.h.a.a.b(cn.jiguang.d.h.a.a.a(j), c);
                    if (c == null) {
                        throw new e(4, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new e(4, "decrypt response error");
                }
            }
            if ((i & 1) == 1) {
                try {
                    b = x.b(c);
                } catch (IOException unused2) {
                }
                return new b(str, b);
            }
            b = c;
            return new b(str, b);
        } catch (m e) {
            StringBuilder stringBuilder = new StringBuilder("parse head error:");
            stringBuilder.append(e.getMessage());
            throw new e(3, stringBuilder.toString());
        }
    }

    private static byte[] a(String str, String str2) {
        byte[] bytes = str2.getBytes(HttpUtils.ENCODING_UTF_8);
        boolean z = false;
        try {
            byte[] a = x.a(bytes);
            if (a.length < bytes.length) {
                z = true;
                bytes = a;
            }
        } catch (IOException unused) {
        }
        int length = bytes.length;
        int c = cn.jiguang.d.h.a.a.c();
        return cn.jiguang.d.d.d.a(str, c, cn.jiguang.d.h.a.a.a(cn.jiguang.d.h.a.a.a((long) c), bytes), z, length);
    }

    private g g() {
        if (this.g == null) {
            String b = cn.jiguang.d.a.b(this.a);
            long c = cn.jiguang.d.a.d.c(this.a);
            int a = k.a(this.a);
            String b2 = k.b(this.a);
            e a2 = f.a(this.a);
            this.g = new g(a, b, O0000Oo0.O00000oo, c, b2, a2.b(), a2.c(), a2.d());
        }
        return this.g;
    }

    private void h() {
        while (this.j.size() > 5) {
            this.j.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            jSONArray.put(((f) it.next()).a());
        }
        a.e(jSONArray.toString());
    }

    public final a a() {
        if (this.h == null) {
            this.h = a.a(a.l());
        }
        if (this.h == null || this.h.a()) {
            this.h = new a();
            LinkedHashMap c = cn.jiguang.d.a.f.c();
            if (c != null) {
                for (String str : c.keySet()) {
                    this.h.a(str, ((Integer) c.get(str)).intValue(), "hardcode_ip");
                }
            }
            if (!this.h.a()) {
                a.d(this.h.toString());
            }
        }
        return this.h;
    }

    public final void a(a aVar) {
        if (aVar != null && !aVar.equals(this.h)) {
            this.h = aVar;
            a.d(this.h.toString());
        }
    }

    public final void a(String str, int i, int i2) {
        this.d.a(str, i, String.valueOf(i2));
    }

    public final void a(String str, int i, long j, long j2, int i2) {
        if (c.a(str, i)) {
            f fVar = new f();
            fVar.a = 1;
            fVar.b = new c(str, i);
            fVar.d = j;
            fVar.e = j2;
            fVar.j = i2;
            g g = g();
            if (g != null) {
                fVar.f = g.a();
                fVar.c = g.b();
                fVar.g = g.c();
                fVar.h = g.d();
                fVar.i = g.e();
            }
            this.j.add(fVar);
            h();
        }
    }

    public final boolean a(c cVar) {
        return this.d.a(cVar);
    }

    public final a b() {
        this.i = c.a(a.n());
        a aVar = new a();
        for (Entry entry : cn.jiguang.d.a.f.b().entrySet()) {
            aVar.a((String) entry.getKey(), ((Integer) entry.getValue()).intValue(), "hardcode_domain");
        }
        if (this.i != null) {
            aVar.a(this.i.a, this.i.b, "last_good");
        }
        return aVar;
    }

    public final void b(String str, int i, int i2) {
        this.e.a(str, i, String.valueOf(i2));
    }

    public final void b(String str, int i, long j, long j2, int i2) {
        if (c.a(str, i)) {
            f fVar = new f();
            fVar.a = 2;
            fVar.b = new c(str, i);
            fVar.d = j;
            fVar.e = j2;
            fVar.j = i2;
            fVar.f = k.a(this.a);
            fVar.c = cn.jiguang.d.a.d.c(this.a);
            e a = f.a(this.a);
            if (a != null && a.a()) {
                fVar.g = a.b();
                fVar.h = a.c();
                fVar.i = a.d();
            }
            this.j.add(fVar);
            h();
        }
    }

    public final boolean b(c cVar) {
        return this.e.a(cVar);
    }

    public final void c(c cVar) {
        if (!cVar.equals(this.i)) {
            this.i = cVar;
            a.f(this.i.toString());
        }
    }

    public final byte[] c() {
        if (this.f == null) {
            g();
            try {
                this.f = a("UG", this.g.f().toString());
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("Failed to package data - ");
                stringBuilder.append(e.getMessage());
                throw new e(1, stringBuilder.toString());
            }
        }
        return this.f;
    }

    public final Context d() {
        return this.a;
    }

    public final g e() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0057 A:{SYNTHETIC, Splitter:B:35:0x0057} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A:{SYNTHETIC, Splitter:B:29:0x0051} */
    public final void f() {
        /*
        r6 = this;
        r0 = 0;
        r1 = cn.jiguang.d.a.a.o();	 Catch:{ Throwable -> 0x0055, all -> 0x004b }
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r1 = new java.net.DatagramSocket;	 Catch:{ Throwable -> 0x0055, all -> 0x004b }
        r1.<init>();	 Catch:{ Throwable -> 0x0055, all -> 0x004b }
        r2 = cn.jiguang.d.a.a.m();	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        if (r3 == 0) goto L_0x001b;
    L_0x0017:
        r1.close();	 Catch:{ Throwable -> 0x001a }
    L_0x001a:
        return;
    L_0x001b:
        r3 = "DG";
        r2 = a(r3, r2);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r3 = r6.b();	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r3 = r6.a(r3, r1, r2);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        if (r3 == 0) goto L_0x003e;
    L_0x002b:
        r3 = cn.jiguang.d.a.f;	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r3 = r3.f();	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r3 = cn.jiguang.d.c.f.a(r3);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r4 = 0;
        r3 = cn.jiguang.d.b.a.a.a(r3, r4);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
        r3 = r6.a(r3, r1, r2);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
    L_0x003e:
        if (r3 != 0) goto L_0x0043;
    L_0x0040:
        cn.jiguang.d.a.a.e(r0);	 Catch:{ Throwable -> 0x0049, all -> 0x0047 }
    L_0x0043:
        r1.close();	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        return;
    L_0x0047:
        r0 = move-exception;
        goto L_0x004f;
    L_0x0049:
        r0 = r1;
        goto L_0x0055;
    L_0x004b:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x004f:
        if (r1 == 0) goto L_0x0054;
    L_0x0051:
        r1.close();	 Catch:{ Throwable -> 0x0054 }
    L_0x0054:
        throw r0;
    L_0x0055:
        if (r0 == 0) goto L_0x005a;
    L_0x0057:
        r0.close();	 Catch:{ Throwable -> 0x005a }
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.a.d.f():void");
    }
}
