package com.qiyukf.basesdk.b.a.a;

import android.os.Handler;
import com.qiyukf.basesdk.c.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class b implements a {
    private static final Handler a = a.b();
    private String b;
    private String c;
    private long d = 0;

    b(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    private void a(final Runnable runnable) {
        a.post(new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("download listener exception: ");
                    stringBuilder.append(th.getMessage());
                    com.qiyukf.basesdk.a.a.a("RES", stringBuilder.toString());
                }
            }
        });
    }

    private synchronized void a(List<d> list) {
        HashSet<String> hashSet = new HashSet();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashSet.add(((d) list.get(i2)).b());
        }
        for (String str : hashSet) {
            i++;
            if (i == hashSet.size()) {
                com.qiyukf.basesdk.b.a.c.a.b(this.c, str);
            } else {
                com.qiyukf.basesdk.b.a.c.a.a(this.c, str);
            }
        }
    }

    private static List<d> c(String str) {
        List a = f.a().a(str);
        return a == null ? null : new ArrayList(a);
    }

    public final void a(String str) {
        final List c = c(str);
        if (c != null) {
            a(new Runnable() {
                public final void run() {
                    Iterator it = c.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    public final void a(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d >= 200) {
            final List c = c(str);
            if (c != null) {
                this.d = currentTimeMillis;
                final long j2 = j;
                final String str2 = str;
                a(new Runnable() {
                    public final void run() {
                        for (d dVar : c) {
                            if (!(dVar.f() || dVar.g() == null)) {
                                dVar.g().a(j2);
                            }
                        }
                        g b = f.a().b(str2);
                        if (b != null) {
                            b.b = j2;
                        }
                    }
                });
            }
        }
    }

    public final void a(String str, final String str2) {
        final List c = c(str);
        if (c != null) {
            a(new Runnable() {
                public final void run() {
                    for (d dVar : c) {
                        if (!(dVar.f() || dVar.g() == null)) {
                            dVar.g().b();
                        }
                    }
                }
            });
        }
    }

    public final void b(String str) {
        final List c = c(str);
        if (c != null) {
            a(c);
            a(new Runnable() {
                public final void run() {
                    for (d dVar : c) {
                        if (!(dVar.f() || dVar.g() == null)) {
                            dVar.g().a();
                        }
                    }
                }
            });
        }
    }

    public final void b(String str, final long j) {
        final List c = c(str);
        if (c != null) {
            a(new Runnable() {
                public final void run() {
                    for (d dVar : c) {
                        if (!(dVar.f() || dVar.g() == null)) {
                            dVar.g().b(j);
                        }
                    }
                }
            });
        }
    }
}
