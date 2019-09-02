package com.qiyukf.nimlib.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.d;
import com.qiyukf.nimlib.b;
import java.util.UUID;

public final class e {
    public static String a() {
        String d = d("k_s_did");
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        d = UUID.randomUUID().toString();
        a("k_s_did", d);
        return d;
    }

    public static void a(String str) {
        a("k_default_link", str);
    }

    private static void a(String str, String str2) {
        d.a(e(), str, str2);
    }

    public static String b() {
        return d("k_default_link");
    }

    public static void b(String str) {
        a("k_default_link_test", str);
    }

    public static String c() {
        return d("k_default_link_test");
    }

    public static void c(String str) {
        a("k_default_link_pre", str);
    }

    public static String d() {
        return d("k_default_link_pre");
    }

    private static String d(String str) {
        return e().getString(str, null);
    }

    private static SharedPreferences e() {
        Context a = b.a();
        StringBuilder stringBuilder = new StringBuilder("NIMSDK_Config_");
        stringBuilder.append(b.g());
        return a.getSharedPreferences(stringBuilder.toString(), 0);
    }
}
