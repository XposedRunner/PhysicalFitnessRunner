package cn.jiguang.a.a.c;

import android.content.Context;
import cn.jiguang.api.a;
import cn.jiguang.d.d.x;
import org.json.JSONObject;

final class f extends Thread implements a {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void a(int i) {
        if (i == 0) {
            e.a(cn.jiguang.d.a.a(null));
        }
    }

    public final void run() {
        try {
            Context a = cn.jiguang.d.a.a(null);
            if (a != null) {
                JSONObject a2 = e.c(a);
                if (a2 != null) {
                    x.a(a, a2, (a) this);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
