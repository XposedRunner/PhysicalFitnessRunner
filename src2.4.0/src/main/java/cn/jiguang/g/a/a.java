package cn.jiguang.g.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import cn.jiguang.b.b;
import cn.jiguang.d.b.d;
import cn.jiguang.d.d.i;
import cn.jiguang.e.c;

public final class a extends b {
    private static boolean a;
    private static cn.jiguang.b.a b;
    private static final DeathRecipient c = new b();

    public static void a(cn.jiguang.b.a aVar) {
        if (aVar != b) {
            if (b != null) {
                try {
                    b.asBinder().unlinkToDeath(c, 0);
                } catch (Throwable unused) {
                }
            }
            b = aVar;
            try {
                b.asBinder().linkToDeath(c, 0);
            } catch (Throwable unused2) {
            }
        }
        a = false;
    }

    public static cn.jiguang.b.a b() {
        return b;
    }

    public static boolean c() {
        return b != null;
    }

    public static boolean d() {
        return a;
    }

    public static void e() {
        a = true;
    }

    public final IBinder a(String str, String str2) {
        cn.jiguang.d.d.b.a();
        return cn.jiguang.d.d.b.c(str, str2);
    }

    public final void a(String str, Bundle bundle) {
        if (!(str == null || bundle == null)) {
            try {
                i.a().a(cn.jiguang.d.a.d, str, bundle);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("onAction error:");
                stringBuilder.append(th.getMessage());
                c.c("DataShare", stringBuilder.toString());
            }
        }
    }

    public final boolean a() {
        d.a();
        return d.d();
    }
}
