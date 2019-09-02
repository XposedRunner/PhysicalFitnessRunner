package com.qiyukf.nimlib.a.d.c;

import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.h.c.c.f;
import java.util.ArrayList;
import java.util.List;

@com.qiyukf.nimlib.a.d.b(a = (byte) 2, b = {"8"})
public class b extends a {
    private List<String> b;

    public final f a(f fVar) {
        int f = fVar.f();
        ArrayList arrayList = new ArrayList(f);
        for (int i = 0; i < f; i++) {
            arrayList.add(fVar.a("utf-8"));
        }
        this.b = arrayList;
        return null;
    }

    public final List<String> f() {
        return this.b;
    }
}
