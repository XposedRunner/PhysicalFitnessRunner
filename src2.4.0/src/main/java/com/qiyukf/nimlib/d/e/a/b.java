package com.qiyukf.nimlib.d.e.a;

import android.content.Context;
import android.os.Build.VERSION;

public final class b {

    public interface a {
        void a();

        void b();
    }

    public static void a(Context context) {
        if (a()) {
            a.a(context);
        }
    }

    public static void a(a aVar) {
        if (a()) {
            a.a(aVar);
        }
    }

    private static boolean a() {
        return VERSION.SDK_INT >= 14;
    }

    public static void b(Context context) {
        a.b(context);
    }

    public static void b(a aVar) {
        if (a()) {
            a.b(aVar);
        }
    }
}
