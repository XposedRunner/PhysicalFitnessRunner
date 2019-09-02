package cn.jiguang.a;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import cn.jiguang.api.JAnalyticsAction;

public final class a {
    public static JAnalyticsAction a = null;
    public static boolean b = true;
    private static boolean c;

    public static void a(Context context) {
        if (!c) {
            try {
                if (VERSION.SDK_INT >= 14 && (context instanceof Application)) {
                    String c = cn.jiguang.d.b.a.c(context);
                    String packageName = context.getPackageName();
                    if (!(c == null || packageName == null || !context.getPackageName().equals(c))) {
                        b = false;
                        ((Application) context).registerActivityLifecycleCallbacks(new cn.jiguang.a.a.d.a());
                    }
                }
            } catch (Throwable unused) {
                b = true;
            }
            c = true;
        }
    }
}
