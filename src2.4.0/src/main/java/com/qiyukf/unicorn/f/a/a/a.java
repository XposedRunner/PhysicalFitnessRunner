package com.qiyukf.unicorn.f.a.a;

import android.text.TextUtils;
import com.qiyukf.unicorn.a.a.a.a.c;
import com.qiyukf.unicorn.f.a.a.a.b;
import com.qiyukf.unicorn.f.a.a.a.d;
import com.qiyukf.unicorn.f.a.a.a.e;
import com.qiyukf.unicorn.f.a.a.a.f;
import com.qiyukf.unicorn.f.a.a.a.g;
import com.qiyukf.unicorn.f.a.a.a.h;
import com.qiyukf.unicorn.f.a.a.a.i;
import com.qiyukf.unicorn.f.a.a.a.j;
import com.qiyukf.unicorn.f.a.a.a.k;
import com.qiyukf.unicorn.f.a.a.a.l;
import com.qiyukf.unicorn.f.a.a.a.m;
import com.qiyukf.unicorn.f.a.a.a.n;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    private static a b;
    private Map<String, Class<? extends c>> a = new HashMap();

    private a() {
        a(g.class);
        a(k.class);
        a(j.class);
        a(m.class);
        a(b.class);
        a(com.qiyukf.unicorn.f.a.a.a.a.class);
        a(l.class);
        a(n.class);
        a(f.class);
        a(i.class);
        a(e.class);
        a(com.qiyukf.unicorn.f.a.a.a.c.class);
        a(d.class);
        a(com.qiyukf.unicorn.a.a.a.a.a.b.class);
        a(h.class);
        a(com.qiyukf.unicorn.a.a.a.a.b.b.class);
        a(com.qiyukf.unicorn.f.a.a.b.c.class);
        a(com.qiyukf.unicorn.f.a.a.b.a.class);
        a(com.qiyukf.unicorn.f.a.a.b.b.class);
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void a(Class<? extends c> cls) {
        com.qiyukf.unicorn.f.a.b.c cVar = (com.qiyukf.unicorn.f.a.b.c) cls.getAnnotation(com.qiyukf.unicorn.f.a.b.c.class);
        if (cVar != null) {
            this.a.put(cVar.a(), cls);
        }
    }

    public final c a(com.qiyukf.unicorn.a.a.a.a.a aVar) {
        try {
            if (TextUtils.equals(aVar.a(), "01")) {
                n nVar = new n();
                nVar.a(aVar.b());
                nVar.a(aVar);
                return nVar;
            }
            if (TextUtils.equals(aVar.a(), Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                JSONObject a = com.qiyukf.basesdk.c.b.a(aVar.b());
                Class cls = (Class) this.a.get(com.qiyukf.basesdk.c.b.e(a, "id"));
                if (cls != null) {
                    c cVar = (c) cls.newInstance();
                    cVar.fromJson(a);
                    cVar.a(aVar);
                    return cVar;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final c a(com.qiyukf.unicorn.a.a.a.a.b bVar) {
        try {
            JSONObject a = bVar.a();
            Class cls = (Class) this.a.get(com.qiyukf.basesdk.c.b.e(a, "id"));
            if (cls != null) {
                c cVar = (c) cls.newInstance();
                cVar.fromJson(a);
                cVar.a(bVar);
                return cVar;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
