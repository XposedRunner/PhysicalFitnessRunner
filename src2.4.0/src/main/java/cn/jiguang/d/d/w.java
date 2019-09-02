package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.d.a;
import java.util.Iterator;
import java.util.LinkedHashSet;

final class w implements Runnable {
    private final Context a;

    private w(Context context) {
        this.a = context;
    }

    /* synthetic */ w(Context context, byte b) {
        this(context);
    }

    public final void run() {
        try {
            String jSONObject = v.a(this.a).f().toString();
            LinkedHashSet b = v.c(this.a);
            b.addAll(a.f.h());
            if (cn.jiguang.g.a.d(this.a)) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!TextUtils.isEmpty(str) && v.b(this.a, str, jSONObject)) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
