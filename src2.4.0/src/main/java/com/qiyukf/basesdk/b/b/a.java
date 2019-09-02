package com.qiyukf.basesdk.b.b;

import android.util.SparseArray;
import com.qiyukf.basesdk.b.b.a.c;
import com.qiyukf.basesdk.b.b.a.e;
import com.qiyukf.basesdk.b.b.a.k;
import com.qiyukf.basesdk.b.b.c.f;

public final class a {
    private final SparseArray<Object> a = new SparseArray();
    private long b;
    private e c;
    private f d = new f();

    public final c a(String str, int i) {
        return new k(this.d).a().a(str, i, this.a, this.c, this.b);
    }

    public final a a() {
        this.b = StatisticConfig.MIN_UPLOAD_INTERVAL;
        return this;
    }

    public final <T> a a(int i, T t) {
        if (t == null) {
            synchronized (this.a) {
                this.a.remove(i);
            }
            return this;
        }
        synchronized (this.a) {
            this.a.put(i, t);
        }
        return this;
    }

    public final a a(e eVar) {
        this.c = eVar;
        return this;
    }

    public final void b() {
        if (this.d != null) {
            this.d.i();
        }
    }
}
