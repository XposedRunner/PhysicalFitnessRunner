package com.qiyukf.nimlib.e;

import android.os.Handler;
import android.util.SparseArray;

public final class a {
    private static a e;
    private final SparseArray<k> a = new SparseArray();
    private final c b = new c(this.d);
    private final j c = new j();
    private final Handler d = com.qiyukf.basesdk.c.a.b();

    private a() {
    }

    public static Object a(i iVar) {
        b();
        return e.d(iVar);
    }

    public static void a() {
        e = new a();
    }

    public static void a(String str, Object obj) {
        b();
        final i iVar = new i();
        iVar.a.a = str;
        iVar.a(new Object[]{obj});
        a aVar = e;
        StringBuilder stringBuilder = new StringBuilder("on notify: ");
        stringBuilder.append(iVar);
        com.qiyukf.basesdk.a.a.a("InvocationMgr", stringBuilder.toString());
        aVar.d.post(new Runnable() {
            public final void run() {
                a.this.b.b(iVar);
            }
        });
    }

    private static void b() {
        if (e == null) {
            throw new IllegalStateException("SDK not inited!");
        }
    }

    public static boolean b(i iVar) {
        b();
        return e.e(iVar);
    }

    public static void c(i iVar) {
        final k kVar;
        b();
        a aVar = e;
        StringBuilder stringBuilder = new StringBuilder("execution result: ");
        stringBuilder.append(iVar);
        com.qiyukf.basesdk.a.a.a("InvocationMgr", stringBuilder.toString());
        synchronized (aVar.a) {
            kVar = (k) aVar.a.get(iVar.c());
            aVar.a.remove(iVar.c());
        }
        if (kVar != null) {
            kVar.a(iVar.b.a, iVar.b.b);
            aVar.c.d(iVar);
            aVar.d.post(new Runnable() {
                public final void run() {
                    kVar.a();
                }
            });
        }
    }

    private Object d(i iVar) {
        if (this.b.a(iVar)) {
            return null;
        }
        if (iVar.d()) {
            return this.c.a(iVar);
        }
        k kVar;
        synchronized (this.a) {
            kVar = new k(iVar);
            this.a.put(iVar.c(), kVar);
            this.c.b(iVar);
        }
        return kVar;
    }

    private boolean e(i iVar) {
        synchronized (this.a) {
            if (this.a.get(iVar.c()) == null) {
                return false;
            }
            this.a.remove(iVar.c());
            try {
                this.c.c(iVar);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
