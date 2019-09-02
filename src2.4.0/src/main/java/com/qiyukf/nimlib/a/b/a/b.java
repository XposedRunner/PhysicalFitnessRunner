package com.qiyukf.nimlib.a.b.a;

import com.qiyukf.nimlib.a.b.g;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.a.d.a;

public final class b extends g {
    public final void a(a aVar) {
        if (aVar.b()) {
            com.qiyukf.nimlib.a.c.a.b bVar = (com.qiyukf.nimlib.a.c.a.b) c.a().a(aVar);
            int f = bVar.f();
            String g = bVar.g();
            if (f == 1) {
                com.qiyukf.nimlib.j.a.a();
                com.qiyukf.nimlib.j.a.a(g);
            }
            StringBuilder stringBuilder = new StringBuilder("report stat success, type=");
            stringBuilder.append(f);
            stringBuilder.append(", md5=");
            stringBuilder.append(g);
            com.qiyukf.basesdk.a.a.b("stat", stringBuilder.toString());
        }
    }
}
