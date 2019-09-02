package com.qiyukf.nimlib.d;

import android.content.Context;
import com.qiyukf.nimlib.d.d.a.b;
import com.qiyukf.nimlib.d.d.a.c;

public final class a {
    private Context a;
    private b b;
    private c c;

    private static class a {
        private static final a a = new a();
    }

    public static a d() {
        return a.a;
    }

    public final Context a() {
        return this.a;
    }

    public final void a(final Context context, b bVar, c cVar) {
        if (context == null || !bVar.d()) {
            throw new IllegalArgumentException("invalid product info");
        } else if (com.qiyukf.nimlib.d.a.d.c.a(context)) {
            this.a = context.getApplicationContext();
            this.b = bVar;
            this.c = cVar;
            com.qiyukf.nimlib.d.a.b.a.a = this.c.d;
            if (com.qiyukf.nimlib.d.a.d.b.a(context, "android.permission.INTERNET")) {
                com.qiyukf.nimlib.d.a.a.b.a().a(context);
                com.qiyukf.nimlib.d.a.c.a.a(context).postDelayed(new Runnable() {
                    public final void run() {
                        com.qiyukf.nimlib.d.e.a.a().a(context);
                    }
                }, 2000);
                return;
            }
            com.qiyukf.nimlib.d.a.b.a.e("unable to request http as without INTERNET permission!");
        }
    }

    public final b b() {
        return this.b;
    }

    public final c c() {
        return this.c;
    }
}
