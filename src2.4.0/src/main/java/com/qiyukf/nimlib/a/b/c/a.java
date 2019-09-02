package com.qiyukf.nimlib.a.b.c;

import com.qiyukf.nimlib.a.b.g;
import com.qiyukf.nimlib.a.d.c.b;
import java.util.ArrayList;
import java.util.List;

public final class a extends g {
    public final void a(com.qiyukf.nimlib.a.d.a aVar) {
        b bVar = (b) aVar;
        if (bVar.b() && bVar.f().size() > 0) {
            List arrayList = new ArrayList(bVar.f().size());
            for (String str : bVar.f()) {
                com.qiyukf.nimlib.a.a aVar2 = new com.qiyukf.nimlib.a.a();
                aVar2.a(str);
                arrayList.add(aVar2);
            }
            com.qiyukf.nimlib.h.g.a(arrayList);
        }
        g.a(aVar, null);
    }
}
