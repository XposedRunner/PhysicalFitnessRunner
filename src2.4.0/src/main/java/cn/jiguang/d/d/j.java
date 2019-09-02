package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.a;

final class j implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ i d;

    j(i iVar, Context context, String str, Bundle bundle) {
        this.d = iVar;
        this.a = context;
        this.b = str;
        this.c = bundle;
    }

    public final void run() {
        try {
            if (a.d(this.a)) {
                String a = i.a(this.a, this.b);
                if (cn.jiguang.d.b.a.c()) {
                    this.d.c(this.a, a, this.c);
                } else {
                    JCoreInterface.execute("ACTION", new k(this.d, this.a, a, this.c, 0), new int[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
