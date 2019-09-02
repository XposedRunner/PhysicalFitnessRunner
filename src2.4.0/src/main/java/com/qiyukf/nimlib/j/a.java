package com.qiyukf.nimlib.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.qiyukf.basesdk.c.d;
import com.qiyukf.basesdk.c.d.c;
import com.qiyukf.nimlib.b;

public final class a {
    private Handler a;

    private static class a {
        private static final a a = new a();
    }

    private a() {
        this.a = com.qiyukf.basesdk.c.a.a().a("MISC");
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return a.a;
    }

    public static void a(String str) {
        d.a(b(), "stat_md5_1", str);
        long currentTimeMillis = System.currentTimeMillis();
        d.a(b(), "stat_time_1", currentTimeMillis);
    }

    private static SharedPreferences b() {
        Context a = b.a();
        StringBuilder stringBuilder = new StringBuilder("NIMSDK_STAT_");
        stringBuilder.append(b.g());
        return a.getSharedPreferences(stringBuilder.toString(), 0);
    }

    public final void a(Context context) {
        context = context.getApplicationContext();
        this.a.postDelayed(new Runnable() {
            public final void run() {
                if (c.f(context)) {
                    com.qiyukf.basesdk.a.a.b("stat", "collect and upload stat on UI login done...");
                    a.a(a.this, context);
                }
            }
        }, 5000);
    }
}
