package com.qiyukf.nimlib.b;

import android.text.TextUtils;

abstract class a {
    boolean a = false;
    boolean b = true;
    boolean c = true;
    boolean d = true;

    a() {
    }

    private static String a(boolean z) {
        return z ? "1" : "0";
    }

    private static boolean a(String str) {
        return !"0".equals(str);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, String str2) {
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(str)) {
            str = d();
            stringBuilder = new StringBuilder("read sdk config from ");
            stringBuilder.append(str2);
            stringBuilder.append(", but get null");
            com.qiyukf.basesdk.a.a.a(str, stringBuilder.toString());
            return;
        }
        String[] split = str.split(",");
        if (split.length == 4) {
            this.a = a(split[0]);
            this.b = a(split[1]);
            this.c = a(split[2]);
            this.d = a(split[3]);
            str = d();
            stringBuilder = new StringBuilder("read sdk config from ");
            stringBuilder.append(str2);
            stringBuilder.append(", ");
            stringBuilder.append(toString());
            com.qiyukf.basesdk.a.a.a(str, stringBuilder.toString());
        }
    }

    public boolean a() {
        return this.b;
    }

    public abstract String b();

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(this.a));
        stringBuilder.append(",");
        stringBuilder.append(a(this.b));
        stringBuilder.append(",");
        stringBuilder.append(a(this.c));
        stringBuilder.append(",");
        stringBuilder.append(a(this.d));
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: final */
    public final String d() {
        StringBuilder stringBuilder = new StringBuilder("sdk_config_");
        stringBuilder.append(b());
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("sdk config=[");
        stringBuilder.append(c());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
