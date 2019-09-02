package com.ximalaya.ting.android.opensdk.auth.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

/* compiled from: NetworkUtil */
public final class c {
    private static NetworkInfo a(Context context, int i) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static boolean a(Context context) {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo e = e(context);
        return e != null && e.isConnected();
    }

    private static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo e = e(context);
        return e != null && 1 == e.getType() && e.isConnected();
    }

    private static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo e = e(context);
        return e != null && e != null && e.getType() == 0 && e.isConnected();
    }

    private static NetworkInfo e(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    private static int f(Context context) {
        if (context == null) {
            return -1;
        }
        NetworkInfo e = e(context);
        return e == null ? -1 : e.getType();
    }

    private static void g(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }
}
