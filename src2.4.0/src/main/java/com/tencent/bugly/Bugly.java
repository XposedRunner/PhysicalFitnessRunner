package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
public class Bugly {
    public static final String SDK_IS_DEV = "false";
    private static boolean a = false;
    public static Context applicationContext = null;
    private static String[] b = new String[]{"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};
    private static String[] c = new String[]{"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static synchronized String getAppChannel() {
        synchronized (Bugly.class) {
            a b = a.b();
            if (b == null) {
                return null;
            }
            String str;
            if (TextUtils.isEmpty(b.l)) {
                p a = p.a();
                if (a == null) {
                    str = b.l;
                    return str;
                }
                Map a2 = a.a(556, null, true);
                if (a2 != null) {
                    byte[] bArr = (byte[]) a2.get("app_channel");
                    if (bArr != null) {
                        str = new String(bArr);
                        return str;
                    }
                }
            }
            str = b.l;
            return str;
        }
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (a) {
                return;
            }
            a = true;
            context = z.a(context);
            applicationContext = context;
            if (context == null) {
                Log.e(x.a, "init arg 'context' should not be null!");
                return;
            }
            if (isDev()) {
                b = c;
            }
            for (String str2 : b) {
                try {
                    if (str2.equals("BuglyCrashModule")) {
                        b.a(CrashModule.getInstance());
                    } else if (!(str2.equals("BuglyBetaModule") || str2.equals("BuglyRqdModule"))) {
                        str2.equals("BuglyFeedbackModule");
                    }
                } catch (Throwable th) {
                    x.b(th);
                }
            }
            b.a = enable;
            b.a(applicationContext, str, z, buglyStrategy);
        }
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean(SDK_IS_DEV.replace("@", "")));
        }
        return isDev.booleanValue();
    }
}
