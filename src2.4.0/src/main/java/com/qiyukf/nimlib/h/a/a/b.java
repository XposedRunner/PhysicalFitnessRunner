package com.qiyukf.nimlib.h.a.a;

import com.qiyukf.nimlib.a.b.a;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.d;
import com.qiyukf.nimlib.h.a.b.e;
import com.qiyukf.nimlib.h.f;
import com.qiyukf.nimlib.h.g;
import com.qiyukf.nimlib.sdk.StatusCode;
import java.util.ArrayList;

public class b extends a {
    private static final String a = "b";
    private final boolean b;

    public b(boolean z) {
        this.b = z;
    }

    public final void a(com.qiyukf.nimlib.a.d.a aVar) {
        if (this.b) {
            com.qiyukf.nimlib.h.a.c.b bVar = (com.qiyukf.nimlib.h.a.c.b) aVar;
            if (d.e() == StatusCode.LOGINING) {
                f.a().a(bVar.e());
                if (bVar.b()) {
                    com.qiyukf.nimlib.a.d.a(bVar.f().a(103));
                    com.qiyukf.nimlib.h.c.b.b bVar2 = new com.qiyukf.nimlib.h.c.b.b();
                    bVar2.a(com.qiyukf.nimlib.a.a.a.a.UNREAD_MESSAGE.a(), 0);
                    bVar2.a(com.qiyukf.nimlib.a.a.a.a.YSF_UNREAD_MSG.a(), 0);
                    com.qiyukf.nimlib.a.c.a eVar = new e();
                    eVar.a(bVar2);
                    f.a().a(eVar);
                }
                ArrayList g = bVar.g();
                if (g == null || g.size() <= 0) {
                    g.a();
                } else {
                    g.a(g);
                    return;
                }
            }
            return;
        }
        c.a().a(aVar.e());
    }
}
