package com.qiyukf.nimlib.a.b;

import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.e.i;
import java.io.Serializable;

public abstract class g extends a {
    protected static void a(a aVar, Serializable serializable) {
        com.qiyukf.nimlib.a.c.a a = c.a().a(aVar);
        if (a != null && a.e() != null && (a.e() instanceof i)) {
            i iVar = (i) a.e();
            iVar.a(aVar.e());
            iVar.a((Object) serializable);
            com.qiyukf.nimlib.e.a.c(iVar);
        }
    }
}
