package cn.jiguang.d.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.e.c;
import cn.jiguang.g.a;
import cn.jpush.android.service.PushService;

public final class i {
    private static final Object c = new Object();
    private static volatile i d;
    private boolean a;
    private Context b;
    private boolean e;

    public static i a() {
        if (d == null) {
            synchronized (c) {
                if (d == null) {
                    d = new i();
                }
            }
        }
        return d;
    }

    private boolean a(Context context) {
        if (this.a) {
            return true;
        }
        if (context == null) {
            c.d("JServiceCommandHelper", "init failed");
            return false;
        }
        this.b = context.getApplicationContext();
        if (!a.q(cn.jiguang.d.a.d)) {
            cn.jiguang.d.b.a.a = 0;
        }
        this.e = cn.jiguang.d.b.a.b(this.b);
        this.a = true;
        return true;
    }

    private static boolean a(String str, Bundle bundle) {
        try {
            if (!cn.jiguang.g.a.a.c()) {
                return false;
            }
            cn.jiguang.g.a.a.b().a(str, bundle);
            return true;
        } catch (Throwable th) {
            c.a("JServiceCommandHelper", "remote call failed", th);
            return false;
        }
    }

    private static String b(Context context) {
        String str = cn.jiguang.d.a.c;
        if (TextUtils.isEmpty(str) && context != null) {
            str = context.getPackageName();
        }
        return str == null ? "" : str;
    }

    public final void a(Context context, String str, Bundle bundle) {
        try {
            Context a = cn.jiguang.d.a.a(context);
            if (a(a)) {
                JCoreInterface.execute("ACTION", new k(this, a, str, bundle, 1), new int[0]);
            }
        } catch (Throwable th) {
            c.c("JServiceCommandHelper", "callAction failed", th);
        }
    }

    public final void b(Context context, String str, Bundle bundle) {
        try {
            context = cn.jiguang.d.a.a(context);
            if (a(context)) {
                JCoreInterface.execute("SDK_MAIN", new j(this, context, str, bundle), new int[0]);
            }
        } catch (Throwable th) {
            c.c("JServiceCommandHelper", "onAction failed", th);
        }
    }

    public final boolean c(Context context, String str, Bundle bundle) {
        if (!a(str, bundle)) {
            try {
                Intent intent = new Intent(context, PushService.class);
                intent.setAction(str);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                context.startService(intent);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("throwable ,cant start service");
                stringBuilder.append(th.getMessage());
                stringBuilder.append(", will use aidl to do action");
                c.c("JServiceCommandHelper", stringBuilder.toString());
                return false;
            }
        }
        return true;
    }
}
