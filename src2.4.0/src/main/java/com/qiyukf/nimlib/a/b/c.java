package com.qiyukf.nimlib.a.b;

import android.util.SparseArray;
import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.a.d.b;

public abstract class c {
    private static c b;
    private static c c;
    private boolean a = false;
    private SparseArray<Class<? extends a>> d = new SparseArray();
    private SparseArray<Integer> e = new SparseArray();
    private SparseArray<a> f = new SparseArray();

    protected c() {
        c();
    }

    public static c a(boolean z) {
        if ((z ? b : c) == null) {
            synchronized (c.class) {
                c cVar;
                if (z) {
                    try {
                        cVar = b;
                    } catch (Throwable th) {
                    }
                } else {
                    cVar = c;
                }
                if (cVar == null) {
                    if (z) {
                        b = new d();
                    } else {
                        c = new e();
                    }
                }
            }
        }
        c cVar2 = z ? b : c;
        cVar2.c();
        return cVar2;
    }

    private void c() {
        if (!this.a) {
            try {
                a();
                b();
                this.a = true;
            } catch (Throwable th) {
                com.qiyukf.basesdk.a.a.a("RF", "register handlers error");
                com.qiyukf.unicorn.analytics.a.a(th);
                th.printStackTrace();
            }
        }
    }

    private static int e(com.qiyukf.nimlib.h.c.a aVar) {
        return aVar.h() | (aVar.g() << 16);
    }

    public abstract void a();

    /* Access modifiers changed, original: protected|final */
    public final void a(Class<? extends a> cls) {
        b bVar = (b) cls.getAnnotation(b.class);
        if (bVar != null) {
            byte a = bVar.a();
            String[] b = bVar.b();
            if (!(b == null || b.length == 0)) {
                for (String split : b) {
                    String[] split2 = split.split("#");
                    if (!(split2 == null || split2.length == 0)) {
                        byte parseByte = Byte.parseByte(split2[0]);
                        if (split2.length >= 2) {
                            this.e.put((a << 16) | parseByte, Integer.valueOf(Integer.parseInt(split2[1])));
                        }
                        this.d.put(parseByte | (a << 16), cls);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Class<? extends a> cls, a aVar) {
        b bVar = (b) cls.getAnnotation(b.class);
        if (bVar != null) {
            byte a = bVar.a();
            String[] b = bVar.b();
            if (!(b == null || b.length == 0)) {
                for (String split : b) {
                    String[] split2 = split.split("#");
                    if (!(split2 == null || split2.length == 0)) {
                        int parseByte = Byte.parseByte(split2[0]) | (a << 16);
                        if (split2.length >= 2) {
                            this.e.append(parseByte, Integer.valueOf(Integer.parseInt(split2[1])));
                        }
                        this.d.append(parseByte, cls);
                        this.f.append(parseByte, aVar);
                    }
                }
            }
        }
    }

    public final boolean a(com.qiyukf.nimlib.h.c.a aVar) {
        return aVar != null && this.d.indexOfKey(e(aVar)) >= 0;
    }

    public final Integer b(com.qiyukf.nimlib.h.c.a aVar) {
        return (aVar == null || this.e == null) ? null : (Integer) this.e.get(e(aVar));
    }

    public abstract void b();

    public final a c(com.qiyukf.nimlib.h.c.a aVar) {
        return (aVar == null || this.f == null) ? null : (a) this.f.get(e(aVar));
    }

    public final a d(com.qiyukf.nimlib.h.c.a aVar) {
        Class cls = (aVar == null || this.d == null) ? null : (Class) this.d.get(e(aVar));
        if (cls == null) {
            return null;
        }
        try {
            return (a) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
