package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* compiled from: BUGLY */
public final class d extends c {
    private static HashMap<String, byte[]> f;
    private static HashMap<String, HashMap<String, byte[]>> g;
    private f e = new f();

    public final <T> void a(String str, T t) {
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder("put name can not startwith . , now is ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        super.a(str, t);
    }

    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            i iVar = new i(bArr, 4);
            iVar.a(this.b);
            this.e.a(iVar);
            i iVar2;
            HashMap hashMap;
            if (this.e.a == (short) 3) {
                iVar2 = new i(this.e.e);
                iVar2.a(this.b);
                if (f == null) {
                    hashMap = new HashMap();
                    f = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.d = iVar2.a(f, 0, false);
                return;
            }
            iVar2 = new i(this.e.e);
            iVar2.a(this.b);
            if (g == null) {
                g = new HashMap();
                hashMap = new HashMap();
                hashMap.put("", new byte[0]);
                g.put("", hashMap);
            }
            this.a = iVar2.a(g, 0, false);
            HashMap hashMap2 = new HashMap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final byte[] a() {
        if (this.e.a != (short) 2) {
            if (this.e.c == null) {
                this.e.c = "";
            }
            if (this.e.d == null) {
                this.e.d = "";
            }
        } else if (this.e.c.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.e.d.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        j jVar = new j(0);
        jVar.a(this.b);
        if (this.e.a == (short) 2) {
            jVar.a(this.a, 0);
        } else {
            jVar.a(this.d, 0);
        }
        this.e.e = l.a(jVar.a());
        jVar = new j(0);
        jVar.a(this.b);
        this.e.a(jVar);
        byte[] a = l.a(jVar.a());
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    public final void b() {
        super.b();
        this.e.a = (short) 3;
    }

    public final void b(int i) {
        this.e.b = 1;
    }

    public final void b(String str) {
        this.e.c = str;
    }

    public final void c(String str) {
        this.e.d = str;
    }
}
