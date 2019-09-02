package com.qiyukf.basesdk.c.d;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.qiyukf.basesdk.c.a;

public final class g {
    private static Handler a;
    private static Context b;
    private static Toast c;

    public static void a(final int i) {
        c().post(new Runnable() {
            public final void run() {
                if (g.c != null) {
                    g.c.setText(i);
                    g.c.setDuration(0);
                } else {
                    g.c = Toast.makeText(g.b, i, 0);
                }
                g.c.show();
            }
        });
    }

    public static void a(Context context) {
        b = context.getApplicationContext();
    }

    public static void a(final String str) {
        c().post(new Runnable() {
            public final void run() {
                if (g.c != null) {
                    g.c.setText(str);
                    g.c.setDuration(0);
                } else {
                    g.c = Toast.makeText(g.b, str, 0);
                }
                g.c.show();
            }
        });
    }

    public static void b(final int i) {
        c().post(new Runnable() {
            public final void run() {
                if (g.c != null) {
                    g.c.setText(i);
                    g.c.setDuration(1);
                } else {
                    g.c = Toast.makeText(g.b, i, 1);
                }
                g.c.show();
            }
        });
    }

    public static void b(final String str) {
        c().post(new Runnable() {
            public final void run() {
                if (g.c != null) {
                    g.c.setText(str);
                    g.c.setDuration(1);
                } else {
                    g.c = Toast.makeText(g.b, str, 1);
                }
                g.c.show();
            }
        });
    }

    private static Handler c() {
        if (a == null) {
            a = a.b();
        }
        return a;
    }
}
