package com.qiyukf.basesdk;

import android.content.Context;
import com.qiyukf.basesdk.sdk.ServerAddresses;

public final class a {
    private static Context a;
    private static b b;

    public static Context a() {
        return a;
    }

    public static void a(Context context, b bVar) {
        a = context.getApplicationContext();
        b = bVar;
    }

    public static String b() {
        return b.a();
    }

    public static int c() {
        return b.b();
    }

    public static ServerAddresses d() {
        return b.c();
    }

    public static String e() {
        return b.d();
    }

    public static String f() {
        return b.e();
    }

    public static void g() {
        b.f();
    }
}
