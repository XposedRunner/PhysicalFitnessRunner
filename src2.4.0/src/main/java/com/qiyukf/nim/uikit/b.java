package com.qiyukf.nim.uikit;

import android.content.Context;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;

public final class b {
    private static Context a;
    private static String b;
    private static com.qiyukf.nim.uikit.session.b c;

    public static Context a() {
        return a;
    }

    public static void a(Context context, UserInfoProvider userInfoProvider) {
        a = context.getApplicationContext();
        com.qiyukf.nimlib.b.d().userInfoProvider = userInfoProvider;
        a.a(context);
    }

    public static void a(String str) {
        b = str;
    }

    public static String b() {
        return b;
    }

    public static com.qiyukf.nim.uikit.session.b c() {
        return c;
    }
}
