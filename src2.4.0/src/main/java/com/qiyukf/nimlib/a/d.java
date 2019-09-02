package com.qiyukf.nimlib.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.qiyukf.nimlib.b;

public final class d {
    public static int a() {
        return (int) c().getLong("k_sys_msg_unread_c", 0);
    }

    public static void a(int i) {
        long j = (long) i;
        com.qiyukf.basesdk.c.d.a(c(), "k_sys_msg_unread_c", j);
    }

    public static void a(String str) {
        com.qiyukf.basesdk.c.d.a(c(), "k_client_ip", str);
    }

    public static String b() {
        return c().getString("k_client_ip", null);
    }

    private static SharedPreferences c() {
        Context a = b.a();
        StringBuilder stringBuilder = new StringBuilder("NIMSDK_Config_");
        stringBuilder.append(b.g());
        stringBuilder.append("_");
        stringBuilder.append(b.b());
        return a.getSharedPreferences(stringBuilder.toString(), 0);
    }
}
