package com.qiyukf.nimlib;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.d.e;
import com.qiyukf.nimlib.a.a;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.service.NimService;
import java.util.ArrayList;

public final class d {
    private static StatusCode a = StatusCode.UNLOGIN;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static String e = "";
    private static int f;
    private static int g;
    private static ArrayList<a> h;

    public static void a(int i) {
        g = i;
    }

    public static void a(Context context) {
        String str = context.getApplicationInfo().processName;
        String b = b(context);
        String a = e.a(context);
        if (TextUtils.equals(a, str)) {
            b(1);
        }
        if (TextUtils.equals(a, b)) {
            b(2);
        }
    }

    public static void a(StatusCode statusCode) {
        a = statusCode;
    }

    public static void a(String str) {
        e = str;
    }

    public static void a(ArrayList<a> arrayList) {
        h = arrayList;
    }

    public static final void a(boolean z) {
        b = z;
    }

    public static final boolean a() {
        return b;
    }

    private static String b(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, NimService.class), 128).processName;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    private static void b(int i) {
        f = i | f;
    }

    public static final void b(boolean z) {
        c = z;
    }

    public static final boolean b() {
        return c;
    }

    public static final void c(boolean z) {
        d = z;
    }

    public static final boolean c() {
        return d;
    }

    public static String d() {
        return e;
    }

    public static StatusCode e() {
        return a;
    }

    public static boolean f() {
        return (f & 1) != 0;
    }

    public static boolean g() {
        return (f & 2) != 0;
    }

    public static int h() {
        return g;
    }

    public static ArrayList<a> i() {
        return h;
    }
}
