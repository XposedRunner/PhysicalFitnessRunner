package com.qiyukf.unicorn.f.a;

import android.util.SparseArray;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.f.a.d.a;
import com.qiyukf.unicorn.f.a.d.b;
import com.qiyukf.unicorn.f.a.d.g;
import com.qiyukf.unicorn.f.a.d.i;
import com.qiyukf.unicorn.f.a.d.k;
import com.qiyukf.unicorn.f.a.d.l;
import com.qiyukf.unicorn.f.a.d.m;
import com.qiyukf.unicorn.f.a.d.o;
import com.qiyukf.unicorn.f.a.d.r;
import com.qiyukf.unicorn.f.a.d.s;
import com.qiyukf.unicorn.f.a.d.t;
import com.qiyukf.unicorn.f.a.e.c;
import com.qiyukf.unicorn.f.a.e.d;
import com.qiyukf.unicorn.f.a.e.e;
import com.qiyukf.unicorn.f.a.e.h;
import com.qiyukf.unicorn.f.a.e.j;
import com.qiyukf.unicorn.f.a.e.n;
import com.qiyukf.unicorn.f.a.e.p;
import com.qiyukf.unicorn.f.a.e.q;
import org.json.JSONObject;

public final class f implements MsgAttachmentParser {
    private static f b;
    private final SparseArray<Class<? extends d>> a = new SparseArray();

    private f() {
        a(a.class);
        a(j.class);
        a(e.class);
        a(k.class);
        a(com.qiyukf.unicorn.f.a.d.f.class);
        a(c.class);
        a(i.class);
        a(n.class);
        a(o.class);
        a(h.class);
        a(p.class);
        a(ProductAttachment.class);
        a(g.class);
        a(t.class);
        a(com.qiyukf.unicorn.f.a.e.a.class);
        a(b.class);
        a(com.qiyukf.unicorn.f.a.d.h.class);
        a(com.qiyukf.unicorn.f.a.d.c.class);
        a(m.class);
        a(q.class);
        a(r.class);
        a(com.qiyukf.unicorn.f.a.d.n.class);
        a(com.qiyukf.unicorn.f.a.d.q.class);
        a(com.qiyukf.unicorn.f.a.d.p.class);
        a(com.qiyukf.unicorn.a.a.a.a.a.class);
        a(com.qiyukf.unicorn.a.a.a.a.b.class);
        a(com.qiyukf.unicorn.f.a.a.c.class);
        a(com.qiyukf.unicorn.f.a.a.b.class);
        a(d.class);
        a(com.qiyukf.unicorn.f.a.d.d.class);
        a(l.class);
        a(s.class);
        a(com.qiyukf.unicorn.f.a.e.k.class);
        a(com.qiyukf.unicorn.f.a.d.j.class);
        a(com.qiyukf.unicorn.f.a.e.o.class);
        a(com.qiyukf.unicorn.f.a.d.e.class);
    }

    public static f a() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    private void a(Class<? extends d> cls) {
        com.qiyukf.unicorn.f.a.b.b bVar = (com.qiyukf.unicorn.f.a.b.b) cls.getAnnotation(com.qiyukf.unicorn.f.a.b.b.class);
        if (bVar != null) {
            this.a.put(bVar.a(), cls);
        }
    }

    /* renamed from: a */
    public final d parse(String str) {
        try {
            JSONObject a = com.qiyukf.basesdk.c.b.a(str);
            Class cls = (Class) this.a.get(com.qiyukf.basesdk.c.b.b(a, "cmd"));
            if (cls != null) {
                e eVar = (e) cls.newInstance();
                eVar.fromJson(a);
                if (eVar instanceof com.qiyukf.unicorn.a.a.a.a.a) {
                    return com.qiyukf.unicorn.f.a.a.a.a().a((com.qiyukf.unicorn.a.a.a.a.a) eVar);
                } else if (!(eVar instanceof com.qiyukf.unicorn.a.a.a.a.b)) {
                    return eVar;
                } else {
                    return com.qiyukf.unicorn.f.a.a.a.a().a((com.qiyukf.unicorn.a.a.a.a.b) eVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
