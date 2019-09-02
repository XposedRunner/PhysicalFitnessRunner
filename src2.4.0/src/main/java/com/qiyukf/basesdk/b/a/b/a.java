package com.qiyukf.basesdk.b.a.b;

import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.basesdk.b.a.b.c.d;
import com.qiyukf.basesdk.b.a.b.c.f;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    private static com.qiyukf.basesdk.b.a.b.d.a e;
    private b a;
    private List<d> b;
    private AtomicBoolean c;
    private Set<c> d;

    private class a implements com.qiyukf.basesdk.b.a.b.c.b {
        private String b;
        private c c;
        private d d;

        a(String str, d dVar, c cVar) {
            this.b = str;
            this.d = dVar;
            this.c = cVar;
        }

        public final void a() {
            b.c(this.b);
            b.e(this.b);
            if (this.c != null) {
                c cVar = this.c;
                d dVar = this.d;
                String decode = URLDecoder.decode(dVar.c());
                String decode2 = URLDecoder.decode(dVar.b());
                StringBuilder stringBuilder = new StringBuilder("https://");
                stringBuilder.append(decode2);
                stringBuilder.append(".nosdn.127.net/");
                stringBuilder.append(decode);
                cVar.a(stringBuilder.toString());
            }
        }

        public final void a(long j, long j2) {
            if (this.c != null) {
                this.c.a(j, j2);
            }
        }

        public final void a(com.qiyukf.basesdk.b.a.b.c.a aVar) {
            if (this.c != null) {
                this.c.a(aVar.a());
            }
            if (aVar.a() == SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED) {
                b.a.d();
                b.c(this.b);
                b.e(this.b);
                return;
            }
            com.qiyukf.basesdk.b.a.b.e.b.c(com.qiyukf.basesdk.a.a());
        }

        public final void a(String str) {
            b.a(this.b, str);
            b.a(this.b, this.d);
        }

        public final void b() {
            if (this.c != null) {
                this.c.a();
            }
        }
    }

    private static class b {
        private static a a = new a();
    }

    public class c implements Runnable {
        private String b;
        private String c;
        private Object d;
        private c e;
        private com.qiyukf.basesdk.b.a.b.f.b f;
        private d g;

        c(String str, String str2, Object obj, c cVar) {
            this.b = str;
            this.c = str2;
            this.d = obj;
            this.e = cVar;
        }

        public final void a() {
            if (this.f != null) {
                this.f.a();
            }
        }

        public final void run() {
            String b = b.b(this.b);
            if (!TextUtils.isEmpty(b)) {
                d d = b.d(this.b);
                if (d != null) {
                    this.g = d;
                }
            }
            f fVar = new f(this.g.a(), this.g.b(), this.g.c(), this.c);
            fVar.b(com.qiyukf.basesdk.c.c.d.c(this.b));
            try {
                this.f = com.qiyukf.basesdk.b.a.b.f.a.a(com.qiyukf.basesdk.a.a(), new File(this.b), this.d, b, fVar, new a(this.b, this.g, this.e));
            } catch (Exception e) {
                if (this.e != null) {
                    c cVar = this.e;
                    new StringBuilder("exception: ").append(e.getMessage());
                    cVar.a(1000);
                }
            }
        }
    }

    private a() {
        this.c = new AtomicBoolean(false);
        this.a = new b();
        this.b = d.d(b.a());
        f();
        this.d = new HashSet();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static final a a() {
        return b.a;
    }

    public static com.qiyukf.basesdk.b.a.b.d.a c() {
        if (e == null) {
            e = new com.qiyukf.basesdk.b.a.b.d.a();
        }
        return e;
    }

    private void e() {
        b.a(d.a(this.b));
    }

    private void f() {
        if (this.b.size() <= 10) {
            h();
        }
    }

    private d g() {
        f();
        synchronized (this.b) {
            if (this.b.size() > 0) {
                d dVar = (d) this.b.remove(this.b.size() - 1);
                e();
                return dVar;
            }
            return null;
        }
    }

    private void h() {
        if (this.c.compareAndSet(false, true)) {
            com.qiyukf.basesdk.a.g();
        }
    }

    public final c a(String str, String str2, Object obj, c cVar) {
        c cVar2 = new c(str, str2, obj, cVar);
        d g = g();
        if (g == null) {
            synchronized (this.d) {
                this.d.add(cVar2);
            }
            return cVar2;
        }
        cVar2.g = g;
        cVar2.run();
        return cVar2;
    }

    /* JADX WARNING: Missing block: B:10:0x0015, code skipped:
            if ((r3 instanceof com.qiyukf.basesdk.b.a.b.a.c) == false) goto L_0x001c;
     */
    /* JADX WARNING: Missing block: B:11:0x0017, code skipped:
            ((com.qiyukf.basesdk.b.a.b.a.c) r3).a();
     */
    /* JADX WARNING: Missing block: B:12:0x001c, code skipped:
            return;
     */
    public final void a(java.lang.Runnable r3) {
        /*
        r2 = this;
        r0 = r2.d;
        monitor-enter(r0);
        r1 = r2.d;	 Catch:{ all -> 0x001d }
        r1 = r1.contains(r3);	 Catch:{ all -> 0x001d }
        if (r1 == 0) goto L_0x0012;
    L_0x000b:
        r1 = r2.d;	 Catch:{ all -> 0x001d }
        r1.remove(r3);	 Catch:{ all -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        return;
    L_0x0012:
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        r0 = r3 instanceof com.qiyukf.basesdk.b.a.b.a.c;
        if (r0 == 0) goto L_0x001c;
    L_0x0017:
        r3 = (com.qiyukf.basesdk.b.a.b.a.c) r3;
        r3.a();
    L_0x001c:
        return;
    L_0x001d:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.b.a.a(java.lang.Runnable):void");
    }

    public final void a(List<d> list) {
        this.c.set(false);
        Iterator it;
        c cVar;
        if (list.size() != 0) {
            synchronized (this.b) {
                this.b.addAll(list);
                e();
            }
            synchronized (this.d) {
                while (this.d.size() > 0) {
                    it = this.d.iterator();
                    cVar = (c) it.next();
                    cVar.g = g();
                    if (cVar.g == null) {
                        h();
                        break;
                    } else {
                        cVar.run();
                        it.remove();
                    }
                }
            }
        } else if (this.b.size() == 0 && this.d.size() > 0) {
            synchronized (this.d) {
                for (c cVar2 : this.d) {
                    if (cVar2.e != null) {
                        cVar2.e.a(408);
                    }
                }
                this.d.clear();
            }
        }
    }

    public final void b() {
        synchronized (this.d) {
            this.d.clear();
        }
        this.c.set(false);
        com.qiyukf.basesdk.b.a.b.f.a.a();
    }

    public final void d() {
        synchronized (this.b) {
            this.b.clear();
        }
        h();
    }
}
