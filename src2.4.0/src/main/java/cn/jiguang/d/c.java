package cn.jiguang.d;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.a.a.c.e;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.a.d;
import cn.jiguang.d.b.a;
import cn.jiguang.d.d.x;

public final class c implements Runnable {
    public final Context a;
    public final int b;

    public c(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    public final void run() {
        e a;
        switch (this.b) {
            case 0:
                a.e(this.a);
                break;
            case 1:
                break;
            case 2:
                if (a.d(this.a)) {
                    a = e.a();
                    Context context = this.a;
                    if (!a.a) {
                        a.a = true;
                        d.a(a.a(context), true);
                    }
                    return;
                }
                break;
            case 3:
                if (a.d(this.a)) {
                    a = e.a();
                    Context context2 = this.a;
                    if (a.a) {
                        a.a = false;
                        d.a(a.a(context2), false);
                        return;
                    }
                }
                break;
            default:
                return;
        }
        Context context3 = this.a;
        a.b();
        if (cn.jiguang.g.a.q(context3)) {
            a.a(context3, false);
        }
        x.a(context3);
        Bundle bundle = new Bundle();
        bundle.putString("action", "cn.jpush.android.intent.REPORT");
        bundle.putString("report", "crash_log");
        bundle.putString("report.extra.info", "");
        JCoreInterface.sendAction(context3, a.a, bundle);
    }
}
