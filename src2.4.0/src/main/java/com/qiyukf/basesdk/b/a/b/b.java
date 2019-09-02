package com.qiyukf.basesdk.b.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qiyukf.basesdk.a;
import com.qiyukf.basesdk.b.a.b.c.d;

public final class b {
    public static String a() {
        return b().getString("tokens", null);
    }

    public static void a(String str) {
        Editor edit = b().edit();
        edit.putString("tokens", str);
        edit.commit();
    }

    public static void a(String str, d dVar) {
        Editor edit = b().edit();
        StringBuilder stringBuilder = new StringBuilder("bo/");
        stringBuilder.append(str);
        edit.putString(stringBuilder.toString(), d.a(dVar));
        edit.commit();
    }

    public static void a(String str, String str2) {
        Editor edit = b().edit();
        StringBuilder stringBuilder = new StringBuilder("fc/");
        stringBuilder.append(str);
        edit.putString(stringBuilder.toString(), str2);
        edit.commit();
    }

    private static SharedPreferences b() {
        Context a = a.a();
        StringBuilder stringBuilder = new StringBuilder("NimSDK_NOS_");
        stringBuilder.append(a.b());
        return a.getSharedPreferences(stringBuilder.toString(), 0);
    }

    public static String b(String str) {
        SharedPreferences b = b();
        StringBuilder stringBuilder = new StringBuilder("fc/");
        stringBuilder.append(str);
        return b.getString(stringBuilder.toString(), null);
    }

    public static void c(String str) {
        Editor edit = b().edit();
        StringBuilder stringBuilder = new StringBuilder("fc/");
        stringBuilder.append(str);
        edit.remove(stringBuilder.toString());
        edit.commit();
    }

    public static d d(String str) {
        SharedPreferences b = b();
        StringBuilder stringBuilder = new StringBuilder("bo/");
        stringBuilder.append(str);
        str = b.getString(stringBuilder.toString(), null);
        return str == null ? null : d.e(str);
    }

    public static void e(String str) {
        Editor edit = b().edit();
        StringBuilder stringBuilder = new StringBuilder("bo/");
        stringBuilder.append(str);
        edit.remove(stringBuilder.toString());
        edit.commit();
    }
}
