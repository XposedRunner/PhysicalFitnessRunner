package cn.jiguang.a.a.c;

import android.content.Context;
import cn.jiguang.api.a;
import cn.jiguang.d.a.d;

final class c implements a {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final void a(int i) {
        if (i == 0) {
            b.a(this.a, this.b);
            d.a(this.a, "last_report_device_info", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
