package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.d.b.a;

final class k implements Runnable {
    final /* synthetic */ i a;
    private String b;
    private Bundle c;
    private int d;
    private Context e;

    public k(i iVar, Context context, String str, Bundle bundle, int i) {
        this.a = iVar;
        this.b = str;
        this.c = bundle;
        this.e = context;
        this.d = i;
    }

    public final void run() {
        if (this.d == 1) {
            i.a(this.a, this.b, this.c);
        } else if (a.c()) {
            this.a.c(this.e, this.b, this.c);
        } else {
            if (this.a.e) {
                i.a(this.a, this.b, this.c);
            }
        }
    }
}
