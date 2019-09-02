package com.qiyukf.nimlib.d.a.b;

import android.util.Log;

public final class a {
    public static boolean a;

    public static void a(String str) {
        if (a) {
            Log.i("dc_framework", str);
        }
    }

    public static void b(String str) {
        if (a) {
            Log.i("dc_info", str);
        }
    }

    public static void c(String str) {
        if (a) {
            Log.e("dc_error", str);
        }
    }

    public static void d(String str) {
        if (a) {
            Log.i("dc_http", str);
        }
    }

    public static void e(String str) {
        if (a) {
            Log.i("dc_server", str);
        }
    }

    public static void f(String str) {
        if (a) {
            Log.i("dc_watcher", str);
        }
    }
}
