package cn.jiguang.d.d;

import android.content.Context;
import cn.jiguang.d.h.f;
import java.io.File;

final class t implements Runnable {
    final /* synthetic */ Context a;

    t(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            File[] a = f.a(p.e(this.a), true);
            if (a != null && a.length > 0) {
                for (File a2 : a) {
                    p.a(this.a, a2);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
