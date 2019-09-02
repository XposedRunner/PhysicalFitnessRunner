package cn.jpush.android.service;

import cn.jpush.android.data.d;
import cn.jpush.android.data.e;

final class c implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ a b;

    c(a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    public final void run() {
        try {
            d a = d.a(this.b.d);
            e a2 = a.a(this.a, 0);
            if (a2 != null) {
                if (a2.c() == 1) {
                    a.b(a2.a(), 0, 1, 0, a2.d(), a2.f(), a2.e());
                } else if (a2.b() > 1) {
                    a.b(a2.a(), a2.b() - 1, 0, 0, a2.d(), a2.f(), a2.e());
                } else if (a2.b() == 1) {
                    if (a2.f() <= System.currentTimeMillis()) {
                        this.b.a(this.b.d, a2.d(), this.b.e, "");
                        a.b(a2.a(), 0, 0, 0, a2.d(), a2.f(), a2.e());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
