package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;

final class r extends s {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    r(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    /* Access modifiers changed, original: final */
    public final ExecutorService a() {
        return v.a(this.a, this.b, this.c);
    }
}
