package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.umeng.commonsdk.internal.utils.e.a;
import java.io.File;

/* compiled from: Root */
public class h {
    public static boolean a() {
        return b() || c() || d() || e();
    }

    private static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c A:{RETURN} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* JADX WARNING: Failed to process nested try/catch */
    private static boolean c() {
        /*
        r0 = 1;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x000f }
        r2 = "/system/app/Superuser.apk";
        r1.<init>(r2);	 Catch:{ Exception -> 0x000f }
        r1 = r1.exists();	 Catch:{ Exception -> 0x000f }
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x001d }
        r2 = "/system/app/Kinguser.apk";
        r1.<init>(r2);	 Catch:{ Exception -> 0x001d }
        r1 = r1.exists();	 Catch:{ Exception -> 0x001d }
        if (r1 == 0) goto L_0x001d;
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.h.c():boolean");
    }

    private static boolean d() {
        return new e().a(a.check_su_binary) != null;
    }

    private static boolean e() {
        for (String str : new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("su");
            if (new File(stringBuilder.toString()).exists()) {
                return true;
            }
        }
        return false;
    }
}
