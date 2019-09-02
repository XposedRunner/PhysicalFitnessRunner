package com.qiyukf.nimlib.c;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.nimlib.b;

public final class c {
    private static c b = new c();
    private a a;

    public static c a() {
        return b;
    }

    public final synchronized boolean a(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.g());
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(str);
        str = stringBuilder.toString();
        String str2 = b.d().databaseEncryptKey;
        if (this.a == null || !this.a.b()) {
            this.a = new a(context, str);
        }
        return b();
    }

    public final boolean b() {
        return this.a != null && this.a.b();
    }

    public final synchronized void c() {
        if (this.a != null) {
            this.a.c();
            this.a = null;
        }
    }

    public final a d() {
        if (this.a != null) {
            return this.a;
        }
        throw new IllegalStateException("MsgDatabase is not opened. Please login first!");
    }
}
