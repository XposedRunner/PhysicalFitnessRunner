package com.qiyukf.basesdk.b.a.a;

import com.qiyukf.basesdk.c.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class f {
    private static f e;
    private final Object a = new Object();
    private Map<String, List<d>> b = new HashMap();
    private Map<String, g> c = new HashMap();
    private e d = new e("HttpDownloadManager", e.b, true);

    private class a implements Runnable {
        private String b;
        private String c;
        private long d;
        private a e;

        public a(String str, String str2, long j, a aVar) {
            this.b = str;
            this.c = str2;
            this.d = j;
            this.e = aVar;
        }

        public final void run() {
            try {
                f.a(f.this, this.b, this.c, this.d, this.e);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("Download exception: ");
                stringBuilder.append(th);
                com.qiyukf.basesdk.a.a.a("RES", stringBuilder.toString());
            }
        }
    }

    private f() {
    }

    public static f a() {
        if (e == null) {
            synchronized (f.class) {
                if (e == null) {
                    e = new f();
                }
            }
        }
        return e;
    }

    /* JADX WARNING: Missing block: B:10:0x0023, code skipped:
            r1.a.a(new com.qiyukf.basesdk.b.a.a.c.a.a(r4, r5).a(r8).a(r6).a());
            r5 = r3.a;
     */
    /* JADX WARNING: Missing block: B:11:0x003b, code skipped:
            monitor-enter(r5);
     */
    /* JADX WARNING: Missing block: B:14:0x0042, code skipped:
            if (r3.c.get(r4) != r1) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:15:0x0044, code skipped:
            r3.c.remove(r4);
            r3.b.remove(r4);
     */
    /* JADX WARNING: Missing block: B:16:0x004e, code skipped:
            monitor-exit(r5);
     */
    /* JADX WARNING: Missing block: B:17:0x004f, code skipped:
            a(r1);
     */
    /* JADX WARNING: Missing block: B:18:0x0052, code skipped:
            return;
     */
    static /* synthetic */ void a(com.qiyukf.basesdk.b.a.a.f r3, java.lang.String r4, java.lang.String r5, long r6, com.qiyukf.basesdk.b.a.a.a r8) {
        /*
        r0 = r3.a;
        monitor-enter(r0);
        r1 = r3.b;	 Catch:{ all -> 0x0058 }
        r1 = r1.containsKey(r4);	 Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0056;
    L_0x000b:
        r1 = r3.c;	 Catch:{ all -> 0x0058 }
        r1 = r1.containsKey(r4);	 Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0014;
    L_0x0013:
        goto L_0x0056;
    L_0x0014:
        r1 = new com.qiyukf.basesdk.b.a.a.g;	 Catch:{ all -> 0x0058 }
        r2 = com.qiyukf.basesdk.b.a.a.c.a();	 Catch:{ all -> 0x0058 }
        r1.<init>(r2);	 Catch:{ all -> 0x0058 }
        r2 = r3.c;	 Catch:{ all -> 0x0058 }
        r2.put(r4, r1);	 Catch:{ all -> 0x0058 }
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        r0 = new com.qiyukf.basesdk.b.a.a.c$a$a;
        r0.<init>(r4, r5);
        r5 = r0.a(r8);
        r5 = r5.a(r6);
        r5 = r5.a();
        r6 = r1.a;
        r6.a(r5);
        r5 = r3.a;
        monitor-enter(r5);
        r6 = r3.c;	 Catch:{ all -> 0x0053 }
        r6 = r6.get(r4);	 Catch:{ all -> 0x0053 }
        if (r6 != r1) goto L_0x004e;
    L_0x0044:
        r6 = r3.c;	 Catch:{ all -> 0x0053 }
        r6.remove(r4);	 Catch:{ all -> 0x0053 }
        r3 = r3.b;	 Catch:{ all -> 0x0053 }
        r3.remove(r4);	 Catch:{ all -> 0x0053 }
    L_0x004e:
        monitor-exit(r5);	 Catch:{ all -> 0x0053 }
        a(r1);
        return;
    L_0x0053:
        r3 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0053 }
        throw r3;
    L_0x0056:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0058:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.a.f.a(com.qiyukf.basesdk.b.a.a.f, java.lang.String, java.lang.String, long, com.qiyukf.basesdk.b.a.a.a):void");
    }

    private static void a(g gVar) {
        synchronized (gVar) {
            gVar.notifyAll();
        }
    }

    private void c(String str) {
        this.b.remove(str);
        g gVar = (g) this.c.get(str);
        if (gVar != null) {
            gVar.a.b();
            this.c.remove(str);
            a(gVar);
        }
    }

    /* Access modifiers changed, original: final */
    public final List<d> a(String str) {
        List list;
        synchronized (this.a) {
            list = (List) this.b.get(str);
        }
        return list;
    }

    public final void a(d dVar) {
        g gVar;
        String a = dVar.a();
        synchronized (this.a) {
            List list = (List) this.b.get(a);
            if (list == null) {
                list = new LinkedList();
                this.b.put(a, list);
            }
            if (!list.contains(dVar)) {
                list.add(dVar);
            }
            gVar = (g) this.c.get(a);
        }
        if (gVar == null) {
            String c = dVar.c();
            this.d.execute(new a(a, c, dVar.d(), new b(a, c)));
        }
    }

    /* Access modifiers changed, original: final */
    public final g b(String str) {
        g gVar;
        synchronized (this.a) {
            gVar = (g) this.c.get(str);
        }
        return gVar;
    }

    public final void b() {
        synchronized (this.a) {
            for (Object obj : this.b.keySet().toArray()) {
                List<d> list = (List) this.b.get(obj);
                if (list != null) {
                    for (d e : list) {
                        e.e();
                    }
                }
                c((String) obj);
            }
        }
    }

    public final void b(d dVar) {
        synchronized (this.a) {
            String a = dVar.a();
            List list = (List) this.b.get(a);
            if (list != null) {
                dVar.e();
                list.remove(dVar);
                if (list.size() == 0) {
                    c(a);
                }
            }
        }
    }
}
