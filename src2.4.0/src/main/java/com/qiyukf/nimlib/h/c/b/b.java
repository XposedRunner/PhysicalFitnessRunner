package com.qiyukf.nimlib.h.c.b;

import android.util.SparseArray;
import com.qiyukf.nimlib.h.c.c.f;

public final class b implements a {
    public SparseArray<String> a = new SparseArray();

    public final String a(int i) {
        return (String) this.a.get(i);
    }

    public final void a(int i, int i2) {
        this.a.put(i, String.valueOf(i2));
    }

    public final void a(int i, String str) {
        if (str != null) {
            this.a.put(i, str);
        }
    }

    public final void a(com.qiyukf.nimlib.h.c.c.b bVar) {
        bVar.b(this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            bVar.b(this.a.keyAt(i));
            bVar.a((String) this.a.valueAt(i));
        }
    }

    public final void a(f fVar) {
        int f = fVar.f();
        for (int i = 0; i < f; i++) {
            a(fVar.f(), fVar.a("utf-8"));
        }
    }

    public final int b(int i) {
        String str = (String) this.a.get(i);
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final long c(int i) {
        String str = (String) this.a.get(i);
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
