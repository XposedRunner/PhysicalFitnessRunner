package com.qiyukf.nimlib.i;

import com.qiyukf.basesdk.b.a.a.f;
import com.qiyukf.basesdk.b.a.b.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b {
    private static b d = new b();
    private Set<String> a = Collections.synchronizedSet(new HashSet());
    private Set<String> b = Collections.synchronizedSet(new HashSet());
    private e c = new e();

    private b() {
    }

    public static b a() {
        return d;
    }

    public final void a(String str) {
        this.a.add(str);
    }

    public final void b() {
        f.a().b();
        a.a().b();
        com.qiyukf.nimlib.g.b.a();
        this.a.clear();
        this.b.clear();
    }

    public final void b(String str) {
        this.a.remove(str);
    }

    public final e c() {
        return this.c;
    }

    public final boolean c(String str) {
        return this.a.contains(str);
    }

    public final void d(String str) {
        this.b.add(str);
    }

    public final void e(String str) {
        this.b.remove(str);
    }

    public final boolean f(String str) {
        return this.b.contains(str);
    }
}
